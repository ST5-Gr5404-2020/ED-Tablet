package ED.Tablet.model;

import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class medication {

    private Timestamp timestamp;
    private final StringProperty name;
    private final StringProperty amount;
	private final StringProperty note;
	
	// Constructor to medication
	public medication(Timestamp timestamp, String name, String amount, String note){
		this.timestamp= timestamp;
		this.name= new SimpleStringProperty(name);
		this.amount= new SimpleStringProperty(amount);
		this.note= new SimpleStringProperty(note); 


	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	// Initializes properties for the TableView
	public StringProperty medName(){
		return name;
	}
	public StringProperty medAmount(){
		return amount;
	}

	public StringProperty medTimestamp(){
		return new SimpleStringProperty(this.timestamp.toString().substring(11,19));
	}
	public StringProperty medNote(){
		return note;
	}
}

