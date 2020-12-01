package ED.Tablet.model;

import java.sql.Connection;
import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	
	// Attributes that defines which database to connect to
	protected static String host = "https://db.course.hst.aau.dk/phpmyadmin/";
	protected static String DBPassword = "pheyiesiehafileingei";
	protected static String username = "hst_2020_20gr5404";
 
	// Here we make the uniqe connection that can be used in the methods
	private static dbConn db = new dbConn(host, DBPassword, username);

	// query to request data from tripinfo, medication and vitalsigns 
	private static String loginServerQuery = "SELECT password FROM loginServer WHERE ID = ?";

	// Method to verify login
    public static boolean validateLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		

		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(loginServerQuery);


		if(rs.getString("password") == password)
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
