import java.util.List;

public class PatientHouseHolder extends Patient {

	private String insCompanyName;
	private int policyNumber;
	private CoverageType coverageType;
	private CoverageExtent coverageExt;
	
	public PatientHouseHolder(Name name,Address address, String dob, 
			int doctor, char gender,int householderID, String insuranceCo, 
			 int policyNum, CoverageType ct, CoverageExtent ce){
		
		super(name,address, dob, doctor,gender, householderID);
		insCompanyName = insuranceCo;
		policyNumber = policyNum;
		coverageType = ct;
		coverageExt = ce;
	}
	
	
	//other setter and getter methods go here. 
	

}
