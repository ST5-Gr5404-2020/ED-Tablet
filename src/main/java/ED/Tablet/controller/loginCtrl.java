package ED.Tablet.controller;

import ED.Tablet.model.personnel;
import ED.Tablet.model.loginServerConn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class loginCtrl {

	//@FXML	
	//private loginView loginView;
	@FXML
	private mainCtrl mainCtrl;
	@FXML
	private personnel personnel;
	@FXML
	TextField personnelID;
	@FXML
	TextField password;

	
	private loginCtrl(mainCtrl mainCtrl, personnel personnel){
		//this.loginView = loginView;
		//this.mainCtrl = mainCtrl;
		this.personnel = personnel;
	}
	@FXML
	public void handleLogin(){
		String value1 = this.personnelID.getText();
		String value2 = this.password.getText();
		//string username = personnelID;

		boolean isVerified = false;

		isVerified = loginServerConn.validateLogin(value1,value2);

		if (isVerified) {
			personnel tempPersonnel = new personnel(value1,value2);

		}

		//TODO: Opret instans af personnel i App istedet. 
		// TODO: Skift til mainView

		




		
	}





}