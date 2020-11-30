package ED.Tablet.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import sun.security.util.Password;

public class dbConn {

    //Attributes:
    protected String host;
    protected String DBPassword;
    protected int port;


    // Lave en constructor 
    public dbConn(String host, String DBPassword, int port){
    this.host=host;
    this.DBPassword=DBPassword;
    this.port=port; 
    }

   

    //Methods
    protected boolean connectToDB(String host, String DBPassword, int port) {
        Connection myDB =null;
        try {
            Connection myDB = DriverManager.getConnection(host, DBPassword, port);

        }
        
        return myDB;
    }

    protected ResultSet executeQuery(){

        Connection myDB = connectToDB();
        
        Statement stmt = null;
        ResultSet rs = null;

        
        


        ResultSet myRs = myStmt.executeQuery("select * from database") 

    }
    
}

