package ED.Tablet.model;

import java.sql.Connection;

public class loginServerConn extends dbConn {
    
    public void validataLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		

		Connection conn = DriverManager.getConnection("loginServer URL"); //Connecter til databaseservreen
			conn.setCatalog("loginServer"); //Connecter til loginServer databasen

		Statement stmt = conn.createStatement(); //laver statement object
		ResultSet rs = stmt.executeQuery("SELECT " + password + "FROM loginServer WHERE ID = " + personnelID); //henter password til tilhørende ID

		if(rs.getString("password") = password) //sammenligner indtastede password med det fra loginServer databasen
		{
			verifyLogin = true;
		}

    }
}
