package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.User;

/**
 * Shows the user information on the display.
 */
public class UserCommand extends Command {

    public static final String COMMAND_WORD = "user";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays your own information here. ";
    public static final String SUCCESS_MESSAGE = "User information retrieved";
    public static final String UNREGISTERED_MESSAGE = "You have not input your profile yet to use this command! ";

    private User user;


    public UserCommand() {
        user = User.getUser();
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (user == null) {
            throw new CommandException(UNREGISTERED_MESSAGE);
        }
        return new CommandResult(String.format("%s\n%s", SUCCESS_MESSAGE, user));
    }
}