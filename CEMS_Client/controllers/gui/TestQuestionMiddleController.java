package gui;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.ExecutedTest;
import entities.Message;
import entities.QaForTable;
import entities.TestForTable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestQuestionMiddleController implements Initializable{


    @FXML
    private Button middleQuestion_btnNext;
    
    @FXML
    private Label middleQuestion_questionLbl;
    
    @FXML
    private Label middleQuestion_questionTextLbl;
    
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
    
    @FXML
    private TableView<QaForTable> middleQuestion_qaTable;

    @FXML
    private TableColumn<QaForTable, String> middleQuestion_qaCol1;

    @FXML
    private TableColumn<QaForTable, Integer> middleQuestion_qaCol2;
    
    private int CurrentQuestionIndex;
    private int totalNumOfQuestions;
    private static DataManager dm = DataManager.getDataManager();
    private ExecutedTest execTest = dm.getTestInExecution();
    private Boolean submited;
    private Boolean  late = false;
  
    public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		Scene scene = null;
		loader.setLocation(getClass().getResource("/fxml/TestQuestionMiddle.fxml"));
		try {
			root = loader.load();
			scene = new Scene(root);
			primaryStage.setTitle("Test - " + dm.getTestInExecution().getExecutionCodePK());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    void backPreviousQuestion(ActionEvent event) {
    	if(middleQuestion_btnNext.getText().equals("Submit")) {
    		middleQuestion_qaTable.setVisible(false);
        	middleQuestion_questionTextLbl.setVisible(true);
        	middleQuestion_btnNext.setText("Finish");
        	middleQuestion_radioAns1.setVisible(true);
    	    middleQuestion_radioAns2.setVisible(true);
    	    middleQuestion_radioAns3.setVisible(true);
    	    middleQuestion_radioAns4.setVisible(true);
    	    setQuestions();
    		return;
    	}
    	execTest.setAnswers(CurrentQuestionIndex,getMarkedAnswer());
    	CurrentQuestionIndex--;
    	setLastAnswer();
    	middleQuestion_progressBar.setProgress((double)(CurrentQuestionIndex+1) / totalNumOfQuestions);
    	setQuestions();
    	if ((CurrentQuestionIndex+1) < totalNumOfQuestions)
    		middleQuestion_btnNext.setText("Next");
    	if (CurrentQuestionIndex == 0)
    		middleQuestion_back.setVisible(false);
    	if (CurrentQuestionIndex == totalNumOfQuestions - 1)
    		middleQuestion_btnNext.setText("Back");
    }

    @FXML
    void goNextQuestion(ActionEvent event) {
    	execTest.setAnswers(CurrentQuestionIndex,getMarkedAnswer());
    	if(middleQuestion_btnNext.getText().equals("Submit")) {
    		submited = true;
    		calculateGrade();
    		try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {}
    		ClientUI.chat.accept(new Message(Operation.SetCompletedExam,execTest)); 
    		TestFinalController tfc = new TestFinalController();
    		Stage primaryStage = new Stage();
    		Stage stage = (Stage) middleQuestion_btnNext.getScene().getWindow();
    		stage.close();
    		tfc.start(primaryStage);
    		return;
    	}
    	if(middleQuestion_btnNext.getText().equals("Finish")) {
    		setFinalAnswerTable();
    		return;
    	}
    	CurrentQuestionIndex++;
    	setLastAnswer();
    	middleQuestion_progressBar.setProgress((double)(CurrentQuestionIndex+1) / totalNumOfQuestions);
    	setQuestions();
    	if ((CurrentQuestionIndex+1) == totalNumOfQuestions)
    		middleQuestion_btnNext.setText("Finish");
    	if (CurrentQuestionIndex >= 1)
    		middleQuestion_back.setVisible(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CurrentQuestionIndex = 0;
		ClientUI.chat.accept(new Message(Operation.getTimeForActiveExam,execTest.getExecutionCodePK()));
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM"); 
	    Date date = new Date();
	    long diff = getTimeDifference();
	    if(diff > 10) 
	    	late = true;
		setQuestions();
		execTest.initAnswers();
		execTest.getTest().setActivated(1);
		String dateOfExec = formatter.format(date);
		execTest.setDate(dateOfExec);
		Timer timer = new Timer();
		submited = false;
		middleQuestion_back.setVisible(false);
		middleQuestion_qaTable.setVisible(false);
		resetAnswers();
		totalNumOfQuestions = execTest.getTest().howManyQuestions();
		middleQuestion_pieProgressIndic.setProgress(0);
		middleQuestion_progressBar.setProgress((double)(CurrentQuestionIndex+1) / totalNumOfQuestions);
		timer.schedule(new App(), 0, 1000);
	}
    
	public long getTimeDifference() {
		SimpleDateFormat formatterTime = new SimpleDateFormat("HHmm"); 
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String testStartTime = execTest.getsTime();
		Date timeNow = new Date();
		String strTimeNow = formatterTime.format(timeNow);
		String h = new String(testStartTime.substring(0,2));
		String m = new String(testStartTime.substring(2,4));
		testStartTime = new String(h+":"+m);
		h = new String(strTimeNow.substring(0,2));
		m = new String(strTimeNow.substring(2,4));
		strTimeNow = new String(h+":"+m);
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = format.parse(testStartTime);
			date2 = format.parse(strTimeNow);
		} catch (ParseException e) {}
		long difference = date2.getTime() - date1.getTime(); 
		long minutesDiff = ((difference/1000)/60);
		return minutesDiff;
	}
	
	public void calculateGrade() {
		DataManager dm = DataManager.getDataManager();
		int grade = 0;
		int[] studentAnswers = execTest.getAnswers();
		String[] pointDistributionString = execTest.getTest().getPointDistribution();
		int[] pointDistribution = new int[pointDistributionString.length];
		for(int i = 0; i < pointDistributionString.length;i++)
			pointDistribution[i] = Integer.parseInt(pointDistributionString[i]);
		for(int i = 0; i < execTest.getTest().questions.size();i++)
			if(studentAnswers[i] == execTest.getTest().questions.get(i).getCorrectAnswerIndex())
				grade+=pointDistribution[i];
		execTest.setGrade(grade);
	}
	
    public void setQuestions() {
    	String[] answers = execTest.getTest().questions.get(CurrentQuestionIndex).getAnswers();
    	middleQuestion_questionLbl.setText("Question #" + Integer.toString(CurrentQuestionIndex + 1));
		middleQuestion_questionTextLbl.setText(execTest.getTest().questions.get(CurrentQuestionIndex).getText());
		middleQuestion_radioAns1.setText(answers[0]);
		middleQuestion_radioAns2.setText(answers[1]);
		middleQuestion_radioAns3.setText(answers[2]);
		middleQuestion_radioAns4.setText(answers[3]);
    }
    
    public int getMarkedAnswer() {
    	if(middleQuestion_radioAns1.isSelected())
    		return 0;
    	else if(middleQuestion_radioAns2.isSelected())
    		return 1;
    	else if(middleQuestion_radioAns3.isSelected())
    		return 2;
    	else if(middleQuestion_radioAns4.isSelected())
    		return 3;
    	else return -1;
    }
    public void setLastAnswer() {
    	int[] answers = execTest.getAnswers();
    	switch(answers[CurrentQuestionIndex]) {
    	case -1:
    		resetAnswers();
    		break;
    	case 0:
    		middleQuestion_radioAns1.setSelected(true);
    		break;
    	case 1:
    		middleQuestion_radioAns2.setSelected(true);
    		break;
    	case 2:
    		middleQuestion_radioAns3.setSelected(true);
    		break;
    	case 3:
    		middleQuestion_radioAns4.setSelected(true);
    		break;
    	}
    }
    public void resetAnswers() {
	    middleQuestion_radioAns1.setSelected(false);
	    middleQuestion_radioAns2.setSelected(false);
	    middleQuestion_radioAns3.setSelected(false);
	    middleQuestion_radioAns4.setSelected(false);
    }
    @FXML
    public void setFinalAnswerTable() {
    	ArrayList<QaForTable> qaForTable = new ArrayList<QaForTable>();
    	int[] answers = execTest.getAnswers();
    	String[] questionStr = new String[totalNumOfQuestions];
    	middleQuestion_questionLbl.setText("Final Review");
    	middleQuestion_questionTextLbl.setVisible(false);
    	middleQuestion_btnNext.setText("Submit");
    	middleQuestion_radioAns1.setVisible(false);
	    middleQuestion_radioAns2.setVisible(false);
	    middleQuestion_radioAns3.setVisible(false);
	    middleQuestion_radioAns4.setVisible(false);
    	for(int i = 0; i < questionStr.length; i++)
    		questionStr[i] = new String("Question " + (i+1));
    	for(int i = 0; i < totalNumOfQuestions; i++) {
    		QaForTable q = new QaForTable(questionStr[i],(answers[i] + 1));
    		qaForTable.add(q);
    	}
    	ObservableList<QaForTable> questions = FXCollections.observableArrayList(qaForTable);
    	middleQuestion_qaCol1.setCellValueFactory(new PropertyValueFactory<>("questionNum"));
    	middleQuestion_qaCol2.setCellValueFactory(new PropertyValueFactory<>("answer"));
    	middleQuestion_qaTable.setItems(questions);
    	middleQuestion_qaTable.setVisible(true);
    }
    public void foceClose() {
    	CurrentQuestionIndex = (totalNumOfQuestions -1);
    	setFinalAnswerTable();
    	if(late)
    		middleQuestion_questionLbl.setText("Final Review - Entered Late");
    	middleQuestion_progressBar.setProgress((double)(CurrentQuestionIndex+1) / totalNumOfQuestions);
    	middleQuestion_back.setVisible(false);
    }
    
    class App extends TimerTask {
    	int allocatedDuration = execTest.getTest().getAllocatedDuration();
        int countdown = allocatedDuration;
        int countUp = 0;
        int totalSeconds = allocatedDuration*60;
        long h,m,s;
        public void run() { 
        	s = totalSeconds % 60;
        	h = totalSeconds / 60;
        	m = h % 60;
        	h/=60;
        	Platform.runLater(new Runnable() {
                @Override
                public void run() {
                	middleQuestion_pieProgressIndic.setProgress((double)countUp/(allocatedDuration*60));
                    middleQuestion_pieProgressIndic12.setText(h+":"+m+":"+s);
                    ClientUI.chat.accept(new Message(Operation.CheckIfTestIsLocked,execTest.getExecutionCodePK()));
                }
            });
            countUp++;
            if((totalSeconds == 0) || (execTest.getTest().isActivated() == 0) || (late == true)) {
            	Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    	execTest.setActualDuration(countUp/60);
                    	foceClose();
                    }
                });
            	this.cancel();
            }
            if(submited) {
            	execTest.setActualDuration(countUp/60);
            	this.cancel();
            }
            //Test Extension Checker
            //------------------------------------------------------------------
        	if((s == 0) && (totalSeconds != 0) && (totalSeconds != (allocatedDuration*60))) {
        		Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    	ClientUI.chat.accept(new Message(Operation.GetTimeForTestInExecution,
                				execTest.getExecutionCodePK())); 
                    }
                });
        		int durationToCompare = execTest.getTest().getAllocatedDuration();
        		if(durationToCompare != allocatedDuration) {
        			allocatedDuration = durationToCompare;
        			totalSeconds = ((allocatedDuration*60)-totalSeconds);
        		}
        	}
            //--------------------------------------------------------------------
        	totalSeconds--;
        	
        }
    }

}
