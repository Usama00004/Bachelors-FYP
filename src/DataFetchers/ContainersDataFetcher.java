package DataFetchers;

//import dataCenterComponents.Batch_Task;
import dataCenterComponents.ContainerInfo;
import dataCenterComponents.Container_Meta;
import dataCenterComponents.Machine_Meta;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContainersDataFetcher {

    public long cpu;
    public long mem;
    String containerMetaPath;


    public ArrayList<Container_Meta> containers_List = new ArrayList();



    public void functioning() {


        try{
            defaultValuesFetcher("ContainerMetaDefaultValues.csv");

        }catch(Exception e){}



        try {
            pathReader("ContainerMetaPath.csv");

        }catch (Exception e){}


        containers_List = readContainersFromCSV(containerMetaPath);

       // for(ContainerInfo c : containers_List){}


    }

    private static ArrayList<Container_Meta> readContainersFromCSV(String fileName) {
        ArrayList<Container_Meta> containers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            // read the first line from the text file
            String line = br.readLine();
            line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(",");
                Container_Meta container = createContainer(attributes);
                containers.add(container);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return containers;
    }

    // Creating Container Object
    private static Container_Meta createContainer(String[] metadata) {
        String container_id = metadata[0];
        String machine_id = metadata[1];
        long time_stamp = Integer.parseInt(metadata[2]);
        String app_du = metadata[3];
        String status = metadata[4];
        long cpu_request = Integer.parseInt(metadata[5]);
        long cpu_limit =Integer.parseInt(metadata[6]);
        long mem_size = Integer.parseInt(metadata[7]);

        return new Container_Meta(container_id,machine_id, time_stamp, app_du, status,cpu_request,cpu_limit,mem_size);
    }



    //Reading File Path
    private void pathReader(String fileName){
        Path pathToFile = Paths.get(fileName);
        try{
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            containerMetaPath = line;

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private void  defaultValuesFetcher(String fileName){

        // Here you can set your Defaut Values
    }


}
