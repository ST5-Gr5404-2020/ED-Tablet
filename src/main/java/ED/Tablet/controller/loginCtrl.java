package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.loginServerConn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginCtrl {
	@FXML
	private TextField txtPersonnelID;
	@FXML
	private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    //private personnel personnel;
    //public BorderPane rootLayout;

    private App mainApp;
    
    //Constructor for the loginCtrl
	public loginCtrl(){}

    //Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

	public void handleLogin(){
		int personnelID  = Integer.parseInt(this.txtPersonnelID.getText());
		String password = this.txtPassword.getText();

		Boolean isVerified = false;
        //validate login from loginServerConn
		isVerified = loginServerConn.validateLogin(personnelID,password); 
		

		if (isVerified == true) {
            this.mainApp.personnel.personnelID = personnelID;
            this.mainApp.showMainView();
            
		}
	
    }
    
    
}