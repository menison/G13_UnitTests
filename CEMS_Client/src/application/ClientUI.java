package application;

import gui.LoginCemsController;
//import gui.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Client User Interfacae class which extends Application class and initializing
 * both the login controller and the client controller.
 */
public class ClientUI extends Application {
	public static ClientController chat;

	public static void main(String args[]) throws Exception {
		launch(args);
	}

	/**
	 * This function initializes both the client controller and the login controller.
	 *@param primaryStage - a Stage to start on the login controller.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		chat = new ClientController("localhost", 5556);
		LoginCemsController aFrame = new LoginCemsController();
		aFrame.start(primaryStage);
	}

}
