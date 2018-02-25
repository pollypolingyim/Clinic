import java.sql.Date;
import java.sql.Time;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointment {
	private SimpleObjectProperty<Date> date; //in the format yyyy-mm-dd
	private SimpleObjectProperty<Time> time;//in the format hh:mm:ss 0-23:0-59:0-59
	private IntegerProperty doctorID;
	private IntegerProperty patientID;
	
	public Appointment(Date d, Time t,int doc, int patient){
		date=new SimpleObjectProperty<Date>(d);
		time=new SimpleObjectProperty<Time>(t);
		doctorID=new SimpleIntegerProperty(doc);
		patientID=new SimpleIntegerProperty(patient);
	}
	
	public Date getDate(){return date.get();}
	public Time getTime(){return time.get();}
	public Integer getDoctorID(){return doctorID.get();}
	public Integer getPatientID(){return patientID.get();}
	
	public void setDate(Date date){this.date.set(date);}
	public void setTime(Time time){this.time.set(time);}
	public void setDoctorID(Integer doc){doctorID.set(doc);}
	public void setPatientID(Integer patient){patientID.set(patient);}
	
}
