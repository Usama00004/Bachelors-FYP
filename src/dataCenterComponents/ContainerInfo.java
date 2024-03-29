package dataCenterComponents;

public class ContainerInfo {

    private String containerID;
    private String machineId;
    private long cpu_required;
    private long mem_required;
    private int startTime;
    private int endTime;
    //private int remainingTime;


    public ContainerInfo(String containerID, String machineId, long cpu_required, long mem_required, int endTime) {
        this.containerID = containerID;
        this.machineId = machineId;
        this.cpu_required = cpu_required;
        this.mem_required = mem_required;
        this.endTime = endTime;
    }


    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public long getCpu_required() {
        return cpu_required;
    }

    public void setCpu_required(long cpu_required) {
        this.cpu_required = cpu_required;
    }

    public long getMem_required() {
        return mem_required;
    }

    public void setMem_required(long mem_required) {
        this.mem_required = mem_required;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}