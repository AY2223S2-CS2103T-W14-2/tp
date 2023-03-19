package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.IndexHandler;
import seedu.address.model.Model;
import seedu.address.model.location.DistanceUtil;
import seedu.address.model.location.Location;
import seedu.address.model.person.ContactIndex;
import seedu.address.model.scheduler.Scheduler;
import seedu.address.model.timetable.time.TimePeriod;

/**
 * Based on a list of people, recommends a list of places to eat and/or study.
 */
public class MeetCommand extends Command {

    public static final String EAT_COMMAND_WORD = "eat";
    public static final String STUDY_COMMAND_WORD = "study";
    public static final String MEET_COMMAND_WORD = "meet";
    public static final String MESSAGE_SUCCESS = "Here are the recommendations!";
    public static final int DEFAULT_NUMBER_OF_RECOMMENDATIONS = 10;
    public static final String MESSAGE_USAGE =
            String.format("%s/%s/%s", EAT_COMMAND_WORD, STUDY_COMMAND_WORD, MEET_COMMAND_WORD)
                    + ": Recommends locations to eat/study/meet based on the indices of the people.";

    private final Set<ContactIndex> indices;
    private final Collection<Location> locations;
    private final int numberOfRecommendations;

    /**
     * Constructor for a {@code MeetCommand}.
     * @param indices The indices of people we want to meet.
     * @param locations The potential locations to meet.
     */
    public MeetCommand(Set<ContactIndex> indices, Collection<Location> locations) {
        this.indices = indices;
        this.locations = locations;
        this.numberOfRecommendations = DEFAULT_NUMBER_OF_RECOMMENDATIONS;
    }

    /**
     * Constructor for a {@code MeetCommand}.
     * @param indices The indices of people we want to meet.
     * @param locations The potential locations to meet.
     * @param numberOfRecommendations The maximum search result size.
     */
    public MeetCommand(
            Set<ContactIndex> indices, Collection<Location> locations, int numberOfRecommendations) {
        this.indices = indices;
        this.locations = locations;
        this.numberOfRecommendations = numberOfRecommendations;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Location> locationsOfPersons = getAllAddresses(model);
        List<? extends Location> recommendations = giveRecommendations(locationsOfPersons);
        Scheduler scheduler = new Scheduler(model).initialise(indices);
        Optional<TimePeriod> recommendedTimings = scheduler.giveLongestTimingRecommendations();
        // This section deals with porting the information over to the front end.
        // @zichen This is the entry point.
        StringBuilder sb = new StringBuilder();
        sb.append(MESSAGE_SUCCESS);

        recommendations.forEach(location -> sb.append("\n").append(location.getName()));

        return new CommandResult(sb.toString());
    }

    /**
     * Returns a list of all contacts and user's own addresses.
     */
    private List<Location> getAllAddresses(Model model) throws CommandException {
        List<Location> locationsOfPersons = new ArrayList<>();
        locationsOfPersons.add(getUserAddress(model));
        locationsOfPersons.addAll(getContactsLocation(model));
        return locationsOfPersons;
    }

    /**
     * Retrieves a list of all contacts' addresses.
     */
    private List<Location> getContactsLocation(Model model) throws CommandException {
        IndexHandler indexHandler = new IndexHandler(model);
        List<Location> contactAddresses = new ArrayList<>();
        for (ContactIndex contactIndex : indices) {
            contactAddresses
                .add(indexHandler.getPersonByIndex(contactIndex)
                    .orElseThrow(() ->
                        new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX))
                    .getAddress().getValue());
        }
        return contactAddresses;
    }

    /**
     * Returns user's own address.
     */
    private Location getUserAddress(Model model) {
        return model.getUser().getAddress().getValue();
    }
    /**
     * Finds the midpoint of the person locations
     * and returns the closest destinations to that midpoint.
     */
    private List<? extends Location> giveRecommendations(List<? extends Location> locationsOfPersons) {
        Location midpoint = DistanceUtil.getMidpoint(locationsOfPersons);
        return DistanceUtil.getClosestPoints(midpoint, numberOfRecommendations, locations);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MeetCommand // instanceof handles nulls
                && indices.equals(((MeetCommand) other).indices)
                && locations.equals(((MeetCommand) other).locations)); // state check
    }
}
