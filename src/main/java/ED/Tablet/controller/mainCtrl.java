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
import javafx.scene.control.Button;

public class mainCtrl {    
    private App mainApp;
    @FXML
    private ListView<String> lstListView;
    private ObservableList<String> cprList = FXCollections.observableArrayList();
    @FXML
    public AnchorPane anchorPatientData;
    @FXML
    private Button btnLogout;


    public mainCtrl(){}
    //Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
        this.mainApp.personnel.updatePatientList();
        //System.out.println(this.mainApp.personnel.personnelID);
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
    }
    public void showPatientDataView (String cpr){
        try {
            // Load mainView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/patientDataView.fxml"));
            AnchorPane anchorPatientDataView = (AnchorPane) loader.load();
            // Set loginView into the center of root layout.
            this.anchorPatientData.getChildren().setAll(anchorPatientDataView);
            // Give the controller access to the main app.
            ED.Tablet.controller.patientDataCtrl controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.setPatient(this.mainApp.personnel.getPatientList().get(cpr));
            controller.displayTripInfo();
            
        } catch (IOException e) {
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
