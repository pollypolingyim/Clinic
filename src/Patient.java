

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Patient{
	private static int patientCounter;
	private IntegerProperty patientID;//the PK of the patient table
	private StringProperty fname;
	private StringProperty lname;
	//private Address address;
	private SimpleObjectProperty<Date> dob;
	private IntegerProperty primaryDoctorID;
	private StringProperty gender;//input Male or Female
	private StringProperty phoneNum;
	private IntegerProperty householdID;/*the householdID of the patient 
	If this number is set to null, this patient does not have
	insurance and therefore not belongs to any household.
	The FK reference to the household table*/
	private StringProperty coverageType;
	private StringProperty isHouseholder;

	
	public Patient(String fname,String lname, Date dob, Integer doctor, 
			String gender, String phoneNum,Integer householdID, 
			String isHouseholder, String coverageType){
		this.fname = new SimpleStringProperty(fname);
		this.lname = new SimpleStringProperty(lname);
		this.dob = new SimpleObjectProperty<Date>(dob);
		primaryDoctorID = new SimpleIntegerProperty( doctor);
		this.gender = new SimpleStringProperty(gender);
		this.phoneNum = new SimpleStringProperty(phoneNum);
		this.householdID = new SimpleIntegerProperty(householdID);
		this.isHouseholder = new SimpleStringProperty(isHouseholder);
		this.coverageType = new SimpleStringProperty(coverageType);
		if(coverageType=="None")this.householdID=null;
		patientID = new SimpleIntegerProperty(++patientCounter);
		//medicalRecord = null;
	}
	
	public String getFname(){return fname.get();}
	public String getLname(){return lname.get();}
	public Date getDob(){return dob.get();}
	public Integer getPrimaryDoctorID(){
		return (int) primaryDoctorID.get();
	}
	public String getGender(){return gender.get();}
	public String getPhoneNum(){return phoneNum.get();}
	public Integer getHouseholdID(){
		if(coverageType.equals("None")) return null;
		return (int) householdID.get();
	}
	public String getCoverageType(){
		return coverageType.get();
	}
	public String getIsHouseholder(){
		return isHouseholder.get();
	}

	
	public void setFname(String fname){this.fname.set(fname);}
	public void setLname(String lname){this.lname.set(lname);}
	public void setDob(Date dob){this.dob.set(dob);}
	public void setPrimaryDoctorID(Integer doc){
		this.primaryDoctorID.set(doc);
	}
	public void setGender(String gender){this.gender.set(gender);}
	public void setPhoneNum(String phone){phoneNum.set(phone);}
	public void setHouseholdID(Integer householdID){
		this.householdID.set(householdID);
	}
	public void setCoverageType(String ct){
		coverageType.set(ct);
		if(coverageType.equals("None"))this.setHouseholdID(null);
	}
	public void setIsHouseholder(String isHouseholder){
		this.isHouseholder.set(isHouseholder);
	}


}
