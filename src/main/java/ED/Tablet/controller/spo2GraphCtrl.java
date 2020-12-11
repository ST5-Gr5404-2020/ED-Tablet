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

public class spo2GraphCtrl extends genericInMainCtrl {
	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();

	@FXML
	LineChart<String,Number> lineChartSpO2 = new LineChart<String,Number>(xAxis, yAxis);

	@FXML 
	Button btnBack;

	public void updateView() {
		updateSpO2Chart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml", this.patient.cpr);
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
	}

	protected void updateSpO2Chart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].spo2));	
		}
		lineChartSpO2.getData().add(series);	
		series.setName("SPO2");	
	}		
}
