package ED.Tablet.controller;

import ED.Tablet.model.vitalSigns;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class vitalSignsCtrl extends genericInMainCtrl {

	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();
	@FXML
	LineChart<String,Number> lineChartBP = new LineChart<String,Number>(xAxis, yAxis);
	@FXML
	LineChart<String,Number> lineChartEtCo2 = new LineChart<String,Number>(xAxis, yAxis);
	@FXML
	LineChart<String,Number> lineChartSpO2 = new LineChart<String,Number>(xAxis, yAxis);
	@FXML
	LineChart<String,Number> lineChartHr = new LineChart<String,Number>(xAxis, yAxis);
	@FXML
	Button btnBpExtend;
	@FXML
	Button btnSpO2Extend;
	@FXML
	Button btnEtCo2Extend;
	@FXML
	Button btnHrExtend;
	@FXML 
	Button btnBack;

	@FXML
    private void initialize(){
		lineChartBP.setAnimated(false);
		lineChartEtCo2.setAnimated(false);
		lineChartHr.setAnimated(false);
		lineChartSpO2.setAnimated(false);
	}
	
	public void updateView() {
		updateBPChart();
		updateEtCo2Chart();
		updateSpO2Chart();
		updateHrChart();
	}

	public void handleEtcO2Extend(){
		this.mainCtrl.showInMainView("view/etco2Graph.fxml");
		//this.mainCtrl.showEtCo2Extend(this.patient.cpr);
	}

	public void handleHrExtend(){
		this.mainCtrl.showInMainView("view/heartRateGraph.fxml");
		//this.mainCtrl.showHrExtend(this.patient.cpr);
	}

	public void handleSpO2Extend(){
		this.mainCtrl.showInMainView("view/spo2Graph.fxml");
		//this.mainCtrl.showSpO2Extend(this.patient.cpr);
	}

	public void handleBpExtend(){
		this.mainCtrl.showInMainView("view/bloodPressureGraph.fxml");
		//this.mainCtrl.showBpExtend(this.patient.cpr);
	}

	public void handleBtnBack(){
		this.mainCtrl.showInMainView("view/patientDataView.fxml");
		//this.mainCtrl.showPatientDataView(this.patient.cpr);
	}
	
	public void updateBPChart(){
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
				lineChartBP.getData().clear();
				lineChartBP.getData().add(0, seriesSys);
				lineChartBP.getData().add(1, seriesDia);
				seriesSys.setName("Systolic");
				seriesDia.setName("Diastolic");
			});
		}
	}

	public void updateEtCo2Chart(){
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		if (vitalSigns != null) {
			XYChart.Series<String,Number> series = new XYChart.Series<>();
			
			for(int i = 0;i<vitalSigns.length;i++){			
				series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].etco2));  
			}
			// Update the graph
			Platform.runLater(() -> {
				lineChartEtCo2.getData().clear();
				lineChartEtCo2.getData().add(series);
				series.setName("ETCO2");	
			});
		}
	}

	public void updateSpO2Chart(){
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

	public void updateHrChart(){
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		if (vitalSigns != null) {
			XYChart.Series<String,Number> series = new XYChart.Series<>();
			
			for(int i = 0;i<vitalSigns.length;i++){			
				series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].hr)); 
			}
			// Update the graph
			Platform.runLater(() -> {
				lineChartHr.getData().clear();
				lineChartHr.getData().add(series);
				series.setName("Heart rate");		
			});
		}
	}
}
