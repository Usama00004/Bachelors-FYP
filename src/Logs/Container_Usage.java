package Logs;

public class Container_Usage {
    /**
     package dataCenterComponents;

     **
     *
     * ### container usage
     * +------------------------------------------------------------------------------------+
     * | container_id    | string     |       | uid of a container                          |
     * | machine_id      | string     |       | uid of container's host machine             |
     * | time_stamp      | double     |       | time stamp, in second                       |
     * | cpu_util_percent | bigint     |       |                                             |
     * | mem_util_percent | bigint     |       |                                             |
     * | cpi             | double     |       |                                             |
     * | mem_gps         | double     |       | normalized memory bandwidth, [0, 100]       |
     * | mpki            | bigint     |       |                                             |
     * | net_in          | double     |       | normarlized in coming network traffic, [0, 100] |
     * | net_out         | double     |       | normarlized out going network traffic, [0, 100] |
     * | disk_io_percent | double     |       | [0, 100], abnormal values are of -1 or 101  |
     * +------------------------------------------------------------------------------------+
     */
//private Fields
    private String container_id;
    private String machine_id;
    private double time_stamp;
    private double cpu_util_percent;
    private double mem_util_percent;

//Class Constructor

    public Container_Usage(String container_id, String machine_id, double time_stamp, double cpu_util_percent, double mem_util_percent) {
        this.container_id = container_id;
        this.machine_id = machine_id;
        this.time_stamp = time_stamp;
        this.cpu_util_percent = cpu_util_percent;
        this.mem_util_percent = mem_util_percent;

    }
    //Getters And Setters
    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public double getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(double time_stamp) {
        this.time_stamp = time_stamp;
    }

    public double getCpu_util_percent() {
        return cpu_util_percent;
    }

    public void setCpu_util_percent(double cpu_util_percent) {
        this.cpu_util_percent = cpu_util_percent;
    }

    public double getMem_util_percent() {
        return mem_util_percent;
    }

    public void setMem_util_percent(double mem_util_percent) {
        this.mem_util_percent = mem_util_percent;
    }

}
