package ED.Tablet.model;

import java.time.LocalDateTime;

import javax.imageio.IIOImage;

public class tripInfo {

    public String dkIndex;
    public int triageScore;
    public String note;
    public IIOImage picture;
    public LocalDateTime ea;
}

public tripInfo(String dkIndex, int triageScore, String note, IIOImage picture, LocalDateTime ea){
    this.dkIndex=dkIndex;
    this.triageScore=triageScore; 
    this.note=note;
    this.picture=picture;
    this.ea=ea;
}