

public class Household {

	private static int householdCounter;
	private String insCompanyName;
	private int policyNumber;
	private CoverageExtent coverageExt;
	private int householdID;//the householder ID, PK of the household table 
	
	
	public Household(String insuranceCo, int policyNum,  
			CoverageExtent ce){
		
		insCompanyName = insuranceCo;
		policyNumber = policyNum;
		coverageExt = ce;
		householdID =++householdCounter;
	}
	
	
	//all setter and getter methods go here. 
	

}
