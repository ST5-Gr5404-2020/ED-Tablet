package ED.Tablet.model;

public class cetreaConn extends dbConn{
    
    public String getPatientCprList(String personnelID){

		//Personale ID bliver benyttet til at finde hvilke patienter de har tildelt. 
		//Her benyttes nedarvning fra bdcConn til at snakke med cetrea Database. executequery bliver benyttet
		//alt efter hvor mange resultater der er i resultsettet fra executequery giver antallet af pladser i arrayet
		String patientList [cpr];
    }
}
