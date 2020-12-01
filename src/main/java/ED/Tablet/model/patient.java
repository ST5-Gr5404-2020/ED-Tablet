package ED.Tablet.model;
import java.time.LocalDateTime;

import javax.imageio.IIOImage;

public class patient {

    private String cpr;
    private tripInfo tripInfo;
    private medication medication[];
	  private vitalSigns vitalSigns[];
	
	public cppjConn conn;
 
  // Constructor
  public patient(String cpr, cppjConn conn) {
    this.cpr=cpr;
    this.conn = conn;
	}

    public void updateTripInfo(tripInfo tripInfo) {
		
        this.tripInfo = conn.queryTripInfo(this.cpr);
		// Query tripInfo from cppjConn
		// Overskriv
    }

    public void updateMedication(medication medication){
        this.medication=conn.queryMedication(this.cpr, this.timestamp);
	
    }

    public void updateVitalSigns(vitalSigns vitalSigns){
		this.vitalSigns=conn.queryVitalSigns(this.cpr, this.timestamp);
		
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
