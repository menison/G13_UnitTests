package gui;

import java.io.IOException;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    	//Stage newStage = new Stage();
    	Stage stage = (Stage) studentMenu_showTests.getScene().getWindow();
    	stage.close();
    	Stage primaryStage = new Stage();
    	//ImageView iv = new ImageView(getClass().getResource("/img/logo4.png").toExternalForm());
    	Pane root = loader.load(getClass().getResource("/fxml/TestTable.fxml").openStream());
    	//TestTableController ttc = new TestTableController();
    	//ttc.start(newStage);
    	showTTController = loader.getController();
    	ClientUI.chat.accept(new Message(Operation.GetTestTable));
    	showTTController.setTable();
    	//stage.close();
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
}
