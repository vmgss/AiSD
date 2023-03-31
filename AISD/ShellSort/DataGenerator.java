package ShellSort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

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
        Random random = new Random();

        for (int size : SIZES) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(); // generate random integer data
            }
            writeDataToFile(data, size);
        }
    }

    private static void writeDataToFile(int[] data, int size) {
        String filename = FILENAME_PREFIX + String.valueOf(size) + ".txt";
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < size; i++) {
                writer.write(Integer.toString(data[i]));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи данных в файл: " + e.getMessage());
        }
    }
}
