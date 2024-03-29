package dataCenterComponents;

public class Busy_Machine {

    String machine_id;
    String container_id;
    long  cpuUsing;
    long memUsing;
    long endtime;
    double increaseintemp;

    public Busy_Machine(String machine_id , long cpuUsing, long memUsing, long endtime, double incTemp) {
        this.machine_id = machine_id;
        this.cpuUsing = cpuUsing;
        this.memUsing = memUsing;
        this.endtime = endtime;
        this.increaseintemp = incTemp;

    }

    public double getIncreaseintemp() {
        return increaseintemp;
    }

    public void setIncreaseintemp(double increaseintemp) {
        this.increaseintemp = increaseintemp;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getTaskid() {
        return container_id;
    }

    public void setTaskid(String taskid) {
        this.container_id = taskid;
    }

    public long getCpuUsing() {
        return cpuUsing;
    }

    public void setCpuUsing(long cpuUsing) {
        this.cpuUsing = cpuUsing;
    }

    public long getMemUsing() {
        return memUsing;
    }

    public void setMemUsing(long memUsing) {
        this.memUsing = memUsing;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }
}
