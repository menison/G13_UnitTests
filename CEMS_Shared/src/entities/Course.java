package entities;

import java.io.Serializable;

public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private Field belongsTo;
	
	public Course(String iD, String name, Field belongsTo) {
		super();
		ID = iD;
		this.name = name;
		this.belongsTo = belongsTo;
	}
	
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
