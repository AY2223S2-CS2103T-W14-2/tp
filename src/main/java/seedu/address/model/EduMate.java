package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.User;
import seedu.address.model.recommender.Recommendation;
import seedu.address.model.recommender.UniqueRecommendationList;
import seedu.address.model.util.SampleDataUtil;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class EduMate implements ReadOnlyEduMate {

    private final UniquePersonList persons;
    private User user;
    private final UniqueRecommendationList recommendations;

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
        recommendations = new UniqueRecommendationList();
    }

    public EduMate() {}

    /**
     * Creates an EduMate using the Persons in the {@code toBeCopied}
     */
    public EduMate(ReadOnlyEduMate toBeCopied) {
        this();
        resetData(toBeCopied);
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
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations.setRecommendations(recommendations);
    }

    /**
     * Replaces the contents of the person list with an empty list of recommendations.
     */
    public void resetRecommendations() {
        this.recommendations.setRecommendations(new ArrayList<>());
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
        setRecommendations(newData.getRecommendationList());
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

    //// recommendation-level operations

    /**
     * Returns true if a recommendation with the same identity as
     * {@code recommendation} exists in the address book.
     */
    public boolean hasRecommendation(Recommendation person) {
        requireNonNull(person);
        return recommendations.contains(person);
    }

    /**
     * Adds a recommendation to the address book.
     * The recommendation must not already exist in the address book.
     */
    public void addRecommendation(Recommendation p) {
        recommendations.add(p);
    }

    /**
     * Replaces the given recommendation {@code target} in the list with {@code editedRecommendation}.
     * {@code target} must exist in the address book.
     * The recommendation identity of {@code editedRecommendation} must not
     * be the same as another existing person in the address book.
     */
    public void setRecommendation(Recommendation target, Recommendation editedRecommendation) {
        requireNonNull(editedRecommendation);

        recommendations.setRecommendation(target, editedRecommendation);
    }

    /**
     * Removes {@code key} from this {@code EduMate}.
     * {@code key} must exist in the address book.
     */
    public void removeRecommendation(Recommendation key) {
        recommendations.remove(key);
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
    public ObservableList<Recommendation> getRecommendationList() {
        return recommendations.asUnmodifiableObservableList();
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
