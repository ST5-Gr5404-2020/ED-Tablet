package ED.Tablet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConn {

    //Attributes:
    protected String host = "https://db.course.hst.aau.dk/phpmyadmin/";
    protected String DBPassword = "pheyiesiehafileingei";
    protected String username = "hst_2020_20gr5404";
   // protected int port = 3306


    // Lave en constructor 
    public dbConn(String host, String DBPassword, String username){
    this.host=host;
    this.DBPassword=DBPassword;
    this.username=username; 
    }
    //Methods
    protected Connection connectToDB(String host, String DBPassword, String username) {
            Connection myDB =null;
            
        try {
            myDB = DriverManager.getConnection(host, DBPassword, username);
        }
           catch (SQLException sqlex) {
            System.out.println("Connection Error: " + sqlex.getMessage());
        }
        
        
        return myDB;
        
    }

    protected void executeQuery(String sqlStatement){

        Connection myDB = connectToDB(host, DBPassword, username);
        
        Statement stmt = null;
        ResultSet rs = null;

        if (myDB != null){
            try {
                
                stmt = myDB.createStatement();
                rs = stmt.executeQuery(sqlStatement);
            }
            catch (SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            finally {
                // it is a good idea to release
                // resources in a finally{} block
                // in reverse-order of their creation
                // if they are no-longer needed
                
                // Close result set
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { 
                        // handle any errors
                        System.out.println("SQLException: " + sqlEx.getMessage());
                        System.out.println("SQLState: " + sqlEx.getSQLState());
                        System.out.println("VendorError: " + sqlEx.getErrorCode());
                    }
                    
                    rs = null;
                }
                
                // Close statement
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { 
                        // handle any errors
                        System.out.println("SQLException: " + sqlEx.getMessage());
                        System.out.println("SQLState: " + sqlEx.getSQLState());
                        System.out.println("VendorError: " + sqlEx.getErrorCode());
                    }
                    
                    stmt = null;
                }
            }

    }    
}
}

