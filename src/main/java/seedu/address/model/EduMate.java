package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.*;

import javafx.collections.ObservableList;
import seedu.address.model.meetup.MeetUp;
import seedu.address.model.meetup.UniqueMeetUpList;
import seedu.address.model.person.ContactIndex;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.User;
import seedu.address.model.util.SampleDataUtil;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class EduMate implements ReadOnlyEduMate {

    private final UniquePersonList persons;
    private final UniqueMeetUpList meets; //todo check again before push
    protected Set<ContactIndex> participants; //todo check again before push
    private User user;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();
        user = SampleDataUtil.getSampleUser();
        meets = new UniqueMeetUpList(); //todo check again before push
        participants = new HashSet<>(); //todo check again before push
    }

    public EduMate() {}

    /**
     * Creates an EduMate using the Persons in the {@code toBeCopied}.
     */
    public EduMate(ReadOnlyEduMate toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //todo double check new addition
    /**
     * Replaces the contents of meet up list with {@code meetUps}.
     * @param meetUps List of meet ups.
     */
    public void setMeetUps(List<MeetUp> meetUps) {
        this.meets.setMeetUps(meetUps);
    }

    /**
     * Replaces the contents of the meet ups list with an empty list of meet ups.
     */
    //todo double check new addition
    public void resetMeetUps() {
        this.meets.setMeetUps(new ArrayList<>());
    }

    @Override
    public ObservableList<MeetUp> getMeetUpList() {
        return meets.asUnmodifiableObservableList();
    }

    public void addMeetUp(MeetUp meetUp) {
        meets.add(meetUp);
    }

    public Set<ContactIndex> getParticipantList() {
        return participants;
    }

    public void setParticipants(Set<ContactIndex> participants) {
        this.participants = participants;
    }
    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }

    /**
     * Replaces the contents of the person list with an empty list of persons.
     */
    public void resetPersons() {
        this.persons.setPersons(new ArrayList<>());
    }

    /**
     * Sets the user of the Address Book.
     */
    public void setUser(User user) {
        requireNonNull(user);
        this.user = user;
    }

    /**
     * Resets the existing data of this {@code EduMate} with {@code newData}.
     */
    public void resetData(ReadOnlyEduMate newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
        setUser(newData.getUser());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code EduMate}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        persons.asUnmodifiableObservableList().forEach(person -> {
            sb.append(person);
            sb.append("\n");
        });
        return sb.toString();
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EduMate // instanceof handles nulls
                && persons.equals(((EduMate) other).persons)
                && user.equals(((EduMate) other).user));
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons, user);
    }

}
