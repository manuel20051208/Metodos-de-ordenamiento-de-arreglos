import java.util.Random;

public class InsertionSort {

    // metodo insertionsort
    public static void insertionSort(int[] arreglo) {
        int n = arreglo.length;
        
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
        Random random = new Random();
        int[] v = new int[1000];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(1000 + 1);
        }

        // calculo tiempo de ejecucion
        long start = System.nanoTime();

        insertionSort(v);
        // código
        long end = System.nanoTime();
        
        for (int i : v) {
            System.out.println(i);
        }
        
        System.out.println("Tiempo: " + ((end - start) / 1_000_000.0) + " ns");
    }
}