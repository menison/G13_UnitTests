package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentMenuController {
	@FXML
	private Button studentMenu_takeTest;
	@FXML
	private Button studentMenu_showTests;
	@FXML
	private Button studentMenu_logOut;
	
	@FXML
    void showTestTable(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) studentMenu_showTests.getScene().getWindow();
    	TestTableController ttc = new TestTableController();
    	ttc.start(newStage);
    	stage.close();
    }
	
	@FXML
    void takeTest(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) studentMenu_takeTest.getScene().getWindow();
    	EnterTestCodeController etc = new EnterTestCodeController();
    	etc.start(newStage);
    	stage.close();
    }
	
	public void start(Stage primaryStage) throws Exception {	
		//Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/StudentMenu.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Student Menu");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
}
