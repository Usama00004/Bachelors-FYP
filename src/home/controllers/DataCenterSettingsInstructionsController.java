package home.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataCenterSettingsInstructionsController implements Initializable {

    @FXML
    private Button btnNext;


    @FXML
   private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        loadStage("/home/fxml/DataCenterSettings.fxml");

   }


   @Override
   public void initialize(URL location, ResourceBundle resources) {

   }

   private void loadStage(String fxml) {
       try {

           Parent root = FXMLLoader.load(getClass().getResource(fxml));
           Stage stage = new Stage();
           stage.setTitle("Thermal Simulator");
           stage.getIcons().add(new Image("/home/icons/icon.png"));
           stage.setScene(new Scene(root));
           stage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }


}
