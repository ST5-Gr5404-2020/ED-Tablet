package ED.Tablet.model;

import java.time.LocalDateTime;

public class medication {

    public LocalDateTime timestamp;
    public String name;
    public int amount;
    public String note;
}

public medication(LocalDateTime timestamp, String name, int amount, String note){
    this.timestamp=timestamp;
    this.name=name;
    this.amount=amount;
    this.note=note;
}