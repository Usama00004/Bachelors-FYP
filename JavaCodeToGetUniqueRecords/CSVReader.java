package com.company;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Container> final_List = new ArrayList<>();

    public static void main(String... args) {
        List<Container> containers = readContainersFromCSV("container_meta_text.txt");


        int flag;
        for (int i = 0; i < containers.size(); i++) {
            flag = 0;

            for (int j = 0; j < final_List.size(); j++) {
                if (final_List.get(j).getMachine_id().equals(containers.get(i).getMachine_id())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                final_List.add(containers.get(i));
            }
        }


//
//        for (Machine m : final_List) {
//            System.out.println(m.getMachine_id() + " " + m.getTime_stamp() + " " + m.getFailure_domain_1() + " " + m.getFailure_domain_2() + " " + m.getCpu_num() + " " + m.getMem_size() + " " + m.getStatus());
//
//        }

   try {writer();}catch(Exception e){System.out.println("File Error");}

   }

  private static List<Container> readContainersFromCSV(String fileName) {
        List<Container> container_list = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                String[] attributes = line.split(",");

                Container container = createContainer(attributes);

                container_list.add(container);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return container_list;
    }
//container_id	machine_id	time_stamp	app_du	status	cpu_request	cpu_limit	mem_size
    private static Container createContainer(String[] metadata) {
        String container_id = metadata[0];
        String machine_id = metadata[1];
        long time_stamp = Integer.parseInt(metadata[2]);
        String app_du = metadata[3];
        String status = metadata[4];
        long cpu_request = Integer.parseInt(metadata[5]);
        long cpu_limit =Integer.parseInt(metadata[6]);
        double mem_size = Double. parseDouble(metadata[7]);


        // create and return Machine of this metadata
        return new Container(container_id,machine_id, time_stamp, app_du, status,cpu_request,cpu_limit,mem_size);
    }


    public static void writer() throws IOException {


        //Delimiter used in CSV file
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";

        //CSV file header
        final String FILE_HEADER = "container_id,machine_id,time_stamp,app_du,status,cpu_request,cpu_limit,mem_size";

        //fileName = System.getProperty("user.home") + "/seat.csv";
        try {
            FileWriter fileWriter = new FileWriter("data.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Container c : final_List) {
                fileWriter.append(c.getContainer_id());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getMachine_id());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(c.getTime_stamp()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getApp_du());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getStatus());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(c.getCpu_request()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(c.getCpu_limit()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(c.getMem_size()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            fileWriter.close();
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
}