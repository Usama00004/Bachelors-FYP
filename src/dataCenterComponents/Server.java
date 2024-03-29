package dataCenterComponents;

public class Server {
	
	private int id;
	private int capacity;
	private int available;
	private int inletTemprature;
	private int memory;
	private int core;
	private double utilization;


	public Server(int id, int capacity, int available, int inletTemprature, int memory, int core) {
		
		this.id = id;
		this.capacity = capacity;
		this.available = available;
		this.inletTemprature = inletTemprature;
		this.memory = memory;
		this.core = core;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getInletTemprature() {
		return inletTemprature;
	}
	public void setInletTemprature(int inletTemprature) {
		this.inletTemprature = inletTemprature;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public double getUtilization() {
		return utilization;
	}

	public void setUtilization(double utilization) {
		this.utilization = utilization;
	}

}
