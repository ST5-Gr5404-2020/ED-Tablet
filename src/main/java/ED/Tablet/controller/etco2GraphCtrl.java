package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.application.Platform;
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

	@FXML
    private void initialize(){
		lineChartEtCo2.setAnimated(false);
	}

	public void updateView() {
		updateEtCo2Chart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml");
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
	}

	private void updateEtCo2Chart(){
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		if (vitalSigns != null) {
			XYChart.Series<String,Number> series = new XYChart.Series<>();
			
			for(int i = 0;i<vitalSigns.length;i++){			
				series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].etco2));  
			}
			// Update the graph
			Platform.runLater(() -> {
				lineChartEtCo2.setAnimated(false);
				lineChartEtCo2.getData().clear();
				lineChartEtCo2.getData().add(series);
				series.setName("ETCO2");	
			});
		}
	}
	
}
