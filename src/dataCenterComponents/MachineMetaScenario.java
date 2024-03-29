package dataCenterComponents;

public class MachineMetaScenario{

    /**
     ### machine meta
     +------------------------------------------------------------------------------------+
     | Field           | Type       | Label | Comment                                     |
     +------------------------------------------------------------------------------------+
     | machine_id      | string     |       | uid of machine                              |
     | time_stamp      | bigint     |       | time stamp, in second                       |
     | failure_domain_1 | bigint     |       | one level of container failure domain      |
     | failure_domain_2 | string     |       | another level of container failure domain  |
     | cpu_num         | bigint     |       | number of cpu on a machine                  |
     | mem_size        | bigint     |       | normalized memory size. [0, 100]            |
     | status          | string     |       | status of a machine                         |
     +------------------------------------------------------------------------------------+

     **/

//Private Fields
    private String machine_id;
    private long time_stamp;
    private long failure_domain_1;
    private String failure_domain_2;
    private long cpu_num;
    private double mem_size;
    private long availavle_cpu_num;
    private double availavle_mem_size;
    private String status;
    private String type;
    private double inlet_temperature;
    private double current_temperature;
    private double average_utilization;

//Class Constructor

    public MachineMetaScenario(String machine_id, long time_stamp, long failure_domain_1, String failure_domain_2, long cpu_num, double mem_size, long availavle_cpu_num, double availavle_mem_size, String status, String type, double inlet_temperature) {
        this.machine_id = machine_id;
        this.time_stamp = time_stamp;
        this.failure_domain_1 = failure_domain_1;
        this.failure_domain_2 = failure_domain_2;
        this.cpu_num = cpu_num;
        this.mem_size = mem_size;
        this.availavle_cpu_num = availavle_cpu_num;
        this.availavle_mem_size = availavle_mem_size;
        this.status = status;
        this.type = type;
        this.inlet_temperature = inlet_temperature;

    }

//Getters Setters

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public long getFailure_domain_1() {
        return failure_domain_1;
    }

    public void setFailure_domain_1(long failure_domain_1) {
        this.failure_domain_1 = failure_domain_1;
    }

    public String getFailure_domain_2() {
        return failure_domain_2;
    }

    public void setFailure_domain_2(String failure_domain_2) {
        this.failure_domain_2 = failure_domain_2;
    }

    public long getCpu_num() {
        return cpu_num;
    }

    public void setCpu_num(long cpu_num) {
        this.cpu_num = cpu_num;
    }

    public double getMem_size() {
        return mem_size;
    }

    public void setMem_size(double mem_size) {
        this.mem_size = mem_size;
    }

    public long getAvailavle_cpu_num() {
        return availavle_cpu_num;
    }

    public void setAvailavle_cpu_num(long availavle_cpu_num) {
        this.availavle_cpu_num = availavle_cpu_num;
    }

    public double getAvailavle_mem_size() {
        return availavle_mem_size;
    }

    public void setAvailavle_mem_size(double availavle_mem_size) {
        this.availavle_mem_size = availavle_mem_size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getInlet_temperature() {
        return inlet_temperature;
    }
    public void setInlet_temperature(double inlet_temperature) {
        this.inlet_temperature = inlet_temperature;
    }
    public double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public double getAverage_utilization() {
        return average_utilization;
    }

    public void setAverage_utilization(double average_utilization) {
        this.average_utilization = average_utilization;
    }
}
