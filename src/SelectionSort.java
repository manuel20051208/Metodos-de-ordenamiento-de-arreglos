import java.util.Random;

public class SelectionSort {
    // metodo selectionsort
    public static int selectionSort(int[] arr) {
        int n = arr.length;
        int ubicacion, temp;
        int movimientos = 0;

        for (int i = 0; i < n - 1; i++) {
            ubicacion = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[ubicacion] > arr[j]) {
                    ubicacion = j;
                }
            }

            if (ubicacion != i) {
                temp = arr[i];
                arr[i] = arr[ubicacion];
                arr[ubicacion] = temp;
                movimientos++;
            }
        }
        return movimientos;
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
        System.out.println("=".repeat(55));
        System.out.printf("%-15s %-25s %-20s%n", "n", "Tiempo promedio(ms)", "Movimientos");
        System.out.println("=".repeat(55));

        for (int i = 0; i < tiempos.length; i++) {
            long total = 0;
            long cantidadMovimiento = 0;

            for (int k = 0; k < 100; k++) {
                v = rellenar(tiempos[i]);

                long start = System.nanoTime();
                cantidadMovimiento += selectionSort(v);
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