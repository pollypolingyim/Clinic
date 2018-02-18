
public class Doctor {
	private static int idCounter;
	private String fullName;
	private Specialty specialty;
	private int appointmentID;
	private int doctorID;
	
	
	public Doctor (String fullName, Specialty specialty){
		this.fullName = fullName;
		this.specialty = specialty;
		idCounter++;
		doctorID = idCounter;
	}
	
	public void setFullName(String fullName){
	}
	
	public void setSpecialty (Specialty specialty){
		
	}
	
	public void setAppointmentID(int aid){
		
	}
	
	public int getDoctorID(){
		return doctorID;
	}
	
	public String getFullName (){
		return fullName;
	}
	

	
	public int getAppointmentID(){
		return 0;
	}
	
	//return the doctor id of the doctor by his name
	public int findDoctor(String fullName){
		return 0;
	}

}
