package ED.Tablet.model;

import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class medication {

    public Timestamp timestamp;
    private final StringProperty name;
    private final StringProperty amount;
	public String note;


	
	// Constructor to medication
	public medication(Timestamp timestamp, String name, String amount, String note){
		this.timestamp=timestamp;
		this.name= new SimpleStringProperty(name);
		this.amount= new SimpleStringProperty(amount);
		this.note=note;


	}

	// Initializes properties for the TableView
	public StringProperty medName(){
		return name;
	}
	public StringProperty medAmount(){
		return amount;
	}
}

