package ED.Tablet.model;

import java.sql.Timestamp;

public class patient {
  public String cpr;
  private tripInfo tripInfo;
  private medication medication[];
  private vitalSigns vitalSigns[];
 
  // Constructor
  public patient(String cpr) {
    this.cpr=cpr;   
	}

    public void updateTripInfo() {		
      this.tripInfo = cppjConn.queryTripInfo(this.cpr);
    }

    public void updateMedication(){
		//TODO: Create method to find newest timestamp, and insert it into the query, so that it comes after the newest data
        // this.medication=conn.queryMedication(this.cpr, this.timestamp);
        
        this.medication = cppjConn.queryMedication(this.cpr, new Timestamp(System.currentTimeMillis()));	
    }

    public void updateVitalSigns(){
		//TODO: Create method to find newest timestamp, and insert it into the query, so that it comes after the newest data
		//this.vitalSigns=conn.queryVitalSigns(this.cpr, this.timestamp);		
    }

    public tripInfo getTripInfo(){
    	return this.tripInfo;
    }

    public medication[] getMedication() {
    	return this.medication;        
    }

    public vitalSigns[] getVitalSigns(){
        return this.vitalSigns;
    }     
}
