package dataCenterComponents;

public class Task {

    public int taskId;
    public int timeRequired;
    public int coresRequired;
    public int memoryRequired;

    public Task(int taskId, int timeRequired, int coresRequired, int memoryRequired) {
        this.taskId = taskId;
        this.timeRequired = timeRequired;
        this.coresRequired = coresRequired;
        this.memoryRequired = memoryRequired;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(int timeRequired) {
        this.timeRequired = timeRequired;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCoresRequired() {
        return coresRequired;
    }

    public void setCoresRequired(int coresRequired) {
        this.coresRequired = coresRequired;
    }

    public int getMemoryRequired() {
        return memoryRequired;
    }

    public void setMemoryRequired(int memoryRequired) {
        this.memoryRequired = memoryRequired;
    }

    public static class ServerTypeA {
    }
}
