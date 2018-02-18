
public class Patient implements Name, Address{
	private static int patientCounter;
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
	
	public Patient(String fName, String initial, String lName, int stNum,
			String stName, int unitNum, String city, 
			Province province, String dob, int doctor, char gender){
		patientCounter++;
	}
	
	//implements all the setters and getters methods here

}
