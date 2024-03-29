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
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoadBalancerSettingController implements Initializable{

    public static int tasksPolicy;
    public static int containerpolicy;
    public int Hasra;

    @FXML
    private Button btnDataCenterSettings;

    @FXML
    private Button btnLoadBalancerSettings;

    @FXML
    private Button btnNext_ThermalProfile;

    @FXML
    private  Button btnThermalSettings;

    @FXML
    private ChoiceBox<String> containerMappingpolicy;

    @FXML
    private ChoiceBox<String> taskMappingpolicy;

    ObservableList<String> containerMappingPolicies = FXCollections.observableArrayList("Round Robin Across Machines","Round Robin Across Racks","Random Placement of Containers","Maximum Utilization","Minmum Utilization","Min Hr With Cap On 62%","Min Hr With Cap On 75%","Hottest Job On Coolest Machine","Hottest Job On Coolest Machine Efficient","HAWDA","GRANITE");
    ObservableList<String> taskMappingPolicies = FXCollections.observableArrayList("First Come First Serve","Minimum Cpu Required","Minimum Memory Required","Maximum Cpu Required","Maximum Memory Required","Minimum Remaining Time","Maximum Remaining Time");


    @FXML
    public  void loadData(){

        containerMappingpolicy.setItems(containerMappingPolicies);
        containerMappingpolicy.setValue("Round Robin Across Machines");
        taskMappingpolicy.setItems(taskMappingPolicies);
        taskMappingpolicy.setValue("First Come First Serve");

    }

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnDataCenterSettings) {
//            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
//            loadStage("/home/fxml/DataCenterSettings.fxml");
        } else if (mouseEvent.getSource() == btnLoadBalancerSettings) {
//            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
//            loadStage("/home/fxml/LoadBalancerSettings.fxml");
        } else if (mouseEvent.getSource() == btnThermalSettings) {
//            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
//            loadStage("/home/fxml/ThermalProfileInstructions.fxml");
        }else if (mouseEvent.getSource() == btnNext_ThermalProfile) {
            try {
               updateValues();
                System.out.println(containerMappingpolicy.getSelectionModel().getSelectedItem());
            }catch (Exception e){}

            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/ThermalProfileMachineTypeA.fxml");
        }


    }



    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {



            FileWriter fileWriter = new FileWriter("LoadBalancer.csv");
            fileWriter.append(containerMappingpolicy.getSelectionModel().getSelectedItem().toString());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(taskMappingpolicy.getSelectionModel().getSelectedItem().toString());
            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(taskMappingpolicy.getSelectionModel().getSelectedItem().toString());
//            fileWriter.append(COMMA_DELIMITER);



            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadData();
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setTitle("Thermal Simulator");
            stage.getIcons().add(new Image("/home/icons/icon.png"));
            //stage.setScene(new Scene(root));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add("C:/Users/danya/Desktop/Final_Year_Project/Simulator/src/home/css/wassooo.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
