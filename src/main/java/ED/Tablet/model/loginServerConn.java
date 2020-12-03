package ED.Tablet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginServerConn {
	
	// Attributes that defines which database to connect to
	private static String host = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2020_20gr5404&serverTimezone=UTC";
	private static String DBPassword = "pheyiesiehafileingei";
	private static String username = "hst_2020_20gr5404";
 
	// Here we make the uniqe connection that can be used in the methods
	private static dbConn db = new dbConn(host, DBPassword, username);

	// query to request verification of login information.  
	private static String loginQuery = "SELECT password FROM personnel WHERE personnelID = ?";

	// Method to verify login
    public static boolean validateLogin(String personnelID, String password) {
		// Forberder statement, så vi får indsæt det rigtige på spørgsmålstegnet.
		PreparedStatement pstmt = db.getPreparedStatement(loginQuery);
        try{ 
			pstmt.setString(1, personnelID);
	
		}
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}

		Boolean verifyLogin = false;
		

		 
		ResultSet rs = db.executeQuery(pstmt);
		


		if(rs.getString("PASSWORD") == password);
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
