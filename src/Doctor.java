
public class Doctor {
	private static int idCounter;
	private Name fullName;
	private Specialty specialty;
	private int appointmentID;
	private int doctorID;
	
	
	public Doctor (Name fullName, Specialty specialty){
		this.fullName = fullName;
		this.specialty = specialty;
		appointmentID = -1; /*if this is set to -1, this doctor does
		not have upcoming appointments*/
		doctorID = ++idCounter;
	}
	
	public void setFullName(Name fullName){
		this.fullName = fullName;
	}
	
	public void setSpecialty (Specialty specialty){
		this.specialty = specialty;
	}
	
	public void setAppointmentID(int aid){
		this.appointmentID=aid;
	}
	
	public int getDoctorID(){
		return doctorID;
	}
	
	public Name getFullName (){
		return fullName;
	}
	
	public int getAppointmentID(){
		return appointmentID;
	}
	
	//return the doctor id of the doctor by his name
	public int findDoctor(Name fullName){
		return -1;
	}

}
