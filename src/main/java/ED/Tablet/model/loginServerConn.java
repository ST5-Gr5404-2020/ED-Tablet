package ED.Tablet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	// TODO: lav ligesom cppjConn. Lav static og fjern constructor
	
	
	 // Attributes
	 protected static String host = "https://db.course.hst.aau.dk/phpmyadmin/";
	 protected static String DBPassword = "pheyiesiehafileingei";
	 protected static String username = "hst_2020_20gr5404";
	 private static String loginQuery = "SELECT password WHERE ID = ?";
	 private static dbConn db = new dbConn(host, DBPassword, username);
	
    public static boolean validateLogin(String personnelID, String password) {
		// Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
		PreparedStatement pstmt = db.getPreparedStatement(loginQuery);
        pstmt.setString(1, personnelID);
		
		

		Boolean verifyLogin = false;
		

		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(pstmt);


		if(rs.getString("password") == password)
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
