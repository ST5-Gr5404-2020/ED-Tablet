package ED.Tablet.model;
import java.util.HashMap;
import javax.swing.JTextField;

public class personnel {
    public String personnelID;
    public String password;
    private HashMap <String, patient> patientList; 
    public boolean loggedIn;


    public void setID(String ID){
        String personnelID = personnelID.getText();
    }

    
    public void setPassword(String password){
        String password= password.getText();
    }


    public void updatePatientList(){
    }


    public HashMap <String, patient> getPatientList(){

    }
}
