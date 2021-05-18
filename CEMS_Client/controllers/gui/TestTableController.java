package gui;

import entities.Exam;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class TestTableController {
	@FXML
	private TableView<Exam> myTestsTable_tblTests;
	@FXML
	private TableColumn<Exam, String> myTests_colTestID;
	@FXML
	private TableColumn<Exam, String> myTests_colTestCode;
	@FXML
	private TableColumn<Exam, String> myTests_colDate;
	@FXML
	private TableColumn<Exam, String> myTests_colAllocDuration;
	@FXML
	private TableColumn<Exam, String> myTests_colActualDuration;
	@FXML
	private TableColumn<Exam, String> myTests_colGrade;
	@FXML
	private Button myTestsTable_btnBack;
	@FXML
	private Button myTestsTable_btnRequestCopy;

}
