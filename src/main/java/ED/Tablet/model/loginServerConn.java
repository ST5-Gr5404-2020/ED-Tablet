package ED.Tablet.model;

public class loginServerConn extends dbConn {
    
    public void validataLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT " + password + "FROM loginServer WHERE ID = " + personnelID);

		if(rs.getString("password") = password)
		{
			verifyLogin = true;
		}

    }
}
