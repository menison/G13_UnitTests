package app;

import gui.ServerController;
import javafx.application.Application;
import javafx.stage.Stage;
import sql.CronTasks;

/**
 *  The server function that determines the port and start the server.
 *
 */
public class Server extends Application {

	final public static int DEFAULT_PORT = 5556;

	@Override
	public void start(Stage primaryStage) throws Exception {
		ServerController aFrame = new ServerController();
		aFrame.start(primaryStage);
		CronTasks.RunEveryDay();
	}

	public static void main(String args[]) throws Exception {
		launch(args);
	}

}
