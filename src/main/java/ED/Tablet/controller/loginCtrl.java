package ED.Tablet.controller;

import ED.Tablet.App;
import ED.Tablet.model.loginServerConn;
import ED.Tablet.model.personnel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class loginCtrl {
    @FXML
    private TextField txtPersonnelID;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    // private personnel personnel;
    // public BorderPane rootLayout;

    private App mainApp;

    // Constructor for the loginCtrl
    public loginCtrl() {
    }

    // Give the controller access to the main app
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void handleLogin() {
        int personnelID = 0;
        // Try parsing the input personnel ID
        try {
            personnelID = Integer.parseInt(this.txtPersonnelID.getText());
        } catch (NumberFormatException e) {
            invalidLogin();
            // Stop executing
            return;
        }
        // Get the password
        String password = this.txtPassword.getText();
        // Try authenticating the ID/password combination
        if (loginServerConn.validateLogin(personnelID, password)) {
            this.mainApp.personnel.personnelID = personnelID;
            this.mainApp.showMainView();
        } else {
            invalidLogin();
        }
    }

    private void invalidLogin() {
        this.mainApp.personnel = new personnel();
        this.txtPassword.clear();
        this.txtPersonnelID.clear();
        // Show an alert
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Invalid login!");
        alert.setHeaderText("Failed to authenticate ID/password combination");    
        alert.showAndWait();
    }   
}