package ED.Tablet.controller;

import ED.Tablet.model.medication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class medicationCtrl extends genericInMainCtrl {
    
    public ObservableList<medication> medList = FXCollections.observableArrayList();

    // Medication labels
    @FXML
    public TableView<medication> tblViewFullMed;
    
    @FXML
    public TableColumn<medication, String> medNameColumn;
    
    @FXML
    public TableColumn<medication, String> medAmountColumn;
    
    @FXML
    public TableColumn<medication, String> medTimestampColumn;
    
    @FXML
    public TableColumn<medication, String> medNoteColumn;
    
    
    public void updateView() {
        displayFullMedication();
    }

	public void handleBtnBack(){
        this.mainCtrl.showInMainView("view/patientDataView.fxml");
		//this.mainCtrl.showPatientDataView(this.patient.cpr);
	}

    @FXML
    private void initialize() {
        // Initialize the med table with the two columns.
        medNameColumn.setCellValueFactory(cellData -> cellData.getValue().medName());
        medAmountColumn.setCellValueFactory(cellData -> cellData.getValue().medAmount());
        medTimestampColumn.setCellValueFactory(cellData -> cellData.getValue().medTimestamp());
        medNoteColumn.setCellValueFactory(cellData -> cellData.getValue().medNote());
    }

    public void displayFullMedication(){
        medication[] med = this.patient.getMedication();
        if (med != null) {
            this.medList.setAll(med);
            this.tblViewFullMed.setItems(this.medList);
        }
    }
}
