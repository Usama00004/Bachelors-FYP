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

public class ContainerUsageController implements Initializable {


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
    private Button btnNext_ThermalUsage;

    @FXML
    private Button btn_done_containerusage;

    @FXML
    private Button btn_done_kibana_index;

    @FXML
    private TextField txt_containerUsage;

    @FXML
    private TextField txt_indexkibana;

    String containerUsageFileName ="default";
    String kibanaIndexForContainerUsageFile="default";
    int containerUsageandIndexCheckList;
    int cfname;
    int cindex;


    private String desktopPath;

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
        }else if((mouseEvent.getSource() == btnNext_ThermalUsage)){

            if(cindex==1 && cfname==1){

                containerUsageandIndexCheckList =1;
            }

            if(containerUsageFileName.equals("default")||kibanaIndexForContainerUsageFile.equals("default")){
                loadStageError("/home/fxml/ErrorForFields.fxml");
            }else {
                fileCreater(txt_containerUsage.getText());
                checkListUpdater();
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/ThermalUsage.fxml");
            }

        }else if(mouseEvent.getSource() == btn_done_containerusage) {
            containerUsageName();
            System.out.println(containerUsageFileName);
            cfname = 1;
        }else if(mouseEvent.getSource() == btn_done_kibana_index) {
            containerUsageIndex();
            System.out.println(kibanaIndexForContainerUsageFile);
            cindex = 1;
        }
    }



    public void containerUsageName()
    {

        String text = txt_containerUsage.getText();

        if(text.equals(null)|| text.equals("")){

            loadStageError("/home/fxml/ErrorForFields.fxml");

        }else {

            containerUsageFileName = text;
            try {
                updateValues();
            } catch (Exception e) {
            }
        }
    }

    public void containerUsageIndex()
    {
        String text = txt_indexkibana.getText();

        if(text.equals(null)|| text.equals("")){

            loadStageError("/home/fxml/ErrorForFields.fxml");

        }else {

            text = text.toLowerCase();
            kibanaIndexForContainerUsageFile = text;
            try {
                updateValues();
            } catch (Exception e) {}
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
            values[4] = containerUsageandIndexCheckList+"";
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



    public void updateValues() throws IOException {
        final String COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("ContainerUsageFileName.csv");
            fileWriter.append(desktopPath+containerUsageFileName+".csv");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(kibanaIndexForContainerUsageFile);

            fileWriter.close();

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        desktopReader("DesktopPath.csv");
    }


    private void fileCreater(String filename){
        String FileName = desktopPath+filename+".csv";

        try {
            FileOutputStream fos = new FileOutputStream(FileName, true);
        }catch (Exception e){}


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
