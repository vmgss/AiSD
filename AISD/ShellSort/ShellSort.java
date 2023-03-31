package ShellSort;

public class ShellSort {

    public static int shellSort(int[] data) {
        int n = data.length;
        int gap = n / 2;
        int iterations = 0;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = data[i];
                int j = i;

                while (j >= gap && data[j - gap] > temp) {
                    data[j] = data[j - gap];
                    j -= gap;
                    iterations++;
                }

                data[j] = temp;
                iterations++;
            }
            gap /= 2;
        }
        return iterations;
    }
}
