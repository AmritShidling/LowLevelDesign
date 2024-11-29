import vehicle.Car;
import vehicle.MotorBike;
import vehicle.Truck;
import vehicle.Vehicle;

public class ParkingLotOrchestrator {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLot(3, 10);
        Vehicle car = new Car("WE13ER2322");
        Vehicle bike1 = new MotorBike("WE13ER231");
        Vehicle bike2 = new MotorBike("WE13ER231");
        Vehicle bike3 = new MotorBike("WE13ER231");
        Vehicle bike4 = new MotorBike("WE13ER231");
        Vehicle truck = new Truck("WE13ER2322");
        parkingLot.assignLot(car);
        parkingLot.assignLot(truck);
        parkingLot.assignLot(bike1);
        parkingLot.assignLot(bike2);
        parkingLot.assignLot(bike3);
        parkingLot.assignLot(bike4);
        parkingLot.printParkingLotLayout();
    }
}
