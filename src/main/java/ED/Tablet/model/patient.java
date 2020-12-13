package ED.Tablet.model;

import java.sql.Timestamp;

import ED.Tablet.updateble;
import ED.Tablet.updater;

public class patient implements updateble {
	public String cpr;
	private tripInfo tripInfo;
	private medication medication[];
	private vitalSigns vitalSigns[];

	private updater patientUpdater;

	// Constructor
	public patient(String cpr) {
		this.cpr=cpr;   
		// Force update
		update();
	}

	public void setUpdater(updater updater) {
		this.patientUpdater = updater;
	}

	public void stopUpdating() {
		if (this.patientUpdater != null) {
			this.patientUpdater.cancel();
		}
	}

	public void update() {
		updateTripInfo();
		updateMedication();
		updateVitalSigns();
	}

	public void updateTripInfo() {		
		this.tripInfo = cppjConn.queryTripInfo(this.cpr);
	}

	public void updateMedication(){
		Timestamp time;
		if (this.medication != null) {
			time = this.medication[this.medication.length - 1].getTimestamp();
		} else {
			time = new Timestamp(System.currentTimeMillis());
		}
		medication[] newMedication = cppjConn.queryMedication(this.cpr, time);	
		if (this.medication == null) {
			this.medication = newMedication;
		} else if (newMedication != null) {
			int lengthOld = this.medication.length;
			int lengthNew = newMedication.length;
			int lengthAll = lengthOld + lengthNew;
			// Allocate space for all new medication
			medication[] allMedication = new medication[lengthAll];
			// Add old medication
			for (int i = 0; i < lengthOld; i++) {
				allMedication[i] = this.medication[i];
			}
			// Add new medication
			for (int i = lengthOld; i < (lengthAll); i++) {
				allMedication[i] = newMedication[i - lengthOld];
			}
			this.medication = allMedication;
		} else {
			System.out.println("No new medication");
		}
	}

	public void updateVitalSigns(){
		Timestamp time;
		if (this.vitalSigns != null) {
			time = this.vitalSigns[this.vitalSigns.length - 1].getTimestamp();
		} else {
			time = new Timestamp(System.currentTimeMillis());
		}
		vitalSigns[] newVitalSigns = cppjConn.queryVitalSigns(this.cpr, time);	
		if (this.vitalSigns == null) {
			this.vitalSigns = newVitalSigns;
		} else if (newVitalSigns != null) {
			int lengthOld = this.vitalSigns.length;
			int lengthNew = newVitalSigns.length;
			int lengthAll = lengthOld + lengthNew;
			vitalSigns[] allVitalSigns = new vitalSigns[lengthAll];
			for (int i = 0; i < lengthOld; i++) {
				allVitalSigns[i] = this.vitalSigns[i];
			}
			for (int i = lengthOld; i < (lengthAll); i++) {
				allVitalSigns[i] = newVitalSigns[i - lengthOld];
			}
			this.vitalSigns = allVitalSigns;
		} else {
			System.out.println("No new vital signs");
		}
	}

	public tripInfo getTripInfo(){
		return this.tripInfo;
	}

	public medication[] getMedication() {
		return this.medication;        
	}

	public vitalSigns[] getVitalSigns(){
		return this.vitalSigns;
	}     
}
