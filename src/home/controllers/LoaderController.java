package home.controllers;

import SimulationHandler.FilesUpdater;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaderController implements Initializable {

@FXML
private ProgressBar progressBar;

@FXML
public static Label p;
public  static Label label;


private void progressRunner(){
    for(int i =0 ; i<100 ;i++){

        progressBar.setProgress(i/100.0);

        try{Thread.sleep(150);}catch(Exception e){}

    }
}

@FXML

private void handleButtonClicks(javafx.event.ActionEvent mouseEvent){

//    FilesUpdater f =  new FilesUpdater();
//    f.functioning();

    ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
    loadStage();

}

@Override
public void initialize(URL location, ResourceBundle resources) {

   //progressRunner();
//label = progress;

}





    private void loadStage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/home/fxml/Home.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Thermal Simulator");
            stage.getIcons().add(new Image("/home/icons/icon.png"));
            stage.setScene(new Scene(root));
            stage.setOnCloseRequest(e -> Platform.exit());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
