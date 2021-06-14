package gui;

import java.io.IOException;


import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author David
 * QuestionTableController for QuestionTable FXML
 */
public class QuestionTableController{

    @FXML
    private JFXButton questionTbl_btnAddQuestion;

    @FXML
    private JFXButton questionTbl_btnEditQuestion;

    @FXML
    private JFXButton questionTbl_btnClose;

    @FXML
    private TableView<Question> questionsTable;

    @FXML
    private TableColumn<Question, String> questionIdColumn;

    @FXML
    private TableColumn<Question, String> questionTxtColumn;

    @FXML
    private TableColumn<Question, String[]> answersColumn;

    @FXML
    private TableColumn<Question, Integer> correctAnswerColumn;

    @FXML
    private TableColumn<Question, String> questionComposerColumn;
    
	/**
	 * starts window
	 * @param primaryStage
	 * @throws IOException
	 */
	public void start(Stage primaryStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/QuestionTable.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Full Question Table");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * opens adds question window 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addQuestion(ActionEvent event) throws IOException {
		CreateQuestionController cqc  = new CreateQuestionController();	
		Stage primaryStage = new Stage();
		cqc.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
	}
	
	/**
	 * closes the window
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void close(ActionEvent event) throws IOException {
		TeacherMenuController tmc  = new TeacherMenuController();	
		Stage primaryStage = new Stage();
		tmc.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
	}

	/**
	 * initializes table view
	 */
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetQuestions));
    	ObservableList<Question> questions = FXCollections.observableArrayList(DataManager.getDataManager().getQuestions());
    	questionIdColumn.setCellValueFactory(new PropertyValueFactory<>("questionID"));
    	questionTxtColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
    	answersColumn.setCellValueFactory(new PropertyValueFactory<>("answersString"));
    	correctAnswerColumn.setCellValueFactory(new PropertyValueFactory<>("correctAnswerIndex"));
    	questionComposerColumn.setCellValueFactory(new PropertyValueFactory<>("teacherComposed"));
    	questionsTable.setItems(questions);

	}    
	/**
	 * opens window editQuestion
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void editQuestion(ActionEvent event) throws IOException {
    	if(questionsTable.getSelectionModel().getSelectedItem()!=null){
            Object selectedItems=questionsTable.getSelectionModel().getSelectedItem().getQuestionID();
        	Stage stage = new Stage();
        	EditQuestionController eqc= new EditQuestionController();
    		DataManager dm = DataManager.getDataManager();
    		dm.setTestID(selectedItems.toString());
        	eqc.start(stage);

    		
        	}else {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setContentText("Please choose a question first first.");

        		alert.showAndWait();
        	}
    }

}
