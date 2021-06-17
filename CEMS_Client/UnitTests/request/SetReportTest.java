package request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import cachedUserData.DataManager;
import entities.Message;
import entities.Report;

class SetReportTest {
	private Message mockMsg;
	private Report report;
	private String GegeneratedBy;
	private String Value;
	private Double expectedAverage;
	
	private ArrayList<String> returnedValuesFromMsg;
	private HashMap<Integer, Integer> expectedGradesAndAppearance;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMsg = Mockito.mock(Message.class);
		report = new Report();
		returnedValuesFromMsg = new ArrayList<String>();
		expectedGradesAndAppearance = new HashMap<Integer, Integer>();
		new SetReport(report);
	}

	@Test
	// Checks if method sets correct data for report. 
	// Input : mockMsg with ArrayList<String> with simulated data instead of data from server, clear report entity object
	// Expected : all data in report equals to expected values
	void testGenerateReport_CheckIfGenerateCorrectValues() {
		GegeneratedBy = "Teacher";
		Value = "123456789";
		returnedValuesFromMsg.add(GegeneratedBy);
		returnedValuesFromMsg.add(Value);
		returnedValuesFromMsg.add("88");
		returnedValuesFromMsg.add("88");
		returnedValuesFromMsg.add("73");
		returnedValuesFromMsg.add("73");
		when(mockMsg.getObj()).thenReturn(returnedValuesFromMsg);
		expectedGradesAndAppearance.put(88, 2);
		expectedGradesAndAppearance.put(73, 2);
		expectedAverage =80.5;
		SetReport.generateReport(mockMsg);
		assertEquals(GegeneratedBy , report.getGegeneratedBy());
		assertEquals(Value,report.getValue());
		assertEquals(expectedGradesAndAppearance,report.getGradesAndAppearance());
		assertEquals(expectedAverage,report.getAverageScore());
		assertEquals(88,report.getMedian());
	}	
}
