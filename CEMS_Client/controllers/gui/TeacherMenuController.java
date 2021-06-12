package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class TeacherMenuController {

	@FXML
	private JFXButton teacherMenu_btnQuestionTable;

	@FXML
	private JFXButton teacherMenu_btnTestTable;

	@FXML
	private JFXButton teacherMenu_btnTestExt;

	@FXML
	private JFXButton teacherMenu_btnTestsStats;

	@FXML
	private JFXButton teacherMenu_btnLogout;
	private FullTestTableController showFTTController;

	public void start(Stage primaryStage) throws Exception {
		// Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TeacherMenu.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Teacher Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void testTable(ActionEvent event) throws IOException {
		FullTestTableController ftt  = new FullTestTableController();
		ClientUI.chat.accept(new Message(Operation.GetFullTestTable));
		Stage primaryStage = new Stage();
		ftt.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
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

	@FXML
	void testsForReport(ActionEvent event) throws IOException {
		ClientUI.chat.accept(new Message(Operation.GetTestsForTeacherReport,
				DataManager.getDataManager().getCurrentUser().getPersonalSID()));
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		TestsStatisticsController tsc = new TestsStatisticsController();
		tsc.start(newStage);
		currentStage.close();
	}
}