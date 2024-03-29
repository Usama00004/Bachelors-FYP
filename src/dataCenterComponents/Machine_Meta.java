package dataCenterComponents;

public class Machine_Meta {

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
    private double cpu_num;
    private double mem_size;
    private double availavle_cpu_num;
    private double availavle_mem_size;
    private long no_of_containers;
    private long no_of_available_containers;
    private double container_cpu_num;
    private double container_mem_size;
    private double contaier_available_cpu_num;
    private double container_availabe_mem_size;
    private String status;
    private String inletTemperature;



//Class Constructor
    public Machine_Meta(String machine_id, long time_stamp, long failure_domain_1, String failure_domain_2, double cpu_num, double mem_size,double availavle_cpu_num,double availavle_mem_size, String status) {
        this.machine_id = machine_id;
        this.time_stamp = time_stamp;
        this.failure_domain_1 = failure_domain_1;
        this.failure_domain_2 = failure_domain_2;
        this.cpu_num = cpu_num;
        this.mem_size = mem_size;
        this.availavle_cpu_num = availavle_cpu_num;
        this.availavle_mem_size = availavle_mem_size;
        this.status = status;
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

    public double getCpu_num() {
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

    public double getAvailavle_cpu_num() {
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

    public long getNo_of_containers() {return no_of_containers; }

    public void setNo_of_containers(long no_of_containers) {this.no_of_containers = no_of_containers;}

    public long getNo_of_available_containers() { return no_of_available_containers;}

    public void setNo_of_available_containers(long no_of_available_containers) {this.no_of_available_containers = no_of_available_containers;}

    public double getContainer_cpu_num() {return container_cpu_num;}

    public void setContainer_cpu_num(long container_cpu_num) {this.container_cpu_num = container_cpu_num;}

    public double getContainer_mem_size() {return container_mem_size;}

    public void setContainer_mem_size(double container_mem_size) {this.container_mem_size = container_mem_size;}

    public double getContaier_available_cpu_num(){return contaier_available_cpu_num;}

    public void setContaier_available_cpu_num(long contaier_available_cpu_num) {this.contaier_available_cpu_num = contaier_available_cpu_num;}

    public double getContainer_availabe_mem_size() {return container_availabe_mem_size;}

    public void setContainer_availabe_mem_size(double container_availabe_mem_size) {this.container_availabe_mem_size = container_availabe_mem_size;}
}
