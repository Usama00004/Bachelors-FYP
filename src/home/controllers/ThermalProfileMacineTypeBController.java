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

public class ThermalProfileMacineTypeBController implements Initializable {


    @FXML
    private Button btnThermalProfileA;

    @FXML
    private Button btnThermalProfileB;

    @FXML
    private Button btnNext_Home;
    @FXML
    private TextField text_0;

    @FXML
    private TextField text_12;

    @FXML
    private TextField text_25;

    @FXML
    private TextField text_37;

    @FXML
    private TextField text_50;

    @FXML
    private TextField text_62;

    @FXML
    private TextField text_75;

    @FXML
    private TextField text_89;


    @FXML
    private TextField text_100;

    @FXML
    private TextField ptext_0;

    @FXML
    private TextField ptext_12;

    @FXML
    private TextField ptext_25;

    @FXML
    private TextField ptext_37;

    @FXML
    private TextField ptext_50;

    @FXML
    private TextField ptext_62;

    @FXML
    private TextField ptext_75;

    @FXML
    private TextField ptext_89;


    @FXML
    private TextField ptext_100;

    public double temp_at_0;
    public double temp_at_12 ;
    public double temp_at_25;
    public double temp_at_37;
    public double temp_at_50;
    public double temp_at_62;
    public double temp_at_75;
    public double temp_at_89;
    public double temp_at_100;
    public double pow_at_0;
    public double pow_at_12;
    public double pow_at_25;
    public double pow_at_37;
    public double pow_at_50;
    public double pow_at_62;
    public double pow_at_75;
    public double pow_at_89;
    public double pow_at_100;






    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnThermalProfileA) {
            try {
                updateValues();
            }catch (Exception e){}

            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/ThermalProfileMachineTypeA.fxml");
        } else if (mouseEvent.getSource() == btnThermalProfileB) {
            try {
                updateValues();
            }catch (Exception e){}

            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            loadStage("/home/fxml/ThermalProfileMachineTypeB.fxml");
        } else if (mouseEvent.getSource() == btnNext_Home) {
            try {
                updateValues();
                updatepowValues();

            }catch (Exception e){}

            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            //loadStage("/home/fxml/ThermalProfileTypeB.fxml");
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        powdataReader("PowerUsageSettingsTypeB.csv");
        dataReader("MachineBThermalProfile.csv");

        text_0.setText(temp_at_0+"");
        text_12.setText(temp_at_12+"");
        text_25.setText(temp_at_25+"");
        text_37.setText(temp_at_37+"");
        text_50.setText(temp_at_50+"");
        text_62.setText(temp_at_62+"");
        text_75.setText(temp_at_75+"");
        text_89.setText(temp_at_89+"");
        text_100.setText(temp_at_100+"");
        ptext_0.setText(pow_at_0+"");
        ptext_12.setText(pow_at_12+"");
        ptext_25.setText(pow_at_25+"");
        ptext_37.setText(pow_at_37+"");
        ptext_50.setText(pow_at_50+"");
        ptext_62.setText(pow_at_62+"");
        ptext_75.setText(pow_at_75+"");
        ptext_89.setText(pow_at_89+"");
        ptext_100.setText(pow_at_100+"");




    }


    public void updateValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("MachineBThermalProfile.csv");
            fileWriter.append(text_0.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_12.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_25.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_37.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_50.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_62.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_75.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_89.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(text_100.getText());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.close();
            System.out.println("CSV BB file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void updatepowValues() throws IOException {
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        try {

            FileWriter fileWriter = new FileWriter("PowerUsageSettingsTypeB.csv");
            fileWriter.append(ptext_0.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_12.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_25.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_37.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_50.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_62.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_75.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_89.getText());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(ptext_100.getText());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.close();
            System.out.println("CSV BB file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
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






    private void powdataReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

            pow_at_0=Double.parseDouble(values[0]);
            pow_at_12=Double.parseDouble(values[1]);
            pow_at_25=Double.parseDouble(values[2]);
            pow_at_37=Double.parseDouble(values[3]);
            pow_at_50=Double.parseDouble(values[4]);
            pow_at_62=Double.parseDouble(values[5]);
            pow_at_75=Double.parseDouble(values[6]);
            pow_at_89=Double.parseDouble(values[7]);
            pow_at_100=Double.parseDouble(values[8]);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    private void dataReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

            temp_at_0=Double.parseDouble(values[0]);
            temp_at_12=Double.parseDouble(values[1]);
            temp_at_25=Double.parseDouble(values[2]);
            temp_at_37=Double.parseDouble(values[3]);
            temp_at_50=Double.parseDouble(values[4]);
            temp_at_62=Double.parseDouble(values[5]);
            temp_at_75=Double.parseDouble(values[6]);
            temp_at_89=Double.parseDouble(values[7]);
            temp_at_100=Double.parseDouble(values[8]);




        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }


}
