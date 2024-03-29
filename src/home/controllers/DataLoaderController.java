package home.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataLoaderController implements Initializable {

    @FXML
    private Button btnMachineMeta;

    @FXML
    private Button btnContainerMeta;

    @FXML
    private Button btnBatchTask;

    @FXML
    private Button btnMachineUsage;

    @FXML
    private Button btnContainerUsage;

    @FXML
    private Button btnThermalUsage;

    @FXML
    private Button btnNext_MachineMeta;



    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {

          if (mouseEvent.getSource() == btnMachineMeta) {
             ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
             loadStage("/home/fxml/MachineMeta.fxml");
          }else if (mouseEvent.getSource() == btnContainerMeta) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
              loadStage("/home/fxml/ContainerMeta.fxml");
          }else if (mouseEvent.getSource() == btnBatchTask) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
              loadStage("/home/fxml/BatchTask.fxml");
          }else if (mouseEvent.getSource() == btnMachineUsage) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
              loadStage("/home/fxml/MachineUsage.fxml");
          }else if (mouseEvent.getSource() == btnContainerUsage) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
             loadStage("/home/fxml/ContainerUsage.fxml");
          }else if(mouseEvent.getSource() == btnThermalUsage) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
              loadStage("/home/fxml/ThermalUsage.fxml");
          }else if(mouseEvent.getSource() == btnNext_MachineMeta) {
              ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
              loadStage("/home/fxml/MachineMeta.fxml");
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
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}





