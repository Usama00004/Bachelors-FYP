package dataCenterComponents;

public class Machines {


    private String machine_id;
    private long cpu_num;
    private long mem_size;
    private long availavle_cpu_num;
    private long availavle_mem_size;
    private String status;
    private double inletTemperature;
    private double currenttemperature;
    private double currentPower;
    private String type;
    private double averageUtilization;
    private double increaseInTemp;
    private int shuffel;
    private double increaseInPower;

    public Machines(String machine_id, long cpu_num, long mem_size, long availavle_cpu_num, long availavle_mem_size, String status, double inletTemperature, double currenttemperature,String type) {
        this.machine_id = machine_id;
        this.cpu_num = cpu_num;
        this.mem_size = mem_size;
        this.availavle_cpu_num = availavle_cpu_num;
        this.availavle_mem_size = availavle_mem_size;
        this.status = status;
        this.inletTemperature = inletTemperature;
        this.currenttemperature = currenttemperature;
        this.type = type;

    }

    public double getIncreaseInPower() {
        return increaseInPower;
    }

    public void setIncreaseInPower(double increaseInPower) {
        this.increaseInPower = increaseInPower;
    }

    public double getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
    }

    public int getShuffel() {
        return shuffel;
    }

    public void setShuffel(int shuffel) {
        this.shuffel = shuffel;
    }

    public double getIncreaseInTemp() {
        return increaseInTemp;
    }

    public void setIncreaseInTemp(double increaseInTemp) {
        this.increaseInTemp = increaseInTemp;
    }

    public double getAverageUtilization() {
        return averageUtilization;
    }

    public void setAverageUtilization(double averageUtilization) {
        this.averageUtilization = averageUtilization;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public long getCpu_num() {
        return cpu_num;
    }

    public void setCpu_num(long cpu_num) {
        this.cpu_num = cpu_num;
    }

    public long getMem_size() {
        return mem_size;
    }

    public void setMem_size(long mem_size) {
        this.mem_size = mem_size;
    }

    public long getAvailavle_cpu_num() {
        return availavle_cpu_num;
    }

    public void setAvailavle_cpu_num(long availavle_cpu_num) {
        this.availavle_cpu_num = availavle_cpu_num;
    }

    public long getAvailavle_mem_size() {
        return availavle_mem_size;
    }

    public void setAvailavle_mem_size(long availavle_mem_size) {
        this.availavle_mem_size = availavle_mem_size;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getInletTemperature() {
        return inletTemperature;
    }

    public void setInletTemperature(double inletTemperature) {
        this.inletTemperature = inletTemperature;
    }

    public double getCurrenttemperature() {
        return currenttemperature;
    }

    public void setCurrenttemperature(double currenttemperature) {
        this.currenttemperature = currenttemperature;
    }
}
