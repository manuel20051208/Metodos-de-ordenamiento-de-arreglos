import java.util.Random;

public class InsertionSort {

    // metodo insertionsort
    public static int insertionSort(int[] arreglo) {
        int n = arreglo.length;
        int cantidadMovimiento = 0;
        int key;

        for (int i = 1; i < n; i++) {
            key = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j--;
                cantidadMovimiento++;
            }

            // solo cuenta como movimiento si key cambió de posición
            if (j + 1 != i) {
                arreglo[j + 1] = key;
                cantidadMovimiento++;
            }
        }
        return cantidadMovimiento;
    }

    public static int[] rellenar(int size) {
        Random random = new Random();
        int[] v = new int[size];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(50000);
        }
        return v;
    }

    // llamada del metodo insertionSort
    public static void main(String[] args) {
        int[] tiempos = { 1000, 3000, 5000, 7000, 10000 };
        int[] v;

        // encabezado
        System.out.println("=".repeat(55));
        System.out.printf("%-15s %-25s %-20s%n", "n", "Tiempo promedio(ms)", "Movimientos");
        System.out.println("=".repeat(55));

        for (int i = 0; i < tiempos.length; i++) {
            long total = 0;
            long cantidadMovimiento = 0;

            for (int k = 0; k < 100; k++) {
                v = rellenar(tiempos[i]);

                long start = System.nanoTime();
                cantidadMovimiento += insertionSort(v);
                long end = System.nanoTime();

                total += (end - start);
            }

            double promedioTiempo = (total / 100) / 1_000_000.0;
            long promedioMovimiento = cantidadMovimiento / 100;

            System.out.printf("%-15d %-25.4f %-20d%n",
                    tiempos[i], promedioTiempo, promedioMovimiento);
        }

        System.out.println("=".repeat(55));
    }
}