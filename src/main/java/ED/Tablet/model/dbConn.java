package ED.Tablet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class dbConn {

    //Attributes:
    private String host;
    private String DBPassword;
    private String username;

    // Constructor
    public dbConn(String host, String username, String DBPassword){
        this.host=host;
        this.DBPassword=DBPassword;
        this.username=username; 
    }

    //Methods
    protected Connection getConnection() {
		Connection myDB =null;            
        try {
			// Try loading the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");   
            myDB = DriverManager.getConnection(this.host, this.username, this.DBPassword);
		} 
		catch (ClassNotFoundException ex) {
            // Print out the exception
			System.out.println("Class not found: " + ex.getMessage());
		}
		catch (SQLException sqlex) {
            System.out.println("Connection Error: " + sqlex.getMessage());
        }    
        return myDB;        
    }

    protected PreparedStatement getPreparedStatement(String query) {
        try {
        	return this.getConnection().prepareStatement(query);
		}
        catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return null;
		}
	}

    protected ResultSet executeQuery(PreparedStatement pstmt){
        ResultSet rs = null;
        
		try {                
			rs = pstmt.executeQuery();
		}
		catch (SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {						
			// Close prepared statement
			// if (pstmt != null) {
			// 	try {
			// 		pstmt.close();
			// 	} 
			// 	catch (SQLException sqlEx) { 
			// 		// handle any errors
			// 		System.out.println("SQLException: " + sqlEx.getMessage());
			// 		System.out.println("SQLState: " + sqlEx.getSQLState());
			// 		System.out.println("VendorError: " + sqlEx.getErrorCode());
			// 	}				
			// 	pstmt = null;
			// }
			
		}    
		return rs;
		//TODO: Create method to close resultset after use
	}
}

