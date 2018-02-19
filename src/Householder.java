

public class Householder {

	private static int householderCounter;
	private String insCompanyName;
	private int policyNumber;
	private CoverageExtent coverageExt;
	private Name name; //the name of the householder
	private String dob; //the dob of the householder
	private int householderID;//the householder ID, PK of the householder table 
	private int patientID; /*the patient ID of this householder. If this
	householder is not a patient, this number will be -1. 
	FK of the patient table*/ 
	
	public Householder(String insuranceCo, int policyNum,  
			CoverageExtent ce, Name name, String dob){
		
		insCompanyName = insuranceCo;
		policyNumber = policyNum;
		coverageExt = ce;
		householderID =++householderCounter;
		patientID=findPatientID(name, dob);
	}
	
	
	//all setter and getter methods go here. 
	

}
