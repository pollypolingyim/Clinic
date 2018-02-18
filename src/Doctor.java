
public class Doctor implements Name {
	private static idCounter;
	private Name fullName;
	private Specialty specialty;
	private int appointmentID;
	private int doctorID;
	
	
	public Doctor (Name fullName, Specialty specialty){
		
	}
	
	public void setFirstName(String fName){
	}
	
	public void setInitial(String initial){
	}
	
	public void setLastName(String lName){
	}
	
	public void setSpecialty (Specialty specialty){
		
	}
	
	public void setAppointmentID(int aid){
		
	}
	
	public int getDoctorID(){
		return doctorID;
	}
	
	public String getFirstName (){
		return null;
	}
	
	public String getInitial(){
		return null;
	}
	
	public String getLastName(){
		return null;
	}
	
	public Specialty getSpecialty(){
		return null;
	}
	
	public int getAppointmentID(){
		return 0;
	}

}
