package dataCenterComponents;

public class Tmax {

    private  String machine_id;
    private  String machineType;
    private  double utilization;
    private  double temperature;

    public Tmax(String machine_id,String machineType, double utilization, double temperature) {
        this.machine_id = machine_id;
        this.machineType = machineType;
        this.utilization = utilization;
        this.temperature = temperature;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public double getUtilization() {
        return utilization;
    }

    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

}


