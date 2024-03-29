package home.controllers;

import DataFetchers.ContainersDataFetcher;
import DataFetchers.MachinesDataFetcher;
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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ContainerMetaController implements Initializable {

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
    private Button btnNext_BatchTask;
    @FXML
    private Button btnChooseFile;

    String container_meta_file_path;
    private  javax.swing.JFrame frame;
   public int containerMetaforCheckList;

    private int checker =0;

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
            loadStage("/home/fxml/ThermalData.fxml");
        }else if(mouseEvent.getSource() == btnChooseFile) {
            checker =1;
            containerMetaFileChooser();


        }else if(mouseEvent.getSource() == btnNext_BatchTask) {

            if(checker == 1){
                containerMetaforCheckList = 1;



//                ContainersDataFetcher c = new ContainersDataFetcher();
//                c.functioning();
//                if(c.containers_List.size()<10) {
//                    loadStageError("/home/fxml/ErrorinSelectedFile .fxml");
//                }




                    try{updateValues(); }catch(Exception e){}
                checkListUpdater();
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                loadStage("/home/fxml/BatchTask.fxml");

            }else{
                loadStageError("/home/fxml/ErrorForChooseFiles.fxml");
            }

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
            values[1] = containerMetaforCheckList+"";
            values[2] = attributes[2];
            values[3] = attributes[3];
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


    public void containerMetaFileChooser(){

        JFileChooser chooser = null;
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            chooser = new JFileChooser();
            FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("Comma Sepreted Values", "csv");
            chooser.setFileFilter(csvFilter);
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}
        chooser.setName("Please choose machine meta file ");
        chooser.showOpenDialog(frame);
        System.out.println(chooser.getSelectedFile());

        container_meta_file_path = ""+(chooser.getSelectedFile());
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

    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";
        try {
            FileWriter fileWriter = new FileWriter("ContainerMetaPath.csv");
            fileWriter.append(container_meta_file_path);
            fileWriter.close();
        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }




}
