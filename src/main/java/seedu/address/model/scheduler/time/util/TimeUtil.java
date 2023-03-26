package seedu.address.model.scheduler.time.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.LocalTime;

import javafx.util.Pair;
import seedu.address.model.scheduler.Timetable;
import seedu.address.model.scheduler.time.Day;
import seedu.address.model.scheduler.time.HourBlock;
import seedu.address.model.scheduler.time.TimeBlock;
import seedu.address.model.scheduler.time.TimePeriod;
import seedu.address.model.util.MathUtil;


/**
 * Contains utils functions for Timetable related jobs.
 */
public class TimeUtil {
    /**
     * Gets a list of free intervals for which a participant is free for the specific school day.
     */
    public static List<HourBlock> getFreeCommonIntervals(Day schoolDay, List<Timetable> schedules) {
        List<ArrayList<HourBlock>> daySchedules = obtainAllSchedulesForDay(schoolDay, schedules);
        if (daySchedules.isEmpty()) {
            return new ArrayList<>();
        }
        List<HourBlock> commonFreeHourBlocks = new ArrayList<>();
        int numberOfTimeSlots = daySchedules.get(0).size();
        for (int i = 0; i < numberOfTimeSlots; i++) {
            boolean isFreeForAll = true;
            for (ArrayList<HourBlock> daySchedule : daySchedules) {
                isFreeForAll &= daySchedule.get(i).isFree();
            }
            if (isFreeForAll) {
                HourBlock sampleSlot = daySchedules.get(daySchedules.size() - 1).get(i);
                commonFreeHourBlocks.add(new HourBlock(sampleSlot));
            }
        }
        return commonFreeHourBlocks;
    }

    /**
     * Retrieves all row schedules from all timetables for a specific day
     */
    public static List<ArrayList<HourBlock>> obtainAllSchedulesForDay(Day schoolDay, List<Timetable> schedules) {
        return schedules.stream()
                .map(timetable -> timetable.getSchedule().get(schoolDay))
                .collect(Collectors.toList());
    }

    /**
     * Reduces the number of TimePeriods by merging consecutive time slots.
     */
    public static List<TimePeriod> mergeTimeSlots(List<HourBlock> hourBlocks) {
        if (hourBlocks.isEmpty()) {
            return new ArrayList<>();
        }
        TimePeriod block = null;
        List<TimePeriod> timePeriods = new ArrayList<>();
        for (int i = 0; i < hourBlocks.size(); i++) {
            HourBlock hourBlock = hourBlocks.get(i);
            if (i == 0) {
                block = hourBlock;
            } else if (hourBlock.isConsecutiveWith(block)) {
                block = block.merge(hourBlock);
            } else {
                timePeriods.add(new TimeBlock(block));
                block = hourBlock;
            }
        }
        if (block != null) {
            timePeriods.add(new TimeBlock(block));
        }
        return timePeriods;
    }

    /**
     * Formats the LocalTime to a more reader-friendly format.
     * @param time LocalTime
     * @return Reader-friendly string format.
     */
    public static String formatLocalTime(LocalTime time) {
        int hourOfDay = time.getHourOfDay();
        if (hourOfDay < 12) {
            return String.format("%d AM", hourOfDay);
        } else if (hourOfDay == 12) {
            return "12 PM";
        } else {
            return String.format("%d PM", hourOfDay % 12);
        }
    }

    /**
     * Checks that amongst these timeperiods, if there are any clashes based on timing
     * and not activity.
     */
    public static boolean hasAnyClash(List<TimePeriod> timePeriods) {
        List<Pair<Integer, TimePeriod>> indexedTimePeriods = MathUtil.<TimePeriod>indexObjects(timePeriods);
        List<Pair<Integer, TimePeriod>> second = List.copyOf(indexedTimePeriods);
        List<List<Pair<Integer, TimePeriod>>> cartesianProductPairs =
            MathUtil.<Pair<Integer, TimePeriod>>getCartesianProduct(indexedTimePeriods, second);
        Stream<List<Pair<Integer, TimePeriod>>> cartesianProductTimePeriodStream = cartesianProductPairs.stream()
            .filter(listPair -> !listPair.get(0).getKey().equals(listPair.get(1).getKey()))
            .filter(listPair -> listPair.get(0).getValue().hasClash(listPair.get(1).getValue()));
        return cartesianProductTimePeriodStream.findAny().isPresent();
    }

    /**
     * Checks if there are any conflicts in these 2 timetables
     */
    public static boolean hasConflict(Timetable timetable, Timetable other) {
        boolean hasClashSoFar = false;
        for (Day day : Day.values()) {
            List<HourBlock> tp = timetable.getSchedule().get(day);
            List<HourBlock> tp2 = other.getSchedule().get(day);
            for (int i = 0; i < tp.size(); i++) {
                hasClashSoFar |= !tp.get(i).isFree() && !tp2.get(i).isFree();
            }
            if (hasClashSoFar) {
                return true;
            }
        }
        return false;
    }


}