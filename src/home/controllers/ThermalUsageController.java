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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ThermalUsageController implements Initializable {


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
    private Button btnNext_Home;

    @FXML
    private Button btn_done_thermalusage;

    @FXML
    private Button btn_done_kibana_index;

    @FXML
    private TextField txt_thermalusage;

    @FXML
    private TextField txt_indexkibana;

    String thermalUsageFileName ="default";
    String kibanaIndexForThermalUsageFile = "default";
    int thermalUsageandIndexCheckList;
    int tfmnme;
    int tindex;
    private String desktopPath;


    public void updateValues() throws IOException {
        final String COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("ThermalUsageFileName.csv");
            fileWriter.append(desktopPath+thermalUsageFileName+".csv");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(kibanaIndexForThermalUsageFile);

            fileWriter.close();

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }


    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {

        if (mouseEvent.getSource() == btnMachineMeta) {
            loadStage("/home/fxml/MachineMeta.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if (mouseEvent.getSource() == btnContainerMeta) {
            loadStage("/home/fxml/ContainerMeta.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if (mouseEvent.getSource() == btnBatchTask) {
            loadStage("/home/fxml/BatchTask.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if (mouseEvent.getSource() == btnMachineUsage) {
            loadStage("/home/fxml/MachineUsage.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if (mouseEvent.getSource() == btnContainerUsage) {
            loadStage("/home/fxml/ContainerUsage.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if(mouseEvent.getSource() == btnThermalUsage) {
            loadStage("/home/fxml/ThermalUsage.fxml");
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }else if((mouseEvent.getSource() == btnNext_Home)) {
            if(thermalUsageFileName.equals("default")||kibanaIndexForThermalUsageFile.equals("default")){
                loadStageError("/home/fxml/ErrorForFields.fxml");
            }else {
                try {
                    updateValues();
                }catch(Exception e){}
               try {
                   fileCreater(txt_thermalusage.getText());
               }catch (Exception e){}
                checkListUpdater();
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            }
        }else if(mouseEvent.getSource() == btn_done_thermalusage) {
            thermalUsageName();
            tfmnme = 1;
        }else if(mouseEvent.getSource() == btn_done_kibana_index) {
            thermalUsageIndex();
            tindex =1;
        }
    }

    public void thermalUsageName()
    {
        String text = txt_thermalusage.getText();
     if(text.equals("")|| text.equals(null)){

         loadStageError("/home/fxml/ErrorForFields.fxml");
     }
     else {
         thermalUsageFileName = text;
     }
    }


    public void thermalUsageIndex()
    {

        String text = txt_indexkibana.getText();
        if(text.equals("")|| text.equals(null)){

            loadStageError("/home/fxml/ErrorForFields.fxml");
        }else {

            text = text.toLowerCase();
            kibanaIndexForThermalUsageFile = text;
            System.out.println(kibanaIndexForThermalUsageFile);
        }
    }






    public void checkListUpdater() {

        String values[] = new String[6];
        Path pathToFile = Paths.get("SimulationCheckList.csv");
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            String[] attributes = line.split(",");

            values[0] = attributes[0];
            values[1] = attributes[1];
            values[2] = attributes[2];
            values[3] = attributes[3];
            values[4] = attributes[4];
            values[5] = thermalUsageandIndexCheckList+"";


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";
        try {
            FileWriter fileWriter = new FileWriter("SimulationCheckList.csv");
            fileWriter.append(values[0]);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(values[1]);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(values[2]);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(values[3]);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(values[4]);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(values[5]);
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.close();
        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
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

    private void fileCreater(String filename){
        String FileName = desktopPath+filename+".csv";

        try {
            FileOutputStream fos = new FileOutputStream(FileName, true);
        }catch (Exception e){}


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desktopReader("DesktopPath.csv");
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



    private void desktopReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            //String[] values = line.split(",");
             desktopPath = line;


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }






}
