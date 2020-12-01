package ED.Tablet.model;

import java.sql.ResultSet;
import java.sql.RowId;

public class cetreaConn extends dbConn{
	private String cetreaQuery = " SELECT * FROM cpr WHERE PersonnelID =?? ";
	
	 // Constructor
	 public cetreaConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
	}
	

    public String[] getPatientCprList(String cetreaQuery, String personnelID){

		ResultSet rs = super.executeQuery(cetreaQuery);

		// Validate that one or more row was returned, else return NULL.
        if (rs.getRow() == 0) {
            return null;
        }
        // Get the number of returned rows. Java has no build in function to
        //  get number of returned rows... (what, why?). Move cursor to last
        //  position. Get the ID, and move cursor back to the first position.
        // Move cursor to last position
		rs.afterLast();
		rs.previous();
        // Get the row ID
        int returnedRows = rs.getRow();
        // Move the cursor back to the first position
		rs.beforeFirst();
        // Prepare an array of patient-CPRs classes, with length of returned rows
        String[] cprPatientList = new String[returnedRows];
        // Loop through each returned row, and add information to the patient CPR instance
        while(rs.next()) {
            // First row has ID 1, while arrays are indexed from 0. Therefore
            //  minus 1 from row ID.
            // Get row ID
            int rowID = rs.getRow();
            // Instanciate the medication class. Use row ID - 1 as ID.
            cprPatientList[rowID-1] = 
        }
        // Return the array of medication
        return cprPatientList[];
    }
		
		

		String[] cprPatientList = new 






		//Personale ID bliver benyttet til at finde hvilke patienter de har tildelt. 
		//Her benyttes nedarvning fra bdcConn til at snakke med cetrea Database. executequery bliver benyttet
		//alt efter hvor mange resultater der er i resultsettet fra executequery giver antallet af pladser i arrayet
		String patientList [cpr];
    }
}
