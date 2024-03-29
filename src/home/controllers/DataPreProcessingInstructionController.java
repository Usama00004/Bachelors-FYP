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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



    public class DataPreProcessingInstructionController implements Initializable {

        @FXML
        private Button btnMachineMeta;

        @FXML
        private Button btnContainerMeta;

        @FXML
        private Button btnBatchTask;

        @FXML

        private Button btnNext_MachineMetaPreProcessor;


        @FXML
        private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
            if (mouseEvent.getSource() == btnMachineMeta) {
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/DataPreProcessorMachineMeta.fxml");
            } else if (mouseEvent.getSource() == btnContainerMeta) {
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/DataPreProcessorContainerMeta.fxml");
            } else if (mouseEvent.getSource() == btnBatchTask) {
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/DataPreProcessorBatchTask.fxml");
            }else if (mouseEvent.getSource() == btnNext_MachineMetaPreProcessor) {
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/DataPreProcessorMachineMeta.fxml");
            }

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
                Scene scene = new Scene(root);
                //scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }




