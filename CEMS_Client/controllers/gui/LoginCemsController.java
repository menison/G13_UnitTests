package gui;

import java.io.IOException;
import java.util.ArrayList;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import request.AbstractController;
import request.Login;
import entities.Message;
import entities.Teacher;
import common.Operation;

public class LoginCemsController extends AbstractController {

    @FXML
    private JFXPasswordField login_txtPassword;

    @FXML
    private JFXTextField login_txtUsername;

    @FXML
    private static JFXButton login_btnLogin;

    @FXML
    private JFXButton login_btnCancel;
    
//    @FXML
//    void login(ActionEvent event) throws Exception {
//    	Stage newStage = new Stage();
//    	if(login_txtUsername.getText().equals("student")) {
//        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
//        	StudentMenuController smc = new StudentMenuController();
//        	smc.start(newStage);
//        	stage.close();
//    	}
//    	else if(login_txtUsername.getText().equals("teacher")) {
//        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
//        	TeacherMenuController tmc = new TeacherMenuController();
//        	tmc.start(newStage);
//        	stage.close();
//    	}
//    	else if(login_txtUsername.getText().equals("principal")) {
//        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
//        	PrincipalMenuController pmc = new PrincipalMenuController();
//        	pmc.start(newStage);
//        	stage.close();
//    	}
//    }
    @FXML
    void login(ActionEvent event) {
    	Login.requestLogin(login_txtUsername.getText(), login_txtPassword.getText(), event);
    }
    @FXML
    void Exit(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide();
    	System.exit(0);
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
    
	public static void setTeacherLogin(Teacher teacher, ActionEvent event) {
		Stage newStage = new Stage();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				FXMLLoader loader = new FXMLLoader();
				Pane root;
				try {
		        	Stage stage = (Stage) login_btnLogin.getScene().getWindow();
		        	TeacherMenuController tmc = new TeacherMenuController();
		        	tmc.start(newStage);
		        	stage.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

	}
}
