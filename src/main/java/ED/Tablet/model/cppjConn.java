package ED.Tablet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class cppjConn {

    // Attributes that defines which database to connect to
    private static String host = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2020_20gr5404";
    private static String DBPassword = "pheyiesiehafileingei";
    private static String username = "hst_2020_20gr5404";

	// Here we make the uniqe connection that can be used in the methods
    private static dbConn db = new dbConn(host, username, DBPassword);
	
	// query to request data from tripinfo, medication and vitalsigns 
    private static String tripInfoQuery = "SELECT * FROM tripInfo WHERE CPR = ?";
    private static String medicationQuery = "SELECT * FROM medication WHERE CPR = ? AND timeStamp > ?";
    private static String vitalSignsQuery = "SELECT * FROM vitalSigns WHERE CPR = ? AND timeStamp > ?";

    //Methods
    public static tripInfo queryTripInfo(String cpr){    
        // Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.   
        PreparedStatement pstmt = db.getPreparedStatement(tripInfoQuery);
        try{
			//Insert CPR query into statement
    		pstmt.setString(1, cpr);
        }
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return null;
		}

        // Execute the tripInfo MySQL query
		ResultSet rs = db.executeQuery(pstmt);
		        
		// Cursor is instantiated before first row, move cursor forward once
		try{
			rs.next();			
			// Instantiate a tripInfo from the resultset
			tripInfo tp = new tripInfo(
				rs.getString("dkIndex"), 
				rs.getInt("triageScore"),
				rs.getString("note"),
				rs.getTimestamp("eta"),
				rs.getString("patientName"),
				rs.getString("accidentNr"),
				rs.getString("ambulancePhoneNr"),
				rs.getTimestamp("arrivedAtScene")
			);
			// Close the resultset
			try{
				rs.close();
			}
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());			
			}
			// Return the tripInfo
			return tp;

		}		
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			//Return null if SQLexception is caught
			return null;
		} 
	}
	

    public static medication[] queryMedication(String cpr, Timestamp timestamp){
        // Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
        PreparedStatement pstmt = db.getPreparedStatement(medicationQuery);
        try{
            pstmt.setString(1, cpr);
            pstmt.setTimestamp(2, timestamp);
		}
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			//Return null if SQLException is caught
			return null;
		}
        // Execute the medication MySQL query
        ResultSet rs = db.executeQuery(pstmt);
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
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());			
		} 
		//validate that returned rows is not 0
		if(returnedRows == 0){
			return null;
		}
		
        // Prepare an array of medication classes, with length of returned rows
        medication[] med = new medication[returnedRows];
		// Loop through each returned row, and add information to the medication instance
		try{
      		while(rs.next()) {
            // First row has ID 1, while arrays are indexed from 0. Therefore
            //  minus 1 from row ID.
            // Get row ID
            int rowID = rs.getRow();
            // Instanciate the medication class. Use row ID - 1 as ID.
            med[rowID - 1] = new medication(
                rs.getTimestamp("timestamp"),
                rs.getString("name"),
				rs.getInt("amount"),
				rs.getString("note")
				);
			}	
		}
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
        // Return the array of medication
        return med;
    }

    public static vitalSigns[] queryVitalSigns(String cpr, Timestamp timestamp){
        // Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
        PreparedStatement pstmt = db.getPreparedStatement(vitalSignsQuery);
        try{
            pstmt.setString(1, cpr);
            pstmt.setTimestamp(2,timestamp);
            }
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			//Return null if SQLexception is caught
			return null; 
		}
        // Execute the medication MySQL query
        ResultSet rs = db.executeQuery(pstmt);
        // initialize returnedRows variable
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
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());			
		} 
		//validate that returned rows is not 0
		if(returnedRows == 0){
			return null;
		}

		vitalSigns[] vs = new vitalSigns[returnedRows];
		// Loop through each returned row
		try{
			while(rs.next()) {
				// Get row ID
				int rowID = rs.getRow();
				// Instanciate the vitalSigns class.
				
				vs[rowID - 1] = new vitalSigns(
					rs.getTimestamp("timestamp"),
					rs.getInt("bpsys"),
					rs.getInt("bpdia"),
					rs.getInt("hr"),
					rs.getInt("spo2"),
					rs.getInt("etco2")
				);
			}

		}	
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());			
		} 
		// Return the array of vitalSigns
		return vs;
		
	}
}