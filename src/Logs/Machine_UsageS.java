package Logs;

public class Machine_UsageS {

    /**
     * ### machine usage
     * +-------------------------------------------------------------------------------------------+
     * | Field           | Type       | Label | Comment                                            |
     * +-------------------------------------------------------------------------------------------+
     * | machine_id      | string     |       | uid of machine                                     |
     * | time_stamp      | double     |       | time stamp, in second                              |
     * | cpu_util_percent | bigint     |       | [0, 100]                                          |
     * | mem_util_percent | bigint     |       | [0, 100]                                          |
     * | mem_gps         | double     |       |  normalized memory bandwidth, [0, 100]             |
     * | mkpi            | bigint     |       |  cache miss per thousand instruction               |
     * | net_in          | double     |       |  normarlized in coming network traffic, [0, 100]   |
     * | net_out         | double     |       |  normarlized out going network traffic, [0, 100]   |
     * | disk_io_percent | double     |       |  [0, 100], abnormal values are of -1 or 101        |
     * +-------------------------------------------------------------------------------------------+
     */

//private Fields

    private String machie_id;
    private double time_stamp;
    private double cpu_util_percent;
    private double mem_util_percent;
    private double outletTemprature;
    private String machineType;




//Class Constructor

    public Machine_UsageS(String machie_id, double time_stamp, double cpu_util_percent, double mem_util_percent,double outletTemprature,String machineType) {
        this.machie_id = machie_id;
        this.time_stamp = time_stamp;
        this.cpu_util_percent = cpu_util_percent;
        this.mem_util_percent = mem_util_percent;
        this.outletTemprature = outletTemprature;
        this.machineType = machineType;

    }

    // Getters and Setters

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachie_id() {
        return machie_id;
    }

    public void setMachie_id(String machie_id) {
        this.machie_id = machie_id;
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

    public double getOutletTemprature() {
        return outletTemprature;
    }

    public void setOutletTemprature(double outletTemprature) {
        this.outletTemprature = outletTemprature;
    }
}
