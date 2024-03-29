package dataCenterComponents;

public class Container_Meta {


    /**
     *
     * ### container meta
     * +------------------------------------------------------------------------------------+
     * | Field           | Type       | Label | Comment                                     |
     * +------------------------------------------------------------------------------------+
     * | container_id    | string     |       | uid of a container                          |
     * | machine_id      | string     |       | uid of container's host machine             |
     * | time_stamp      | bigint     |       |                                             |
     * | app_du          | string     |       | containers with same app_du belong to same application group |
     * | status          | string     |       |                                             |
     * | cpu_request     | bigint     |       | 100 is 1 core                               |
     * | cpu_limit       | bigint     |       | 100 is 1 core                               |
     * | mem_size        | double     |       | normarlized memory, [0, 100]                |
     * +------------------------------------------------------------------------------------+
     *
     */

//Private Fields

    private String container_id;
    private String machine_id;
    private long time_stamp;
    private String app_du;
    private String status;
    private long cpu_request;
    private long cpu_limit;
    private long mem_size;
    private  long endtime;


//Class Constructor

    public Container_Meta(String container_id, String machine_id, long time_stamp, String app_du, String status, long cpu_request, long cpu_limit, long mem_size) {
        this.container_id = container_id;
        this.machine_id = machine_id;
        this.time_stamp = time_stamp;
        this.app_du = app_du;
        this.status = status;
        this.cpu_request = cpu_request;
        this.cpu_limit = cpu_limit;
        this.mem_size = mem_size;
    }

//Getters and Setters

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {this.machine_id = machine_id;}

    public long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getApp_du() {
        return app_du;
    }

    public void setApp_du(String app_du) {
        this.app_du = app_du;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCpu_request() {
        return cpu_request;
    }

    public void setCpu_request(long cpu_request) {
        this.cpu_request = cpu_request;
    }

    public long getCpu_limit() {
        return cpu_limit;
    }

    public void setCpu_limit(long cpu_limit) {
        this.cpu_limit = cpu_limit;
    }

    public double getMem_size() {
        return mem_size;
    }

    public void setMem_size(long mem_size) {
        this.mem_size = mem_size;
    }
}
