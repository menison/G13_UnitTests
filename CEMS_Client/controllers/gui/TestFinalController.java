package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import cachedUserData.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestFinalController implements Initializable{

    @FXML
    private Button txtSentSuccess_btnClose;

    @FXML
    private JFXTextField testSentSuccess_txtTimeSpent;
    

    public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestFinal.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Finished - test sent successfully!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void close(ActionEvent event) {
    	Stage primaryStage = (Stage) txtSentSuccess_btnClose.getScene().getWindow();
    	primaryStage.close();
    	StudentMenuController smc = new StudentMenuController();
    	primaryStage = new Stage();
    	smc.start(primaryStage);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DataManager dm = DataManager.getDataManager();
		int s,h,m;
		int totalSeconds = (dm.getTestInExecution().getActualDuration()*60);
		s = totalSeconds % 60;
    	h = totalSeconds / 60;
    	m = h % 60;
    	h/=60;
		testSentSuccess_txtTimeSpent.setText(h + ":" + m);
	}
}
