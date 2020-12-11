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
    Timestamp time = new Timestamp(System.currentTimeMillis());
    if (this.medication != null) {
      time = this.medication[this.medication.length - 1].getTimestamp();
    }

    medication[] newMedication = cppjConn.queryMedication(this.cpr, time);	

    if (this.medication == null) {
      this.medication = newMedication;
    } else if (newMedication != null) {
      int lengthOld = this.medication.length;
      int lengthNew = newMedication.length;
      int lengthAll = lengthOld + lengthNew;

      medication[] allMedication = new medication[lengthAll];

      for (int i = 0; i < lengthOld; i++) {
        allMedication[i] = this.medication[i];
      }

      for (int i = lengthOld; i < (lengthAll); i++) {
        allMedication[i] = newMedication[i - lengthOld];
      }

      this.medication = allMedication;
    } else {
      System.out.println("No new medication");
    }
  }

    public void updateVitalSigns(){
      Timestamp time = new Timestamp(System.currentTimeMillis());
      if (this.vitalSigns != null) {
        time = this.vitalSigns[this.vitalSigns.length - 1].getTimestamp();
      }

      vitalSigns[] newVitalSigns = cppjConn.queryVitalSigns(this.cpr, time);	
  
      if (this.vitalSigns == null) {
        this.vitalSigns = newVitalSigns;
      } else if (newVitalSigns != null) {
        int lengthOld = this.vitalSigns.length;
        int lengthNew = newVitalSigns.length;
        int lengthAll = lengthOld + lengthNew;
  
        vitalSigns[] allVitalSigns = new vitalSigns[lengthAll];
  
        for (int i = 0; i < lengthOld; i++) {
          allVitalSigns[i] = this.vitalSigns[i];
        }
  
        for (int i = lengthOld; i < (lengthAll); i++) {
          allVitalSigns[i] = newVitalSigns[i - lengthOld];
        }
  
        this.vitalSigns = allVitalSigns;
      } else {
        System.out.println("No new vital signs");
      }
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
