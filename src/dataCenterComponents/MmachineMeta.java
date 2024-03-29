package dataCenterComponents;

public class MmachineMeta {


        private String machine_id;
        private double cpu_num;
        private double mem_size;
        private double availavle_cpu_num;
        private double availavle_mem_size;
        private long no_of_available_containers;
        private String status;
        private double inletTemperature;
        private double currenttemperature;

        public MmachineMeta(String machine_id, double cpu_num, double mem_size, double availavle_cpu_num, double availavle_mem_size, String status, double inletTemperature, double currenttemperature) {
            this.machine_id = machine_id;
            this.cpu_num = cpu_num;
            this.mem_size = mem_size;
            this.availavle_cpu_num = availavle_cpu_num;
            this.availavle_mem_size = availavle_mem_size;
            this.status = status;
            this.inletTemperature = inletTemperature;
            this.currenttemperature = currenttemperature;
        }

        public String getMachine_id() {
            return machine_id;
        }

        public void setMachine_id(String machine_id) {
            this.machine_id = machine_id;
        }

        public double getCpu_num() {
            return cpu_num;
        }

        public void setCpu_num(long cpu_num) {
            this.cpu_num = cpu_num;
        }

        public double getMem_size() {
            return mem_size;
        }

        public void setMem_size(double mem_size) {
            this.mem_size = mem_size;
        }

        public double getAvailavle_cpu_num() {
            return availavle_cpu_num;
        }

        public void setAvailavle_cpu_num(long availavle_cpu_num) {
            this.availavle_cpu_num = availavle_cpu_num;
        }

        public double getAvailavle_mem_size() {
            return availavle_mem_size;
        }

        public void setAvailavle_mem_size(double availavle_mem_size) {
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











