import java.util.List;

public class Patient{
	protected static int patientCounter;
	protected int patientID;
	protected Name fullName;
	protected Address address;
	protected int streetNum;
	protected String dob;
	protected int primaryDoctorID;
	protected char gender;
	protected int householderID;/*the householderID of the patient 
	whom the patient can use insurance from. If the householderID
	is the same as the patientID, this patient is a householder.
	If this number is -1, this patient does not have
	insurance and therefore not belongs to any household*/
	protected CoverageType coverageType;
	protected List<String> medicalRecord;
	
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
	
	public int findPatientID(String fName, String lName, String dob){
		return -1;
	}
	
	//other setters and getters methods

}
