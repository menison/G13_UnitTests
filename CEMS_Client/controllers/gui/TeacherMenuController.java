package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    
    public void start(Stage primaryStage) throws Exception {	
		//Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TeacherMenu.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Teacher Menu");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

}