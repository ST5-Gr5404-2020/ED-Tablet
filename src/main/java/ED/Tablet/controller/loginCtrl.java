// package ED.Tablet.controller;

// import ED.Tablet.model.personnel;

// import java.io.IOException;

// import ED.Tablet.model.loginServerConn;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.control.TextField;
// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Scene;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.BorderPane;
// import javafx.stage.Stage;



// private Stage primaryStage;
// private BorderPane rootLayout;

// public class loginCtrl {

// 	//@FXML	
// 	//private loginView loginView;
// 	@FXML
// 	private mainCtrl mainCtrl;
// 	@FXML
// 	private personnel personnel;
// 	@FXML
// 	TextField personnelID;
// 	@FXML
// 	TextField password;

	
// 	private loginCtrl(mainCtrl mainCtrl, personnel personnel){
// 		//this.loginView = loginView;
// 		//this.mainCtrl = mainCtrl;
// 		this.personnel = personnel;
// 	}

// 	public void handleLogin(ActionEvent event) throws IOException
// 	{
// 		String value1 = this.personnelID.getText();
// 		String value2 = this.password.getText();

// 		Boolean isVerified = false;

// 		isVerified = loginServerConn.validateLogin(value1,value2); //Validater password
		

// 		Parent mainViewParent = FXMLLoader.load(getClass().getResource("mainView.fxml")); //Henter mainview.fxml
// 		Scene mainViewScene = new Scene(mainViewParent); //Sætter mainView i til et scene objekt
		
// 		Stage window = (stage)((Node)event.getSource()).getScene.getWindow); //event.getSource castes til Nodeobject, og fra nodeobject kan getScene().getWindow() køres
																			
	

// 		if (isVerified) {
// 			window.setScene(mainViewScene); //Sætter scene til mainView
// 			window.show();
// 		}

// 		//TODO: Opret instans af personnel i App istedet. 
// 		// TODO: Skift til mainView
	

// 	}





// }