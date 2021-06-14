package gui;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cachedUserData.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * /** A controller class handling the interaction with principal in get
 * generated report window.
 */
public class PrincipalGeneratedReportController {

	@FXML
	private BarChart<?, ?> PrincipalGeneratedReport_principalHistogram;

	@FXML
	private JFXTextField PrincipalGeneratedReport_byTxt;

	@FXML
	private JFXTextField PrincipalGeneratedReport_AverageScoreTxt;

	@FXML
	private JFXTextField PrincipalGeneratedReport_medianTxt;

	@FXML
	private JFXButton PrincipalGeneratedReport_btnExit;

	/**
	 * Standard controller starting mechanism.
	 * 
	 * @param primaryStage - a stage to start on.
	 * @throws IOException
	 */
	public void start(Stage primaryStage) {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalGeneratedReport.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Principal Generated Report");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes the histogram and all the relevant information with
	 * data from The server.
	 */
	@FXML
	public void initialize() {
		DataManager dm = DataManager.getDataManager();
		PrincipalGeneratedReport_byTxt.setText(PrincipalGeneratedReport_byTxt.getText() + ": "
				+ dm.getReport().getGegeneratedBy() + "-" + dm.getReport().getValue());
		PrincipalGeneratedReport_AverageScoreTxt
				.setText(PrincipalGeneratedReport_AverageScoreTxt.getText() + ": " + dm.getReport().getAverageScore());
		PrincipalGeneratedReport_medianTxt
				.setText(PrincipalGeneratedReport_medianTxt.getText() + ": " + dm.getReport().getMedian());
		XYChart.Series set1 = new XYChart.Series<>();
		for (Integer key : dm.getReport().getGradesAndAppearance().keySet()) {
			set1.getData().add(new XYChart.Data(key.toString(), dm.getReport().getGradesAndAppearance().get(key)));
		}
		PrincipalGeneratedReport_principalHistogram.getData().addAll(set1);
	}

	/**
	 * This method exits the current window and routes the user back to the principal get
	 * report window.
	 * @param event - exit clicked
	 */
	@FXML
	void PrincipalGeneratedReport_btnExitClicked(ActionEvent event) {
		DataManager.getDataManager().getReport().getGradesAndAppearance().clear();
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		PrincipalGetReportWindowController pgrwc = new PrincipalGetReportWindowController();
		try {
			pgrwc.start(newStage);
			currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
