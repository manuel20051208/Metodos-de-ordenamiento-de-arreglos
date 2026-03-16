import java.util.Random;

public class SelectionSort {
    static long cantidadMovimiento = 0;
    static long cantidadComparaciones = 0;

    // metodo selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int ubicacion;
        int temp;

        for (int i = 0; i < n - 1; i++) {
            ubicacion = i;

            for (int j = i + 1; j < n; j++) {
                cantidadComparaciones++;
                if (arr[ubicacion] > arr[j]) {
                    ubicacion = j;
                }
            }

            // solo cuenta movimiento si ubicacion cambio
            if (ubicacion != i) {
                temp = arr[i];
                arr[i] = arr[ubicacion];
                arr[ubicacion] = temp;
                cantidadMovimiento ++;
            }
        }
    }

    public static int[] rellenar(int size) {
        Random random = new Random();
        int[] v = new int[size];
        for (int i = 0; i < size; i++) {
            v[i] = random.nextInt(50000);
        }
        return v;
    }

    /**
     * Arreglo de 1000 elementos ordenados con selection sort
     */
    public static void main(String[] args) {
        int[] tiempos = { 1000, 3000, 5000, 7000, 10000 };
        int[] v;

        // encabezado
        System.out.println("=".repeat(80));
        System.out.printf("%-15s %-25s %-20s %-15s%n", "n", "Tiempo promedio(ms)",
                "Movimientos", "Comparaciones");
        System.out.println("=".repeat(80));

        for (int i = 0; i < tiempos.length; i++) {
            long total = 0;

            for (int k = 0; k < 100; k++) {
                v = rellenar(tiempos[i]);

                long start = System.nanoTime();
                selectionSort(v);
                long end = System.nanoTime();

                total += (end - start);
            }

            double promedioTiempo = (total / 100) / 1_000_000.0;
            long promedioMovimiento = cantidadMovimiento / 100;
            long promedioComparaciones = cantidadComparaciones / 100;

            cantidadMovimiento = 0;
            cantidadComparaciones = 0;

            System.out.printf("%-15d %-25.4f %-20d %-15d%n",
                    tiempos[i], promedioTiempo, promedioMovimiento, promedioComparaciones);
        }

        System.out.println("=".repeat(80));
    }
}