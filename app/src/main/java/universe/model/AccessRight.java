package universe.model;

public enum AccessRight {
	owner("o"), read("r"), readWrite("rw");
	
	private String accessRight;
	
	
	private AccessRight() {
		
	}
	
	private AccessRight(String accessRight){
		this.accessRight=accessRight;
	}
	public String getAccessRight() {
		return this.accessRight;
	}
	
}
