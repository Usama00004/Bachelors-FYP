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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

public class MachineUsageController implements Initializable
{
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
    private Button btnNext_ContainerUsage;

    @FXML
    private Button btn_done_machineusage;

    @FXML
    private Button btn_done_kibana_index;

    @FXML
    private TextField txt_machineusage;

    @FXML
    private TextField txt_indexkibana;

    String machineUsageFileName = "default";

    String kibanaIndexForMachineUsageFile = "default";
    String desktopPath;
    int mfname;
    int mIndex;
    int machineUsageandIndexCheckList;


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
        }else if(mouseEvent.getSource() == btnNext_ContainerUsage) {
                if(kibanaIndexForMachineUsageFile.equals("default")||machineUsageFileName.equals("default")){
                    loadStageError("/home/fxml/ErrorForFields.fxml");
                }else {

                    if(mfname == 1 && mIndex == 1 ){

                        machineUsageandIndexCheckList=1;
                        checkListUpdater();
                    }

                    fileCreater(txt_machineusage.getText());
                    ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                    loadStage("/home/fxml/ContainerUsage.fxml");
                }
        }else if(mouseEvent.getSource() == btn_done_machineusage){
            machineUsageName();
            System.out.println(machineUsageFileName);
            mfname = 1;
        }else if(mouseEvent.getSource() == btn_done_kibana_index){
            machineUsageIndex();
            System.out.println(kibanaIndexForMachineUsageFile);
            mIndex =1 ;

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
            values[3] = machineUsageandIndexCheckList+"";
            values[4] = attributes[4];
            values[5] = attributes[5];


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


    public void machineUsageName() {

        String text = txt_machineusage.getText();
        if (text.equals(null) || text.equals("")) {

            loadStageError("/home/fxml/ErrorForFields.fxml");

        }else {

            machineUsageFileName = txt_machineusage.getText();
            try {
                updateValues();
            } catch (Exception e) {
            }
        }
    }
    public void machineUsageIndex()
    {

        String text = txt_indexkibana.getText();
        text = text.toLowerCase();
        if(text.equals(null) || text.equals("")){

            loadStageError("/home/fxml/ErrorForFields.fxml");

        }
        else {

            kibanaIndexForMachineUsageFile = text;
            try {
                updateValues();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        desktopReader("DesktopPath.csv");
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
        final String COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("MachineUsageFileName.csv");
            fileWriter.append(desktopPath+machineUsageFileName+".csv");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(kibanaIndexForMachineUsageFile);

            fileWriter.close();

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

}
