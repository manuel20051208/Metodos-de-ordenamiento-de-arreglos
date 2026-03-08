import java.util.Random;

public class ShellSort {

    //metodo shellsort
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

    }
    
    static void main(String[] args) {
        int[] v = new int[1000];

        //calculo tiempo de ejecucion
        long start = System.nanoTime();

        shellSort(v);

        long end = System.nanoTime();

        System.out.println("Tiempo: " + ((end - start)/1_000_000.0) + " ns");
        for(int i: v){
            System.out.println(i);
        }
    }
}
