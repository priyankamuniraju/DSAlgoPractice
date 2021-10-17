package com.parking.lot.management;

import java.util.UUID;

public class Vehicle {
   private String vehicle_id;
   private String vehicle_number;
   private String type;
   private String colour;
   private String timeOfEntry;
   private String timeOfExit;
   private String parkingSize;

   public Vehicle(String vehicle_number, String type, String colour, String timeOfEntry, String timeOfExit, String parkingSize) {
      this.vehicle_id = UUID.randomUUID().toString();
      vehicle_number = vehicle_number;
      colour = colour;
      type = type;
      timeOfEntry = timeOfEntry;
      timeOfExit = timeOfExit;
      parkingSize = parkingSize;
   }

   public String getVehicle_id() {
      return vehicle_id;
   }

   public void setVehicle_id(String vehicle_id) {
      this.vehicle_id = vehicle_id;
   }

   public String getVehicle_number() {
      return vehicle_number;
   }

   public void setVehicle_number(String vehicle_number) {
      this.vehicle_number = vehicle_number;
   }

   public String getColour() {
      return colour;
   }

   public void setColour(String colour) {
      this.colour = colour;
   }

   public String getTimeOfEntry() {
      return timeOfEntry;
   }

   public void setTimeOfEntry(String timeOfEntry) {
      this.timeOfEntry = timeOfEntry;
   }

   public String getTimeOfExit() {
      return timeOfExit;
   }

   public void setTimeOfExit(String timeOfExit) {
      this.timeOfExit = timeOfExit;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getParkingSize() {
      return parkingSize;
   }

   public void setParkingSize(String parkingSize) {
      this.parkingSize = parkingSize;
   }

}
