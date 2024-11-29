import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSpot {
    int parkingSpotNumber;
    Vehicle vehicleParked;
    VehicleType vehicleType;
    public ParkingSpot(int parkingSpotNumber, VehicleType vehicleType){
        this.parkingSpotNumber = parkingSpotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isEmpty(){
        return this.vehicleParked == null;
    }
    public synchronized boolean assignLot(Vehicle vehicle){
        if(this.isEmpty()){
            this.vehicleParked = vehicle;
            return true;
        }
        return false;
    }

    public synchronized boolean unAssignLot(){
        if(this.isEmpty()) return false;
        this.vehicleParked = null;
        return true;
    }

}
