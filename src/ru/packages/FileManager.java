package ru.packages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    public int[] readNumbersFromFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        String numLine = Files.readString(path);
        List<Integer> numbers = new ArrayList<>();

        String[] parts = numLine.trim().split("\\s+");

        int[] array = new int[parts.length];
        for (int i=0; i<parts.length;i++){
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }

    public void writeNumbersToFileByCleanOld(String filePath, int[] numbers) throws IOException {
        String content = Arrays.stream(numbers)  //toString(Arrays.stream(numbers).toArray());
                               .mapToObj(String::valueOf)
                               .collect(Collectors.joining(" "));
        Path path = Path.of(filePath);
        Files.write(path, content.getBytes());
    }
}
