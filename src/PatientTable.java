

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientTable extends Application {
	private Statement stmt;
    private final TableView<Patient> table = new TableView<>();
    private ObservableList<Patient> patients;
    final HBox hb1 = new HBox();
    final HBox hb2 = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Patient Table");
        stage.setHeight(550);
 
        table.setMinWidth(450);
        table.setEditable(true);
 
        TableColumn<Patient, Integer> idCol = new TableColumn<>("Patient ID");
        idCol.setMinWidth(50);
        idCol.setEditable(false);
        idCol.setSortable(true);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("patientID"));
 
        TableColumn<Patient,String> fnameCol = new TableColumn<>("First Name");
        fnameCol.setMinWidth(200);
        fnameCol.setSortable(true);
        fnameCol.setCellValueFactory(
                new PropertyValueFactory<>("fname"));
        fnameCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        fnameCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setFname(event.getNewValue());
        });
 
        TableColumn<Patient,String> lnameCol = new TableColumn<>("Last Name");
        lnameCol.setMinWidth(200);
        lnameCol.setSortable(true);
        lnameCol.setCellValueFactory(
                new PropertyValueFactory<>("lname"));
        lnameCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        lnameCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setLname(event.getNewValue());
        });
        
        TableColumn<Patient,String> dobCol = new TableColumn<>("Date of Birth");
        dobCol.setMinWidth(100);
        dobCol.setSortable(true);
        dobCol.setCellValueFactory(
                new PropertyValueFactory<>("dob"));
        dobCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        dobCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setDob(Date.valueOf(event.getNewValue()));
        });
        
        TableColumn<Patient,String> docIDCol = new TableColumn<>("Primary Doctor ID");
        docIDCol.setMinWidth(50);
        docIDCol.setSortable(true);
        docIDCol.setCellValueFactory(
                new PropertyValueFactory<>("primaryDoctorID"));
        docIDCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        docIDCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setPrimaryDoctorID(Integer.parseInt(event.getNewValue()));
        });
        
        TableColumn<Patient,String> genderCol = new TableColumn<>("Gender");
        genderCol.setMinWidth(50);
        genderCol.setSortable(true);
        genderCol.setCellValueFactory(
                new PropertyValueFactory<>("gender"));
        genderCol.setCellFactory(
                ComboBoxTableCell.forTableColumn("Male","Female"));
        genderCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setGender(event.getNewValue());
        });
        
        TableColumn<Patient,String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setMinWidth(100);
        phoneCol.setSortable(true);
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNum"));
        phoneCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        phoneCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setPhoneNum(event.getNewValue());
        });
        
        TableColumn<Patient,String> householdCol = new TableColumn<>("Household ID");
        householdCol.setMinWidth(100);
        householdCol.setSortable(true);
        householdCol.setCellValueFactory(
                new PropertyValueFactory<>("householdID"));
        householdCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        householdCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setHouseholdID(Integer.parseInt(event.getNewValue()));
        });
        
        TableColumn<Patient,String> isHouseholderCol = new TableColumn<>("Is Householder?");
        isHouseholderCol.setMinWidth(50);
        isHouseholderCol.setSortable(true);
        isHouseholderCol.setCellValueFactory(
                new PropertyValueFactory<>("isHouseholder"));
        isHouseholderCol.setCellFactory(
                ComboBoxTableCell.forTableColumn("true","false"));
        isHouseholderCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setIsHouseholder(event.getNewValue());
        });
        
        TableColumn<Patient,String> ctCol = new TableColumn<>("Coverage Type");
        ctCol.setMinWidth(50);
        ctCol.setSortable(true);
        ctCol.setCellValueFactory(
                new PropertyValueFactory<>("coverageType"));
        ctCol.setCellFactory(
                ComboBoxTableCell.forTableColumn("Single","Familty","None"));
        ctCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setCoverageType(event.getNewValue());
        });
        
        
        /*TableColumn<Patient,String> appDateCol = new TableColumn<>("Next App Date");
        appDateCol.setMinWidth(100);
        appDateCol.setSortable(true);
        appDateCol.setCellValueFactory(
                new PropertyValueFactory<>("nextAppDate"));
        appDateCol.setCellFactory(
                TextFieldTableCell.forTableColumn());
        appDateCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setNextAppDate(event.getNewValue());
        });
        
        TableColumn<Patient,String> timeCol = new TableColumn<>("Next App Time");
        timeCol.setMinWidth(50);
        timeCol.setSortable(true);
        timeCol.setCellValueFactory(
                new PropertyValueFactory<>("nextAppTime"));
        timeCol.setCellFactory(
                ComboBoxTableCell.forTableColumn("09:00","09:30","10:00",
                		"10:30","11:00","11:30","13:00","13:30",
                		"14:00","14:30","15:00","15:30","16:00", "16:30"));
        timeCol.setOnEditCommit(event -> {
            Patient row = event.getRowValue();
            row.setNextAppTime(event.getNewValue());
        });
        */
 
        table.setItems(patients);
        table.getColumns().addAll(idCol, fnameCol, lnameCol,dobCol,
        		docIDCol, genderCol, phoneCol,householdCol, 
        		isHouseholderCol,ctCol);
 
        final TextField addFName = new TextField();
        addFName.setPromptText("First Name");
        addFName.setMinWidth(100);
        final TextField addLName = new TextField();
        addLName.setPromptText("Last Name");
        addLName.setMinWidth(100);
        final TextField addDob = new TextField();
        addDob.setPromptText("DOB");
        addDob.setMinWidth(50);
        final TextField addDocID = new TextField();
        addDocID.setPromptText("Doctor ID");
        addDocID.setMinWidth(5);
        final ComboBox addGender = new ComboBox();
        addGender.getItems().addAll("Male","Female");
        final TextField addPhone = new TextField();
        addPhone.setPromptText("Phone");
        addPhone.setMinWidth(50);
        final TextField addHouse = new TextField();
        addHouse.setPromptText("Household ID");
        final ComboBox isH = new ComboBox();
        isH.getItems().addAll("true", "false");
        final ComboBox addCt = new ComboBox();
        addCt.getItems().addAll("Single", "Family", "None");
 
        /*final TextField addDate = new TextField();
        addDate.setPromptText("Next app date");
        final ComboBox time = new ComboBox();
        time.getItems().addAll("09:00","09:30","10:00",
        		"10:30","11:00","11:30","13:00","13:30",
        		"14:00","14:30","15:00","15:30","16:00", "16:30");
        		*/
   
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            patients.add(new Patient(
                    addFName.getText(),
                    addLName.getText(),
                    (addDob.getText().length()==0)?null:Date.valueOf(addDob.getText()),
                    (addDocID.getText().length()==0)?null:Integer.parseInt(addDocID.getText()),
                    (addGender.getValue()==null)?null:addGender.getValue().toString(),
                    addPhone.getText(),
                    (addHouse.getText().length()==0)?null:Integer.parseInt(addHouse.getText()),    
                    (isH.getValue()==null)?null:isH.getValue().toString(),
                    (addCt.getValue()==null)?null:addCt.getValue().toString()
                    ));
            addFName.clear();
            addLName.clear();
            addDob.clear();
            addDocID.clear();
            addPhone.clear();
            addHouse.clear();
        });
        
        final Label delMsg=new Label("To delete an item from the list, select an item then click Delete");
        
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Patient selectedItem = table.getSelectionModel().getSelectedItem();
            patients.remove(selectedItem);
        });
        
 
 
        hb1.getChildren().addAll(addFName, addLName, addButton);
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
        connectToDB();
    }
    
	private void connectToDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost", "root", "UBC@@e1d8");
			System.out.println("Database connected");
			
			stmt=connection.createStatement();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void updateDB(int primaryKey, String updateField, String newVal){
		try{
			String sqlStr = "UPDATE Doctor SET "+
		    updateField +"="+ newVal+
		    "WHERE DoctorID=" + primaryKey ;
			stmt.executeQuery(sqlStr);
		}
		catch(SQLException ex){
			ex.printStackTrace();	
		}
	}

}
