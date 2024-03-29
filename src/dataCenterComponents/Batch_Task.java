//package dataCenterComponents;
//
//public class Batch_Task {
//
//    /**
//     * ### batch task
//     * +------------------------------------------------------------------------------------+
//     * | task_name       | string     |       | task name. unique within a job              |
//     * | instance_num    | bigint     |       | number of instances                         |
//     * | job_name        | string     |       | job name                                    |
//     * | task_type       | string     |       | task type                                   |
//     * | status          | string     |       | task status                                 |
//     * | start_time      | bigint     |       | start time of the task                      |
//     * | end_time        | bigint     |       | end of time the task                        |
//     * | plan_cpu        | double     |       | number of cpu needed by the task, 100 is 1 core |
//     * | plan_mem        | double     |       | normalized memorty size, [0, 100]           |
//     * +------------------------------------------------------------------------------------+
//     *
//     */
//
////private fields
//
//    private String task_name;
//    private long instance_num;
//    private String job_name;
//    private String task_type;
//    private String status;
//    private long start_time;
//    private long end_time;
//    private long plan_cpu;
//    private double  plan_mem;
//    private long total_cpu_for_all_instances;
//    private long total_mem_for_all_instances;
//    private int remainingTime;
//
//
//    //Class Constructor
//
//    public Batch_Task(String task_name, long instance_num, String job_name, String task_type, String status, long start_time, long end_time, long plan_cpu, double plan_mem) {
//        this.task_name = task_name;
//        this.instance_num = instance_num;
//        this.job_name = job_name;
//        this.task_type = task_type;
//        this.status = status;
//        this.start_time = start_time;
//        this.end_time = end_time;
//        this.plan_cpu = plan_cpu;
//        this.plan_mem = plan_mem;
//    }
//
////Getters and Setters
//
//    public int getRemainingTime() {
//        return remainingTime;
//    }
//    public void setRemainingTime(int remainingTime) {
//        this.remainingTime = remainingTime;
//    }
//    public String getTask_name() {
//        return task_name;
//    }
//
//    public void setTask_name(String task_name) {
//        this.task_name = task_name;
//    }
//
//    public long getInstance_num() {
//        return instance_num;
//    }
//
//    public void setInstance_num(long instance_num) {
//        this.instance_num = instance_num;
//    }
//
//    public String getJob_name() {
//        return job_name;
//    }
//
//    public void setJob_name(String job_name) {
//        this.job_name = job_name;
//    }
//
//    public String getTask_type() {
//        return task_type;
//    }
//
//    public void setTask_type(String task_type) {
//        this.task_type = task_type;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public long getStart_time() {
//        return start_time;
//    }
//
//    public void setStart_time(long start_time) {
//        this.start_time = start_time;
//    }
//
//    public long getEnd_time() {
//        return end_time;
//    }
//
//    public void setEnd_time(long end_time) {
//        this.end_time = end_time;
//    }
//
//    public long getPlan_cpu() {
//        return plan_cpu;
//    }
//
//    public void setPlan_cpu(long plan_cpu) {
//        this.plan_cpu = plan_cpu;
//    }
//
//    public double getPlan_mem() {
//        return plan_mem;
//    }
//
//    public void setPlan_mem(double plan_mem) {
//        this.plan_mem = plan_mem;
//    }
//
//    public long getTotal_cpu_for_all_instances() {
//        return total_cpu_for_all_instances;
//    }
//    public void setTotal_cpu_for_all_instances(long total_cpu_for_all_instances) {
//        this.total_cpu_for_all_instances = total_cpu_for_all_instances;
//    }
//    public long getTotal_mem_for_all_instances() {
//        return total_mem_for_all_instances;
//    }
//    public void setTotal_mem_for_all_instances(long total_mem_for_all_instances) {
//        this.total_mem_for_all_instances = total_mem_for_all_instances;
//    }
//}
