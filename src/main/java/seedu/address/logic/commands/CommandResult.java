package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean isShowHelp;

    /** The application should show user profile. */
    private final boolean isShowUserProfile;

    /** The application should exit. */
    private final boolean isExit;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean isShowHelp, boolean isExit, boolean isShowUserProfile) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.isShowHelp = isShowHelp;
        this.isExit = isExit;
        this.isShowUserProfile = isShowUserProfile;
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

    public boolean isShowUserProfile() {
        return isShowUserProfile;
    }

    @Override
    public boolean equals(Object other) {
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
                && isExit == otherCommandResult.isExit
                && isShowUserProfile == otherCommandResult.isShowUserProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, isShowHelp, isExit);
    }

}
