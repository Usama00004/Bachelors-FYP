package home.controllers;

import fileGenerator.ExelOpner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VisualizationController implements Initializable {


        @FXML
        private javafx.scene.control.Button btnVisualize;

        @FXML
        private CheckBox checkBoxExel;

        @FXML
        private CheckBox checkBoxKibana;

        int value = 0;


        @Override
        public void initialize(URL location, ResourceBundle resources) {


        }


        @FXML
        private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {


            if(checkBoxKibana.isSelected()){

                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:5601/"));
                }
                catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }

            }

            if(checkBoxExel.isSelected()){

                Thread e =  new Thread(new ExelOpner());
                e.start();

            }



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





