package app;

import gui.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
	public static ClientController chat;

	public static void main(String args[]) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		chat = new ClientController("localhost", 5556);
		LoginController aFrame = new LoginController();
		aFrame.start(primaryStage);
	}

}
