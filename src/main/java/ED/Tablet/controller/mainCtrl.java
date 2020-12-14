package ED.Tablet.controller;

import java.io.IOException;

import ED.Tablet.App;
import ED.Tablet.updater;
import ED.Tablet.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class mainCtrl {    
	
	private App mainApp;

	private patient selectedPatient;

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

	private genericInMainCtrl currentInMainCtrl;


	public mainCtrl(){}
	
    //Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
        this.mainApp.personnel.updatePatientList();
        cprList.setAll(this.mainApp.personnel.getPatientList().keySet());
		this.lstListView.setItems(cprList);
		//Displays personnel ID
		this.txtSignedInAs.setText("Signed in as: " + Integer.toString(this.mainApp.personnel.personnelID));
		//Displays number of patients assigned to the personnel
		this.txtPatientsAss.setText("Patients Assigned: " + Integer.toString((this.mainApp.personnel.getPatientList()).size()));
	}

    // This method is automatically run after FXML file is loaded
    @FXML
    private void initialize(){
        lstListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String selectedCpr){
				// Set the selected patient
				setSelectedPatient(selectedCpr);
				// Update the view
				showInMainView("view/patientDataView.fxml");
            }
        });
	}
	
	public void setSelectedPatient(String cpr) {
		// Stop the current patient updater, if it is defined
		if (this.selectedPatient != null) {
			this.selectedPatient.stopUpdating();
		}
		// Get instance of patient from personnel
		this.selectedPatient = this.mainApp.personnel.getPatientList().get(cpr); // En patient instans
		// Create and store a updater
		this.selectedPatient.setUpdater(new updater(this.selectedPatient));
	}

	/**
	 * Generic show in main view screne
	 */
	public void showInMainView(String viewPath) {
		try {
			// Stop the current controller from updating
			if (this.currentInMainCtrl != null) {
				this.currentInMainCtrl.stopUpdating();
			}
			// Load HrExtended View
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getClassLoader().getResource(viewPath));
			AnchorPane anchorpane = (AnchorPane) loader.load();
			// Set pane into the center of root layout.
			this.anchorPatientData.getChildren().setAll(anchorpane);
			ED.Tablet.controller.genericInMainCtrl controller = loader.getController();
			controller.setMainCtrl(this);
			controller.setPatient(this.selectedPatient);
			controller.updateView();
			// Start an updater
			controller.setUpdater(new updater(controller));
			// Store the active controller
			this.currentInMainCtrl = controller;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    public void handleLogout(){
		// Stop the current controller from updating
		if (this.currentInMainCtrl != null) {
			this.currentInMainCtrl.stopUpdating();
		}
		// Stop the current patient updater, if it is defined
		if (this.selectedPatient != null) {
			this.selectedPatient.stopUpdating();
		}
        this.mainApp.personnel = new personnel();
        this.mainApp.showLoginView();
    }
}
