package fileGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class kibanaRunner implements Runnable{



    private String kibanaPath;

    @Override
    public void run() {

       pathReader("KibanaPath.csv");

        System.out.println(kibanaPath);
            try{
            ProcessBuilder builder = new ProcessBuilder(kibanaPath);
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
            kibanaPath = line;

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }



}
