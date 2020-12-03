package ED.Tablet.model;

import java.sql.Connection;
import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	
	 // Constructor
	 public loginServerConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
    }
	
    public Boolean validateLogin(String personnelID, String password) {
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
