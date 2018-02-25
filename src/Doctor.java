import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Doctor {
	private SimpleLongProperty doctorID;
	private SimpleStringProperty fullName;
	private SimpleStringProperty specialty;
	
	
	public Doctor (int doctorId, String fullName, String specialty){
		this.fullName = new SimpleStringProperty(fullName);
		this.specialty = new SimpleStringProperty(specialty);
		this.doctorID = new SimpleLongProperty(doctorId);
	}

	public void setFullName(String fName){
		fullName.set(fName);
	}
	
	public void setSpecialty (String spec){
		specialty.set(spec);
	}
	
	public String getFullName(){return fullName.get();}
	public String getSpecialty(){return specialty.get();}
	public int getDoctorID(){return (int) doctorID.get();}

	@Override
	public String toString() {
		return "Doctor{" +
				"fullName=" + fullName.get() +
				", specialty=" + specialty.get() +
				", doctorID=" + doctorID.get() +
				'}';
	}
}