package ru.packages;

public class OperationManager {


    public int getMax(int[] arr){
        int maxNum=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (maxNum<arr[i])maxNum=arr[i];
        }
        return maxNum;
    }

    public int getMin(int[] arr){
        int minNum=Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++){
            if (minNum>arr[i])minNum=arr[i];
        }
        return minNum;
    }
}


