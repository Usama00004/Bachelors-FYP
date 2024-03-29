package home.controllers;

import fileGenerator.ElasticSearchRunner;
import fileGenerator.LogStashFileGenerator;
import fileGenerator.RunLogstashCommand;
import fileGenerator.kibanaRunner;
import javafx.application.Platform;
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
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnDataPreprocessing;

    @FXML
    private Button btnData;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSimulation;

    @FXML
    private Button btnVisualization;



    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnHome) {
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
           // loadStage("/home/fxml/Home.fxml");
        } else if (mouseEvent.getSource() == btnDataPreprocessing) {
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/DataPreProcessorInstructions.fxml");
        } else if (mouseEvent.getSource() == btnData) {
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/DataLoader.fxml");
        } else if (mouseEvent.getSource() == btnSettings) {
          //  ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/DatacenterSettingInstructions.fxml");
        } else if (mouseEvent.getSource() == btnSimulation){
            //((Node) (mouseEvent.getSource())).getScene().getWindow().hide();

            LogStashFileGenerator l = new LogStashFileGenerator();
            l.functioning();

            loadStage("/home/fxml/Simulation.fxml");
        } else if (mouseEvent.getSource() == btnVisualization){
           //((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
             loadStage("/home/fxml/Visualization.fxml");
//             Thread tl = new Thread(new RunLogstashCommand());
//             tl.start();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        elasticSearch_starter();
        kibana_starter();

    }


    public static void elasticSearch_starter(){
        Thread t1 = new Thread(new ElasticSearchRunner());
        t1.start();
    }

    public static void kibana_starter(){
         Thread t2 = new Thread(new kibanaRunner());
         t2.start();
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
