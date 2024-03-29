package DataFetchers;

import dataCenterComponents.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MachinesDataFetcher {

   public String machine_type;
   public long cpu_cores;
   public long memSize;
   public double inletTemp;
   public String machineStatus;

   public String machineMetaPath;

   public ArrayList<Machines> machines_List = new ArrayList<>();


     public void functioning(){


         try{
             defaultValuesFetcher("MachineMetaDefaultValues.csv");

         }catch(Exception e){}


         System.out.println("Default Type = "+machine_type);

         System.out.println("Default cores = "+cpu_cores);

         System.out.println("Default Memory= "+memSize);

         System.out.println("Default Temp= "+inletTemp);

         System.out.println("Default Status = "+machineStatus);

         pathReader("MachineMetaPath.csv");


         try{

             machines_List = readMachinesFromCSV(machineMetaPath);


         }catch(Exception e){}




   }


    private  ArrayList<Machines> readMachinesFromCSV(String fileName) {
        ArrayList<Machines> tasks = new ArrayList<>();

        Path pathToFile = Paths.get(fileName);

        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(",");
                Machines m = createMachine(attributes);
                tasks.add(m);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tasks;
    }




   private Machines createMachine(String[] metadata) {

       int skip = 0;

       String machine_id ="defaultMachie";
       long cpu_num = cpu_cores;
       long memNum = memSize;
       double temp = inletTemp;
       String status = machineStatus;
       String machinetype = machine_type;





       if(metadata[0].equals("")||metadata[0].equals(null)|| metadata[0].equals(" ")) {


       }else{

           machine_id = metadata[0];
        }


       if(metadata[1].equals("")||metadata[1].equals(null)|| metadata[1].equals(" ")) {



       }else{

           cpu_num = Integer.parseInt(metadata[1]);
       }

       if(metadata[2].equals("")||metadata[2].equals(null)|| metadata[2].equals(" ")) {

       }else{

           memNum = Integer.parseInt(metadata[2]);
       }

       if(metadata[3].equals("")||metadata[3].equals(null)|| metadata[3].equals(" ")) {


       }else{

           status = metadata[3];
       }
       if(metadata[4].equals("")||metadata[4].equals(null)|| metadata[4].equals(" ")) {



       }else{

           temp = Double.parseDouble(metadata[4]);
       }

       if(metadata[5].equals("")||metadata[5].equals(null)|| metadata[5].equals(" ")){


       }else{


           machinetype = metadata[5];

       }


        return (new Machines(machine_id,cpu_num,memNum,cpu_num,memNum,status,temp,temp,machinetype));
    }


    //Reading File Path
    private void pathReader(String fileName){

        Path pathToFile = Paths.get(fileName);
        try{
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            machineMetaPath = line;

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private void  defaultValuesFetcher(String fileName){

        Path pathToFile = Paths.get(fileName);
        try{
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");

              machine_type  = values[0];
              cpu_cores = Integer.parseInt(values[1]);
              memSize = Integer.parseInt(values[2]);
              inletTemp = Double.parseDouble(values[3]);
              machineStatus = values[4];


        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}

