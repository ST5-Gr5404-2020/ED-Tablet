package ED.Tablet.model;

import java.util.HashMap;

public class personnel {
    public int personnelID;
    public String password;
    private HashMap <String, patient> patientList; 
    public boolean loggedIn;

	public personnel(int ID, String password) {
    this.personnelID = ID;
    this.password=password;

    this.patientList = new HashMap<String, patient>();
    
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
