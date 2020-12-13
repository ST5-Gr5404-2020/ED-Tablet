package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.application.Platform;
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

	@FXML
    private void initialize(){
		lineChartSpO2.setAnimated(false);
	}

	public void updateView() {
		updateSpO2Chart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml");
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
	}

	private void updateSpO2Chart(){
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		if (vitalSigns != null) {
			XYChart.Series<String,Number> series = new XYChart.Series<>();
			
			for(int i = 0;i<vitalSigns.length;i++){			
				series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].spo2)); 
				
			}
			// Update the graph
			Platform.runLater(() -> {
				lineChartSpO2.getData().clear();
				lineChartSpO2.getData().add(series);
				series.setName("SPO2");	
			});	
		}
	}		
}
