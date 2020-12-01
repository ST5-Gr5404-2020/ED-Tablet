package ED.Tablet.model;

import java.sql.ResultSet;

public class cetreaConn extends dbConn{
	private String cetreaQuery = " SELECT * FROM cpr WHERE PersonnelID =";
	
	 // Constructor
	 public cetreaConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
	}
	

    public String[] getPatientCprList(String cetreaQuery, String personnelID){

		ResultSet rs = super.executeQuery(cetreaQuery+ personnelID);



		//Personale ID bliver benyttet til at finde hvilke patienter de har tildelt. 
		//Her benyttes nedarvning fra bdcConn til at snakke med cetrea Database. executequery bliver benyttet
		//alt efter hvor mange resultater der er i resultsettet fra executequery giver antallet af pladser i arrayet
		String patientList [cpr];
    }
}
