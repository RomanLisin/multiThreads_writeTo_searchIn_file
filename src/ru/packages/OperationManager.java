package ru.packages;

public class OperationManager {
    private InputManager inputManager = new InputManager();


    public int maxNumber(int number){
        int max = Integer.MIN_VALUE;
        if (max < number) max = number;

        return max;
    }

    public int minNumber(int number){
        int min = Integer.MAX_VALUE;
        if (min > number) min = number;
        return min;
    }
}


