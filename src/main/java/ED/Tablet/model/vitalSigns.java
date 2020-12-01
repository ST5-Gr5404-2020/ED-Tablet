package ED.Tablet.model;

import java.time.LocalDateTime;

public class vitalSigns {
    public LocalDateTime timestamp;
    public int bp;
    public int hr;
    public int spo2;
    public int etco2;

	public vitalSigns(LocalDateTime timestamp, int bp, int hr, int spo2, int etco2){
        this.timestamp=timestamp;
        this.bp=bp;
        this.hr=hr;
        this.spo2=spo2;
        this.etco2=etco2;
	}
}