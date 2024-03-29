package home.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

public class DataPerProcessorMachineMetaController implements  Initializable {

        @FXML
        private Button btnMachineMeta;

        @FXML
        private Button btnContainerMeta;

        @FXML
        private Button btnBatchTask;

        @FXML

        private Button btnNext_ContainerMetaPreProcessing;


        @FXML
        private ChoiceBox<String> choiceBoxMachineType;

        @FXML
        private TextField textDefaultCpu;

        @FXML
        private TextField textDefautMem;

        @FXML
        private TextField textDefautInletTemp;

        @FXML
        private ChoiceBox<String> choiceBoxStatus;

    ObservableList<String> types = FXCollections.observableArrayList("A","B");

    ObservableList<String> statuses = FXCollections.observableArrayList("Free","Using");

        private String type;
        private double cpu;
        private double mem;
        private double temp;
        private String status;




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
            }else if (mouseEvent.getSource() == btnNext_ContainerMetaPreProcessing) {
                try {
                    updateValues();
                }catch (Exception e){}
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/DataPreProcessorContainerMeta.fxml");
            }

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            choiceBoxMachineType.setItems(types);
            choiceBoxStatus.setItems(statuses);
            dataReader("MachineMetaPreprocess.csv");
            choiceBoxMachineType.setValue(type);
            textDefaultCpu.setText(cpu+"");
            textDefautMem.setText(mem+"");
            textDefautInletTemp.setText(temp+"");
            choiceBoxStatus.setValue(status);
        }

    private void dataReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

            type=values[0];
            cpu=Double.parseDouble(values[1]);
            mem=Double.parseDouble(values[2]);
            temp=Double.parseDouble(values[3]);
            status=values[4];

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
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("MachineMetaPreprocess.csv");
            fileWriter.append(choiceBoxMachineType.getSelectionModel().getSelectedItem());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(textDefaultCpu.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(textDefautMem.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(textDefautInletTemp.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(choiceBoxStatus.getSelectionModel().getSelectedItem());
            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }











}



