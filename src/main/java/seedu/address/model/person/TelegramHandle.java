package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a User's telegram handle in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTelegramHandle(String)}
 */
public class TelegramHandle {

    public static final String MESSAGE_CONSTRAINTS =
            "Telegram Handle should not be blank and should start with @ symbol";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     * The first character should be "@" followed by alphanumeric characters.
     */
    public static final String VALIDATION_REGEX = "^@[\\p{Alnum}]";

    public final String telegramHandle;

    /**
     * Constructs a {@code TelegramHandle}.
     *
     * @param telegramHandle A valid telegram handle.
     */
    public TelegramHandle(String telegramHandle) {
        requireNonNull(telegramHandle);
        checkArgument(isValidTelegramHandle(telegramHandle), MESSAGE_CONSTRAINTS);
        this.telegramHandle = telegramHandle;
    }

    /**
     * Returns true if the telegram handle is valid.
     * @param test telegram handle
     * @return true if the telegram handle is valid.
     */
    public static boolean isValidTelegramHandle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.telegramHandle;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TelegramHandle // instanceof handles nulls
                && telegramHandle.equals(((TelegramHandle) other).telegramHandle)); // state check
    }

    @Override
    public int hashCode() {
        return telegramHandle.hashCode();
    }
}