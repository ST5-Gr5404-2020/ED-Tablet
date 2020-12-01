package ED.Tablet.model;

import java.util.HashMap;
import javax.swing.JTextField;

import ED.Tablet.App;

public class personnel {
    public String personnelID;
    public String password;
    private HashMap <String, patient> patientList; 
    public boolean loggedIn;

	public personnel(String ID, String password) {
    this.personnelID = ID;
    this.password=password;
    
	}

    public void updatePatientList(){
    String[] cprPatientList = conn.getPatientCprList();

    for (int i=0;i<cprPatientList.length;i++){
      this.patientList.put(cprPatientList[i], new patient);
    }
    
      // Cetrea conn -> Få string list af CPR
      
		// Cetrea conn -> Få string list af CPR
		// Gem list af CpR i hashmap som key
    // For hver key lav en patient instans og gem i hashmap
    
    }

}
