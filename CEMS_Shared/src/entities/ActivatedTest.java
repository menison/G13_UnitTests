package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**Class ActivatedTest
 * this class holds elements to match those in SQL table ActivatedTest
 * @author David
 */
public class ActivatedTest implements  Serializable {

	private static final long serialVersionUID = -7278799683179472714L;
	private String testCode;
	private String testID;
	private String activatedBy;
	private LocalDate startDate;
	private LocalTime startTime;
	private int isActivated;
	private int duration;
	
	/**
	 * Constructor for parameters
	 * @param testCode 			Test execution code.
	 * @param testID			Test ID.
	 * @param activatedBy		ID teacher who activated the test.
	 * @param startDate			Start date of test.
	 * @param startTime			Start Time of test.
	 * @param isActivated		Is test activated.
	 */
	public ActivatedTest(String testCode, String testID, String activatedBy, LocalDate startDate, LocalTime startTime,
			int isActivated) {
		this.testCode = testCode;
		this.testID = testID;
		this.activatedBy = activatedBy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.isActivated = isActivated;
		
	}
	/**
	 * Constructor for parameters
	 * @param testCode			Test execution code.
	 * @param testID			Test ID.
	 * @param activatedBy		ID teacher who activated the test.
	 * @param startDate			Start date of test.
	 * @param startTime			Start Time of test.
	 * @param isActivated		Is test activated.
	 * @param duration			Duration of test.
	 */
	public ActivatedTest(String testCode, String testID, String activatedBy, String startDate, String startTime,
			int isActivated,int duration) {
		this.testCode = testCode;
		this.testID = testID;
		this.activatedBy = activatedBy;
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");

		this.startDate = LocalDate.parse(startDate, formatter);
		 
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");


		this.startTime = LocalTime.parse(startTime, timeFormatter);
		 
		this.isActivated = isActivated;
		this.duration=duration;
		
	}
	

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public String getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}

	public String getStartDateToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy"); 
		return startDate.format(formatter);
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getStartTimeToString() {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
		return startTime.format(timeFormatter);
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public int getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}

	

}
