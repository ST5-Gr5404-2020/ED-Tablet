package ED.Tablet.model;

<<<<<<< HEAD
import java.sql.Connection;
=======
import sun.invoke.util.VerifyType;
>>>>>>> 35610fa618e2c14d29c6e738d55680003c2a8976

public class loginServerConn extends dbConn {
	
	 // Constructor
	 public loginServerConn(String host, String DBPassword, String username) {
        // Use superclass constructor
        super(host, DBPassword, username);
    }
	
    public boolean validataLogin(String personnelID, String password) {
		Boolean verifyLogin = false;
<<<<<<< HEAD
		

		Connection conn = DriverManager.getConnection("loginServer URL"); //Connecter til databaseservreen
			conn.setCatalog("loginServer"); //Connecter til loginServer databasen

		Statement stmt = conn.createStatement(); //laver statement object
		ResultSet rs = stmt.executeQuery("SELECT " + password + "FROM loginServer WHERE ID = " + personnelID); //henter password til tilhørende ID

		if(rs.getString("password") = password) //sammenligner indtastede password med det fra loginServer databasen
=======
		//TODO: Fin en løsning til dette
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT password FROM loginServer WHERE ID = " + personnelID);

		if(rs.getString("password") == password)
>>>>>>> 35610fa618e2c14d29c6e738d55680003c2a8976
		{
			verifyLogin = true;
		}

		return verifyLogin;
    }
}
