package SimulationHandler;

import java.io.FileWriter;
import java.io.IOException;

public class FilesUpdater {



    public void functioning(){
        try {

            updateLoadBalancerValues();
            updateContainerMetaDefaultValues();
            ContainerMetaPathValues();
            ContainerUsageFileNameValues();
            DataCenterDefaultValues();
            DataCenterSettingsValues();
            LoadBalancerDefaultValues();
            LoadBalancerValues();
            MachineAThermalProfileValues();
            MachineBThermalProfileValues();


        }catch(Exception e){}
    }


    public void updateLoadBalancerValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("LoadBalancer.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void updateContainerMetaDefaultValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("ContainerMetaDefaultValues.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void ContainerMetaPathValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("ContainerMetaPath.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }


    public void ContainerUsageFileNameValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("ContainerUsageFileName.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void DataCenterDefaultValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("DataCenterDefaultValues.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void DataCenterSettingsValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("DataCenterSettings.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void LoadBalancerValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("LoadBalancer.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void LoadBalancerDefaultValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("LoadBalancerDefaultValues.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void MachineAThermalProfileValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("MachineAThermalProfile.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
    public void MachineBThermalProfileValues() throws IOException {
        try {

            FileWriter fileWriter = new FileWriter("MachineBThermalProfile.csv");
            fileWriter.append("");

            fileWriter.close();


        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

}
