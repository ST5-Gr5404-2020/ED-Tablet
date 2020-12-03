package ED.Tablet.model;

import java.sql.Timestamp;

public class medication {

    public Timestamp timestamp;
    public String name;
    public int amount;
	public String note;
	

	public medication(Timestamp timestamp, String name, int amount, String note){
		this.timestamp=timestamp;
		this.name=name;
		this.amount=amount;
		this.note=note;
	}
}

