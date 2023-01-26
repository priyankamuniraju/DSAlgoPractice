package com.algorithms.example.Arrays2023;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveAllOccurrencesOfValInTheArray {

    public static void main(String args[]){
        int[] nums = {3,3,3,2,2,2,3,3,3};
        int val = 3;
        int[] returnedArray = removeVal(nums,val);

        for(int k = 0;k<returnedArray.length;k++){
            System.out.print(returnedArray[k]+" ");
        }

    }

    public static int[] removeVal(int [] array, int val){
        for(int i=0; i<=array.length-1;i++){
            if(array[i]==val)
            {
                array[i]=-1;
            }
        }
        for(int j=0;j<=array.length-1;j++){
            for(int k=array.length-1;k>=0;k--){
                if((array[j]==-1) && (array[k]!=-1) && (j<k)){
                    int temp = array[j];
                    array[j]=array[k];
                    array[k]=temp;
                    break;
                }
            }
        }
      return array;
    }

}
