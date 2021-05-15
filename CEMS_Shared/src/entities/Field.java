package entities;

public class Field {

	private String ID;
	private String name;
	
	public Field(String iD, String name) {
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
	
}
