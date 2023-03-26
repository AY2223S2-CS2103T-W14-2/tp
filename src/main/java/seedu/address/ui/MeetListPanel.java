package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

public class MeetListPanel extends UiPart<Region> {
    private static final String FXML = "MeetListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(MeetListPanel.class);

    @FXML
    private ListView<Person> meetListView;

    public MeetListPanel(ObservableList<Person> recommendationList) {
        super(FXML);
        meetListView.setItems(recommendationList);
        meetListView.setCellFactory(listView -> new MeetListPanel.MeetListViewCell());
    }

    class MeetListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person).getRoot());
            }
        }
    }
}