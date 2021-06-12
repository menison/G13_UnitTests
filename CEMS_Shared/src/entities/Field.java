package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Field implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private ArrayList<Course> courseList;
	
	public Field(String iD, String name, ArrayList<Course> courseList) {
		super();
		ID = iD;
		this.name = name;
		this.courseList = courseList;
	}
	
	public Field(String iD, String name) {
		super();
		ID = iD;
		this.name=name;
	}
	
	public Field(String iD) {
		super();
		ID = iD;
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

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void addToFieldCourseList(Course courseToAdd) {
		this.courseList.add(courseToAdd);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	

}
