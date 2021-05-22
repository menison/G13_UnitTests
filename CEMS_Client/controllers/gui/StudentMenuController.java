package gui;

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
