package com.company;

public class Container {

    public String container_id;
    public String machine_id;
    public long time_stamp;
    public String app_du;
    public String status;
    public long cpu_request;
    public long cpu_limit;
    public double mem_size;
//Class Constructor

    public Container(String container_id, String machine_id, long time_stamp, String app_du, String status, long cpu_request, long cpu_limit, double mem_size) {
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

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

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

    public void setMem_size(double mem_size) {
        this.mem_size = mem_size;
    }

}
