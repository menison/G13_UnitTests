package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.Question;
import entities.TestForFullTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
	
	@FXML
	void addQuestion(ActionEvent event) throws IOException {
		CreateQuestionController cqc  = new CreateQuestionController();	
		Stage primaryStage = new Stage();
		cqc.start(primaryStage);
		//((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
	}
	
	@FXML
	void close(ActionEvent event) throws IOException {
		TeacherMenuController tmc  = new TeacherMenuController();	
		Stage primaryStage = new Stage();
		tmc.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
	}

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

}
