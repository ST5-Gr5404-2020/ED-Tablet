package ED.Tablet.controller;

import ED.Tablet.updateble;
import ED.Tablet.updater;
import ED.Tablet.model.patient;

public abstract class genericInMainCtrl implements updateble {

	protected patient patient;
	protected mainCtrl mainCtrl;

	protected updater ctrlUpdater;

	public void setMainCtrl(mainCtrl mainCtrl) {
		this.mainCtrl = mainCtrl;
	}

	public void setPatient(patient patient){
		this.patient = patient;
	}
	
	public void update() {
		updateView();
	}
	
	public void setUpdater(updater updater) {
		this.ctrlUpdater = updater;
	}

	public void stopUpdating() {
		if (this.ctrlUpdater != null) {
			this.ctrlUpdater.cancel();
		}
	}

	public abstract void updateView();
}
