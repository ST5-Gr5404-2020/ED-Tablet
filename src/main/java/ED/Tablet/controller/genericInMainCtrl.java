package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.patient;

public abstract class genericInMainCtrl {
	protected App mainApp;	
	protected patient patient;
	protected mainCtrl mainCtrl;
    
	public void setMainApp(App mainApp) {
		this.mainApp = mainApp;
	}

	public void setMainCtrl(mainCtrl mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setPatient(patient patient){
		this.patient = patient;
    }
    
	public abstract void updateView();
}
