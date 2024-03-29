package DataFetchers;

//import dataCenterComponents.Batch_Task;
import dataCenterComponents.Task;
import dataCenterComponents.Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class TasksDataFetcher {

   public long cpu;
   public long mem;
   public long instances;
   public String batchTaskFilePath;


   public ArrayList<Tasks> tasks_List = new ArrayList<>();



   public void functioning(){

       try{
            defaultValuesFetcher("BatchTaskDefaultValues.csv");

       }catch(Exception e){}

       try {
           pathReader("BatchTaskPath.csv");
       }catch(Exception e){}


       tasks_List = readTasksFromCSV(batchTaskFilePath);

       //System.out.println(tasks_List.size()+" "+tasks_List.size());


   }


    //Reading tasks from csv
    private  ArrayList<Tasks> readTasksFromCSV(String fileName) {
        ArrayList<Tasks> tasks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);

            String line = br.readLine();
            line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                String[] attributes = line.split(",");
                Tasks t = createTask(attributes);
                tasks.add(t);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tasks;
    }


    //Creating Batch Task Object
    private Tasks createTask(String[] metadata){

        int skip = 0;
        String taskid = "UnknownTask";
        long cpu = this.cpu;
        long mem = this.mem;
        long inst= instances;
        long startTime= 0;
        long endTime=5;

            if (metadata[0].equals("")||metadata[0].equals(null)||metadata[0].equals(" ")) {
            skip = 1;
            }else{

                 taskid = metadata[0];
            }
            if(metadata[1].equals("")||metadata[1].equals(null)||metadata[1].equals(" ")){
            }else{

                inst = Integer.parseInt(metadata[1]);

            }


            if(metadata[2].equals("")||metadata[2].equals(null)||metadata[2].equals(" ")){

            } else{

                startTime  = Integer.parseInt(metadata[2]);
            }


            if(metadata[3].equals("")||metadata[3].equals(null)|| metadata[3].equals(" ")){

            } else{

                endTime = Integer.parseInt(metadata[3]);
            }


            if(metadata[4].equals("")||metadata[4].equals(null)||metadata[4].equals(" ")){

            } else{

                cpu = Integer.parseInt(metadata[4]);
            }


            if(metadata[5].equals("")||metadata[5].equals(null)||metadata[5].equals(" ")){

            } else{

                mem = Integer.parseInt(metadata[5]);
            }



        return new Tasks(taskid,inst,startTime,endTime,cpu,mem);
    }

   //Reading File Path
    private void pathReader(String fileName){

        Path pathToFile = Paths.get(fileName);
        try{
             BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
             String line = br.readLine();
             batchTaskFilePath = line;

        }catch (IOException ioe){

            ioe.printStackTrace();
        }
    }



        private void  defaultValuesFetcher(String fileName){

            Path pathToFile = Paths.get(fileName);
            try{
                BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
                String line = br.readLine();
                String[] values = line.split(",");

                cpu  = Integer.parseInt(values[0]);
                mem  = Integer.parseInt(values[1]);
                instances = Integer.parseInt(values[2]);


            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }


    }

    //BatchTaskDefaultValues.csv


