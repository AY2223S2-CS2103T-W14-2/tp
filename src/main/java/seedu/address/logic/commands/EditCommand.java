package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TelegramHandle;
import seedu.address.model.person.User;
import seedu.address.model.tag.GroupTag;
import seedu.address.model.tag.ModuleTag;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_GROUP_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_EDIT_USER_SUCCESS = "Edited User: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final Index index;
    private final EditPersonDescriptor editPersonDescriptor;

    /**
     * @param index of the person in the filtered person list to edit
     * @param editPersonDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditPersonDescriptor editPersonDescriptor) {
        requireNonNull(editPersonDescriptor);

        this.index = index;
        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (index == null) {
            return editUser();
        }

        return editPerson(model);
    }

    /**
     * Edits person at the given index
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    private CommandResult editPerson(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = createEditedPerson(personToEdit, editPersonDescriptor);

        if (!personToEdit.isSamePerson(editedPerson) && model.hasPerson(editedPerson)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, editedPerson));
    }

    /**
     * Edits the user information
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    private CommandResult editUser() throws CommandException {
        User user = User.getUser();
        User editedUser = createEditedUser(user, editPersonDescriptor);
        User.setUser(editedUser);

        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, editedUser));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static Person createEditedPerson(Person personToEdit, EditPersonDescriptor editPersonDescriptor) {
        assert personToEdit != null;

        Name updatedName = editPersonDescriptor.getName().orElse(personToEdit.getName());
        Phone updatedPhone = editPersonDescriptor.getPhone().orElse(personToEdit.getPhone());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(personToEdit.getEmail());
        Address updatedAddress = editPersonDescriptor.getAddress().orElse(personToEdit.getAddress());
        TelegramHandle updatedTelegramHandle = editPersonDescriptor.getTelegramHandle()
                .orElse(personToEdit.getTelegramHandle());
        Set<GroupTag> updatedGroupTags = editPersonDescriptor.getGroupTags()
                .orElse(personToEdit.getGroupTags());
        Set<ModuleTag> updatedModuleTags = editPersonDescriptor.getModuleTags()
                .orElse(personToEdit.getModuleTags());
        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedTelegramHandle,
                updatedGroupTags, updatedModuleTags);
    }

    /**
     * Creates and returns a {@code User} with the details of {@code user}
     * edited with {@code editPersonDescriptor}.
     */
    private static User createEditedUser(User user, EditPersonDescriptor editPersonDescriptor) {
        assert user != null;

        Name updatedName = editPersonDescriptor.getName().orElse(user.getName());
        Phone updatedPhone = editPersonDescriptor.getPhone().orElse(user.getPhone());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(user.getEmail());
        Address updatedAddress = editPersonDescriptor.getAddress().orElse(user.getAddress());
        TelegramHandle updatedTelegramHandle = editPersonDescriptor.getTelegramHandle()
                .orElse(user.getTelegramHandle());
        Set<GroupTag> updatedGroupTags = editPersonDescriptor.getGroupTags()
                .orElse(user.getGroupTags());
        Set<ModuleTag> updatedModuleTags = editPersonDescriptor.getModuleTags()
                .orElse(user.getModuleTags());
        return User.getSingletonUser(updatedName, updatedPhone, updatedEmail, updatedAddress,
                updatedTelegramHandle, updatedGroupTags, updatedModuleTags);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return index.equals(e.index)
                && editPersonDescriptor.equals(e.editPersonDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private Phone phone;
        private Email email;
        private Address address;
        private TelegramHandle telegramHandle;
        private Set<GroupTag> groupTags;
        private Set<ModuleTag> moduleTags;

        public EditPersonDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code groupTags} and {@code moduleTags} is used internally.
         */
        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            setName(toCopy.name);
            setPhone(toCopy.phone);
            setEmail(toCopy.email);
            setAddress(toCopy.address);
            setTelegramHandle(toCopy.telegramHandle);
            setGroupTags(toCopy.groupTags);
            setModuleTags(toCopy.moduleTags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, phone, email, address, groupTags, moduleTags, telegramHandle);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public Optional<Phone> getPhone() {
            return Optional.ofNullable(phone);
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setTelegramHandle(TelegramHandle telegramHandle) {
            this.telegramHandle = telegramHandle;
        }

        public Optional<TelegramHandle> getTelegramHandle() {
            return Optional.ofNullable(telegramHandle);
        }

        /**
         * Sets {@code groupTags} to this object's {@code groupTags}.
         * A defensive copy of {@code groupTags} is used internally.
         */
        public void setGroupTags(Set<GroupTag> groupTags) {
            this.groupTags = (groupTags != null) ? new HashSet<>(groupTags) : null;
        }

        /**
         * Sets {@code moduleTags} to this object's {@code moduleTags}.
         * A defensive copy of {@code moduleTags} is used internally.
         */
        public void setModuleTags(Set<ModuleTag> moduleTags) {
            this.moduleTags = (moduleTags != null) ? new HashSet<>(moduleTags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code groupTags} is null.
         */
        public Optional<Set<GroupTag>> getGroupTags() {
            return (groupTags != null) ? Optional.of(Collections.unmodifiableSet(groupTags)) : Optional.empty();
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code moduleTags} is null.
         */
        public Optional<Set<ModuleTag>> getModuleTags() {
            return (moduleTags != null) ? Optional.of(Collections.unmodifiableSet(moduleTags)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;
            return getName().equals(e.getName())
                    && getPhone().equals(e.getPhone())
                    && getEmail().equals(e.getEmail())
                    && getAddress().equals(e.getAddress())
                    && getTelegramHandle().equals(e.getTelegramHandle())
                    && getGroupTags().equals(e.getGroupTags())
                    && getModuleTags().equals(e.getModuleTags());
        }
    }
}
