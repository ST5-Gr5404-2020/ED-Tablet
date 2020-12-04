package ED.Tablet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

public class cetreaConn{
	
	// Attributes that defines which database to connect to
	private static String host = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2020_20gr5404&serverTimezone=UTC";
    private static String DBPassword = "pheyiesiehafileingei";
    private static String username = "hst_2020_20gr5404";
    // Here we make the uniqe connection that can be used in the methods
    private static dbConn db = new dbConn(host, DBPassword, username);

	// query to request data from crp
	private static String cetreaQuery = " SELECT * FROM CPR WHERE personnelID = ?";

    // Method to get patientCprlist from personnelID 
    public static String[] getPatientCprList(String personnelID){

		// Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
		PreparedStatement pstmt = db.getPreparedStatement(cetreaQuery);
        try{ 
			pstmt.setString(1, personnelID);
	
		}
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}
        
		
		ResultSet rs = db.executeQuery(pstmt);


		// Validate that one or more row was returned, else return NULL.
        if (rs.getRow() == 0) {
			return null;
        }
        
		try{

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
            cprPatientList[rowID-1] = rs.getString("CPR");
		}
	}	//Gives error message if somthing went wrong
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}
        return cprPatientList; 
    }
// Return the array of medication

}

