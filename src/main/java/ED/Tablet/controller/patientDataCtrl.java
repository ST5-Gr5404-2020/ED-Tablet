package ED.Tablet.controller;

import ED.Tablet.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class patientDataCtrl {
	@FXML
	private Label valBP;
	@FXML
	public Label valSPO2;
	@FXML
	public Label valETCO2;
	@FXML
	public Label valHR;
	public App mainApp;


	public patientDataCtrl(){

	}

	public void setMainApp(App mainApp) {
		this.mainApp = mainApp;
	}


	public void setVitalSigns(String input){
		this.valBP.setText(input);

	}




	
}
