package ED.Tablet.model;
import java.time.LocalDateTime;

import javax.imageio.IIOImage;

public class patient {

    private String cpr;
    private tripInfo tripInfo;
    private medication medication;
    private vitalSigns vitalSigns;

    public void updateTripInfo(tripInfo tripInfo) {
        this.tripInfo=tripInfo;

    }

    public void updateMedication(medication medication){
        this.medication=medication;

    }

    public void updateVitalSigns(vitalSigns vitalSigns){
        this.vitalSigns=vitalSigns;
    }

    public tripInfo getTripInfo(){
      return this.tripInfo;

    }

    public medication getMedication() {
        return this.medication;
        
    }

    public vitalSigns getVitalSigns(){
        return this.vitalSigns;
    }   

 

  
}
