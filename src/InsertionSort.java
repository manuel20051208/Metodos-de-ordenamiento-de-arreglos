import java.util.Random;

public class InsertionSort {

    // metodo insertionsort
    public static void insertionSort(int[] arreglo) {
        Random random = new Random();
        int n = arreglo.length;

        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(1000 + 1);
        }

        int ordenado;
        for (int i = 1; i < n; i++) {
            ordenado = arreglo[i];
            int j = i - 1;

            // Find the right location
            while (j >= 0 && arreglo[j] > ordenado) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            // add the location found
            arreglo[j + 1] = ordenado;
        }
    }

    /**
     * llamada del metodo insertionSort
     */
    public static void main(String[] args) {
        int[] v = new int[1000];
        
        long start = System.nanoTime();
        
        insertionSort(v);
        // código
        long end = System.nanoTime();
        System.out.println("Tiempo: " + ((end - start)/1_000_000.0) + " ns");

        for (int i : v) {
            System.out.println(i);
        }
    }
}