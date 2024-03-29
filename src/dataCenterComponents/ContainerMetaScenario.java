package dataCenterComponents;

public class ContainerMetaScenario {

    private String containerID;
    private long cores_required;
    private long memory_required;


//Class Constructor
    public ContainerMetaScenario(String containerID, long cores_required, long memory_required) {
        this.containerID = containerID;
        this.cores_required = cores_required;
        this.memory_required = memory_required;
    }

//Setter Getter Methods
    public String getContainerID() {
        return containerID;
    }


    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }


    public long getCores_required() {
        return cores_required;
    }


    public void setCores_required(long cores_required) {
        this.cores_required = cores_required;
    }


    public long getMemory_required() {
        return memory_required;
    }


    public void setMemory_required(long memory_required) {
        this.memory_required = memory_required;
    }


}