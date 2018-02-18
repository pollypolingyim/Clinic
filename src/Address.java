
public class Address {
	private int streetNum;
	private String streetName;
	private String unit;
	private String city;
	private Province province;
	private String postalCode;
	public Address (int stNum, String stName, String unit, 
			String city, Province province,String postalCode){
		streetNum = stNum;
		streetName = stName;
		this.unit = unit;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}
	
	public void setStreetNumber (int stNum){
		streetNum = stNum;
	}
	
	public void setStreetName(String stName){
		streetName = stName;
	}
	
	public void setUnitNumber(String unit){
		this.unit = unit;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setProvince(Province province){
		this.province = province;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public int getStreetNumber (){
		return streetNum;
	}
	public String getStreetName(){
		return streetName;
	}
	public String getUnitNumber(){
		return unit;
	}
	public String getCity(){
		return city;
	}
	public Province getProvince(){
		return province;
	}
	public String getPostalCode(){
		return postalCode;
	}
	
	public String toString(){
		String str = (unit == null)? "Apt " + unit + ", \n": null;
		str = str + streetNum +" "+ streetName+", \n"
				+ city +", \n" 
				+ province+", \n"
				+ postalCode;
		return str;
	}
	
	

}
