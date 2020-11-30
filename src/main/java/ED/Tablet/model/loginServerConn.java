package ED.Tablet.model;

import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	// constructor
	
    public boolean validataLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		//TODO: Fin en løsning til dette
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT password FROM loginServer WHERE ID = " + personnelID);

		if(rs.getString("password") == password)
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
