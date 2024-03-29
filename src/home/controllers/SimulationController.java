package home.controllers;

import DataFetchers.TasksDataFetcher;
import SimulationHandler.Simulation;
import dataCenterComponents.Container_Meta;
import fileGenerator.LogStashFileGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationController implements Initializable{

        @FXML
        private Button btnSimulate;

        @FXML
        private CheckBox checkBoxElasticSearch;

        @FXML
        private CheckBox checkBoxKibana;

        @FXML
        private CheckBox hasraCheckBox;

        @FXML
        private ProgressBar progressBar;


        public String taskspolicy;
        public String containerPolicy;
        public short machineusageCheck;
        public short machineIndexCheck;
        public short containerUsageCheck;
        public short containerIndexCheck;
        public short thermalUsageCheck;
        public short thermalIndexCeck;
        public  static short indicator =0;



        class PbThread implements Runnable{

            public int taskSize;

           public PbThread (int taskSize){
               super();
               this.taskSize = taskSize;

           }

            @Override
         public void run(){
           try{
             for (double i = 0; i <= taskSize; i++) {
               progressBar.setProgress(i/taskSize);
                 System.out.println(i +"------"+(i/taskSize));

                 Thread.sleep(800);

             }

               progressBar.setVisible(false);
               btnSimulate.setText("Done");


             LogStashFileGenerator l = new LogStashFileGenerator();
             l.functioning();

           }catch (Exception e){}
         };


        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            progressBar.setVisible(false);
            checkBoxElasticSearch.setSelected(true);
            checkBoxKibana.setSelected(true);
        }


    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {

        if(btnSimulate.getText().equals("Done")){

        }else {

            checker();
            thermalIndexCeck = 1;
          //  if ((machineusageCheck != 1) || (machineIndexCheck != 1) || (containerUsageCheck != 1) || (containerIndexCheck != 1) || (thermalUsageCheck != 1) || (thermalIndexCeck != 1)) {

            if ((machineusageCheck != 1) || (machineIndexCheck != 1) || (containerUsageCheck != 1) || (containerIndexCheck != 1) || (thermalUsageCheck != 1) || (thermalIndexCeck != 1)) {

                loadStage("/home/fxml/MissingData.fxml");

            }else{

                TasksDataFetcher td = new TasksDataFetcher();
                td.functioning();
                fetchLoadBalancerValues();

                Simulation s = new Simulation(taskspolicy , containerPolicy,hasraCheckBox.isSelected());
                s.functioning();

                progressBar.setVisible(true);
                Thread t1 = new Thread(new PbThread(td.tasks_List.size()));
                t1.start();
                btnSimulate.setText("Simulating");
                progressBar.setVisible(true);

//                while(true ){
//
//                    progressBar.setVisible(true);
//
//                    System.out.print(".");
//                    if(indicator == 1){
//                        System.out.println("While Loop Run");
//                        progressBar.setVisible(false);
//                        btnSimulate.setText("Done");
//                        break;
//                    }


//                }
            }

        }

    }

    public void fetchLoadBalancerValues(){


       Path pathToFile = Paths.get("LoadBalancer.csv");
         try{

             BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
             String line = br.readLine();
             String values[] = line.split(",");
             containerPolicy = values[0];
             taskspolicy = values[1];

         } catch (IOException ioe){

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




    public void checker(){

        Path pathToFile = Paths.get("SimulationCheckList.csv");
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String values[] = line.split(",");

            machineusageCheck = Short.parseShort(values[0]);
            machineIndexCheck = Short.parseShort(values[1]);
            containerUsageCheck= Short.parseShort(values[2]);
            containerIndexCheck = Short.parseShort(values[3]);
            thermalUsageCheck = Short.parseShort(values[4]);
            thermalIndexCeck = Short.parseShort(values[5]);


         } catch (IOException ioe) {
            ioe.printStackTrace();
         }


    }


    }
