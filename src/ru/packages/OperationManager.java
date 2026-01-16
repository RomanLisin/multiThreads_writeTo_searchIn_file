package ru.packages;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public BigDecimal findSum(int[] array){
        BigDecimal sum = BigDecimal.ZERO;
        for(int num: array){
            sum = sum.add(BigDecimal.valueOf(num));
        }
        return sum;
    }

    public BigDecimal findAverage(int[] array){
        if(array.length==0) return BigDecimal.ZERO;
        return findSum(array).divide(BigDecimal.valueOf(array.length),
                RoundingMode.HALF_UP);
    }
}


