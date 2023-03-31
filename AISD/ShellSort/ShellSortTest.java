package ShellSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShellSortTest {

    private static final int[] SIZES =
            { 100, 200, 300, 400, 500,
                    600, 700, 800, 900, 1000, 1200, 1300, 1400, 1500, 2000, 2200,
                    2300, 2400, 2500, 3000, 3200, 3300, 3400, 3500, 4000, 4200,
                    4300, 4400, 4500, 5000, 5200, 5300, 5400, 5500, 6000, 6200,
                    6300, 6400, 6500, 7000, 7200, 7300, 7500, 8000, 8200,
                    8300, 8500, 9000, 9200, 9300,
                    9500, 10000 }; // different sizes to test
    private static final String FILENAME_PREFIX = "data_"; // prefix for the filename

    public static void main(String[] args) {
        for (int size : SIZES) {
            int[] data = readDataFromFile(size);
            long startTime = System.currentTimeMillis();
            int iterations = ShellSort.shellSort(data);
            long endTime = System.currentTimeMillis();
            System.out.println("Сортировка " + size + " элементов заняла " + (endTime - startTime) + " миллисекунд и " + iterations + " итераций.");
        }
    }

    private static int[] readDataFromFile(int size) {
        String filename = FILENAME_PREFIX + size + ".txt";
        File file = new File(filename);
        int[] data = new int[size];

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < size; i++) {
                String line = reader.readLine();
                data[i] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка считывания данных из файла: " + e.getMessage());
        }

        return data;
    }
}
