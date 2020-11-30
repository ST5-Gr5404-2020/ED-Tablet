package ED.Tablet.model;

import java.time.LocalDateTime;


public class tripInfo {

    public String dkIndex;
    public int triageScore;
    public String note;
    public LocalDateTime ea;

	public tripInfo(String dkIndex, int triageScore, String note, LocalDateTime ea){
		this.dkIndex=dkIndex;
		this.triageScore=triageScore; 
		this.note=note;
		this.ea=ea;
	}
}