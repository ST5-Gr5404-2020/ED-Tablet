/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ED.Tablet;

import java.io.IOException;
import ED.Tablet.model.personnel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {
    public BorderPane rootLayout;
    public Stage primaryStage;
    public static personnel personnel = new personnel();

    public void initRootLayout(){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginView (){
        try {
            // Load loginView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/loginView.fxml"));
            AnchorPane loginView = (AnchorPane) loader.load();
            // Set loginView into the center of root layout.
            
            rootLayout.setCenter(loginView);
            // Give the controller access to the main app.
            ED.Tablet.controller.loginCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainView (){
        try {
            // Load mainView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("view/mainView.fxml"));
            AnchorPane mainView = (AnchorPane) loader.load();
            // Set mainView into the center of root layout.
            rootLayout.setCenter(mainView);
            // Give the controller access to the main app.
            ED.Tablet.controller.mainCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Function that loads the first scene loginView, runs automatically when main() is initiated.
    //@param stage
    //@throws Exception

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        initRootLayout();
		showLoginView();
		//personnel.personnelID = 123456;
        //showMainView();
        
        



        // FXMLLoader loader = new FXMLLoader();
        // ED.Tablet.controller.loginCtrl controller = loader.getController();
        // System.out.println(controller);
        // controller.setMainApp(this);
        // controller.showLoginView();
    }



	
    public static void main(String[] args) {
        //Runs start() when main initiates, so that the loginView is opened
        launch(args); 
        

        


        // System.out.println(robert);

		// robert.updatePatientList();
		// System.out.println(robert.getPatientList());

        // patient deep = robert.getPatientList().get("0906634738");

        // deep.updateTripInfo();
        // deep.getTripInfo().printTripInfo();

        // 1. Instantierer de tre databaser connections.
        //      a. Cppj, Login, Cetrea conn er klar til at blive brugt. 
        // 2. Instancier personnel, som der kan lægges password/ID ind i. 
        // 3. Vis loginView.
        // 4. LoginCtrl --> sæt værdier ind i personnel.
        //      a. Login verified / not verified. 
        //      b. If not verified --> delete instance of personnel --> go to 2. 
        // 5. Skift til / vis mainView
        // 6. (i mainCtrl) mainView skal bruge personnel til at hente patients, som er assigned.
        //      a. input til mainCtrl er personnel. 
        //      b. personnel.updatePatientList().
        //      c. Display patientList
        // 7. mainCtrl kør funktion for at der trykkes på patient
        // 8. mainCtrl indsætter patientDataView i mainView, for valgt patient.
        // 9. For hvert view laves en controller, som gør det muligt at hoppe fra et view til et andet. 

        // Evt. 
        // Implementer stages for hvert view som der kan hoppes imellem. Eksempel login = stage1 og spo2=stage 9, 
        // og så en funktion der hopper fra stage 9 til stage 2. 

		

        


        
    }
}
