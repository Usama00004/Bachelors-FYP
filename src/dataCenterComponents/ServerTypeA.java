package dataCenterComponents;

public class ServerTypeA {
    private double percentage_utilization;
    private double increase_in_temperature;
    private double power;


    public ServerTypeA(double percentage_utilization, double increase_in_temperature, double power) {
        this.percentage_utilization = percentage_utilization;
        this.increase_in_temperature = increase_in_temperature;
        this.power = power;
    }

    public double getPercentage_utilization() {
        return percentage_utilization;
    }

    public void setPercentage_utilization(double percentage_utilization) {
        this.percentage_utilization = percentage_utilization;
    }

    public double getIncrease_in_temperature() {
        return increase_in_temperature;
    }

    public void setIncrease_in_temperature(double increase_in_temperature) {
        this.increase_in_temperature = increase_in_temperature;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
