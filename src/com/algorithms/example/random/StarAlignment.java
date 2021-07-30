package com.algorithms.example.random;

public class StarAlignment {

    public static void main (String[] args){
        starAlignment(6);
    }
    public static void starAlignment(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=n-i-1; j++){
                System.out.print(" ");
            }
            for(int k=0; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
