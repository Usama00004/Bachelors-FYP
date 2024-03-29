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

public class DataPreProcessorBatchTaskController implements Initializable {




    @FXML
    private Button btnMachineMeta;

    @FXML
    private Button btnContainerMeta;

    @FXML
    private Button btnBatchTask;

    @FXML
    private Button btnNext_Home;

    @FXML
    private TextField textCpuRequired;

    @FXML
    private TextField textMemRequired;

    @FXML
    private TextField textInstances;

    private int cpu;
    private int mem;
    private int instances;

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
        }else if (mouseEvent.getSource() == btnNext_Home) {
            try {
                updateValues();
            }catch (Exception e){}
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
           // loadStage("/home/fxml/DataPreProcessorContainerMeta.fxml");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dataReader("BatchTaskDefaultValues.csv");
        textCpuRequired.setText(cpu+"");
        textMemRequired.setText(mem+"");
        textInstances.setText(instances+"");


    }



    private void dataReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

            cpu=Integer.parseInt(values[0]);
            mem=Integer.parseInt(values[1]);
            instances = Integer.parseInt(values[2]);

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
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("BatchTaskDefaultValues.csv");
            fileWriter.append(textCpuRequired.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(textMemRequired.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(textInstances.getText());

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }






    //BatchTaskDefaultValues.csv




}
