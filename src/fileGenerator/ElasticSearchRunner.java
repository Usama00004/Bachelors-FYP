package fileGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ElasticSearchRunner implements Runnable{

    private String elasticSearchbinPath;


    @Override
    public void run() {

        pathReader("ElasticSearchPath.csv");

            try{
                ProcessBuilder builder = new ProcessBuilder(elasticSearchbinPath);
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line1;
                while (true) {
                    line1 = r.readLine();
                    if (line1 == null) { break; }
                    System.out.println(line1);
                }

            }catch(Exception e) {
                e.printStackTrace();
            }

    }


    private void pathReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            //  String[] values = line.split(",");
            elasticSearchbinPath = line;

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }






}
