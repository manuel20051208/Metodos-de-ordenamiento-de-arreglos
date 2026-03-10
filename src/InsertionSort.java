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

    public static int [] rellenar(int storage){
        Random random = new Random();
        int [] v = new int[storage];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(10000);
        }

        return v;
    }

    /**
     * llamada del metodo insertionSort
     */
    public static void main(String[] args) {
        int[] v;
        int[] tiempos = {1000, 3000, 5000, 7000, 10000};

        for (int i = 0; i < tiempos.length; i++) {

            long total = 0;

            for (int k = 0; k < 10; k++) {

                v = rellenar(tiempos[i]);

                long start = System.nanoTime();
                insertionSort(v);
                long end = System.nanoTime();

                total += (end - start);
            }

            double promedio = (total / 50) / 1_000_000.0;

            System.out.println("n = " + tiempos[i] + " | tiempo promedio: " + promedio + " ms");

        }
    }
}