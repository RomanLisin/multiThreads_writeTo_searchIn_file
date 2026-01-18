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

    public int[] findWordPositions(String filePath, String targetWord){
        List<Integer> positions = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            for(int lineIdx = 0; lineIdx < lines.size();lineIdx++){
                String line = lines.get(lineIdx);
                String[] words = line.trim().split("\\s+");

                for(int wordIdx = 0; wordIdx < words.length; wordIdx++){
                    if(words[wordIdx].equals(targetWord)){
                        positions.add(lineIdx + 1);
                        positions.add(wordIdx + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return new int[0];
        }
        return positions.stream().mapToInt(Integer::intValue).toArray();
    }
}
