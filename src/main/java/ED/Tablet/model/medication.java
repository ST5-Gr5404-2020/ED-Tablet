package ED.Tablet.model;

import java.sql.Timestamp;

public class medication {

    public Timestamp timestamp;
    public String name;
    public String amount;
	public String note;
	
	// Constructor to medication
	public medication(Timestamp timestamp, String name, String amount, String note){
		this.timestamp=timestamp;
		this.name=name;
		this.amount=amount;
		this.note=note;
	}
}

