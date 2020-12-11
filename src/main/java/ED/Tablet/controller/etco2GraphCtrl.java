package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class etco2GraphCtrl extends genericInMainCtrl {
	
	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();
	
	@FXML
	LineChart<String,Number> lineChartEtCo2 = new LineChart<String,Number>(xAxis, yAxis);
	
	@FXML 
	Button btnBack;

	public void updateView() {
		updateEtCo2Chart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml", this.patient.cpr);
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
	}

	public void updateEtCo2Chart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].etco2)); 
			 
		}
		lineChartEtCo2.getData().add(series);
		series.setName("ETCO2");	
	}
	
}
