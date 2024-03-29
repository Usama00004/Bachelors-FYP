package home;

import TaskDividers.*;
import com.sun.javafx.application.LauncherImpl;
import fileGenerator.ElasticSearchRunner;
import fileGenerator.LogStashFileGenerator;
import fileGenerator.kibanaRunner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sun.misc.Launcher;

import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {


    private static final int COUNT_LIMIT = 500000;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("fxml/Loader.fxml"));
        primaryStage.setTitle("Thermal Simulator");
        primaryStage.getIcons().add(new Image("/home/icons/icon.png"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());


    }

    public static void main(String[] args) {
       try {
           updateValues();
       }catch (Exception e){}

        launch(args);

    }

    public static void updateValues() throws IOException {

        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

       try {

            FileWriter fileWriter = new FileWriter("SimulationCheckList.csv");
            fileWriter.append("0");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("0");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("1");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("1");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("1");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("0");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.close();
            System.out.println("CSV AA file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }







}
