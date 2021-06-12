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
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    
	public void start(Stage primaryStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalGeneratedReport.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Principal Generated Report");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	@FXML
	public void initialize() {
		DataManager dm = DataManager.getDataManager();
		PrincipalGeneratedReport_byTxt.setText(PrincipalGeneratedReport_byTxt.getText() + ": " + dm.getReport().getGegeneratedBy()+ "-" + dm.getReport().getValue());
		PrincipalGeneratedReport_AverageScoreTxt.setText(PrincipalGeneratedReport_AverageScoreTxt.getText() + ": " + dm.getReport().getAverageScore());
		PrincipalGeneratedReport_medianTxt.setText(PrincipalGeneratedReport_medianTxt.getText() + ": " + dm.getReport().getMedian());
		XYChart.Series set1 = new XYChart.Series<>();
		for (Integer key : dm.getReport().getGradesAndAppearance().keySet()) {
			set1.getData().add(new XYChart.Data(key.toString(),dm.getReport().getGradesAndAppearance().get(key)));
		}
		PrincipalGeneratedReport_principalHistogram.getData().addAll(set1);
	}
	
	@FXML
	void PrincipalGeneratedReport_btnExitClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalGetReportWindowController pgrwc = new PrincipalGetReportWindowController();
    	pgrwc.start(newStage);
    	currentStage.close();
	}
}
