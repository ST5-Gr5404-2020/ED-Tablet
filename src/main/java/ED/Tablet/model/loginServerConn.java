package ED.Tablet.model;

import java.sql.Connection;
import sun.invoke.util.VerifyType;

public class loginServerConn extends dbConn {
	
	
	 // Constructor
	 public loginServerConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
    }
	
    public boolean validateLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
		

		Connection conn = DriverManager.getConnection("loginServer URL"); //Connecter til databaseservreen
			conn.setCatalog("loginServer"); //Connecter til loginServer databasen

		Statement stmt = conn.createStatement(); //laver statement object
		ResultSet rs = stmt.executeQuery("SELECT " + password + "FROM loginServer WHERE ID = " + personnelID); //henter password til tilhørende ID

		if(rs.getString("password") = password) //sammenligner indtastede password med det fra loginServer databasen
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
