package TaskDividers;

import DataFetchers.MachinesDataFetcher;
import DataFetchers.TasksDataFetcher;
//import TaskDividingPolicies.RoundRobinAcrossRacks;
import Logs.Machine_UsageS;
import dataCenterComponents.*;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Max_Utilization {

    private int noOfRacks;
    private int machinesPerRack;
    private int cpuforcontainer;
    private int memoryforcontainer;
    private ArrayList<Machines> mahines = new ArrayList<>();
    private ArrayList<Tasks> tasks = new ArrayList<>();
    private String previousId;
    private String newId;
    private int timeStamp=0;
    private int containerPointer=0;
    private int machinePoniter=0;
    private double increseTemperature=0;
    private ArrayList<Double> thermalProfileOfA = new ArrayList<>();
    private ArrayList<Double> thermalProfileOfB = new ArrayList<>();
    private ArrayList<Busy_Machine> busy_machines = new ArrayList<>();
    private ArrayList<Machine_UsageS> machine_usage =  new ArrayList<>();
    private int containersFormationPolicy;
    public String machineUsageFile;
    public String tmaxFile;
    public boolean applyhasra;


    public Max_Utilization(int containersFormationPolicy,boolean applyhasra){

        this.applyhasra = applyhasra;
        this.containersFormationPolicy = containersFormationPolicy;
    }

    public void functioning(){


        TasksDataFetcher t = new TasksDataFetcher();
        t.functioning();
        tasks = t.tasks_List;


        if(applyhasra == true) {

            HASRA hasra =  new HASRA();
            mahines =  hasra.functioning();

            System.out.println("HasraApplied");
            for(Machines m : mahines){
                System.out.println(m.getMachine_id());
            }

        }
        else{
            MachinesDataFetcher m = new MachinesDataFetcher();
            m.functioning();
            mahines = m.machines_List;

            System.out.println("HasraNotApplied");
            for(Machines c : mahines){
                System.out.println(c.getMachine_id());
            }

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" Policy         : MAX UTILIZATION");
        System.out.println(" Total Tasks    : "+tasks.size());
        System.out.println(" Total Machines : "+mahines.size());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");



        thermalSettingsForTypeA();
        thermalSettingsForTypeB();

        tasks= addEndtime(tasks,10);

        for(Tasks a:tasks){
            a.setRemainingTime(a.getEnd_time() - a.getStart_time());
        }


        containerDefaultValuesReader();
        mapping(mahines,tasks);


        try{
            machineUsageGenerator();
        }catch(Exception e){}


        try{
            Tmax_Calculator(machine_usage);
        }catch (Exception e){}


    }



//Function for Mapping

    public void mapping(ArrayList<Machines> machines,ArrayList<Tasks> tasks){


//     while(true) {

//
//            ArrayList<Tasks> taskAtgivenTime = current_Tasks(tasks, timeStamp);
//
//            ArrayList<ContainerInfo> containers_to_map = containerFormation(taskAtgivenTime);
//
//
//            //{New Line ADDED}
            ArrayList<ContainerInfo> containers_to_map = new ArrayList<>();

        int cnt =0;
        for(Tasks t : tasks){

            containers_to_map.add(new ContainerInfo(("T"+(cnt+1))+"","machineId",t.getPlan_cpu(),t.getPlan_mem(),0));
            cnt++;

        }

//{New Block}
//        for(int i=0;i<240 ;i++){
//
//            if(i>=0 && i<16){
//
//                containers_to_map.add(new ContainerInfo(("T"+(i+1))+"","machineId",8,100,0));
//
//            }else if(i>=16 && i<48){
//
//                containers_to_map.add(new ContainerInfo(("T"+(i+1))+"","machineId",4,100,0));
//
//            }else if(i>=48 && i<112){
//
//                containers_to_map.add(new ContainerInfo(("T"+(i+1))+"","machineId",2,100,0));
//
//            }else if(i>=112 && i<240){
//
//                containers_to_map.add(new ContainerInfo(("T"+(i+1))+"","machineId",1,100,0));
//
//            }
//
//        }

//{/New Block}





            int checker = 0;


            for (int i = 0; i < containers_to_map.size(); i++) {

                machines = averageUtilizationCalculator(machines);

                if (machines.get(machinePoniter).getAvailavle_cpu_num() >= containers_to_map.get(i).getCpu_required()  && machines.get(machinePoniter).getAvailavle_mem_size()>= containers_to_map.get(i).getMem_required()){
                    checker = 0;
                    machines.get(machinePoniter).setAvailavle_cpu_num(machines.get(machinePoniter).getAvailavle_cpu_num() - containers_to_map.get(i).getCpu_required());
                    machines.get(machinePoniter).setAvailavle_mem_size(machines.get(machinePoniter).getAvailavle_mem_size() - containers_to_map.get(i).getMem_required());

                    long cpuUtilization = percentageUtilizationCalculator(machines.get(machinePoniter).getCpu_num(),machines.get(machinePoniter).getAvailavle_cpu_num());
                    long memUtilization = percentageUtilizationCalculator(machines.get(machinePoniter).getMem_size(),machines.get(machinePoniter).getAvailavle_mem_size());


                    System.out.print(timeStamp+"    ");

                    System.out.print(machines.get(machinePoniter).getMachine_id()+"   ");

                    System.out.print(machines.get(machinePoniter).getAvailavle_cpu_num()+"   ");

                    System.out.print(machines.get(machinePoniter).getAvailavle_mem_size()+"   ");

                    System.out.print(cpuUtilization+"       ");

                    System.out.print(memUtilization+"       ");

                    System.out.println(machines.get(machinePoniter).getCurrenttemperature());



                    double otemp = machines.get(machinePoniter).getCurrenttemperature();
                    double  ntemp =  machines.get(machinePoniter).getInletTemperature()+temperature_monitor(machines.get(machinePoniter).getType(),cpuUtilization);
                    increseTemperature = ntemp - otemp;

                    machines.get(machinePoniter).setCurrenttemperature(machines.get(machinePoniter).getInletTemperature()+temperature_monitor(machines.get(machinePoniter).getType(),cpuUtilization));
                    busy_machines.add(new Busy_Machine(machines.get(machinePoniter).getMachine_id(),containers_to_map.get(i).getCpu_required(),containers_to_map.get(i).getMem_required(),containers_to_map.get(i).getEndTime(),increseTemperature));
                    machine_usage.add(new Machine_UsageS(machines.get(machinePoniter).getMachine_id(),timeStamp,cpuUtilization,memUtilization,machines.get(machinePoniter).getCurrenttemperature(),machines.get(machinePoniter).getType()));

                }else{

                    if(machinePoniter == machines.size()-1){
                        machinePoniter = 0;
                    }else{
                        machinePoniter++;
                        i--;
                        checker++;
                        if(checker == 100){

                            i=i+3;
                            System.out.println("three skipped");
                        }
                    }


                }


            }

//            if(timeStamp == tasks.get(tasks.size()-3).getStart_time()){
//                System.out.println("Done and Dusted");
//                break;
//            }else{
//                timeStamp++;
//            }
//
//            busy_machines = busy_machines_Updater(busy_machines,timeStamp);

 //       }

    }


    public ArrayList<Machines> averageUtilizationCalculator(ArrayList<Machines> machines) {

        for (Machines mm : machines) {
            int counter = 0;
            double sum = 0;
            double avg =0;

            for (Machine_UsageS mu : machine_usage) {

                if(mm.getMachine_id().equals(mu.getMachie_id())){

                    sum = sum + mu.getCpu_util_percent();
                    counter++;

                }
            }
            avg = sum/counter;
            mm.setAverageUtilization(avg);
        }


        for(int i=0;i<machines.size();i++){
            for(int j=i+1;j<machines.size();j++){

                if(machines.get(j).getAverageUtilization() > machines.get(i).getAverageUtilization()){

                    Machines temp = machines.get(i);
                    machines.set(i,machines.get(j));
                    machines.set(j,temp);
                }
            }

        }


        return machines;
    }




    public ArrayList<Busy_Machine> busy_machines_Updater(ArrayList<Busy_Machine> oldList, int time){

        ArrayList<Busy_Machine> newList = new ArrayList<>();


        for(Busy_Machine bm : oldList) {

            if (bm.getEndtime() == time) {
                String mId = bm.getMachine_id();
                for (Machines m : mahines) {
                    if (m.getMachine_id().equals(mId)) {
                        m.setAvailavle_cpu_num(m.getAvailavle_cpu_num() + bm.getCpuUsing());
                        m.setAvailavle_mem_size(m.getAvailavle_mem_size() + bm.getMemUsing());
                        m.setCurrenttemperature(m.getCurrenttemperature() - bm.getIncreaseintemp());
                        break;
                    }
                }

            }else{
                newList.add(bm);
            }

        }

        return  newList;

    }


    //Method for calculating Percentage
    public double calculatePercentageUtilization(double currentValue,double total){
        double t = total;
        double c = currentValue;
        double diff = t-c;
        double ans = diff/t;
        double percentageUtilization = Math.round(ans*100);

        return percentageUtilization;
    }





//Percentage Utilization Calculator

    public long percentageUtilizationCalculator(double total,double available){

        double a = total-available;
        double d = a/total;
        double p = d*100;
        long percentage = Math.round(p);
        return percentage;

    }


    //Function for selection Tasks at given Time
    public ArrayList<Tasks> current_Tasks(ArrayList<Tasks> tasks, int timeStamp ){

        ArrayList<Tasks> current_tasks = new ArrayList<>();

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getStart_time() == timeStamp){
                current_tasks.add(tasks.get(i));
            }
        }



        if(containersFormationPolicy == 2){

            current_tasks = mimimumCpu(current_tasks);

        }else if(containersFormationPolicy == 3){

            current_tasks = mimimumMem(current_tasks);

        }else if(containersFormationPolicy == 4){

            current_tasks = maximumCpu(current_tasks);


        }else if(containersFormationPolicy == 5){

            current_tasks = maximumMem(current_tasks);


        }else if(containersFormationPolicy == 6) {

            current_tasks = maximumRemainingTime(current_tasks);


        }else if(containersFormationPolicy == 7){

            current_tasks = mimimumRemainingTime(current_tasks);

        } else{}





        return current_tasks;
    }


    //Function For Adding End Time
    public ArrayList<Tasks> addEndtime(ArrayList<Tasks> tasks, int timeDifference){

        for(Tasks t : tasks){

            t.setEnd_time(t.getStart_time()+ timeDifference);
        }
        return tasks;
    }




    public void containerDefaultValuesReader() {
        Path pathToFile = Paths.get("ContainerMetaDefaultValues.csv");
        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] attributes = line.split(",");

            cpuforcontainer= Integer.parseInt(attributes[0]);
            memoryforcontainer = Integer.parseInt(attributes[1]);

        }catch (IOException ioe) {ioe.printStackTrace();}

    }


    //Function for container Formation
    public ArrayList<ContainerInfo> containerFormation(ArrayList<Tasks> tasksforContainerization){

        ArrayList<ContainerInfo> containers_to_be_mapped =  new ArrayList<>();
        int time=0;
        long cpu=0;
        long mem=0;

        for(int i=0; i<tasksforContainerization.size();i++){

            for(int j=0;j<tasksforContainerization.get(i).getInstance_num();j++){

                if(((cpu+tasksforContainerization.get(i).getPlan_cpu()) <= cpuforcontainer ) && ((mem+tasksforContainerization.get(i).getPlan_mem())<= memoryforcontainer)){

                    cpu = cpu+tasksforContainerization.get(i).getPlan_cpu();
                    mem = mem+tasksforContainerization.get(i).getPlan_mem();

                }else{

                    containers_to_be_mapped.add(new ContainerInfo(("C"+containerPointer),"",cpu,mem,timeStamp+10));
                    containerPointer++;
                    cpu =0;
                    mem =0;

                    //System.out.println();

                }
            }
        }

        return containers_to_be_mapped;

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

        } catch (IOException ioe) {
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



//
//    public ArrayList<ContainerInfo> minimum_cpu(ArrayList<ContainerInfo> containers) {
//
//        for (int i=0; i <containers.size(); i++) {
//            for (int j = i+1; j<containers.size(); j++) {
//                if (containers.get(j).getCpu_required() < containers.get(i).getCpu_required()) {
//
//                    ContainerInfo temp = containers.get(i);
//                    containers.set(i, containers.get(j));
//                    containers.set(j, temp);
//
//                }
//            }
//        }
//        return  containers;
//    }
//
//    public ArrayList<ContainerInfo> maximum_cpu(ArrayList<ContainerInfo> containers){
//        for(int i=0; i<containers.size();i++){
//            for(int j=i+1;j<containers.size();j++){
//                if(containers.get(j).getCpu_required() > containers.get(i).getCpu_required()){
//
//                    ContainerInfo temp = containers.get(i);
//                    containers.set(i,containers.get(j));
//                    containers.set(j,temp);
//                }
//            }
//        }
//        return containers;
//    }
//
//    public ArrayList<ContainerInfo> minimum_memory(ArrayList<ContainerInfo> containers) {
//
//        for (int i = 0; i < containers.size(); i++) {
//            for (int j = i + 1; j < containers.size(); j++) {
//                if (containers.get(j).getMem_required() < containers.get(i).getMem_required()) {
//
//                    ContainerInfo temp = containers.get(i);
//                    containers.set(i, containers.get(j));
//                    containers.set(j, temp);
//
//                }
//            }
//        }
//        return  containers;
//    }
//
//    public ArrayList<ContainerInfo> maximum_memory(ArrayList<ContainerInfo> containers){
//        for(int i=0; i<containers.size();i++){
//            for(int j=i+1;j<containers.size();j++){
//                if(containers.get(j).getMem_required() > containers.get(i).getMem_required()){
//
//                    ContainerInfo temp = containers.get(i);
//                    containers.set(i,containers.get(j));
//                    containers.set(j,temp);
//                }
//            }
//        }
//        return containers;
//    }
//
//
//
//    public ArrayList<ContainerInfo> firstComeFirstServe(ArrayList<ContainerInfo> containers){
//
//        return  containers;
//    }


    public  ArrayList<Tasks> maximumRemainingTime(ArrayList<Tasks> t){


        for(int i = 0 ; i < t.size() ;i++){

            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getRemainingTime() > t.get(i).getRemainingTime()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }

            }
        }

        return  t;
    }

    public  ArrayList<Tasks> mimimumRemainingTime(ArrayList<Tasks> t){

        for(int i = 0 ; i < t.size() ;i++){

            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getRemainingTime() < t.get(i).getRemainingTime()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }

            }
        }

        return  t;

    }

    public  ArrayList<Tasks> mimimumCpu(ArrayList<Tasks> t){

        for(int i = 0 ; i < t.size() ;i++){

            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getPlan_cpu() < t.get(i).getPlan_cpu()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }

            }
        }

        return  t;

    }


    public  ArrayList<Tasks> maximumCpu(ArrayList<Tasks> t){


        for(int i = 0 ; i < t.size() ;i++){
            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getPlan_cpu() > t.get(i).getPlan_cpu()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }
            }
        }

        return  t;
    }


    public  ArrayList<Tasks> maximumMem(ArrayList<Tasks> t){


        for(int i = 0 ; i < t.size() ;i++){
            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getPlan_mem() > t.get(i).getPlan_mem()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }
            }
        }

        return  t;
    }


    public  ArrayList<Tasks> mimimumMem(ArrayList<Tasks> t){

        for(int i = 0 ; i < t.size() ;i++){

            for (int j=i+1; j<t.size();j++){

                if(t.get(j).getPlan_mem() < t.get(i).getPlan_mem()){

                    Tasks temp = t.get(i);
                    t.set(i,t.get(j));
                    t.set(j,temp);

                }

            }
        }

        return  t;

    }
    private void machineUsageFileReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");
            machineUsageFile = values[0];


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private void tmaxFileReader(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try {

            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String[] values = line.split(",");
            tmaxFile = values[0];


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public void machineUsageGenerator() throws IOException {
        //Delimiter used in CSV file
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";
        //CSV file header
        final String FILE_HEADER = "Machine_ID,Type,Time_Stamp,Cpu_Utilization,Mem_Utilzation,OutLet_Temperature";
        //fileName = System.getProperty("user.home") + "/seat.csv";
        try {

            machineUsageFileReader("MachineUsageFileName.csv");


            FileWriter fileWriter = new FileWriter(machineUsageFile);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Machine_UsageS mu : machine_usage) {
                fileWriter.append(mu.getMachie_id());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(mu.getMachineType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getTime_stamp()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getCpu_util_percent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((String.valueOf(mu.getMem_util_percent())));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((String.valueOf(mu.getOutletTemprature())));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
            System.out.println("CSV file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }






    public void tMaxGenerator(ArrayList<Tmax> machines) throws IOException {



        //Delimiter used in CSV file
        final String NEW_LINE_SEPARATOR = "\n", COMMA_DELIMITER = ",";
        //CSV file header
        final String FILE_HEADER = "Machine_ID,Type,Cpu_Utilization,OutLet_Temperature";
        //fileName = System.getProperty("user.home") + "/seat.csv";
        try {

            tmaxFileReader("ThermalUsageFileName.csv");
            FileWriter fileWriter = new FileWriter(tmaxFile);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Tmax mu : machines) {
                fileWriter.append(mu.getMachine_id());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(mu.getMachineType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getUtilization()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mu.getTemperature()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
            System.out.println("CSV file was created successfully !!!");

        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }




    public void Tmax_Calculator(ArrayList<Machine_UsageS> machinesAfterMapping) {
//,ArrayList<MachineMetaScenario> machinesBeforeMapping
        ArrayList<Tmax> finalMachines = new ArrayList<>();

        for (Machine_UsageS m : machinesAfterMapping) {
            if (m.getCpu_util_percent() == 100.0) {

                finalMachines.add(new Tmax(m.getMachie_id(), m.getMachineType(), m.getCpu_util_percent(), m.getOutletTemprature()));
            }
        }


        for (int i = machine_usage.size() - 1; i > 0; i--) {
            int chek = 1;
            for (Tmax tm : finalMachines) {

                if (machine_usage.get(i).getMachie_id().equals(tm.getMachine_id())) {
                    chek = 0;
                }
            }
            if (chek == 1) {
                finalMachines.add(new Tmax(machine_usage.get(i).getMachie_id(), machine_usage.get(i).getMachineType(), machine_usage.get(i).getCpu_util_percent(), machine_usage.get(i).getOutletTemprature()));
            }


        }

//       for(MachineMetaScenario m : machinesBeforeMapping){
//
//           for(Tmax fm : finalMachines){
//
//               if(m.getMachine_id().equals(fm.getMachine_id())){
//
//                   fm.setTemperature(fm.getTemperature() +m.getInlet_temperature());
//
//               }
//           }
//       }

        for (int i = 0; i < finalMachines.size(); i++) {
            for (int j = i + 1; j < finalMachines.size(); j++) {

                if (finalMachines.get(j).getTemperature() > finalMachines.get(i).getTemperature()) {

                    Tmax temp = finalMachines.get(i);
                    finalMachines.set(i, finalMachines.get(j));
                    finalMachines.set(j, temp);
                }
            }

        }


        try {
            tMaxGenerator(finalMachines);
        } catch (Exception e) {
        }


    }

}