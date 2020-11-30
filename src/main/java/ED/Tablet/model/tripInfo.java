package ED.Tablet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class tripInfo {

    public String dkIndex;
    public int triageScore;
    public String note;
	public LocalDateTime eta;
	public String patientName;
	public String accidentNumber;
	public String ambulancePhoneNumber;
	public LocalDateTime arrivedAtScene; 


	public tripInfo(String dkIndex, int triageScore, String note, LocalDateTime eta, 
	String patientName, String accidentNumber, String ambulancePhoneNumber, LocalDateTime arrivedAtScene){
		this.dkIndex=dkIndex;
		this.triageScore=triageScore; 
		this.note=note;
		this.eta=eta;
		this.patientName=patientName;
		this.accidentNumber=accidentNumber;
		this.ambulancePhoneNumber=ambulancePhoneNumber;
		this.arrivedAtScene=arrivedAtScene;
	}
}