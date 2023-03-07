package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import seedu.address.logic.commands.LoadCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new LoadCommand object
 */
public class LoadCommandParser implements Parser<LoadCommand> {
    @Override
    public LoadCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
        List<String> fileNameList = argMultimap.getAllValues(new Prefix(""));

        // we only allow single unspaced strings as filenames
        if (fileNameList.stream().allMatch(String::isEmpty)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, LoadCommand.MESSAGE_USAGE));
        }

        Path filePath = Paths.get("data", fileNameList.get(0) + ".json");

        return new LoadCommand(filePath);
    }
}
