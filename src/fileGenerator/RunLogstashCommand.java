package fileGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RunLogstashCommand implements  Runnable {


    private String desktopPath;


    @Override
    public void run() {

        desktopReader("DesktopPath.csv");

//        try{
//            ProcessBuilder builder = new ProcessBuilder("new.conf");
//            builder.redirectErrorStream(true);
//            //builder.directory(desktopPath);
//            Process p = builder.start();
//            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line1;
//            while (true) {
//                line1 = r.readLine();
//                if (line1 == null) { break; }
//                System.out.println(line1);
//            }
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        ProcessBuilder processBuilder = new ProcessBuilder();
// -- Linux --
// Run a shell command
        //processBuilder.command("bash", "-c", "ls /home/mkyong/");
//        processBuilder.command("logstash -f new.conf");
// Run a shell script
//processBuilder.command("path/to/hello.sh");
// -- Windows --
// Run a command
//processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

// Run a bat file
//processBuilder.command("C:\\Users\\mkyong\\hello.bat");
//        try {
//
//            processBuilder.command("logstash", "-f", "new.conf");
//            Process process = processBuilder.start();
//            StringBuilder output = new StringBuilder();
//            BufferedReader reader = new BufferedReader(
//            new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line + "\n");
//            }
//
//            int exitVal = process.waitFor();
//            if (exitVal == 0) {
//                System.out.println("Success!");
//                System.out.println(output);
//                System.exit(0);
//            } else {
//                //abnormal...
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        try {

            // -- Linux --

            // Run a shell command
             Process process = Runtime.getRuntime().exec("logstash -f new.conf");

            // Run a shell script
            // Process process = Runtime.getRuntime().exec("path/to/hello.sh");

            // -- Windows --

            // Run a command
            //Process process = Runtime.getRuntime().exec("cmd /c dir C:\\Users\\mkyong");

            //Run a bat file
//            Process process = Runtime.getRuntime().exec(
//                    "cmd /c hello.bat", null, new File("C:\\Users\\mkyong\\"));

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
