package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class EditQuestionController for EditQuestion FXML
 * @author David
 * 
 * This class is used for editing questions
 * @param EditQuestion_btnClose			FXML: Close Button.						
 * @param EditQuestion_btnSubmit		FXML: Submit Button.			
 * @param EditQuestion_questionField	FXML: Field for question.
 * @param EditQuestion_asnwer1Field		FXML: First answer field.
 * @param EditQuestion_answer2Field		FXML: Second answer field.
 * @param EditQuestion_answer3Field		FXML: Third answer field.
 * @param EditQuestion_answer4Field		FXML: Fourth answer field.
 * @param EditQuestion_checkAnswer1		FXML: check answer 1
 * @param EditQuestion_checkAnswer2		FXML: check answer 2
 * @param EditQuestion_checkAnswer3		FXML: check answer 3
 * @param EditQuestion_checkAnswer4		FXML: check answer 4
 * @param EditQuestion_checkAnswer4		
 * @param EditQuestion_btnClear			FXML: button for clear
 * @param ToggleGroup1					
 */
public class EditQuestionController {

    @FXML
    private JFXButton EditQuestion_btnClose;

    @FXML
    private JFXButton EditQuestion_btnSubmit;

    @FXML
    private JFXTextArea EditQuestion_questionField;

    @FXML
    private JFXTextField EditQuestion_asnwer1Field;

    @FXML
    private JFXTextField EditQuestion_answer2Field;

    @FXML
    private JFXTextField EditQuestion_answer3Field;

    @FXML
    private JFXTextField EditQuestion_answer4Field;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer1;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer2;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer3;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer4;

    @FXML
    private JFXButton EditQuestion_btnClear;



    /**
     * clear: clears all fields
     * @param event
     */
    @FXML
    void clear(ActionEvent event) {
		EditQuestion_questionField.setText("");
		EditQuestion_asnwer1Field.setText("");
		EditQuestion_answer2Field.setText("");
		EditQuestion_answer3Field.setText("");
		EditQuestion_answer4Field.setText("");
		EditQuestion_checkAnswer1.setSelected(false);
		EditQuestion_checkAnswer2.setSelected(false);
		EditQuestion_checkAnswer3.setSelected(false);
		EditQuestion_checkAnswer4.setSelected(false);
		
    }

    /**
     * Closes window
     * @param event
     */
    @FXML
    void close(ActionEvent event) {
		Stage stage = (Stage) EditQuestion_btnClose.getScene().getWindow();
		stage.close();
    }

    /**
     * Activated once submit is clicked
     * this method submits the question in field for editing purpose
     * @param event 
     * @param answers			FXML:array of 4 answers
     * @param questionText		question from question text field		
     * @param answer			answer holds 4 answers in one string
     * @param question			Question object for created question
     * @param id				question id sent from previous window
     * @param composer			question editor
     * 
     */
    @FXML
    void submitQuestion(ActionEvent event) {
    	if(EditQuestion_questionField.getText().isEmpty())
    		warningPopUp("Question text filed is empty");
    	else if(EditQuestion_asnwer1Field.getText().isEmpty()||EditQuestion_answer2Field.getText().isEmpty()||
    			EditQuestion_answer3Field.getText().isEmpty()||EditQuestion_answer4Field.getText().isEmpty()) {
    		warningPopUp("All 4 answer are needed");
    	}

    	
    	String[] answers = new String[4];
    	String questionText =EditQuestion_questionField.getText();
    	String id= DataManager.getDataManager().getQuestion().getQuestionID();
    	String composer=DataManager.getDataManager().getCurrentUser().getPersonalSID();
    	int selected=0;
    	if(EditQuestion_checkAnswer1.isSelected()) {
    		selected=0;
    	}
    	if(EditQuestion_checkAnswer2.isSelected()) {
    		selected=1;
    	}
    	if(EditQuestion_checkAnswer3.isSelected()) {
    		selected=2;
    	}
    	if(EditQuestion_checkAnswer4.isSelected()) {
    		selected=3;
    	}

    	answers[0]=EditQuestion_asnwer1Field.getText();
    	answers[1]=EditQuestion_answer2Field.getText();	
    	answers[2]=EditQuestion_answer3Field.getText();
    	answers[3]=EditQuestion_answer4Field.getText();
    	String answer=answers[0]+","+answers[1]+","+answers[2]+","+answers[3];
    	
    	Question question = new Question(id, questionText,answers,selected,composer);
    	question.setAnswersString(answer);
    	ClientUI.chat.accept(new Message(Operation.SubmitQuestionInfo,question));
    	confirmPopUp(DataManager.getDataManager().getActivateMsg());
    	
    }
	public void start(Stage newStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EditQuestion.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Edit Question For Test");
		newStage.setScene(scene);
		newStage.show();
	}
	/**initialize
	 * this methods initializes the window and fills its fields with chosen question information
	 */
	@FXML
	public void initialize() {
		String questionID=DataManager.getDataManager().getTestID();
		ClientUI.chat.accept(new Message(Operation.GetQuestionInfo,questionID));
		
		Question question = DataManager.getDataManager().getQuestion();
		EditQuestion_questionField.setText(question.getText());
		EditQuestion_asnwer1Field.setText(question.getAnswers()[0]);
		EditQuestion_answer2Field.setText(question.getAnswers()[1]);
		EditQuestion_answer3Field.setText(question.getAnswers()[2]);
		EditQuestion_answer4Field.setText(question.getAnswers()[3]);
		EditQuestion_checkAnswer1.setSelected(false);
		EditQuestion_checkAnswer2.setSelected(false);
		EditQuestion_checkAnswer3.setSelected(false);
		EditQuestion_checkAnswer4.setSelected(false);
		if(question.getCorrectAnswerIndex()==0)
			EditQuestion_checkAnswer1.setSelected(true);
		if(question.getCorrectAnswerIndex()==1)
			EditQuestion_checkAnswer2.setSelected(true);
		if(question.getCorrectAnswerIndex()==2)
			EditQuestion_checkAnswer3.setSelected(true);
		if(question.getCorrectAnswerIndex()==3)
			EditQuestion_checkAnswer4.setSelected(true);
	}
	
    /**
     *  Warning alert
     * @param warning			Warning String for alert.
     *
     */
    public void warningPopUp(String warning) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(warning);

		alert.showAndWait();
    }
    /**
     *  confirm alert 
     * @param confirm			confirm String for alert.
     */
    public void confirmPopUp(String confirm) {  
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(confirm);

		alert.showAndWait();
    }
	
}
