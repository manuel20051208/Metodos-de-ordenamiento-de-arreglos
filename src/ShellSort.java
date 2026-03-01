import java.util.Random;

public class ShellSort {
    public static void shellSort(int[] arreglo) {
        Random random = new Random();
        int n = arreglo.length;

        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(1 + 1000);
        }

        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = arreglo[i];
                int j;
                for (j = i; j >= interval && arreglo[j - interval] > temp; j -= interval) {
                    arreglo[j] = arreglo[j - interval];
                }
                arreglo[j] = temp;
            }
        }

        for(int i: arreglo){
            System.out.println(i);
        }
    }

    static void main(String[] args) {
        int[] v = new int[1000];
        shellSort(v);
    }
}
