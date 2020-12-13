package ED.Tablet.model;

import java.util.HashMap;

import ED.Tablet.updateble;

public class personnel implements updateble {
    public int personnelID;
    public String password;
    private HashMap <String, patient> patientList; 
    public boolean loggedIn;

	public personnel() {
		this.patientList = new HashMap<String, patient>(); 
	}
  
	public void update() {
		updatePatientList();
	}

	public void updatePatientList(){
		String[] cprPatientList = cetreaConn.getPatientCprList(this.personnelID);

		for (int i=0; i<cprPatientList.length; i++){
			this.patientList.put(cprPatientList[i], new patient(cprPatientList[i]));
		}    
	}
	
	public HashMap <String, patient> getPatientList(){
		return this.patientList;	
	}

}