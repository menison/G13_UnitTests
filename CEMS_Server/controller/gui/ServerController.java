package gui;

import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logics.ClientConnection;
import server.ServerConnection;

public class ServerController implements Initializable {
	
	public static ServerController sc;

    @FXML
    private Button startServerBtn;

    @FXML
    private Button stopServerBtn;

    @FXML
    private Button exitServerBtn;

    @FXML
    private TextArea serverLogTxt;

    @FXML
    private TableView<ClientConnection> clientTable;

    @FXML
    private TableColumn<ClientConnection, String> colIP;

    @FXML
    private TableColumn<ClientConnection, String> colHost;

    @FXML
    private TableColumn<ClientConnection, String> colStatus;
    
    @FXML
    void Exit(ActionEvent event) {
		ServerConnection.stopServer(this);
		System.exit(0);
    }
	@FXML
	void StopServer(ActionEvent event) {
		ServerConnection.stopServer(this);
		//BtnConection.setText("OFF");
		//BtnConection.getStylesheets().add("/css/Btn.css");
		//BtnConection.setStyle("-fx-text-fill: red");
	}
	@FXML
	void StartServer(ActionEvent event) {
		ServerConnection.runServer(null, this);
		//BtnConection.setText("ON");
		//BtnConection.getStylesheets().add("/css/Btn.css");
		//BtnConection.setStyle("-fx-text-fill: green");
	}
    
	public void addToTextArea(String msg) {
		String timeStamp = new SimpleDateFormat("[dd.MM.yyyy]  [HH:mm:ss]  ").format(Calendar.getInstance().getTime());
		Platform.runLater(() -> serverLogTxt.appendText(timeStamp + msg + "\n"));
	}
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ServerWindow.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void Update(ArrayList<ClientConnection> client) {

		addToTextArea("Update Table by client --> " + client);
		ObservableList<ClientConnection> data = FXCollections.observableArrayList(client);
		clientTable.setItems(data);
		clientTable.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sc=this;
		colIP.setCellValueFactory(new PropertyValueFactory<ClientConnection, String>("ipAddress"));
		colHost.setCellValueFactory(new PropertyValueFactory<ClientConnection, String>("hostName"));
		colStatus.setCellValueFactory(new PropertyValueFactory<ClientConnection, String>("status"));
		
	}
}
