import java.util.Random;

public class ShellSort {

    // metodo shellsort
    public static void shellSort(int[] arreglo) {
        int n = arreglo.length;
        
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
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] v = new int[1000];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(1000);
        }

        // calculo tiempo de ejecucion
        long start = System.nanoTime();

        shellSort(v);

        long end = System.nanoTime();

        
        for (int i : v) {
            System.out.println(i);
        }
        
        System.out.println("Tiempo: " + ((end - start) / 1_000_000.0) + " ns");
    }
}