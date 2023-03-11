package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.model.person.Person;


/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final Person displayPerson;

    private final boolean toShowNewPerson;

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean isShowHelp;

    /** The application should exit. */
    private final boolean isExit;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean isShowHelp, boolean isExit, boolean isShowUserProfile) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.isShowHelp = isShowHelp;
        this.isExit = isExit;
        this.displayPerson = null;
        this.toShowNewPerson = false;
    }

    /**
     * Constructs a {@code CommandResult} with the Person's information to be displayed on the
     * profile panel.
     * @param feedbackToUser
     * @param isShowHelp
     * @param isExit
     * @param person
     * @param personToChange
     */
    public CommandResult(String feedbackToUser, boolean isShowHelp, boolean isExit, Person person,
                         boolean personToChange) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.isShowHelp = isShowHelp;
        this.isExit = isExit;
        this.displayPerson = person;
        this.toShowNewPerson = true;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return isShowHelp;
    }

    public boolean isExit() {
        return isExit;
    }

    public boolean isToShowNewPerson() {
        return toShowNewPerson;
    }

    public Person getDisplayPerson() {
        return displayPerson;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CommandResult) {
            System.out.println(feedbackToUser);
            System.out.println(((CommandResult) other).feedbackToUser);
        }
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && isShowHelp == otherCommandResult.isShowHelp
                && isExit == otherCommandResult.isExit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, isShowHelp, isExit);
    }

}
