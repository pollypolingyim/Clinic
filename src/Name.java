
public class Name {
	private String firstName;
	private String initial;
	private String lastName;
	
	public Name(String firstName, String initial, String lastName){
		this.firstName = firstName;
		this.initial = initial;
		this.lastName = lastName;
	}
	public void setFirstName(String fName){
		firstName = fName;
	}
	public void setInitial(String initial){
		this.initial = initial;
	}
	public void setLastName(String lName){
		this.lastName = lName;
	}
	
	public String getFirstName (){
		return firstName;
	}
	public String getInitial(){
		return initial;
	}
	public String getLastName(){
		return lastName;
	}
	
	public String toString(){
		if (initial == null) initial = "";
		return firstName + " "+initial+" "+lastName;
	}

}
