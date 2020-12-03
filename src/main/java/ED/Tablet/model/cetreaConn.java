package ED.Tablet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cetreaConn{
	
	// Attributes that defines which database to connect to
	private static String host = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2020_20gr5404";
    private static String DBPassword = "pheyiesiehafileingei";
    private static String username = "hst_2020_20gr5404";
    // Here we make the uniqe connection that can be used in the methods
	private static dbConn db = new dbConn(host, username, DBPassword);

	// query to request data from crp
	private static String cetreaQuery = " SELECT * FROM assignments WHERE personnelID = ?";

    // Method to get patientCprlist from personnelID 
    public static String[] getPatientCprList(int personnelID){

		// Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
		PreparedStatement pstmt = db.getPreparedStatement(cetreaQuery);
        try{ 
			//personnelID inserted into statement
			pstmt.setInt(1, personnelID); 	
		}
		catch(SQLException ex){
			System.out.println("Failed to incert personnelID");
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			//Return null if SQLexception is caught
			return null; 
		}        
		//Executes prepared statement
		ResultSet rs = db.executeQuery(pstmt);	
		// Fail if resultset is null
		if (rs == null) {
			System.out.println("ResultSet is null");
			return null;
		}
		//Find number of rows
		int returnedRows = 0;
		try{
			// Get the number of returned rows. Java has no build in function to
			//  get number of returned rows... (what, why?). Move cursor to last
			//  position. Get the ID, and move cursor back to the first position.
			// Move cursor to last position
			rs.afterLast();
			rs.previous();
			// Get the row ID
			returnedRows = rs.getRow();
			// Move the cursor back to the first position
			rs.beforeFirst();
		}
		catch(SQLException ex){
			System.out.println("Failed to get number of returned rows");
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());			
		} 
		//validate that returned rows is not 0
		if(returnedRows == 0){
			return null;
		}
		// Prepare an array of patient-CPRs classes, with length of returned rows
		String[] cprPatientList = new String[returnedRows];
		try{
			// Loop through each returned row, and add information to the patient CPR instance
			while(rs.next()) {
				// First row has ID 1, while arrays are indexed from 0. Therefore
				//  minus 1 from row ID.
				// Get row ID
				int rowID = rs.getRow();
				// Instanciate the medication class. Use row ID - 1 as ID.
				cprPatientList[rowID-1] = rs.getString("CPR");
			}
		}	//Gives error message if somthing went wrong
		catch(SQLException ex){
			System.out.println("Failed to loop through all returned patient CPR-numbers");
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}
        // Return the array of medication
		return cprPatientList;
    }

}

