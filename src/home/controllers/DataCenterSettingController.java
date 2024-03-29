package home.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class DataCenterSettingController implements Initializable {

    @FXML
    private Button btnDataCenterSettings;

    @FXML
    private Button btnLoadBalancerSettings;

    @FXML
    private Button btnNext_LoadBalancerSettings;

    @FXML
    private  Button btnThermalSettings;

    @FXML
    private  TextField txt_racks;

    @FXML
    private  TextField txt_machinesperRack;

    @FXML
    private TextField txt_typeOfMachines;

    private int noOfRacks ;
    private int machinesPerRack ;
    private int types;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnDataCenterSettings) {
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/DataCenterSettings.fxml");
        } else if (mouseEvent.getSource() == btnLoadBalancerSettings) {
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/LoadBalancerSettings.fxml");
        } else if (mouseEvent.getSource() == btnThermalSettings) {
            ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/ThermalProfileInstructions.fxml");
        }else if (mouseEvent.getSource() == btnNext_LoadBalancerSettings) {
                try {
                    updateValues();
                }catch (Exception e){}
            ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/LoadBalancerSettings.fxml");


        }
    }

    private void loadStageError(String fxml){
        try {

            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setTitle("Error!");
            stage.getIcons().add(new Image("/home/icons/icon.png"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dataReader("DataCenterSettings.csv");



        txt_racks.setText(noOfRacks+"");
        txt_machinesperRack.setText(machinesPerRack+"");
        txt_typeOfMachines.setText(types+"");


    }



    private void dataReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

            noOfRacks=Integer.parseInt(values[0]);
            machinesPerRack=Integer.parseInt(values[1]);
            types = Integer.parseInt(values[2]);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
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


    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("DataCenterSettings.csv");
            fileWriter.append(txt_racks.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(txt_machinesperRack.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(txt_typeOfMachines.getText());

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }




}
