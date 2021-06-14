package gui;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import cachedUserData.DataManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import request.AbstractController;
import javafx.scene.control.Label;
import request.Login;
import entities.Principal;
import entities.Student;
import entities.Teacher;

/**
 * @author David
 *	LoginCemsController for Login FXML
 */
public class LoginCemsController extends AbstractController implements Initializable{
	
	public static LoginCemsController loginCemsController;

    @FXML
    private JFXPasswordField login_txtPassword;

    @FXML
    private JFXTextField login_txtUsername;

    @FXML
    private static JFXButton login_btnLogin;

    @FXML
    private JFXButton login_btnCancel;
    
    @FXML
    private Label TxtError;
    
    /**
     *login when login button clicked
     * @param event
     */
    @FXML
    void login(ActionEvent event) {
    	Login.requestLogin(login_txtUsername.getText(), login_txtPassword.getText(), event);
    }
    /**
     * when exit button clicked it exits the window
     * @param event
     */
    @FXML
    void Exit(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide();
    	System.exit(0);
    }
    
    /**
     * starts LoginCems window
     * @param primaryStage
     * @throws Exception
     */
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
    
	/**
	 * teacher login if user id was teacher
	 * @param teacher
	 * @param event
	 */
	public static void setTeacherLogin(Teacher teacher,ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Stage newStage = new Stage();
				TeacherMenuController tmc = new TeacherMenuController();
				try {
					tmc.start(newStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

	}
	/**
	 *  student login if user id was student
	 * @param student
	 * @param event
	 */
	public static void setStudentLogin(Student student,ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Stage newStage = new Stage();
				StudentMenuController smc = new StudentMenuController();
				try {
					smc.start(newStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

	}
	/**student principal if user id was principal
	 * @param principal
	 * @param event
	 */
	public static void setPrincipalLogin(Principal principal,ActionEvent event) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Stage newStage = new Stage();
				PrincipalMenuController pmc = new PrincipalMenuController();
				try {
					pmc.start(newStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

	}
	/**
	 *	initialize window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(DataManager.getDataManager().getCurrentUser()!=null)
			Login.LogOut(DataManager.getDataManager().getCurrentUser().getPersonalSID());
		loginCemsController =this;	
		TxtError.setVisible(false);
		
	}
	
	public void setError(String msg) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				TxtError.setVisible(true);
				TxtError.setText(msg);
				TxtError.setAlignment(Pos.CENTER);
			}
		});

	}
}
