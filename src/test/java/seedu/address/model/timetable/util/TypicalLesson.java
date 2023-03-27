package seedu.address.model.timetable.util;

import org.joda.time.LocalTime;

import seedu.address.model.commitment.Lesson;
import seedu.address.model.location.Location;
import seedu.address.model.time.Day;


/**
 * Represents some of Typical Lessons.
 */
public class TypicalLesson {

    public static final Lesson MONDAY_8AM_2HR_LESSON = new Lesson("CS2103T",
            new LocalTime(8, 0),
            new LocalTime(10, 0),
            Day.MONDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson MONDAY_9AM_1HR_LESSON = new Lesson("CS2103T",
            new LocalTime(9, 0),
            new LocalTime(10, 0),
            Day.MONDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson MONDAY_ANOTHER_8AM_2HR_LESSON = new Lesson("CS2101",
            new LocalTime(8, 0),
            new LocalTime(10, 0),
            Day.MONDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson MONDAY_10AM_2HR_LESSON = new Lesson("CS2109S",
            new LocalTime(10, 0),
            new LocalTime(12, 0),
            Day.MONDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson TUESDAY_8AM_2HR_LESSON = new Lesson("CS2106",
            new LocalTime(8, 0),
            new LocalTime(10, 0),
            Day.TUESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson TUESDAY_10AM_2HR_LESSON = new Lesson("CS2102",
            new LocalTime(10, 0),
            new LocalTime(12, 0),
            Day.TUESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson TUESDAY_10AM_1HR_LESSON = new Lesson("CS2108",
            new LocalTime(10, 0),
            new LocalTime(11, 0),
            Day.TUESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson TUESDAY_2PM_2HR_LESSON = new Lesson("CS2104",
            new LocalTime(14, 0),
            new LocalTime(16, 0),
            Day.TUESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson TUESDAY_4PM_1HR_LESSON = new Lesson("CS3263",
            new LocalTime(16, 0),
            new LocalTime(17, 0),
            Day.TUESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson WEDNESDAY_10AM_3HR_LESSON = new Lesson("MA2101S",
            new LocalTime(10, 0),
            new LocalTime(13, 0),
            Day.WEDNESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson WEDNESDAY_2PM_2HR_LESSON = new Lesson("CS2108",
            new LocalTime(14, 0),
            new LocalTime(16, 0),
            Day.WEDNESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson WEDNESDAY_4PM_1HR_LESSON = new Lesson("MA2214",
            new LocalTime(16, 0),
            new LocalTime(17, 0),
            Day.WEDNESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson WEDNESDAY_6PM_1HR_LESSON = new Lesson("CS3263",
            new LocalTime(18, 0),
            new LocalTime(19, 0),
            Day.WEDNESDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_8AM_2HR_LESSON = new Lesson("MA3236",
            new LocalTime(8, 0),
            new LocalTime(10, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_12PM_2HR_LESSON = new Lesson("MA3236",
            new LocalTime(12, 0),
            new LocalTime(14, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_10AM_3HR_LESSON = new Lesson("MA3236",
            new LocalTime(10, 0),
            new LocalTime(13, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_1PM_3HR_LESSON = new Lesson("MA3236",
            new LocalTime(13, 0),
            new LocalTime(16, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_4PM_2HR_LESSON = new Lesson("MA3236",
            new LocalTime(16, 0),
            new LocalTime(18, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_11AM_2HR_LESSON = new Lesson("CS3230",
            new LocalTime(11, 0),
            new LocalTime(13, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_5PM_4HR_LESSON = new Lesson("CS3230",
            new LocalTime(17, 0),
            new LocalTime(21, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson THURSDAY_9PM_1HR_LESSON = new Lesson("CS3230",
            new LocalTime(21, 0),
            new LocalTime(22, 0),
            Day.THURSDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson FRIDAY_7PM_3HR_LESSON = new Lesson("MA3252",
            new LocalTime(19, 0),
            new LocalTime(22, 0),
            Day.FRIDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson FRIDAY_9AM_1HR_LESSON = new Lesson("CS1101S",
            new LocalTime(9, 0),
            new LocalTime(10, 0),
            Day.FRIDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson FRIDAY_9AM_2HR_LESSON = new Lesson("CS1231S",
            new LocalTime(9, 0),
            new LocalTime(11, 0),
            Day.FRIDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson FRIDAY_8AM_1HR_LESSON = new Lesson("MA2104",
            new LocalTime(8, 0),
            new LocalTime(9, 0),
            Day.FRIDAY,
            new Location("NUS", 1.34, 103.7));

    public static final Lesson FRIDAY_ANOTHER_8AM_1HR_LESSON = new Lesson("MA2104",
            new LocalTime(8, 0),
            new LocalTime(9, 0),
            Day.FRIDAY,
            new Location("NUS", 1.341, 103.71));
}

public class LessonBuilder {
    public static final String DEFAULT_MODULE_CODE = "CS2103T";
    public static final LocalTime DEFAULT_START_TIME = new LocalTime(10, 0);
    public static final LocalTime DEFAULT_END_TIME = new LocalTime(12, 0);
    public static final Day DEFAULT_DAY = Day.TUESDAY;

    private String moduleCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private Day day;

    public LessonBuilder() {
        moduleCode = DEFAULT_MODULE_CODE;
        startTime = DEFAULT_START_TIME;
        endTime = DEFAULT_END_TIME;
        day = DEFAULT_DAY;
    }

    public LessonBuilder(Lesson lesson) {
        moduleCode = lesson.getModuleCode();
        startTime = lesson.getStartTime();
        endTime = lesson.getEndTime();
        day = lesson.getDay();
    }

    public LessonBuilder withModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
        return this;
    }

    public LessonBuilder withStartTime(LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LessonBuilder withDay(Day day) {
        this.day = day;
        return this;
    }

    public Lesson build() {
        return new Lesson(moduleCode, startTime,
                endTime, day, Location.NUS);
    }
}
