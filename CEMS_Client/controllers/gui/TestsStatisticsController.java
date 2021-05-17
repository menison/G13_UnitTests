package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TestsStatisticsController {

    @FXML
    private JFXButton testsStatistics_btnClose;

    @FXML
    private TableView<?> testStatisticsTable;

    @FXML
    private TableColumn<?, ?> testIdColumn;

    @FXML
    private TableColumn<?, ?> testCodeColumn;

    @FXML
    private TableColumn<?, ?> testSubjectColumn;

    @FXML
    private TableColumn<?, ?> testCourseColumn;

    @FXML
    private TableColumn<?, ?> testAllocDurationColumn;

    @FXML
    private TableColumn<?, ?> testActuDurationColumn;

    @FXML
    private JFXButton testsStatistics_btnGetStatistics;

}
