package com.parking.lot.management;

public class LevelZero {

    static final int PARKING_SIZE_ZERO = 20;
    Vehicle[] levelZero;

    public LevelZero() {
        this.levelZero = new Vehicle[PARKING_SIZE_ZERO];
    }

    public boolean isLevelZeroEmpty(){
        for(int i=0;i<PARKING_SIZE_ZERO;i++){
            if(levelZero[i]!=null){
                continue;
            }
            return true;
        }
        return false;
    }

    public static int getParkingSizeZero() {
        return PARKING_SIZE_ZERO;
    }

    public Vehicle[] getLevelZero() {
        return levelZero;
    }

    public void setLevelZero(Vehicle[] levelZero) {
        this.levelZero = levelZero;
    }

    public boolean isBikeSpaceAvailable() {
        return false;
    }

    public boolean isCarSpaceAvailable() {
        return false;
    }

    public boolean isTruckSpaceAvailable() {
        return false;
    }
}
