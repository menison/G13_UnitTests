package gui;

import com.jfoenix.controls.JFXTextField;

import cachedUserData.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class TestQuestionMiddleController {


    @FXML
    private Button middleQuestion_btnNext;

    @FXML
    private RadioButton middleQuestion_radioAns1;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton middleQuestion_radioAns2;

    @FXML
    private RadioButton middleQuestion_radioAns4;

    @FXML
    private RadioButton middleQuestion_radioAns3;

    @FXML
    private ProgressBar middleQuestion_progressBar;

    @FXML
    private ProgressIndicator middleQuestion_pieProgressIndic;
    
    @FXML
    private JFXTextField middleQuestion_pieProgressIndic12;

    @FXML
    private Button middleQuestion_back;
    
    private int CurrentQuestionIndex;
    
    private static DataManager dm = DataManager.getDataManager();

    @FXML
    void backPreviousQuestion(ActionEvent event) {
    	
    	CurrentQuestionIndex--;
    	
    	int numOfQuestions = dm.getTestInExecution().howManyQuestions();
    	middleQuestion_progressBar.setProgress(CurrentQuestionIndex / numOfQuestions);
    	
    	if (CurrentQuestionIndex == 1)
    		middleQuestion_back.setVisible(false);
    	
    	if (CurrentQuestionIndex == numOfQuestions - 1)
    		middleQuestion_btnNext.setText("Back");
    }

    @FXML
    void goNextQuestion(ActionEvent event) {
    	
    	CurrentQuestionIndex++;
    	
    	int numOfQuestions = dm.getTestInExecution().howManyQuestions();
    	middleQuestion_progressBar.setProgress(CurrentQuestionIndex / numOfQuestions);
    
    	if (CurrentQuestionIndex == numOfQuestions)
    		middleQuestion_btnNext.setText("Finish");
    	
    	if (CurrentQuestionIndex > 1)
    		middleQuestion_back.setVisible(true);
    	
   
    	
    }
    
    
    

}
