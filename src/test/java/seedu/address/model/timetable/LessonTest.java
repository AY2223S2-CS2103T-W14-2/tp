package seedu.address.model.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.model.timetable.util.TypicalLesson.FRIDAY_ANOTHER_MORNING_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.FRIDAY_MORNING_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.MONDAY_9AM_1HR_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.MONDAY_ANOTHER_FIRST_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.MONDAY_FIRST_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.MONDAY_SECOND_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.TUESDAY_10AM_1HR_LESSON;
import static seedu.address.model.timetable.util.TypicalLesson.TUESDAY_10AM_2HR_LESSON;

import org.joda.time.LocalTime;
import org.junit.jupiter.api.Test;

import seedu.address.model.location.Location;

class LessonTest {

    @Test
    public void equalityCheck_differentModule_notEquals() {
        assertNotEquals(MONDAY_FIRST_LESSON, MONDAY_ANOTHER_FIRST_LESSON);
    }

    @Test
    public void equalityCheck_differentStartTime_notEquals() {
        assertNotEquals(MONDAY_FIRST_LESSON, MONDAY_9AM_1HR_LESSON);
    }

    @Test
    public void equalityCheck_differentEndTime_notEquals() {
        assertNotEquals(TUESDAY_10AM_1HR_LESSON, TUESDAY_10AM_2HR_LESSON);
    }

    @Test
    public void equalityCheck_differentSchoolDay_notEquals() {
        assertNotEquals(MONDAY_SECOND_LESSON, TUESDAY_10AM_2HR_LESSON);
    }

    @Test
    public void equalityCheck_differentLocation_notEquals() {
        assertNotEquals(FRIDAY_MORNING_LESSON, FRIDAY_ANOTHER_MORNING_LESSON);
    }

    @Test
    public void equalityCheck_withNull_notEquals() {
        assertNotEquals(MONDAY_9AM_1HR_LESSON, null);
    }

    @Test
    public void equalityCheck_sameObjectReference_equals() {
        assertEquals(MONDAY_9AM_1HR_LESSON, MONDAY_9AM_1HR_LESSON);
    }

    @Test
    public void equalityCheck_sameObjectDifferentReference_equals() {
        Lesson anotherLesson = new Lesson(new Module("MA2104"),
                new LocalTime(8, 0),
                new LocalTime(9, 0),
                SchoolDay.FRIDAY,
                new Location("NUS", 1.34, 103.7));
        assertEquals(FRIDAY_MORNING_LESSON, anotherLesson);
    }

}