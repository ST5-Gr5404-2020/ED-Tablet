package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.application.Platform;
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

	@FXML
    private void initialize(){
		lineChartBp.setAnimated(false);
	}

	public void updateView() {
		updateBPChart();
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/vitalSignsView.fxml");
		//this.mainCtrl.showVitalSignsView(this.patient.cpr);
	}

	private void updateBPChart(){
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		if (vitalSigns != null) {
			XYChart.Series<String,Number> seriesSys = new XYChart.Series<>();
			XYChart.Series<String,Number> seriesDia = new XYChart.Series<>();
					
			for(int i = 0;i<vitalSigns.length;i++){			
				seriesSys.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].bpsys)); 
				seriesDia.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].bpdia)); 
			}
			// Update the graph
			Platform.runLater(() -> {
				lineChartBp.setAnimated(false);
				lineChartBp.getData().clear();
				lineChartBp.getData().add(seriesSys);
				lineChartBp.getData().add(seriesDia);
				seriesSys.setName("Systolic");
				seriesDia.setName("Diastolic");
			});
		}
	}
	
}
