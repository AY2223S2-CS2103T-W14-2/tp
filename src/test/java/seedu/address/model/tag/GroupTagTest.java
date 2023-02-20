package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GroupTagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GroupTag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new GroupTag(invalidTagName));
    }

    @Test
    public void isValidTagName_null_throwsNullPointerException() {
        // null tag name
        assertThrows(NullPointerException.class, () -> GroupTag.isValidTagName(null));
    }

    @Test
    public void isValidTagName_validTagName_true() {
        String validTagName = "Friend";
        assertTrue(GroupTag.isValidTagName(validTagName));

        validTagName = "NUS";
        assertTrue(GroupTag.isValidTagName(validTagName));
    }

    @Test
    public void isValidTagName_invalidTagName_false() {
        String invalidTagName = "NUS Friend";
        assertFalse(GroupTag.isValidTagName(invalidTagName));

        invalidTagName = "";
        assertFalse(GroupTag.isValidTagName(invalidTagName));
    }

}