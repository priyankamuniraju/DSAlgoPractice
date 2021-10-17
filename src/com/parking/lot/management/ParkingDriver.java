package com.parking.lot.management;

import java.util.Scanner;

public class ParkingDriver {
    private final ParkingDriverApi parkingDriverApi;

    public ParkingDriver(ParkingDriverApi parkingDriverApi) {
        this.parkingDriverApi = parkingDriverApi;
    }

    void readInputFromConsole(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the vehicle details");


        while(true){
            String string = in.nextLine();
            String[] vehicleDetails = string.split(",");

            String code = in.nextLine();
            switch (code){
                case "1": //When vehicle is bike

                case "2": //When vehicle is car

                case "3"://When vehicle is truck
                    break;
                default:
                    break;
            }
        }


    }



    public static void main(String args[]){
        ParkingDriver parkingDriver = new ParkingDriver(new ParkingDriverApi());

    }
}
