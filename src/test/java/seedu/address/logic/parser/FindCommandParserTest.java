package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.person.ContainsKeywordsPredicate;

public class FindCommandParserTest {

    private final FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_NAME,
                Arrays.asList("Albert", "Bart"),
                " n/Albert Bart",
                " n/Albert \n \t Bart  \t");

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_PHONE,
                Arrays.asList("92752656", "82630347"),
                " p/92752656 82630347",
                " p/92752656 \n \t 82630347  \t"
        );

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_ADDRESS,
                Arrays.asList("2", "Blackmore", "Drive"),
                " a/2 Blackmore Drive",
                " a/2 \n \t Blackmore \t \n \t Drive\t"
        );

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_EMAIL,
                Arrays.asList("albertpark@gmail.com", "angmeihua@gmail.com"),
                " e/albertpark@gmail.com angmeihua@gmail.com",
                " e/albertpark@gmail.com \n \t angmeihua@gmail.com \t"
        );

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_TELEGRAM_HANDLE,
                Arrays.asList("@angmeihua", "@bartlee"),
                " t/@angmeihua @bartlee",
                " t/@angmeihua \n \t@bartlee \t"
        );

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_GROUP_TAG,
                Arrays.asList("CCA", "TA", "Study"),
                " g/CCA TA Study",
                " g/CCA \n \t TA \t \n \t Study \t"
        );

        create_validArgs_returnsFindCommand(
                CliSyntax.PREFIX_MODULE_TAG,
                Arrays.asList("CE3121", "CS3219"),
                " m/CE3121 CS3219",
                " m/CE3121 \n \t CS3219 \t"
        );
    }

    public void create_validArgs_returnsFindCommand(
            Prefix prefix, List<String> personList, String normalUserInput, String wUserInput) {
        // no leading and trailing whitespaces
        FindCommand expectedFindPersonCommand =
                new FindCommand(new ContainsKeywordsPredicate(personList, prefix));
        assertParseSuccess(parser, normalUserInput, expectedFindPersonCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, wUserInput, expectedFindPersonCommand);
    }

}
