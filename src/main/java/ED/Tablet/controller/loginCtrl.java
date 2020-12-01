package ED.Tablet;

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

	@FXML
	private loginCtrl(mainCtrl mainCtrl, personnel personnel){
		//this.loginView = loginView;
		this.mainCtrl = mainCtrl;
		this.personnel = personnel;
	}

	public void handleLogin(string personnelID, string password){
		personnelID = personnelID.getText();
		password = password.getText();
		//string username = personnelID;

		boolean isVerified = false;

		isVerified = loginServerConn.validateLogin(personnelID,password);

		if (isVerified) {
			personnel tempPersonnel = new personnel(personnelID,password);

		}

		




		
	}





}