package vehicle;

public abstract class Vehicle {
    VehicleType vehicleType;
    String vehicleNumber;
    public Vehicle(VehicleType vehicleType, String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }
}
