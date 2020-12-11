package ED.Tablet.controller;

import java.io.IOException;

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
		
		//Displays personnel ID
		this.txtSignedInAs.setText("Signed in as: " + Integer.toString(this.mainApp.personnel.personnelID));
		//Updates patient list
		this.mainApp.personnel.updatePatientList();
		//Displays number of patients assigned to the personnel
		this.txtPatientsAss.setText("Patients Assigned: " + Integer.toString((this.mainApp.personnel.getPatientList()).size()));
	}
	
    // This method is automatically run after FXML file is loaded
    @FXML
    private void initialize(){
        lstListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String selectedCpr){
				showInMainView("view/patientDataView.fxml", selectedCpr);
				//showPatientDataView(selectedCpr);
            }
        });
	}
	
	/**
	 * Generic show in main view screne
	 */
	public void showInMainView(String viewPath, String cpr) {
		try {
			// Load HrExtended View
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getClassLoader().getResource(viewPath));
			AnchorPane anchorpane = (AnchorPane) loader.load();
			// Set pane into the center of root layout.
			this.anchorPatientData.getChildren().setAll(anchorpane);
			ED.Tablet.controller.genericInMainCtrl controller = loader.getController();
			controller.setMainCtrl(this);
			controller.setPatient(this.mainApp.personnel.getPatientList().get(cpr));
			controller.updateView();
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
