import java.util.List;

public class PatientHouseHolder extends Patient {

	private String insuranceCompanyName;
	private int policyNumber;
	private CoverageType coverageType;
	private CoverageExtent coverageExt;
	private List<Integer> otherPatientsCovered;
	
	public PatientHouseHolder(String fName, String initial, String lName, 
			int stNum,String stName, int unitNum, String city, 
			Province province, String dob, int doctor,boolean hasIn,
			 char gender,int householderID, String insuranceCo, 
			 int policyNum, CoverageType ct, CoverageExtent ce, 
			 List<Integer> patients){
		
		super(fName, initial, lName, stNum,stName, unitNum, city, 
				province, dob, doctor,hasIn,gender, householderID);
		//the rest of the initialization
		patientCounter++;
	}
	
	public void addPatientCovered(int patientID){
		otherPatientsCovered.add(patientID);
	}
	
	public void removePatientCovered(int patientID){
		otherPatientsCovered.remove(patientID);
	}
	
	//other setter and getter methods go here. 
	

}
