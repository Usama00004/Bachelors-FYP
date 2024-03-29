package dataCenterComponents;

public class Tasks {


    private String task_name;
    private long instance_num;
    private String job_name;
    private String task_type;
    private String status;
    private long start_time;
    private long end_time;
    private long plan_cpu;
    private long  plan_mem;
    private long remainingTime;


    public Tasks(String task_name, long instance_num, long start_time, long end_time, long plan_cpu, long plan_mem) {
        this.task_name = task_name;
        this.instance_num = instance_num;
        this.start_time = start_time;
        this.end_time = end_time;
        this.plan_cpu = plan_cpu;
        this.plan_mem = plan_mem;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public long getInstance_num() {
        return instance_num;
    }

    public void setInstance_num(long instance_num) {
        this.instance_num = instance_num;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public long getPlan_cpu() {
        return plan_cpu;
    }

    public void setPlan_cpu(long plan_cpu) {
        this.plan_cpu = plan_cpu;
    }

    public long getPlan_mem() {
        return plan_mem;
    }

    public void setPlan_mem(long plan_mem) {
        this.plan_mem = plan_mem;
    }
}
