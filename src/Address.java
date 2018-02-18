
public interface Address {
	void setStreetNumber (int StNum);
	void setStreetName(String StName);
	void setUnitNumber(String unitNum);
	void setCity(String city);
	void setProvince(Province province);
	void setPostalCode();
	
	int getStreetNumber ();
	String getStreetName();
	String getUnitNumber();
	String getCity();
	Province getProvince();
	String getPostalCode();
	
	

}
