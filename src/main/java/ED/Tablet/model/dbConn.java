package ED.Tablet.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class dbConn {

    //Attributes:
    protected String host;
    protected String DBPassword;
    protected int port;


	// Lave en constructor 

    //Methods
    protected boolean connectToDB(String host, String DBPassword, int port) {
        try {
            Connection myDB = DriverManager.getConnection(url, user, password)
        }
        

    }

    protected ResultSet executeQuery(){
        ResultSet myRs = myStmt.executeQuery("select * from database") 
    }
}
