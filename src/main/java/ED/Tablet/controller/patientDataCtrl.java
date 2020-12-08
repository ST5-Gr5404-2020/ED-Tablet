package ED.Tablet.controller;

import java.util.Observable;

import javax.swing.text.html.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ED.Tablet.App;
import ED.Tablet.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    
    //Medication labels
    @FXML
    public TableView<medication> tblViewMed;
    public ObservableList<medication> medList = FXCollections.observableArrayList();
    @FXML
    public TableColumn<medication, String> medNameColumn;
    @FXML
    public TableColumn<medication, String> medAmountColumn;
   
    public App mainApp;
	public patient patient; 
	
	tripInfo tripInfo;

    // Constructor
	public patientDataCtrl(){

    }
    

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        medNameColumn.setCellValueFactory(cellData -> cellData.getValue().medName());
        medAmountColumn.setCellValueFactory(cellData -> cellData.getValue().medAmount());
    
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
        displayMedication();
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
           /* for (int i=0; i<med.length;i++){
                //med[i].name.setAll(this.medication.getMedication().keySet());
                //this.tblViewMed.setItems(med[i].name);

                medName.addAll(med[i].name);
                medAmount.addAll(med[i].amount);
            }*/
            this.medList.addAll(med);
            this.tblViewMed.setItems(this.medList);
        }

        //medNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        
       /* if(med==null){
            System.out.println("Den gik ik Theis");
        } else {
            for (int i = 0; i<med.length;i++){
            System.out.println(med[i].name);
            System.out.println(med[i].amount);
            System.out.println(med[i].note);
            }
        }*/
    }

	
}
