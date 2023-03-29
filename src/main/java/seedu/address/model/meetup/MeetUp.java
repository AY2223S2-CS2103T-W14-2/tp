package seedu.address.model.meetup;

import seedu.address.model.location.Location;
import seedu.address.model.person.ContactIndex;
import seedu.address.model.recommendation.Recommendation;
import seedu.address.model.time.TimePeriod;

/**
 * A scheduled meet up consisting of location, time period and participants' indexes.
 */
public class MeetUp implements Comparable<MeetUp> {
    private final TimePeriod timePeriod;
    private final Location location;
    private final Participants participants;
    private final ContactIndex meetUpIndex;

    /**
     * Constructor for a {@code MeetUp} object.
     */
    public MeetUp(Recommendation recommendation, Participants participants, ContactIndex meetUpIndex) {
        this.timePeriod = recommendation.getTimePeriod();
        this.location = recommendation.getLocation();
        this.participants = participants;
        this.meetUpIndex = meetUpIndex;
    }

    /**
     * Overloaded constructor for a {@code MeetUp} object not from meet recommendations.
     */
    public MeetUp(TimePeriod timePeriod, Location location, Participants participants, ContactIndex meetUpIndex) {
        this.timePeriod = timePeriod;
        this.location = location;
        this.participants = participants;
        this.meetUpIndex = meetUpIndex;
    }

    /**
     * Gets index of meetup.
     */
    public ContactIndex getMeetUpIndex() {
        return this.meetUpIndex;
    }

    /**
     * Gets location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets time period.
     */
    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    /**
     * Gets location.
     */
    public Participants getParticipants() {
        return participants;
    }

    @Override
    public int compareTo(MeetUp other) {
        return meetUpIndex.compareTo(other.meetUpIndex);
    }

    public boolean isSameMeetUp(MeetUp other) {
        return this.timePeriod.equals(other.timePeriod) && this.location.equals(other.location) && this.participants.equals(other.participants);
    }
}