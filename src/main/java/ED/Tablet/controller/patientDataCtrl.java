package ED.Tablet.controller;

import java.io.IOException;
import java.util.Observable;

import javax.swing.text.html.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ED.Tablet.App;
import ED.Tablet.model.*;
import ED.Tablet.controller.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import jdk.nashorn.api.tree.ForLoopTree;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class patientDataCtrl {
    // Vitalsigns labels
    @FXML
    private Label valBPsys;
    @FXML
    private Label valBPdia;
    @FXML
    public Label valSPO2;
    @FXML
    public Label valETCO2;
    @FXML
    public Label valHR;
    
    @FXML 
    public StackPane myStackpaneHR;

    // Tripinfo labels
    @FXML
    public Label txtPatientName;
    @FXML
    public Label txtCprNumber;
    @FXML
    public Label txtAccidentNumber;
    @FXML
    public Label txtAmbulancePhone;
    @FXML
    public Label txtArrivedAtScene;
    @FXML
    public Label txtEta;
    @FXML
    public Label txtTriageScore;
    @FXML
    public Label txtDkIndex;

    // Note lavel
    @FXML
    public TextArea txtNoteArea;

    // Medication labels
    @FXML
    public TableView<medication> tblViewMed;
    public ObservableList<medication> medList = FXCollections.observableArrayList();
    @FXML
    public TableColumn<medication, String> medNameColumn;
    @FXML
    public TableColumn<medication, String> medAmountColumn;

    public App mainApp;
    public patient patient;

    private mainCtrl mainCtrl;

    @FXML
    private Button btnExtendVitalSigns;

    tripInfo tripInfo;

    // Constructor
    public patientDataCtrl() {

    }

    public void setMainCtrl(mainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        medNameColumn.setCellValueFactory(cellData -> cellData.getValue().medName());
        medAmountColumn.setCellValueFactory(cellData -> cellData.getValue().medAmount());

    }

    // Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void setPatient(patient patient) {
        this.patient = patient;
    }

    public void updateView() {
        displayTripInfo();
        displayNote();
        displayMedication();
        displayVitalSigns();

    }

    public void displayVitalSigns() {
        //StackPane myStackpaneHR = new StackPane();
        this.patient.updateVitalSigns();
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();

        if (vitalSigns == null) {
            System.out.println("Den gik ik Theis");
        } else {
            this.valBPsys.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].bpsys)));
            this.valBPdia.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].bpdia)));
            this.valHR.setText((Integer.toString(vitalSigns[vitalSigns.length - 2].hr)));
            this.valSPO2.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].spo2)));
            this.valETCO2.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].etco2)));
        }
        
        // Set alert colours
        if (vitalSigns[vitalSigns.length - 2].hr>=80 && vitalSigns[vitalSigns.length - 2].hr<=120) {
            valHR.setBackground(new Background(new BackgroundFill(Color.web("#d7dd2b"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if (vitalSigns[vitalSigns.length - 2].hr>=130 && vitalSigns[vitalSigns.length - 2].hr<=500){
            valHR.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if (vitalSigns[vitalSigns.length - 2].hr>=1 && vitalSigns[vitalSigns.length - 2].hr<=50){
            valHR.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    public void displayTripInfo(){ 
        this.patient.updateTripInfo();
        this.tripInfo = this.patient.getTripInfo(); 
		//Sets value from this.tripInfo in patientDataView
		this.txtPatientName.setText(this.tripInfo.patientName);	
		this.txtCprNumber.setText(this.patient.cpr);	
		this.txtAccidentNumber.setText(this.tripInfo.accidentNumber);	
        this.txtAmbulancePhone.setText(this.tripInfo.ambulancePhoneNumber);
        this.txtDkIndex.setText(this.tripInfo.dkIndex);			
		//TimeStamps converted to string with .toString(), substring removes year/month/date, so that only time is left
		this.txtArrivedAtScene.setText((this.tripInfo.arrivedAtScene.toString()).substring(11,19));	
        this.txtEta.setText((this.tripInfo.eta.toString()).substring(11,19));	
        //Integer converted to string
        this.txtTriageScore.setText(Integer.toString(this.tripInfo.triageScore));	

    }

    public void displayNote(){
        this.txtNoteArea.setText(this.tripInfo.note);
    }

    public void displayMedication(){
        this.patient.updateMedication();
        medication[] med = this.patient.getMedication();
        if(med==null){
            System.out.println("Den gik ik Theis");
        } else {
            this.medList.addAll(med);
            this.tblViewMed.setItems(this.medList);
        }
    }
    
    @FXML
    public void handleExtendVitalSigns(){
        this.mainCtrl.showVitalSignsView(this.patient.cpr);
    }

	
}
