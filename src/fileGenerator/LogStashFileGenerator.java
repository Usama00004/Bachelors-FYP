package fileGenerator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LogStashFileGenerator{


 ArrayList<String>fileLines = new ArrayList<>();
 public String kibanaIndexForMachineUsage;
 public String kibanaIndexForContainerUsage;
 public String kibanaIndexForThermalUsage;
 public String machineUsageIndexName;
 public int containerUsageIndexName;
 public int thermalUsageIndexName;
 public String fileName;
 public String indexName;
 public String desktopPath;


  //public LogStashFileGenerator(){}

    public void functioning(){

        desktopReader("DesktopPath.csv");
        nameReader("MachineUsageFileName.csv");
        Reader();
        logstashWriter();

    }

    public void Reader()
        {
            try
            {
                FileInputStream fis=new FileInputStream("Readit.txt");
                Scanner sc=new Scanner(fis);    //file to be scanned
                while(sc.hasNextLine())
                {
                    fileLines.add(sc.nextLine());      //returns the line that was skipped
                }
                sc.close();     //closes the scanner
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }


    }


    public void kibanaDataFeeder(){

    }

    private void nameReader(String fileName){
        Path pathToFile = Paths.get(fileName);
        try{
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();

            String[] attributes = line.split(",");

            this.fileName = attributes[0];
            machineUsageIndexName = attributes[1];

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void logstashWriter(){

      try {
          FileOutputStream fos = new FileOutputStream(desktopPath+"new.conf", true);
        //FileOutputStream fos = new FileOutputStream(desktopPath+"new.conf", true);

      }catch (Exception e){}

        try {
            FileWriter myWriter = new FileWriter(desktopPath+"new.conf");

            char arr[] = fileName.toCharArray();
//            char farr[] = new char[arr.length-2];

            String nfname ="";

            for(int i =0 ;i<arr.length;i++){
                if(i>=2){

                    if (arr[i] == '\\'){
                        nfname = nfname+'/';
                    }else{
                        nfname=nfname+arr[i];
                    }
                }

            }

            fileName = nfname;


            String two = "path => \""+fileName +"\"";
            String twentyEight = "index => "+"\""+machineUsageIndexName+"\"";

            for(int i=0;i<fileLines.size();i++){


            if(i==2){

                myWriter.write(two);
                myWriter.write('\n');

            }else if(i==28){

                myWriter.write(twentyEight);
                myWriter.write('\n');
            }else {
                myWriter.write(fileLines.get(i));
                myWriter.write('\n');
            }
            }

           // myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }



    private void desktopReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            //String[] values = line.split(",");
            desktopPath = line;


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
