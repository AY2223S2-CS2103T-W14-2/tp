package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.joda.time.LocalTime;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.commitment.Lesson;
import seedu.address.model.time.Day;

public class JsonAdaptedLesson {
    private final Integer startHour;
    private final Integer endHour;
    private final String day;

    /**
     * Constructs a {@code JsonAdaptedLesson} with the given
     * {@code startHour}, {@code endHour}, {@code day}.
     */
    @JsonCreator
    public JsonAdaptedLesson(Integer startHour, Integer endHour, String day) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.day = day;
    }

    /**
     * Converts a given {@code Lesson} into this class for Jackson use.
     */
    public JsonAdaptedLesson(Lesson lesson) {
        startHour = lesson.getStartTime().getHourOfDay();
        endHour = lesson.getEndTime().getHourOfDay();
        day = lesson.getDay().toString();
    }

    /**
     * Converts this Jackson-friendly adapted lesson object into the model's {@code Lesson} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted lesson.
     */
    public Lesson toModelType() throws IllegalValueException {
        LocalTime parsedStartHour = ParserUtil.parseLocalTime(startHour.toString());
        LocalTime parsedEndHour = ParserUtil.parseLocalTime(endHour.toString());
        Day parsedDay = ParserUtil.parseDay(day);
        return new Lesson(parsedStartHour, parsedEndHour, parsedDay);
    }
}
