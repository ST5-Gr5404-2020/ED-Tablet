package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class bpGraphCtrl extends genericInMainCtrl {

	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();
	
	@FXML
	LineChart<String,Number> lineChartBp = new LineChart<String,Number>(xAxis, yAxis);
	
	@FXML 
	Button btnBack;

	public void updateView() {
		updateBpChart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml", this.patient.cpr);
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
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
		seriesSys.setName("Systolic");
		seriesDia.setName("Diastolic");	
	}
	
}
