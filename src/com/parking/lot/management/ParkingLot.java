package com.parking.lot.management;

public class ParkingLot {
    static final int LEVEL_ZERO_SIZE = 20;
    static final int LEVEL_ONE_SIZE = 30;
    static final int LEVEL_TWO_SIZE = 40;

    Vehicle[] levelZero = new Vehicle[LEVEL_ZERO_SIZE];
    Vehicle[] levelOne = new Vehicle[LEVEL_ONE_SIZE];
    Vehicle[] levelTwo = new Vehicle[LEVEL_TWO_SIZE];

    public boolean isLevelZeroEmpty(){
        for(int i=0;i<LEVEL_ZERO_SIZE;i++){
            if(levelZero[i]!=null){
                continue;
            }
            return true;
        }
        return false;
    }

    public boolean isLevelOneEmpty(){
        for(int i=0;i<LEVEL_TWO_SIZE;i++){
            if(levelTwo[i]!=null){
                continue;
            }
            return true;
        }
        return false;
    }

    public boolean isLevelTwoEmpty(){
        for(int i=0;i<LEVEL_ONE_SIZE;i++){
            if(levelOne[i]!=null){
                continue;
            }
            return true;
        }
        return false;
    }

}
