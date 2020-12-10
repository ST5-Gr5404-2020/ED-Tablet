package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.patient;
import ED.Tablet.model.vitalSigns;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class bpGraphCtrl {
public App mainApp;	
public patient patient;
private mainCtrl mainCtrl;
CategoryAxis xAxis = new CategoryAxis();
NumberAxis yAxis = new NumberAxis();
@FXML
LineChart<String,Number> lineChartBp = new LineChart<String,Number>(xAxis, yAxis);
@FXML 
Button btnBack;
private boolean addAll;

public void setMainApp(App mainApp) {
	this.mainApp = mainApp;
}

public void setMainCtrl(mainCtrl mainCtrl) {
	this.mainCtrl = mainCtrl;
}

public void setPatient(patient patient){
	this.patient = patient;
}

public void handleBtnBack(){
	this.mainCtrl.showVitalSignsView(this.patient.cpr);
}

public void updateBpChart(){
	this.patient.updateVitalSigns();
	vitalSigns[] vitalSigns = this.patient.getVitalSigns();
	XYChart.Series<String,Number> seriesSys = new XYChart.Series<>();
	XYChart.Series<String,Number> seriesDia = new XYChart.Series<>();
	
	for(int i = 0;i<vitalSigns.length;i++){			
		seriesSys.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 19), vitalSigns[i].bpsys));
		seriesDia.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 19), vitalSigns[i].bpdia));  
			
	}
	lineChartBp.getData().addAll(seriesSys,seriesDia);		
}
	
}
