package seedu.address.model;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.meetup.MeetUp;
import seedu.address.model.person.ContactIndex;
import seedu.address.model.person.Person;
import seedu.address.model.person.User;
import seedu.address.model.recommendation.Recommendation;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Comparator} that sorts by contact index */
    Comparator<Person> COMPARATOR_CONTACT_INDEX_PERSON = Comparator.comparing(Person::getContactIndex);

    /** {@code Predicate} that always evaluate to true */
    Predicate<Recommendation> PREDICATE_SHOW_ALL_RECOMMENDATIONS = unused -> true;

    /** {@code Comparator} that sorts by contact index */
    Comparator<Recommendation> COMPARATOR_CONTACT_INDEX_RECOMMENDATION =
            Comparator.comparing(Recommendation::getContactIndex);

    //todo double check
    Predicate<MeetUp> PREDICATE_SHOW_ALL_MEETUPS = unused -> true;

    Comparator<MeetUp> COMPARATOR_CONTACT_INDEX_MEETUP = Comparator.comparing(MeetUp::getContactIndex);

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getEduMateFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setEduMateFilePath(Path eduMateFilePath);

    /**
     * Replaces address book data with the data in {@code eduMate}.
     */
    void setEduMate(ReadOnlyEduMate eduMate);

    /** Returns the EduMate */
    ReadOnlyEduMate getEduMate();

    ReadOnlyEduMateHistory getEduMateHistory();

    void addEduMateHistory(String command);

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    Person addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Clears the person list.
     * Used for sorting the list, as the list needs to be cleared before it can be sorted.
     */
    void resetPersons();

    /**
     * Returns true if a recommendation with the same identity as
     * {@code recommendation} exists in the address book.
     */
    boolean hasRecommendation(Recommendation recommendation);

    /**
     * Deletes the given recommendation.
     * The recommendation must exist in the address book.
     */
    void deleteRecommendation(Recommendation target);

    /**
     * Adds the given recommendation.
     * {@code recommendation} must not already exist in the address book.
     */
    Recommendation addRecommendation(Recommendation recommendation);

    /**
     * Replaces the given recommendation {@code target} with {@code editedRecommendation}.
     * {@code target} must exist in the address book.
     * The recommendation identity of {@code editedRecommendation}
     * must not be the same as another existing recommendation in the address book.
     */
    void setRecommendation(Recommendation target, Recommendation editedRecommendation);

    /**
     * Clears the person list.
     * Used for sorting the list, as the list needs to be cleared before it can be sorted.
     */
    void resetRecommendations();

    /**
     * Returns the user object.
     * User will not be null.
     */
    User getUser();

    /**
     * Sets the user object to the EduMate object.
     * @param user {@code User} must not be null.
     */
    void setUser(User user);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getObservablePersonList();

    /**
     * Updates the filter of the observable person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservablePersonList(Predicate<Person> predicate);

    /**
     * Updates the sort comparator of the observable person list to sort by the given {@code comparator}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservablePersonList(Comparator<Person> comparator);

    /**
     * Updates the sort and filter of the observable person list to default.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservablePersonList();

    //TODO ADD JAVA DOCS
    Optional<Recommendation> getRecommendationByIndex(ContactIndex contactIndex);

    void addMeetUp(MeetUp meetUp);

    ContactIndex getMeetUpIndex();

    List<MeetUp> getObservableMeetUpList();

    //todo do i need this??
    //void updateObservableMeetUpList();

    /** Returns an unmodifiable view of the filtered recommendation list */
    ObservableList<Recommendation> getObservableRecommendationList();

    /**
     * Updates the filter of the observable recommendation list to
     * filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservableRecommendationList(Predicate<Recommendation> predicate);

    /**
     * Updates the sort comparator of the observable recommendation list to
     * sort by the given {@code comparator}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservableRecommendationList(Comparator<Recommendation> comparator);

    /**
     * Updates the sort and filter of the observable recommendation list to default.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateObservableRecommendationList();

    Set<ContactIndex> getParticipants();

    void updateObservableMeetUpList();
}
