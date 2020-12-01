package ED.Tablet.model;

import java.sql.Connection;
import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	// TODO: lav ligesom cppjConn. Lav static og fjern constructor
	
	
	 // Constructor
	 public loginServerConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
    }
	
    public boolean validateLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		

		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT password FROM loginServer WHERE ID = " + personnelID);


		if(rs.getString("password") == password)
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
