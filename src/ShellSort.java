import java.util.Random;

public class ShellSort {
    // metodo shellsort
    public static int shellSort(int[] arreglo) {
        int n = arreglo.length;
        int cantidadMovimiento = 0;

        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = arreglo[i];
                int j;
                for (j = i; j >= interval && arreglo[j - interval] > temp; j -= interval) {

                    arreglo[j] = arreglo[j - interval];
                    cantidadMovimiento++;
                }
                arreglo[j] = temp;
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
                cantidadMovimiento += shellSort(v);
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