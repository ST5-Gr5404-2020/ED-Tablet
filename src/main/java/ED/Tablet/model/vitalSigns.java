package ED.Tablet.model;

import java.sql.Timestamp;

public class vitalSigns {
    public Timestamp timestamp;
	public int bpsys;
	public int bpdia;
    public int hr;
    public int spo2;
	public int etco2;
	// Constructor to vitalSigns
	public vitalSigns(Timestamp timestamp, int bpsys, int bpdia, int hr, int spo2, int etco2){
        this.timestamp=timestamp;
		this.bpsys=bpsys;
		this.bpdia=bpdia;
        this.hr=hr;
        this.spo2=spo2;
        this.etco2=etco2;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

}