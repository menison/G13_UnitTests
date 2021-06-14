package gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import cachedUserData.DataManager;
import entities.QaForTable;
import entities.TestForRequestedTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RequestedTestController implements Initializable{

    @FXML
    private JFXTextField testReview_DateTxt;

    @FXML
    private JFXTextField testReview_testCodeTxt;

    @FXML
    private JFXTextField testReview_AlDurTxt;

    @FXML
    private JFXTextField testReview_ActDurTxt;

    @FXML
    private JFXTextField testReview_testIDTxt;

    @FXML
    private JFXTextField testReview_GradeTxt;

    @FXML
    private TableView<QaForTable> testReview_QaTbl;

    @FXML
    private TableColumn<QaForTable, String> testReview_questionCol;

    @FXML
    private TableColumn<QaForTable, Integer> testReview_AnswerCol;

    @FXML
    private Button testReview_closeBtn;
    
    public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/RequestedTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Requested Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    
    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage stage = (Stage) testReview_closeBtn.getScene().getWindow();
    	stage.close();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DataManager dm = DataManager.getDataManager();
		TestForRequestedTest t = dm.getReviewTest();
		testReview_testIDTxt.setText(t.getTestID());
		testReview_testCodeTxt.setText(t.getTestCode());
		testReview_DateTxt.setText(t.getDate());
		testReview_AlDurTxt.setText(String.valueOf(t.getAllocatedDuration()));
		testReview_ActDurTxt.setText(String.valueOf(t.getActualDuration()));
		testReview_GradeTxt.setText(String.valueOf(t.getGrade()));
		ObservableList<QaForTable> questions = FXCollections.observableArrayList(t.getQa());
		testReview_questionCol.setCellValueFactory(new PropertyValueFactory<>("questionNum"));
		testReview_AnswerCol.setCellValueFactory(new PropertyValueFactory<>("answer"));
		testReview_QaTbl.setItems(questions);
	}

}
