package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import com.jfoenix.controls.JFXTextField;
import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.ExecutedTest;
import entities.Message;
import entities.Test;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ManualTestController implements Initializable{

	private File SolutionFile;
	
	private File filepath;

	@FXML
	private Button manualTest_btnDownload;

	@FXML
	private Button manualTest_btnUpload;

	@FXML
	private ProgressIndicator manualTest_pieProgressIndicator;

	@FXML
	private JFXTextField manualTest_txtElapsedTime;

	@FXML
	private Button manualTest_btnSend;
	
	private boolean submited;
	private ExecutedTest execTest;
	@FXML
    void downloadTest(ActionEvent event) {
		Stage stage = (Stage) manualTest_btnDownload.getScene().getWindow();
		DataManager dm = DataManager.getDataManager();
		Test test = dm.getTestInExecution().getTest();
		FileChooser fc = new FileChooser();
		fc.setInitialFileName(test.getTestID() + "_" + test.getCurrExecutionCode()+".txt");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fc.setSelectedExtensionFilter(new ExtensionFilter("txt","*.txt"));
		File file = fc.showSaveDialog(stage);
		filepath = file;
		Object[] arr = new Object[2];
		arr[0] = (Object)file;
		arr[1] = (Object)test;
		ClientUI.chat.accept(new Message(Operation.DownloadManualTest, (Object)arr));
		System.out.println("Test downloaded successfully. You can find it in: " 
				+ file.getAbsolutePath() + "\n");
    }

	@FXML
	void uploadTest(ActionEvent event) {
		Stage stage = (Stage) manualTest_btnUpload.getScene().getWindow();
		FileChooser fc = new FileChooser();
		int index = filepath.getAbsolutePath().lastIndexOf("\\");
		File folderpath = new File(filepath.getAbsolutePath().substring(0, index));
		fc.setInitialDirectory(new File(folderpath.getAbsolutePath()));
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fc.setSelectedExtensionFilter(new ExtensionFilter("txt","*.txt"));
		SolutionFile = fc.showOpenDialog(stage);
	}

	@FXML
	void sendManualTest(ActionEvent event) {
		DataManager dm = DataManager.getDataManager();
		ExecutedTest execTest = dm.getTestInExecution();
		Object[] arr = new Object[2];
		arr[0] = SolutionFile;
		arr[1] = execTest;
		System.out.println("before upload accept");
		ClientUI.chat.accept(new Message(Operation.UploadManualTest, arr));
		System.out.println("Test sent succesfully. Good luck!\n");
		TestFinalController tfc = new TestFinalController();
		Stage primaryStage = new Stage();
		Stage stage = (Stage)manualTest_btnSend.getScene().getWindow();
		stage.close();
		tfc.start(primaryStage);
	}

	public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ManualTest.fxml"));
		submited = false;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Manual Test");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
                	manualTest_pieProgressIndicator.setProgress((double)countUp/(allocatedDuration*60));
                	manualTest_txtElapsedTime.setText(h+":"+m+":"+s);
                }
            });
            countUp++;
            if(submited) 
            	execTest.setActualDuration(countUp/60);
            	this.cancel();
        	totalSeconds--;
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	DataManager dm = DataManager.getDataManager();
    	execTest = dm.getTestInExecution();
    	Timer timer = new Timer();
    	timer.schedule(new App(), 0, 1000);
	}

}
