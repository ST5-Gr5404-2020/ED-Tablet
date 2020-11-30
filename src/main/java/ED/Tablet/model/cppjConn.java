package ED.Tablet.model;

import java.sql.Connection;
import java.sql.ResultSet;

public class cppjConn extends dbConn{

    // Attributes
    private String tripInfoQuery = "SELECT * FROM tripInfo WHERE cpr = ?";
    private String medicationQuery = "SELECT * FROM medication WHERE cpr = ? AND timestamp > ?";
    private String vitalSignsQuery = "SELECT * FROM tripInfo WHERE cpr = ? AND timestamp > ?";

    // Constructor
    public cppjConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
    }

    //Methods
    public tripInfo queryTripInfo(String cpr){

        // TODO: Vi skal have en måde at lave en connection og få et conn object,
        //  måske connectToDB skal lave til at returnere et conn object

    
        // Execute the tripInfo MySQL query
        ResultSet rs = super.executeQuery(tripInfoQuery, cpr);
        // Validate that a row was returned, by getting row ID. If no rows are
        //  returned row ID will be 0, before moving the cursor.
        if (rs.getRow() == 0) {
            return null;
        }
        // Cursor is instantiated before first row, move cursor forward once
        rs.next();
        // Instantiate a tripInfo from the resultset
        tripInfo tp = new tripInfo(
            rs.getString("dkIndex"), 
            rs.getInt("triageScore"),
            rs.getString("note"),
            rs.getTimestamp("ea")
		);
        // Close the resultset
        rs.close();
        // Return the tripInfo
        return tp;
    }

    public medication[] queryMedication(String cpr, LocalDateTime timeStamp){
        // Execute the medication MySQL query
        ResultSet rs = super.executeQuery(medicationQuery, cpr, timeStamp);
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
        // Prepare an array of medication classes, with length of returned rows
        medication[] med = new medication[returnedRows];
        // Loop through each returned row, and add information to the medication instance
        while(rs.next()) {
            // First row has ID 1, while arrays are indexed from 0. Therefore
            //  minus 1 from row ID.
            // Get row ID
            int rowID = rs.getRow();
            // Instanciate the medication class. Use row ID - 1 as ID.
            med[rowID - 1] = new medication(
                rs.getTimestamp("timestamp"),
                rs.getString("name"),
                rs.getInt("amount")
            );
        }
        // Return the array of medication
        return med;
    }

    public vitalSigns[] queryVitalSigns(String cpr, LocalDateTime timeStamp){
        // Execute the medication MySQL query
        ResultSet rs = super.executeQuery(vitalSignsQuery, cpr, timeStamp);
        // Validate that one or more row was returned, else return NULL
        if (rs.getRow() == 0) {
            return NULL;
        }
        // Get the number of returned rows
		rs.afterLast();
		rs.previous();
        // Get the row ID
        int returnedRows = rs.getRow();
        // Move the cursor back to the first position
        rs.beforeFirst();
        // Prepare an array of vitalsigns classes
        vitalSigns[] vs = new vitalSigns[returnedRows];
        // Loop through each returned row
        while(rs.next()) {
            // Get row ID
            int rowID = rs.getRow();
            // Instanciate the vitalSigns class.
            vs[rowID - 1] = new vitalSigns(
                rs.getTimestamp("timestamp"),
                rs.getFloat("bt"),
                rs.getInt("bp"),
                rs.getInt("hr"),
                rs.getInt("rr"),
                rs.getInt("spo2"),
                rs.getInt("etco2")
            );
        }
        // Return the array of vitalSigns
        return vs;
    }
}