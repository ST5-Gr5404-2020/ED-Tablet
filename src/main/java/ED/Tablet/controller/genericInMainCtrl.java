package ED.Tablet.controller;

import ED.Tablet.model.patient;

public abstract class genericInMainCtrl {

	protected patient patient;
	protected mainCtrl mainCtrl;

	public void setMainCtrl(mainCtrl mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setPatient(patient patient){
		this.patient = patient;
    }
    
	public abstract void updateView();
}
