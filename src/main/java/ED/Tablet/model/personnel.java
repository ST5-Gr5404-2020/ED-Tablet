package ED.Tablet.model;
import java.util.HashMap;
import javax.swing.JTextField;

public class personnel {
    public String personnelID;
    public String password;
    private HashMap <String, patient> patientList; 
    public boolean loggedIn;

	public personnel(String ID, String password) {
		this.personnelID = ID;
		//
	}




    public void updatePatientList(){
		// Cetrea conn -> Få string list af CPR
		// Gem list af CpR i hashmap som key
		// For hver key lav en patient instans og gem i hashmap
    }


    public HashMap <String, patient> getPatientList(){
      

    }
}
