package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import jdk.nashorn.api.tree.ForLoopTree;

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

    //Note lavel
    @FXML
    public TextArea txtNoteArea;

    public App mainApp;
	public patient patient; 
	
	tripInfo tripInfo;

    // Constructor
	public patientDataCtrl(){

	}
    //Give the controller access to the main app
	public void setMainApp(App mainApp) {
		this.mainApp = mainApp;
	}

	public void setPatient(patient patient){
		this.patient = patient;
	}

	public void displayVitalSigns(){
        // this.valHR.setText(Integer.parseint(patient.getVitalSigns()[0].hr));
        // this.valBPsys.setText.(patient.getVitalSigns[0].bpsys);
        // this.valBPdia.setText(patient.getVitalSigns[0].bpdia);
        // this.valSPO2.setText(patient.getVitalSigns[0].spo2);
        // this.valETCO2.setText(patient.getVitalSigns[0].etco2);
        // this.valHR.setText(Integer.parseint(patient.getVitalSigns[0].hr));

	}
    public void updateView(){
        this.patient.updateTripInfo();
        this.tripInfo = this.patient.getTripInfo(); 
        displayTripInfo();
        displayNote();
        //displayMedication();
        //displayVitalSigns();

    }
    public void displayTripInfo(){ 
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
            for (int i = 0; i<med.length;i++){
            System.out.println(med[i].name);
            System.out.println(med[i].amount);
            System.out.println(med[i].note);
            }
        }
    }

	
}
