package gui;

import java.net.URL;
import java.util.ResourceBundle;

import cachedUserData.DataManager;
import entities.Principal;
import entities.Student;
import entities.Teacher;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import request.Login;

public class MyLoginCemsController implements ILoginCemsController {
	
    void login(ActionEvent event) {LoginCemsController.loginCemsController.login(event);}
    void Exit(ActionEvent event) {LoginCemsController.loginCemsController.Exit(event);}
    public void start(Stage primaryStage) throws Exception {LoginCemsController.loginCemsController.start(primaryStage);}
	public static void setTeacherLogin(Teacher teacher,ActionEvent event) {LoginCemsController.setTeacherLogin(teacher, event);}
	public static void setStudentLogin(Student student,ActionEvent event) {LoginCemsController.setStudentLogin(student, event);}
	public static void setPrincipalLogin(Principal principal,ActionEvent event) {LoginCemsController.setPrincipalLogin(principal, event);}
	public void initialize(URL location, ResourceBundle resources) {LoginCemsController.loginCemsController.initialize(location, resources);}
	public void setError(String msg) {LoginCemsController.loginCemsController.setError(null);}
}
