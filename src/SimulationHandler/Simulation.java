package SimulationHandler;

import DataFetchers.MachinesDataFetcher;
import DataFetchers.TasksDataFetcher;
import MachineShuffelingPolicies.GRANITE;
import TaskDividers.*;
import dataCenterComponents.*;

import java.util.ArrayList;

public class Simulation {

    ArrayList<Machines> machines =  new ArrayList<>();
    ArrayList<Tasks> tasks = new ArrayList<>();


    public String containerPolicy;
    public String taskPolicy;
    public int taskPolicyIndicator;
    public boolean hasraValue;




    public Simulation(String taskPolicy,String containerPolicy,boolean hasraValue){
        this.taskPolicy = taskPolicy;
        this.containerPolicy = containerPolicy;
        this.hasraValue  = hasraValue;

    }


    public void functioning() {


        MachinesDataFetcher d = new MachinesDataFetcher();
        TasksDataFetcher  t = new TasksDataFetcher();
        d.functioning();
        t.functioning();
        tasks = t.tasks_List;
        machines = d.machines_List;
        taskpolicyFinder();

        if(containerPolicy.equals("Round Robin Across Machines")){

            RoundRobin r = new RoundRobin(taskPolicyIndicator,hasraValue);
            r.functioning();

        }else if(containerPolicy.equals("Round Robin Across Racks")){

            RoundRobin_AcrossRacks rr = new RoundRobin_AcrossRacks(taskPolicyIndicator,hasraValue);
            rr.functioning();

        }else if(containerPolicy.equals("Maximum Utilization")){

            Max_Utilization mu = new Max_Utilization(taskPolicyIndicator,hasraValue);
            mu.functioning();

        }else if(containerPolicy.equals("Minmum Utilization")){

            Min_Utilization mut = new Min_Utilization(taskPolicyIndicator,hasraValue);
            mut.functioning();

        } else if(containerPolicy.equals("Min Hr With Cap On 62%")){

            MinHr_SixtyTwo minHr_sixtyTwo = new MinHr_SixtyTwo(taskPolicyIndicator,hasraValue);
            minHr_sixtyTwo.functioning();

        } else if(containerPolicy.equals("Min Hr With Cap On 75%")){

            MinHr_SeventyFive minHr_seventyFive = new MinHr_SeventyFive(taskPolicyIndicator,hasraValue);
            minHr_seventyFive.functioning();

        } else if(containerPolicy.equals("Hottest Job On Coolest Machine")){

            TASAA ta = new TASAA(taskPolicyIndicator,hasraValue);
            ta.functioning();

        } else if(containerPolicy.equals("Hottest Job On Coolest Machine Efficient")){

            TASAB tb = new TASAB(taskPolicyIndicator,hasraValue);
            tb.functioning();

        } else if(containerPolicy.equals("HAWDA")){

            HAWDA h = new HAWDA(taskPolicyIndicator,hasraValue);
            h.functioning();
        } else if(containerPolicy.equals("Random Placement of Containers")){

            Random_Placement rp = new Random_Placement(taskPolicyIndicator,hasraValue);
            rp.functioning();
        } else if(containerPolicy.equals("GRANITE")){
            GRANITE gr = new GRANITE(taskPolicyIndicator);
            gr.functioning();
        }
    }


    public void taskpolicyFinder(){

        if (taskPolicy.equals("First Come First Serve")){

            taskPolicyIndicator = 1;

        }else if(taskPolicy.equals("Minimum Cpu Required")){

            taskPolicyIndicator = 2;

        }else if(taskPolicy.equals("Minimum Memory Required")){

            taskPolicyIndicator = 3;

        }else if(taskPolicy.equals("Maximum Cpu Required")){

            taskPolicyIndicator = 4;

        }else if(taskPolicy.equals("Maximum Memory Required")){

            taskPolicyIndicator = 5;

        }else if(taskPolicy.equals("Minimum Remaining Time")){

            taskPolicyIndicator = 6;

        }else{

            taskPolicyIndicator = 7;

        }
    }
}







