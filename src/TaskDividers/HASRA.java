package TaskDividers;

import DataFetchers.MachinesDataFetcher;
import DataFetchers.TasksDataFetcher;
import dataCenterComponents.ContainerInfo;
import dataCenterComponents.Machines;
import dataCenterComponents.Tasks;
import dataCenterComponents.Tmax;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class HASRA {

    private ArrayList<Double> thermalProfileOfA = new ArrayList<>();
    private ArrayList<Double> thermalProfileOfB = new ArrayList<>();
    private ArrayList<Machines> mahines = new ArrayList<>();
    private ArrayList<Tasks> tasks = new ArrayList<>();

    public ArrayList<Machines> functioning(){

         MachinesDataFetcher m = new MachinesDataFetcher();
         m.functioning();
         mahines = m.machines_List;


         ArrayList<Machines> orignalList = new ArrayList<>(m.machines_List);


        thermalSettingsForTypeA();
        thermalSettingsForTypeB();


        ArrayList<ContainerInfo> containers_to_map = new ArrayList<>();

        int cnt =0;
        for(Tasks t : tasks){

            containers_to_map.add(new ContainerInfo(("T"+(cnt+1))+"","machineId",t.getPlan_cpu(),t.getPlan_mem(),0));
            cnt++;

        }
    //{New Block}
//        for(int i=0;i<464 ;i++){
//
//            if(i>=0 && i<16){
//                containers_to_map.add(new ContainerInfo((i+1)+"","machineId",8,100,0));
//            }else if(i>=16 && i<80){
//                containers_to_map.add(new ContainerInfo((i+1)+"","machineId",4,100,0));
//            }else if(i>=80 && i<208){
//                containers_to_map.add(new ContainerInfo((i+1)+"","machineId",2,100,0));
//            }else if(i>=208 && i<464){
//                containers_to_map.add(new ContainerInfo((i+1)+"","machineId",1,100,0));
//            }
//        }
     //{/New Block}



//        for(Machines a : mahines){
//
//
//            System.out.println(a.getMachine_id()+"  "+a.getCpu_num()+"  "+a.getInletTemperature() +"  "+a.getCurrenttemperature());
//
//        }

//        for(ContainerInfo c : containers_to_map){
//
//
//            System.out.println(c.getContainerID() +"  "+c.getCpu_required()+"   "+c.getMem_required());
//        }



//        for(Machines a : mahines){
//             System.out.println(a.getMachine_id()+"  "+a.getCpu_num()+"  "+a.getInletTemperature() +"  "+a.getCurrenttemperature());
//        }




                System.out.println("       :::::::::::::::::::: Initial State ::::::::::::::::::::::::::::::::");

        for(Machines a : mahines){
              a.setCurrenttemperature(a.getCurrenttemperature()+temperature_monitor(a.getType(),100));
        //   System.out.println(a.getMachine_id()+"  "+a.getCpu_num()+"  "+a.getInletTemperature() +"  "+a.getCurrenttemperature());
        }

       // mahines = sorting_Machines_In_Decending_Temp(mahines);

        mahines = bubbleSort(mahines);


        System.out.println("       :::::::::::::::::::: Step 1 ::::::::::::::::::::::::::::::::");


        for(Machines a : mahines){

              System.out.println(a.getMachine_id()+"  "+a.getCpu_num()+"  "+a.getInletTemperature() +"  "+a.getCurrenttemperature());

        }

        double tmax = mahines.get(0).getCurrenttemperature();

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("tmax == "+tmax );


//        System.out.println("---------------------------------------------------------------------------------------------------------------");



        ArrayList<Machines> firstHalf =  new ArrayList<>();
        ArrayList<Machines> secondHalf =  new ArrayList<>();


        for(int i=0;i<(mahines.size()/2);i++){

            firstHalf.add(mahines.get(i));
        }


        for(int i=mahines.size()-1 ; i>=mahines.size()/2; i--) {

            secondHalf.add(mahines.get(i));
        }


        ArrayList<Machines> temp = new ArrayList<>();
//
//        int c=0;
//        for(int i=secondHalf.size()-1;i>=0;i--){
//            temp.add(secondHalf.get(i));
//            c++;
//        }
//
//
//
//        secondHalf = temp;
//





        System.out.println("++++++++++++++++++++++++First Half+++++++++++++++++++++++++");

        for (Machines f :firstHalf){
            System.out.println(f.getMachine_id() +"     "+f.getType()+"     "+f.getCurrenttemperature());
        }
        System.out.println("------------------------------------------------------------");


        System.out.println("++++++++++++++++++++++++second Half+++++++++++++++++++++++++");
        for(Machines sa : secondHalf){

            System.out.println(sa.getMachine_id() +"     "+sa.getType()+"     "+sa.getCurrenttemperature());
        }
        System.out.println("------------------------------------------------------------");

//
//        for (Machines f :firstHalf){
//            System.out.println(f.getMachine_id() +"     "+f.getType()+"     "+f.getCurrenttemperature());
//        }

//
//        System.out.println("------------------------------------------------------------------------");
//
//        for (Machines s :secondHalf){
//            System.out.println(s.getMachine_id()+"      "+ s.getType()+"    "+s.getCurrenttemperature());
//        }
//
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        for(Machines j :orignalList){
//            System.out.println(j.getMachine_id()+"  ");
//        }
//
//        System.out.println("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
//
//Main loop
        for (Machines fh :firstHalf){


            //if(fh.getCurrenttemperature()>= tmax){

//                System.out.println("1st if");


                for(Machines sh:secondHalf) {


                   int swap =0;

                    String Id = fh.getMachine_id();
                    String ID1 = sh.getMachine_id();
                    String t1=fh.getType();
                    String t2=sh.getType();

                    if(t1.equals(t2)){

                        continue;

                    }

                    double a1 = sh.getCurrenttemperature();
                    double a2 = fh.getCurrenttemperature();
                    double a3 = sh.getInletTemperature();
                    double a4 = fh.getInletTemperature();

                    if(fh.getShuffel()==1  || sh.getShuffel() == 1){
                        continue;
                    }

                    if ((sh.getCurrenttemperature() < fh.getCurrenttemperature()) && (sh.getInletTemperature()<fh.getInletTemperature())) {

                        double currentTempFirstHalfBeforeRealocation = fh.getCurrenttemperature();
                        double currentTempSecondHalfBeforeRealocation  = sh.getCurrenttemperature();
                        Machines f = fh;
                        Machines s = sh;

                        double fInlettemp = f.getInletTemperature();
                        double sInlettemp = s.getInletTemperature();

                       // String ftype = f.getType();
                       // String stype = s.getType();

  //                      f.setType(stype);
  //                      s.setType(ftype);


                        f.setInletTemperature(sInlettemp);
                        s.setInletTemperature(fInlettemp);

                       // String ddd = s.getType();
                       // String ddde = f.getType();
                        double fTemp = temperature_monitor(f.getType(), 100);
                        double sTemp = temperature_monitor(s.getType(), 100);


                        f.setCurrenttemperature(f.getInletTemperature() + fTemp);
                        s.setCurrenttemperature(s.getInletTemperature() +sTemp);

                       // double aa = f.getCurrenttemperature();
                       // double b = s.getCurrenttemperature();

                       // System.out.println(f.getCurrenttemperature() + "       " + s.getCurrenttemperature());


                        if ((s.getCurrenttemperature() < currentTempFirstHalfBeforeRealocation) && f.getCurrenttemperature() < currentTempFirstHalfBeforeRealocation) {


                                int indexf = 0;
                                int indexs = 0;

                                for (int a = 0; a < orignalList.size(); a++) {

                                    if (orignalList.get(a).getMachine_id().equals(f.getMachine_id())) {
//                                    System.out.println("Third If");
                                        indexf = a;
                                    } else if (orignalList.get(a).getMachine_id().equals(s.getMachine_id())) {
                                        indexs = a;
                                    }
                                }

                                sh.setShuffel(1);
                                fh.setShuffel(1);

                                System.out.println(fh.getMachine_id() + "   is replaced by   " + sh.getMachine_id());

//                                String a =fh.getType();
//                                fh.setType(sh.getType());
//                                sh.setType(a);

//
//                                double ta = fh.getInletTemperature();
//                                double tb = fh.getInletTemperature();
                                //String ta = fh.getType();
                                //String tb = sh.getType();
//
//                                orignalList.set(indexf, new Machines(fh.getMachine_id(),fh.getCpu_num(),fh.getMem_size(),fh.getAvailavle_cpu_num(),fh.getAvailavle_cpu_num(),fh.getStatus(),fh.getInletTemperature(),fh.getCurrenttemperature(),sh.getType()));
//                                orignalList.set(indexs, new Machines(sh.getMachine_id(),sh.getCpu_num(),sh.getMem_size(),sh.getAvailavle_cpu_num(),sh.getAvailavle_cpu_num(),sh.getStatus(),sh.getInletTemperature(),sh.getCurrenttemperature(),a));

                                swap=1;
                                orignalList.set(indexf,sh);
                                orignalList.set(indexs,fh);

                                String   sds =  orignalList.get(indexs).getType();
                                String   ssds =  orignalList.get(indexf).getType();


                                //break;



                        }else{

                            double f1Inlettemp = f.getInletTemperature();
                            double s1Inlettemp = s.getInletTemperature();

                            f.setInletTemperature(s1Inlettemp);
                            s.setInletTemperature(f1Inlettemp);

//                             String ft =f.getType();
//                             String st  = s.getType();
//
//                             f.setType(st);
//                             s.setType(ft);

                            f.setCurrenttemperature(f.getInletTemperature() + temperature_monitor(f.getType(), 100));
                            s.setCurrenttemperature(s.getInletTemperature() + temperature_monitor(s.getType(), 100));


                        }


                    }

                    if(swap == 1){
                        break;
                    }

                }
            //}


        }


//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        for(Machines j :orignalList){
//            System.out.println(j.getMachine_id()+"  "+j.getInletTemperature()+"    "+j.getType());
//        }
//        System.out.println("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
//




        //Delimiter used in CSV file
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";
        //CSV file header
        final String FILE_HEADER = "machine_id,cpu_num,mem_size,status,InletTemperature,Type";
        //fileName = System.getProperty("user.home") + "/seat.csv";
        try {

            FileWriter fileWriter = new FileWriter("tmax.csv");
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Machines mu : orignalList) {
                fileWriter.append(mu.getMachine_id());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getCpu_num()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getMem_size()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getStatus()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getInletTemperature()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getType()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
            System.out.println("CSV file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }




            return orignalList;

    }






    //Method to Update Temperature
     public double temperature_monitor(String type,long percentage_utilization){

       double  increaseTemperature = 0;

        if(type.equals("A")) {

            if (percentage_utilization >= 0 && percentage_utilization < 12.5) {
                increaseTemperature = thermalProfileOfA.get(0);
            } else if (percentage_utilization >= 12.5 && percentage_utilization < 25) {
                increaseTemperature = thermalProfileOfA.get(1);
            } else if (percentage_utilization >= 25 && percentage_utilization < 37.5) {
                increaseTemperature = thermalProfileOfA.get(2);
            } else if (percentage_utilization >= 37.5 && percentage_utilization < 50) {
                increaseTemperature =  thermalProfileOfA.get(3);
            } else if (percentage_utilization >= 50 && percentage_utilization < 62.5) {
                increaseTemperature =  thermalProfileOfA.get(4);
            } else if (percentage_utilization >= 62.5 && percentage_utilization < 75) {
                increaseTemperature = thermalProfileOfA.get(5);
            } else if (percentage_utilization >= 75 && percentage_utilization < 87.5) {
                increaseTemperature = thermalProfileOfA.get(6);
            } else if (percentage_utilization >= 87.5 && percentage_utilization < 100) {
                increaseTemperature = thermalProfileOfA.get(7);
            } else {
                increaseTemperature = thermalProfileOfA.get(8);
            }

        }else{

            if (percentage_utilization >= 0 && percentage_utilization < 12.5) {
                increaseTemperature = thermalProfileOfB.get(0);
            } else if (percentage_utilization >= 12.5 && percentage_utilization < 25) {
                increaseTemperature = thermalProfileOfB.get(1);
            } else if (percentage_utilization >= 25 && percentage_utilization < 37.5) {
                increaseTemperature = thermalProfileOfB.get(2);
            } else if (percentage_utilization >= 37.5 && percentage_utilization < 50) {
                increaseTemperature = thermalProfileOfB.get(3);
            } else if (percentage_utilization >= 50 && percentage_utilization < 62.5) {
                increaseTemperature = thermalProfileOfB.get(4);
            } else if (percentage_utilization >= 62.5 && percentage_utilization < 75) {
                increaseTemperature = thermalProfileOfB.get(5);
            } else if (percentage_utilization >= 75 && percentage_utilization < 87.5) {
                increaseTemperature = thermalProfileOfB.get(6);
            } else if (percentage_utilization >= 87.5 && percentage_utilization < 100) {
                increaseTemperature =thermalProfileOfB.get(7);
            } else {
                increaseTemperature = thermalProfileOfB.get(8);
            }
        }
        return  increaseTemperature;
     }


    public void thermalSettingsForTypeA(){

        Path pathToFile = Paths.get("MachineAThermalProfile.csv");
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] attributes = line.split(",");
            thermalProfileOfA.add(Double.parseDouble(attributes[0]));
            thermalProfileOfA.add(Double.parseDouble(attributes[1]));
            thermalProfileOfA.add(Double.parseDouble(attributes[2]));
            thermalProfileOfA.add(Double.parseDouble(attributes[3]));
            thermalProfileOfA.add(Double.parseDouble(attributes[4]));
            thermalProfileOfA.add(Double.parseDouble(attributes[5]));
            thermalProfileOfA.add(Double.parseDouble(attributes[6]));
            thermalProfileOfA.add(Double.parseDouble(attributes[7]));
            thermalProfileOfA.add(Double.parseDouble(attributes[8]));

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void thermalSettingsForTypeB(){

        Path pathToFile = Paths.get("MachineBThermalProfile.csv");
        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] attributes = line.split(",");
            thermalProfileOfB.add(Double.parseDouble(attributes[0]));
            thermalProfileOfB.add(Double.parseDouble(attributes[1]));
            thermalProfileOfB.add(Double.parseDouble(attributes[2]));
            thermalProfileOfB.add(Double.parseDouble(attributes[3]));
            thermalProfileOfB.add(Double.parseDouble(attributes[4]));
            thermalProfileOfB.add(Double.parseDouble(attributes[5]));
            thermalProfileOfB.add(Double.parseDouble(attributes[6]));
            thermalProfileOfB.add(Double.parseDouble(attributes[7]));
            thermalProfileOfB.add(Double.parseDouble(attributes[8]));

        }catch (IOException ioe) {ioe.printStackTrace();}

    }



    public ArrayList<Machines> sorting_Machines_In_Decending_Temp(ArrayList<Machines> machines) {
        Machines temp;
        for (int i = 0; i < machines.size(); i++) {
            for (int j = i + 1; j < machines.size(); j++) {
                if (machines.get(i).getCurrenttemperature() <= machines.get(j).getCurrenttemperature()) {


                    temp = machines.get(i);
                    machines.set(i, machines.get(j));
                    machines.set(j, temp);

                }
            }
        }

        return machines;
    }



        public ArrayList<Machines> bubbleSort(ArrayList<Machines> arr) {
            Machines temp;
            for (int i = 0; i < mahines.size(); i++) {
                for (int j = 1; j < (mahines.size() - i); j++) {
                    if (arr.get(j - 1).getInletTemperature() < arr.get(j).getInletTemperature()) {
                        //swap elements

                        temp = arr.get(j - 1);
                        arr.set((j-1),arr.get(j));
                        arr.set(j,temp);

                    }

                }
            }

            return  arr;
        }
    }
