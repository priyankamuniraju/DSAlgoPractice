package com.parking.lot.management;

import java.util.HashMap;
import java.util.Map;

public class ParkingDriverApi {
    static final int MINIMUM_PARKING_PRICE=50; // for first 3 hours 50Rs and every next hour 20Rs
    Map<String,Vehicle> vehiclesMap = new HashMap<>();

    public Vehicle addVehicleDetails(String[] vehicleDetails){
        String vehicle_number = vehicleDetails[1];
        String type = vehicleDetails[2];
        String colour = vehicleDetails[3];
        String timeOfEntry = vehicleDetails[4];
        String timeOfExit = vehicleDetails[5];
        String parkingSize = vehicleDetails[6];

        if(Utility.isEmpty(vehicle_number) || Utility.isEmpty(type) || Utility.isEmpty(colour) || Utility.isEmpty(timeOfEntry)||
        Utility.isEmpty(timeOfExit) || Utility.isEmpty(parkingSize));{
            System.out.println("Some details are missing.Please enter all the details.");
        }
        Vehicle vehicle = null;
        switch(type){
            case "bike":
                vehicle = new Bike(vehicle_number,type,colour,timeOfEntry,timeOfExit,parkingSize);
                break;
            case "car":
                vehicle = new Car(vehicle_number,type,colour,timeOfEntry,timeOfExit,parkingSize);
                break;
            case "truck":
                vehicle = new Truck(vehicle_number,type,colour,timeOfEntry,timeOfExit,parkingSize);
                break;
        }
        if(vehicle == null){
            System.out.println("Please enter valid input!");
        }
        return vehicle;
    }

    public boolean addVehicleToParking(Vehicle vehicle, ParkingLot parkingLot){


     return false;
    }

    public boolean removeVehicleFromParking(ParkingLot parkingLot, Vehicle vehicle){

        String vehicleId = vehicle.getVehicle_id();

     return true;
    }
    public void printParkingSnapshot(){

    }

    public int ticketPrice(int numberOfHours){
       int cost = MINIMUM_PARKING_PRICE +((numberOfHours-3)*20);
       return cost;
    }
}
