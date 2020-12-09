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

public class heartRateGraphCtrl {
	public App mainApp;	
public patient patient;
private mainCtrl mainCtrl;
CategoryAxis xAxis = new CategoryAxis();
NumberAxis yAxis = new NumberAxis();
@FXML
LineChart<String,Number> lineChartHr = new LineChart<String,Number>(xAxis, yAxis);
@FXML 
Button btnBack;

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
	public void updateHrChart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 19), vitalSigns[i].hr)); 
			 
		}
		lineChartHr.getData().add(series);		
	}
	
}