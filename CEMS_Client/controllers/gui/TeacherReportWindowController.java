package gui;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

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

}