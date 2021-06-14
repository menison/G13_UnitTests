package entities;

import java.io.Serializable;

/**
 * Class for course, this class holds all info in course from SQL Database 
 * @author David
 *
 */
public class Course implements Serializable{


	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private Field belongsTo;
	private int numOfQuestions;
	private int numOfTests;
	
	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public int getNumOfTests() {
		return numOfTests;
	}

	/**
	 * Constructor
	 * @param iD			course ID
	 * @param name			Course name
	 * @param belongsTo		field ID
	 */
	public Course(String iD, String name, Field belongsTo) {
		super();
		ID = iD;
		this.name = name;
		this.belongsTo = belongsTo;
	}
	
	/**
	 * Constructor for id and name
	 * @param iD			course ID
	 * @param name			Course name
	 */
	public Course(String iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Field getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Field belongsTo) {
		this.belongsTo = belongsTo;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	

}
