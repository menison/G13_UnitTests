package gui;

import java.io.IOException;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentMenuController {
	@FXML
	private Button studentMenu_takeTest;
	@FXML
	private Button studentMenu_showTests;
	@FXML
	private Button studentMenu_logOut;
	private TestTableController showTTController;
	
	@FXML
    void showTestTable(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	Stage stage = (Stage) studentMenu_showTests.getScene().getWindow();
    	DataManager dm = DataManager.getDataManager();
    	stage.close();
    	Stage primaryStage = new Stage();
    	Pane root = loader.load(getClass().getResource("/fxml/TestTable.fxml").openStream());
    	showTTController = loader.getController();
    	ClientUI.chat.accept(new Message(Operation.GetTestTable,dm.getCurrentUser().getPersonalSID()));
    	if(dm.getExecutedExams() != null)
    		showTTController.setTable();
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("/css/das.css").toExternalForm());
    	primaryStage.getIcons().add(new Image("/img/logo4.png"));
		primaryStage.setTitle("Test Table");
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
	
	@FXML
    void takeTest(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) studentMenu_takeTest.getScene().getWindow();
    	EnterTestCodeController etc = new EnterTestCodeController();
    	etc.start(newStage);
    	stage.close();
    }
	
	public void start(Stage primaryStage){	
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/StudentMenu.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Student Menu");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void logOut(ActionEvent event) throws IOException {
		Stage newStage = new Stage();
		LoginCemsController lcc = new LoginCemsController();
		try {
			lcc.start(newStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Node) event.getSource()).getScene().getWindow().hide();
		
	}
}
