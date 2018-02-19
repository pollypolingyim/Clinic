import java.util.List;

public class Patient{
	private static int patientCounter;
	private int patientID;//the PK of the patient table
	private Name fullName;
	private Address address;
	private int streetNum;
	private String dob;
	private int primaryDoctorID;
	private char gender;
	private int householderID;/*the householderID of the patient 
	whom the patient can use insurance from.
	If this number is -1, this patient does not have
	insurance and therefore not belongs to any household.
	The FK of the householder table*/
	private CoverageType coverageType;
	private List<String> medicalRecord;
	
	public Patient(Name name,Address add, String dob, int doctor, 
			char gender, int householderID, CoverageType coverageType){
		fullName = name;
		address = add;
		this.dob = dob;
		primaryDoctorID = doctor;
		this.gender = gender;
		this.householderID = householderID;
		this.coverageType = coverageType;
		patientID = ++patientCounter;
		medicalRecord = null;
	}
	
	public int findPatientID(Name name, String dob){
		//search the patientID by his name and dob. If not found, return -1
		return -1;
	}
	
	//other setters and getters methods

}
