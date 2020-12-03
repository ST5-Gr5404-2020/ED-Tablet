package ED.Tablet.model;

import java.sql.Timestamp;


public class tripInfo {

	public String dkIndex;
	public int triageScore;
	public String note;
	public Timestamp eta;
	public String patientName;
	public String accidentNumber;
	public String ambulancePhoneNumber;
	public Timestamp arrivedAtScene;

	public tripInfo(String dkIndex, int triageScore, String note, Timestamp eta,
	String patientName, String accidentNumber, String ambulancePhoneNumber, Timestamp arrivedAtScene) {
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