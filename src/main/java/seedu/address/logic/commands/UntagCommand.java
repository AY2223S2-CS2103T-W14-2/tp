package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.ModuleTagSet;
import seedu.address.model.person.Person;
import seedu.address.model.person.User;
import seedu.address.model.tag.ModuleTag;

/**
 * Removes modules from an existing person in the address book.
 */
public class UntagCommand extends Command {

    public static final String COMMAND_WORD = "untag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Removes a ModuleTag to a person. \n"
            + "untag <index> m/<module> : Removes tags from the person of given index in displayed list. \n"
            + "untag n/<module> : Removes tags from your own profile instead.";

    public static final String MESSAGE_UNTAG_PERSON_SUCCESS = "Module(s) untagged to Person!";
    public static final String MESSAGE_UNTAG_USER_SUCCESS = "Module(s) untagged to User!";
    public static final String MESSAGE_NO_TAGS = "At least one Module must be provided.";

    private final Index index;
    private final Set<ModuleTag> moduleTags;

    /**
     * @param index of the person in the filtered person list to edit.
     * @param modulesToRemove set of modules to be removed.
     */
    public UntagCommand(Index index, Set<ModuleTag> modulesToRemove) {
        requireNonNull(modulesToRemove);

        this.index = index;
        this.moduleTags = modulesToRemove;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (index == null) {
            return removeUserTags(model);
        }
        return removePersonTags(model);
    }

    /**
     * Removes tags from person at given index.
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display.
     * @throws CommandException if an error occurs during command execution.
     */
    public CommandResult removePersonTags(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());

        ModuleTagSet oldModules = personToEdit.getModuleTags();

        oldModules.removeAll(this.moduleTags);

        Set<ModuleTag> userModuleTags = model.getUser().getImmutableModuleTags();

        personToEdit.setCommonModules(userModuleTags);

        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_UNTAG_PERSON_SUCCESS,
                personToEdit.getImmutableModuleTags().toString()));
    }

    /**
     * Removes tags from the user.
     * @param model {@code Model} which the command should operate on
     * @return feedback message of the operation result for display.
     * @throws CommandException if an error occurs during command execution.
     */
    public CommandResult removeUserTags(Model model) throws CommandException {
        User editedUser = model.getUser();

        ModuleTagSet userModuleTags = editedUser.getModuleTags();

        userModuleTags.removeAll(this.moduleTags);

        model.getFilteredPersonList().forEach(person ->
                person.setCommonModules(editedUser.getImmutableModuleTags()));

        return new CommandResult(String.format(MESSAGE_UNTAG_USER_SUCCESS, editedUser));
    }


}