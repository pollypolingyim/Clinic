import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

public class DoctorTable extends Application {
    private int maxDoctorId;
	private Statement stmt;
    private final TableView<Doctor> table = new TableView<>();
    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    final HBox hb1 = new HBox();
    final HBox hb2 = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        connectToDB();
        List<Doctor> doctorsFromDb = selectAllRecordsFromDb();
        OptionalInt maxDoctorIdFromDb = doctorsFromDb.stream().mapToInt(Doctor::getDoctorID).max();
        this.maxDoctorId = maxDoctorIdFromDb.isPresent() ? maxDoctorIdFromDb.getAsInt() : 0;
        doctors.addAll(doctorsFromDb);

        Scene scene = new Scene(new Group());
        stage.setTitle("Doctor Table");
        stage.setWidth(500);
        stage.setHeight(550);
 
        table.setMinWidth(450);
        table.setEditable(true);
 
        TableColumn<Doctor, Integer> idCol = new TableColumn<>("Doctor ID");
        idCol.setMinWidth(50);
        idCol.setEditable(false);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("doctorID"));
 
        TableColumn<Doctor,String> nameCol = new TableColumn<>("Full Name");
        nameCol.setMinWidth(200);
        nameCol.setSortable(true);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("fullName"));
        nameCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(event -> {
            Doctor row = event.getRowValue();
            row.setFullName(event.getNewValue());
            updateRecordInDb(row.getDoctorID(), "FullName", row.getFullName());
        });
 
        TableColumn<Doctor,String> specialtyCol = new TableColumn<>("Specialty");
        specialtyCol.setMinWidth(200);
        specialtyCol.setSortable(true);
        specialtyCol.setCellValueFactory(
                new PropertyValueFactory<>("specialty"));
        specialtyCol.setCellFactory(
                ComboBoxTableCell.forTableColumn("GP","Dermatologist","Cardiologist"));
        specialtyCol.setOnEditCommit(event -> {
            Doctor row = event.getRowValue();
            row.setSpecialty(event.getNewValue());
            updateRecordInDb(row.getDoctorID(), "specialty", row.getSpecialty());
        });

        table.setItems(doctors);
        table.getColumns().addAll(idCol, nameCol, specialtyCol);
 
        final TextField addFullName = new TextField();
        addFullName.setPromptText("Full Name");
        addFullName.setMinWidth(200);
        
        final Label specialtyMsg = new Label("Select the specialty: ");
        
        final ComboBox addSpecialty = new ComboBox();
        addSpecialty.getItems().addAll("GP","Dermatologist","Cardiologist");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Doctor doctor = new Doctor(
                    ++maxDoctorId,
                    addFullName.getText(),
                    addSpecialty.getValue().toString());
            doctors.add(doctor);
            insertRecordToDb(doctor);
            addFullName.clear();
        });
        
        final Label delMsg=new Label("To delete an item from the list, select an item then click Delete");
        
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Doctor selectedItem = table.getSelectionModel().getSelectedItem();
            doctors.remove(selectedItem);
            deleteRecordFromDb(selectedItem.getDoctorID());
        });

 
        hb1.getChildren().addAll(addFullName, specialtyMsg, addSpecialty, addButton);
        hb1.setSpacing(3);
        
        hb2.getChildren().addAll(delMsg,deleteButton);
        hb2.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb1,hb2);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }

    private void connectToDB(){
		try{
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost", "username", "password");
			System.out.println("Database connected");
			stmt = connection.createStatement();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

    private List<Doctor> selectAllRecordsFromDb(){
        System.out.println("Select all from Doctor table in DB.");
        String sqlStr = "SELECT * FROM clinic.Doctor";

        List<Doctor> doctors = new LinkedList<>();
        try (ResultSet rs = stmt.executeQuery(sqlStr)){
            while (rs.next()) {
                int doctorId = rs.getInt("DoctorID");
                String fullName = rs.getString("FullName");
                String specialty = rs.getString("Specialty");
                Doctor doctor = new Doctor(doctorId, fullName, specialty);
                doctors.add(doctor);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return doctors;
    }

    private void deleteRecordFromDb(int primaryKey) {
        System.out.println("Deleting record from Doctor table in DB with id " + primaryKey);
        try{
            String sqlStr = "DELETE FROM clinic.Doctor WHERE DoctorID = " + primaryKey;
            System.out.println("Delete sql: " + sqlStr);
            stmt.executeUpdate(sqlStr);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private void insertRecordToDb(Doctor doctor) {
        System.out.println("Inserting new record into Doctor table in DB: " + doctor);
        try{
            String sqlStr = "INSERT INTO clinic.Doctor (DoctorID, FullName, Specialty) VALUES "
                    + "(" + doctor.getDoctorID() + ", " + quoteNullableString(doctor.getFullName()) + ", " + quoteNullableString(doctor.getSpecialty()) + ")";
            System.out.println("Insert sql: " + sqlStr);
            stmt.executeUpdate(sqlStr);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private void updateRecordInDb(int primaryKey, String updateField, String newVal){
        System.out.println("Updating Doctor table in DB." + updateField + " = " + newVal);
		try{
			String sqlStr = "UPDATE clinic.Doctor SET "
                    + updateField +" = " + quoteNullableString(newVal)
                    + " WHERE DoctorID =" + primaryKey ;
            System.out.println("Update sql: " + sqlStr);
			stmt.executeUpdate(sqlStr);
		}
		catch(SQLException ex){
			ex.printStackTrace();	
		}
	}

    private String handleEmptyStringAsNull(String newValue) {
        if (newValue == null
                || newValue.trim().isEmpty()){
            newValue = null;
        }
        return newValue;
    }

    private String quoteNullableString(String str) {
        if (str == null) {
            return str;
        }
        return  "'" + str + "'";
    }
}
