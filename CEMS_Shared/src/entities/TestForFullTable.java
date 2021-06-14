package entities;

/**
 * @author David
 *this class is to create a list of tests for a table view
 */
public class TestForFullTable {
	private String testID;
	private String subject;
	private String course;
	private int duration;
	private String composer;
	
	/**
	 * @param testID		test id
	 * @param subject		subject name
	 * @param course		course name
	 * @param duration		duration
	 * @param composer		composer of test
	 */
	public TestForFullTable(String testID,String subject,String course,int duration,String composer) {
		this.testID = testID;
		this.subject=subject;
		this.course=course;
		this.duration=duration;
		this.composer=composer;
	}
	
	@Override
	public String toString() {
		return(this.testID+","+this.subject+","+this.course+","+this.duration+
				","+this.composer);
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}
	

}
