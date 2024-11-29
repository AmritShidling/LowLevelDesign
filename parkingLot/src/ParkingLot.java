import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int floors;
    int numberOfSpots;
    List<ParkingSpot>[] parkingLots;
    static ParkingLot parkingLot;
    private ParkingLot(int floors, int numberOfSpots){
        this.floors = floors;
        this.numberOfSpots = numberOfSpots;
        this.parkingLots = new List[this.floors];
        int carCount = (int)(0.5 * numberOfSpots), truckCount = (int)(0.2 * numberOfSpots), bikeCount = numberOfSpots - carCount - truckCount;

        for(int i = 0, j = 0, k = 0; i < floors; i++){
            parkingLots[i] = new ArrayList<>();
            for(j = 0; j < carCount; j++){
                parkingLots[i].add(new ParkingSpot(k++, VehicleType.CAR));
            }
            for(j = 0; j < truckCount; j++){
                parkingLots[i].add(new ParkingSpot(k++, VehicleType.TRUCK));
            }
            for(j = 0; j < bikeCount; j++){
                parkingLots[i].add(new ParkingSpot(k++, VehicleType.MOTOR_BIKE));
            }
        }
    }

    public static synchronized ParkingLot getParkingLot(int floors, int numberOfSpots){
        if(parkingLot == null){
            parkingLot = new ParkingLot(floors, numberOfSpots);
        }
        return parkingLot;
    }

    public void assignLot(Vehicle vehicle){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < this.numberOfSpots; j++){
                if(parkingLots[i].get(j).vehicleType.equals(vehicle.getVehicleType()) && parkingLots[i].get(j).isEmpty()){
                    parkingLots[i].get(j).assignLot(vehicle);
                    System.out.println(String.format("Assigned floor: {}, Parking Lot: {}", i, j));
                    return;
                }
            }
        }
        throw new RuntimeException("There is not free suitable spot!");
    }

    public void unAssignLot(int floor, int parkingLot){
        if(parkingLots[floor].get(parkingLot).unAssignLot()){
            System.out.println(String.format("Unassigned floor: %d, Parking Lot: %d", floor, parkingLot));
            return;
        }
        throw new RuntimeException("There is no vehicle spot!");
    }

    public void printParkingLotLayout(){

        for(int i = 0; i < this.floors; i++){
            System.out.println("Floor number: " + (i+1));
            for(ParkingSpot parkingSpot: parkingLots[i]){
                System.out.println(parkingSpot.parkingSpotNumber + " " + parkingSpot.vehicleType +" " + (parkingSpot.vehicleParked == null ? "_":parkingSpot.vehicleParked.getVehicleNumber()));
            }
        }
    }


}
