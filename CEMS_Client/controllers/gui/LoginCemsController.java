package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginCemsController {

    @FXML
    private JFXPasswordField login_txtPassword;

    @FXML
    private JFXTextField login_txtUsername;

    @FXML
    private JFXButton login_btnLogin;

    @FXML
    private JFXButton login_btnCancel;
    
    @FXML
    void login(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	if(login_txtUsername.getText().equals("student")) {
        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
        	StudentMenuController smc = new StudentMenuController();
        	smc.start(newStage);
        	stage.close();
    	}
    	else if(login_txtUsername.getText().equals("teacher")) {
        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
        	TeacherMenuController tmc = new TeacherMenuController();
        	tmc.start(newStage);
        	stage.close();
    	}
    	else if(login_txtUsername.getText().equals("principal")) {
        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
        	PrincipalMenuController pmc = new PrincipalMenuController();
        	pmc.start(newStage);
        	stage.close();
    	}
    }
    
    public void start(Stage primaryStage) throws Exception {	
		//Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/LoginCems.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login CEMS");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
}
