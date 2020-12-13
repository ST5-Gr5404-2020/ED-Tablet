package ED.Tablet.controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ED.Tablet.model.vitalSigns;
import ED.Tablet.model.medication;
import ED.Tablet.model.tripInfo;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class patientDataCtrl extends genericInMainCtrl {
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
    public Label valBP;
    
    @FXML
    public Label lblBpTimestamp;
    
    @FXML
    public Label lblSpo2Timestamp;
    
    @FXML
    public Label lblEtco2Timestamp;
    
    @FXML
    public Label lblHrTimestamp;

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

    public ObservableList<medication> medList = FXCollections.observableArrayList();

    // Medication labels
    @FXML
    public TableView<medication> tblViewMed;
    
    @FXML
    public TableColumn<medication, String> medNameColumn;
    
    @FXML
    public TableColumn<medication, String> medAmountColumn;

    @FXML
    private Button btnExtendVitalSigns;
    
    @FXML 
    private Button btnFullMedList;

    public int patientBirthYear;
    public int todaysYear;
    public int patientAge;

    @FXML
    private void initialize() {
        // Initialize the med table with the two columns.
        medNameColumn.setCellValueFactory(cellData -> cellData.getValue().medName());
        medAmountColumn.setCellValueFactory(cellData -> cellData.getValue().medAmount());

    }

    public void updateView() {
        displayTripInfo();
        displayNote();
        displayMedication();
        displayVitalSigns();

    }

    public void displayVitalSigns() {
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();
        if (vitalSigns != null) {
            //this.valBPsys.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].bpsys)));
            //this.valBPdia.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].bpdia)));
            
            this.valBP.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].bpsys)) + " / " + (Integer.toString(vitalSigns[vitalSigns.length - 1].bpdia)));
            this.valHR.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].hr)));
            this.valSPO2.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].spo2)));
            this.valETCO2.setText((Integer.toString(vitalSigns[vitalSigns.length - 1].etco2)));
            this.lblBpTimestamp.setText(vitalSigns[vitalSigns.length - 1].timestamp.toString().substring(11,19));
            this.lblSpo2Timestamp.setText(vitalSigns[vitalSigns.length - 1].timestamp.toString().substring(11,19));
            this.lblEtco2Timestamp.setText(vitalSigns[vitalSigns.length - 1].timestamp.toString().substring(11,19));
            this.lblHrTimestamp.setText(vitalSigns[vitalSigns.length - 1].timestamp.toString().substring(11,19));
            
            int patientBirthYear=1900 + Integer.parseInt(this.patient.cpr.toString().substring(4,6));
            int todaysYear = LocalDate.now().getYear();
            int patientAge = todaysYear - patientBirthYear;
            // Set alarm colors
            setAlarmHr(patientAge);
            setAlarmBp(patientAge);
            setAlarmSpo2();
            setAlarmEtco2();
        }
    }

    public void displayTripInfo(){ 
        tripInfo tripInfo = this.patient.getTripInfo(); 
        if (tripInfo != null) {
            //Sets value from this.tripInfo in patientDataView
            this.txtPatientName.setText(tripInfo.patientName);	
            this.txtCprNumber.setText(patient.cpr);	
            this.txtAccidentNumber.setText(tripInfo.accidentNumber);	
            this.txtAmbulancePhone.setText(tripInfo.ambulancePhoneNumber);
            this.txtDkIndex.setText(tripInfo.dkIndex);			
            //TimeStamps converted to string with .toString(), substring removes year/month/date, so that only time is left
            this.txtArrivedAtScene.setText((tripInfo.arrivedAtScene.toString()).substring(11,19));	
            this.txtEta.setText((tripInfo.eta.toString()).substring(11,19));	
            //Integer converted to string
            this.txtTriageScore.setText(Integer.toString(tripInfo.triageScore));	
        }
    }

    public void displayNote(){
        tripInfo tripInfo = this.patient.getTripInfo(); 
        if (tripInfo != null) {
            this.txtNoteArea.setText(tripInfo.note);
        }
    }

    public void displayMedication(){
        medication[] med = this.patient.getMedication();
        if(med != null){
            this.medList.setAll(med);
            //this.medList.addAll(med);
            this.tblViewMed.setItems(this.medList);
        }
    }
    
    @FXML
    public void handleExtendVitalSigns(){
        this.mainCtrl.showInMainView("view/vitalSignsView.fxml");
        //this.mainCtrl.showVitalSignsView(this.patient.cpr);
    }

    @FXML
    public void handleMedList(){
        this.mainCtrl.showInMainView("view/medicationListView.fxml");
        //this.mainCtrl.showExtendedMedication(this.patient.cpr);
    }
    
    

    public void setAlarmHr(int patientAge){
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();
        if (vitalSigns != null) {
            // Set alert colours for heartrate
            if(patientAge>18){
                if (vitalSigns[vitalSigns.length - 1].hr>=60 && vitalSigns[vitalSigns.length - 1].hr<=100){
                    valHR.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else{
                    valHR.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            } 
            else{
                if (vitalSigns[vitalSigns.length - 1].hr>=70 && vitalSigns[vitalSigns.length - 1].hr<=100){
                    valHR.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else{
                    valHR.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void setAlarmBp(int patientAge){
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();
        if (vitalSigns != null) {
            // Set alert for the systolic
            if(patientAge>60){
                if(vitalSigns[vitalSigns.length - 1].bpsys>=120 && vitalSigns[vitalSigns.length - 1].bpsys<=140){
                    valBP.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else{
                    valBP.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
            else{
                if(vitalSigns[vitalSigns.length - 1].bpsys>=100 && vitalSigns[vitalSigns.length - 1].bpsys<=130){
                    valBP.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else{
                    valBP.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void setAlarmEtco2(){
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();
        if (vitalSigns != null) {
            // Set alert for the end tidal co2 volume
            if(vitalSigns[vitalSigns.length - 1].etco2>=35 && vitalSigns[vitalSigns.length - 1].etco2<=45){
                valETCO2.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else{
                valETCO2.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

    public void setAlarmSpo2(){
        vitalSigns[] vitalSigns = this.patient.getVitalSigns();
        if (vitalSigns != null) {
            // Set alert for the end tidal co2 volume
            if(vitalSigns[vitalSigns.length - 1].spo2>=97 && vitalSigns[vitalSigns.length - 1].spo2<=100){
                valSPO2.setBackground(new Background(new BackgroundFill(Color.web("#2b9d31"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else{
                valSPO2.setBackground(new Background(new BackgroundFill(Color.web("#f80c0c"), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

}
