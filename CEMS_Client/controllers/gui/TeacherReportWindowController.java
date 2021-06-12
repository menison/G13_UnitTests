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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TeacherReportWindowController {

    @FXML
    private BarChart<?, ?> histogramChart;

    @FXML
    private CategoryAxis histXaxis;

    @FXML
    private NumberAxis histYaxis;

    @FXML
    private JFXTextField teacherRprtMenu_txtTeacherName;

    @FXML
    private JFXTextField teacherRprtMenu_txtAvg;

    @FXML
    private JFXTextField teacherRprtMenu_txtMedian;

    @FXML
    private JFXButton teacherRprtWindow_btnExit;

	public void start(Stage newStage) {
		Pane root = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TeacherReportWindow.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		newStage.setTitle("Test Report");
		newStage.setScene(scene);
		newStage.show();
	}
	@FXML
	void teacherRprtWindow_btnExit(ActionEvent event) throws Exception {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		TestsStatisticsController tsc = new TestsStatisticsController();
		tsc.start(newStage);
		currentStage.close();
	}
	
	@FXML
	public void initialize() {
		DataManager dm = DataManager.getDataManager();
		teacherRprtMenu_txtTeacherName.setText(teacherRprtMenu_txtTeacherName.getText() + ": " + dm.getReport().getGegeneratedBy()+ "-" + dm.getReport().getValue());
		teacherRprtMenu_txtAvg.setText(teacherRprtMenu_txtAvg.getText() + ": " + dm.getReport().getAverageScore());
		teacherRprtMenu_txtMedian.setText(teacherRprtMenu_txtMedian.getText() + ": " + dm.getReport().getMedian());
		XYChart.Series set1 = new XYChart.Series<>();
		for (Integer key : dm.getReport().getGradesAndAppearance().keySet()) {
			set1.getData().add(new XYChart.Data(key.toString(),dm.getReport().getGradesAndAppearance().get(key)));
		}
		histogramChart.getData().addAll(set1);
	}

}