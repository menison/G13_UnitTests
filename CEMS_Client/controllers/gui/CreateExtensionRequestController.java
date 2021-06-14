package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import cachedUserData.DataManager;
import entities.ActivatedTest;
import entities.Extension;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**Class CreateExtensionRequestController for CreateExtensionRequest FXML
 * @author David
 *
 *This class is for CreateExtensionRequest FXML which handles extensions for activated tests by user
 *
 */
public class CreateExtensionRequestController {

    @FXML
    private JFXButton RequestExtension_btnExtend;

    @FXML
    private JFXButton RequestExtension_btnClose;

    @FXML
    private TableView<ActivatedTest> RequestExtension_tblTest;


    @FXML
    private TableColumn<ActivatedTest, String> RequestExtension_CodeCol;

    @FXML
    private TableColumn<ActivatedTest, String> RequestExtension_testIDCol;

    @FXML
    private TableColumn<ActivatedTest, LocalDate> RequestExtension_DateCol;

    @FXML
    private TableColumn<ActivatedTest, LocalTime> RequestExtension_timeCol;

    @FXML
    private TableColumn<ActivatedTest, Integer> RequestExtension_DurationCol;

    /**
     * @param event
     * @throws IOException
     * Function activated once RequestExtension_btnExtend button is activated
     * opens new window of Extension for the user to fill details
     */
    @FXML
    void Extend(ActionEvent event) throws IOException {
    	String selectedItems=(String)RequestExtension_tblTest.getSelectionModel().getSelectedItem().getTestCode();
    	int duration=(int)RequestExtension_tblTest.getSelectionModel().getSelectedItem().getDuration();
    	if(selectedItems!=null);
    	{

    	Stage stage = new Stage();
    	ExtensionController extension= new ExtensionController();
    	extension.start(stage);
		DataManager dm = DataManager.getDataManager();
		dm.setExtension(new Extension(duration,selectedItems,dm.getCurrentUser().getPersonalSID()));
    	}	
    }

    /**
     * @param event
     * @throws Exception
     * close window function activated once close button is clicked
     */
    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) RequestExtension_btnClose.getScene().getWindow();
    	TeacherMenuController tmc = new TeacherMenuController();
    	tmc.start(newStage);
    	stage.close();
    }
	/**
	 * @param primaryStage
	 * @throws IOException
	 * 
	 * starts window
	 */
	public void start(Stage primaryStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/CreateExtensionRequest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Extension Request");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	/**
	 * initialize table of tests
	 */
	@FXML
	public void initialize() {

		ObservableList<ActivatedTest> tests = FXCollections.observableArrayList( DataManager.getDataManager().getTeacherActivatedTests());
		RequestExtension_CodeCol.setCellValueFactory(new PropertyValueFactory<>("testCode"));
		RequestExtension_testIDCol.setCellValueFactory(new PropertyValueFactory<>("testID"));
		RequestExtension_DateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		RequestExtension_timeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
		RequestExtension_DurationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
		RequestExtension_tblTest.setItems(tests);
		
	}
}
