package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

/**
 * Wraps past commands entered by user.
 */
public class EduMateHistory implements ReadOnlyEduMateHistory {

    private ArrayList<String> eduMateHistory;
    private int index = 0;
    private final int minIndex = 0;
    private final int maxIndex = 100;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        eduMateHistory = new ArrayList<>();
    }

    public EduMateHistory() {}

    /**
     * Creates an EduMateHistory using the ArrayList in the {@code toBeCopied}.
     */
    public EduMateHistory(ReadOnlyEduMateHistory toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Replaces the contents of the command history list with {@code history}.
     */
    public void setList(ArrayList<String> history) {
        this.eduMateHistory = history;
    }

    /**
     * Replaces the exisitng contents of the current data of this {@code EduMateHistory} with {@code newData}.
     */
    public void resetData(ReadOnlyEduMateHistory newData) {
        requireNonNull(newData);

        setList(newData.getHistory());
    }

    /**
     * Adds a command to the current command history.
     * @param command Command string
     */
    public void addCommand(String command) {
        eduMateHistory.add(0, command);
        index = 0;
    }

    /**
     * Returns the previous command the user requests.
     * @param isUp Boolean to see whether the user wants to return the older command or the newer command
     * @return The previous command
     */
    @Override
    public String getPreviousCommand(boolean isUp) {
        if (isUp) {
            String previousCommand = eduMateHistory.get(index);
            if ((index < eduMateHistory.size() - 1) && (eduMateHistory.size() < maxIndex)) {
                index++;
            }
            return previousCommand;
        } else {
            if (index > minIndex) {
                index--;
            }
            return eduMateHistory.get(index);
        }
    }

    /**
     * Returns the command history.
     * @return The command history
     */
    @Override
    public ArrayList<String> getHistory() {
        return eduMateHistory;
    }

}
