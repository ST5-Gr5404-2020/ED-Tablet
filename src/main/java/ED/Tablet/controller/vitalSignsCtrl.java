package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class vitalSignsCtrl {
	public App mainApp;	
	public patient patient;
	private mainCtrl mainCtrl;
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
	
	

	
	

    //Give the controller access to the main app
	public void setMainApp(App mainApp) {
		this.mainApp = mainApp;
	}

	public void setMainCtrl(mainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

	public void setPatient(patient patient){
		this.patient = patient;
	}


	public void handleEtcO2Extend(){
		this.mainCtrl.showEtCo2Extend(this.patient.cpr);
	}

	public void handleHrExtend(){
		this.mainCtrl.showHrExtend(this.patient.cpr);
	}

	public void handleSpO2Extend(){
		this.mainCtrl.showSpO2Extend(this.patient.cpr);
	}

	public void handleBpExtend(){
		this.mainCtrl.showBpExtend(this.patient.cpr);
	}
	
	public void updateBPChart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> seriesSys = new XYChart.Series<>();
		XYChart.Series<String,Number> seriesDia = new XYChart.Series<>();
				
		for(int i = 0;i<vitalSigns.length;i++){			
			seriesSys.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].bpsys)); 
			seriesDia.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].bpdia)); 
		}
		lineChartBP.getData().addAll(seriesSys,seriesDia);		
	}

	public void updateEtCo2Chart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].etco2));  
		}
		lineChartEtCo2.getData().add(series);		
	}

	public void updateSpO2Chart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].spo2)); 
			 
		}
		lineChartSpO2.getData().add(series);		
	}

	public void updateHrChart(){
		this.patient.updateVitalSigns();
		vitalSigns[] vitalSigns = this.patient.getVitalSigns();
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		
		for(int i = 0;i<vitalSigns.length;i++){			
			series.getData().add(new XYChart.Data<>(((vitalSigns[i].timestamp).toString()).substring(11, 16), vitalSigns[i].hr)); 
			 
		}
		lineChartHr.getData().add(series);		
	}
}
