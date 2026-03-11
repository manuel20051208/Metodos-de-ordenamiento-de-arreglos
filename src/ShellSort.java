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

    public static int [] rellenar(int storage){
        Random random = new Random();
        int [] v = new int[storage];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(10000);
        }
        return v;
    }

    public static void main(String[] args) {
        int[] v;
        int[] tiempos = {1000, 3000, 5000, 7000, 10000};

        for (int i = 0; i < tiempos.length; i++) {

            long total = 0;

            //iteramos varias veces para sumar y promediar por cada vector
            for (int k = 0; k < 10; k++) {

                v = rellenar(tiempos[i]);

                long start = System.nanoTime();
                shellSort(v);
                long end = System.nanoTime();

                total += (end - start);
            }

            double promedio = (total / 10) / 1_000_000.0;

            System.out.println("n = " + tiempos[i] + " | tiempo promedio: " + promedio + " ms");

        }
}