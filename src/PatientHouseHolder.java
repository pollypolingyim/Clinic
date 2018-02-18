

public class PatientHouseHolder extends Patient {

	private String insCompanyName;
	private int policyNumber;
	private CoverageExtent coverageExt;
	
	public PatientHouseHolder(Name name,Address address, String dob, 
			int doctor, char gender,int householderID, CoverageType ct,
			String insuranceCo, int policyNum,  CoverageExtent ce){
		
		super(name,address, dob, doctor,gender, householderID,ct);
		insCompanyName = insuranceCo;
		policyNumber = policyNum;
		coverageType = ct;
		coverageExt = ce;
	}
	
	
	//all setter and getter methods go here. 
	

}
