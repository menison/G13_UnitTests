import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddQuestionForTestController {

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableView<?> questionTable;

    @FXML
    private TableColumn<?, ?> qustionIDcol;

    @FXML
    private TableColumn<?, ?> subjectCol;

    @FXML
    private TableColumn<?, ?> CourseCol;

    @FXML
    private TableColumn<?, ?> composerCol;

    @FXML
    private JFXTextField courseNameField;

    @FXML
    private JFXTextField pointsField;

    @FXML
    void btnAddClicked(ActionEvent event) {

    }

    @FXML
    void btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void btnSearchClicked(ActionEvent event) {

    }

}
