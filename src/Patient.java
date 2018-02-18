import java.util.List;

public class Patient implements Name, Address{
	protected static int patientCounter;
	private int patientID;
	private String firstName;
	private String initial;
	private String lastName;
	private int streetNum;
	private String streetName;
	private int unitNum;
	private String city;
	private Province province;
	private String postalCode;
	private String dob;
	private int primaryDoctorID;
	private char gender;
	private boolean hasInsurance;
	private int householderID;
	private List<String> medicalRecord;
	
	public Patient(String fName, String initial, String lName, int stNum,
			String stName, int unitNum, String city, 
			Province province, String dob, int doctor, 
			boolean hasIns,char gender, int householderID){
		patientCounter++;
	}
	
	public int findPatientID(String fName, String lName, String dob){
		return -1;
	}
	
	//other setters and getters methods

}
