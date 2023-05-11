import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int ARRAY_SIZE = 10000;
    private static final int SEARCH_SIZE = 100;
    private static final int DELETE_SIZE = 1000;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];

        // заполняем массив случайными числами и добавляем их в дерево
        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt();
            array[i] = value;
            long startTime = System.nanoTime();
            tree.insert(value);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Вставка " + i + ": " + duration + " наносекунд");
        }

        // выбираем случайные элементы из массива и ищем их в дереве
        int[] searchValues = new int[SEARCH_SIZE];
        for (int i = 0; i < SEARCH_SIZE; i++) {
            int value = array[random.nextInt(ARRAY_SIZE)];
            searchValues[i] = value;
            long startTime = System.nanoTime();
            tree.search(value);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Поиск " + i + ": " + duration + " наносекунд");
        }

        // выбираем случайные элементы из массива и удаляем их из дерева
        int[] deleteValues = new int[DELETE_SIZE];
        for (int i = 0; i < DELETE_SIZE; i++) {
            int value = array[random.nextInt(ARRAY_SIZE)];
            deleteValues[i] = value;
            long startTime = System.nanoTime();
            tree.delete(value);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Удаление " + i + ": " + duration + " наносекунд");
        }

        // считаем среднее время вставки, удаления и поиска данных
        double insertTimeSum = 0;
        double deleteTimeSum = 0;
        double searchTimeSum = 0;
        int insertOpCount = 0;
        int deleteOpCount = 0;
        int searchOpCount = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            int value = array[i];

            // время вставки
            long startTime = System.nanoTime();
            tree.insert(value);
            long endTime = System.nanoTime();
            insertTimeSum += endTime - startTime;
            insertOpCount++;

            // время удаления
            if (i < DELETE_SIZE) {
                startTime = System.nanoTime();
                tree.delete(deleteValues[i]);
                endTime = System.nanoTime();
                deleteTimeSum += endTime - startTime;
                deleteOpCount++;
            }

            // время поиска
            if (Arrays.binarySearch(searchValues, value) >= 0) {
                startTime = System.nanoTime();
                tree.search(value);
                endTime = System.nanoTime();
                searchTimeSum += endTime - startTime;
                searchOpCount++;
            }
        }

        double avgInsertTime = insertTimeSum / insertOpCount;
        double avgDeleteTime = deleteTimeSum / deleteOpCount;
        double avgSearchTime = searchTimeSum / searchOpCount;

        System.out.println("Среднее время вставки: " + avgInsertTime + " наносекунд на операцию");
        System.out.println("Среднее время удаления: " + avgDeleteTime + " наносекунд на операцию");
        System.out.println("Среднее время поиска: " + avgSearchTime + " наносекунд на операцию");
    }
}

