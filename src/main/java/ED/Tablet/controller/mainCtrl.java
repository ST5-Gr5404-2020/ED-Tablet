package ED.Tablet.controller;

import java.io.IOException;
import java.util.Observable;

import ED.Tablet.App;
import ED.Tablet.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class mainCtrl {    
    private App mainApp;
    @FXML
    private ListView<String> lstListView;
    private ObservableList<String> cprList = FXCollections.observableArrayList();
    @FXML
    public AnchorPane anchorPatientData;
    @FXML
	private Button btnLogout;
	@FXML
	private Label txtSignedInAs;
	@FXML
	private Label txtPatientsAss;


    public mainCtrl(){}
    //Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
        this.mainApp.personnel.updatePatientList();
        cprList.setAll(this.mainApp.personnel.getPatientList().keySet());
        this.lstListView.setItems(cprList);
    }
    // This method is automatically run after FXML file is loaded
    @FXML
    private void initialize(){
        lstListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String selectedCpr){
                showPatientDataView(selectedCpr);
            }
        });
        
		
		//Displays personnel ID
		this.txtSignedInAs.setText("Signed in as: " + Integer.toString(this.mainApp.personnel.personnelID));
		//Updates patient list
		this.mainApp.personnel.updatePatientList();
		//Displays number of patients assigned to the personnel
		this.txtPatientsAss.setText("Patients Assigned: " + Integer.toString((this.mainApp.personnel.getPatientList()).size()));
		
    }
    public void showPatientDataView (String cpr){
        try {
            // Load mainView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/patientDataView.fxml"));
            AnchorPane anchorPatientDataView= (AnchorPane) loader.load();
            // Set loginView into the center of root layout.
            this.anchorPatientData.getChildren().setAll(anchorPatientDataView);
            // Give the controller access to the main app.
            ED.Tablet.controller.patientDataCtrl controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.setMainCtrl(this);
            controller.setPatient(this.mainApp.personnel.getPatientList().get(cpr));
            controller.updateView();
        } catch (IOException e) {
            e.printStackTrace();
		}
    }
    public void showVitalSignsView(String cpr){
        try {
            // Load vitalSignsView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/vitalSignsView.fxml"));
            AnchorPane anchorpaneVitalSignsView = (AnchorPane) loader.load();
            // Set loginView into the center of root layout.
            this.anchorPatientData.getChildren().setAll(anchorpaneVitalSignsView);
            // Give the controller access to the main app.
			ED.Tablet.controller.vitalSignsCtrl controller = loader.getController();			
			controller.setMainApp(this.mainApp);  
			controller.setMainCtrl(this);          
			controller.setPatient(this.mainApp.personnel.getPatientList().get(cpr));
			controller.updateBPChart();
			controller.updateEtCo2Chart();
			controller.updateSpO2Chart();
			controller.updateHrChart();
			
            
        } catch (IOException e) {
            e.printStackTrace();
		}
    }

	public void showEtCo2Extend(String cpr){
		try {
			// Load EtCo2Extended View
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getClassLoader().getResource("view/etco2Graph.fxml"));
			AnchorPane anchorpaneEtCo2View = (AnchorPane) loader.load();
			// Set loginView into the center of root layout.
			this.anchorPatientData.getChildren().setAll(anchorpaneEtCo2View);
			ED.Tablet.controller.etco2GraphCtrl controller = loader.getController();
			controller.setMainCtrl(this);
			controller.setMainApp(this.mainApp); 
			controller.setPatient(this.mainApp.personnel.getPatientList().get(cpr));
			controller.updateEtCo2Chart();

		} catch(IOException e) {
			e.printStackTrace();
			}


	}


    @FXML
    public void handleSelectPatient(){
        System.out.println("Der er klikket");
    }

    @FXML
    public void handleLogout(){
        this.mainApp.personnel= new personnel();
        this.mainApp.showLoginView();
        
    }
}
