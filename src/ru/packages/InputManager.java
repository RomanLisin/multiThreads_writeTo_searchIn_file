package ru.packages;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {

    private final Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String text) {
        if (!text.isEmpty()) {
            System.out.println(text);
            return scanner.nextLine();
        } else return null;
    }

    public Integer getInt(String text) {
        while (true) {
            try {
                if (text != null) {
                    return Integer.parseInt(text);
                } else return null;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + text + "' не является числом. Побробуйте снова: ");
            }
        }
    }

    public int[] getIntArray() {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Введите числа по одному в строку.");
        System.out.println("Два пустых вводда подряд завершают ввод.");

        int empty = 0;
        while (true) { //(empty < 1) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                empty++;
                if (empty == 1){
                    if(list.isEmpty()){
                        System.out.println("Нет введенных чисел.");
                        System.exit(0);//завершаем программу
                    } else {
                        break;
                    }
                }
            } else {
                empty = 0; // сбрасываем счетчик

            try {
                int num = Integer.parseInt(input.trim());
                list.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + input + "' не является целым числом");
            }
            }
        }
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//
//        return result;
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}