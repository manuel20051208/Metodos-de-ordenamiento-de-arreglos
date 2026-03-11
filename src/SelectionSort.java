import java.util.Random;

public class SelectionSort {

    // metodo selectionsort
    public static void selectionsort(int[] insertion) {
        int n = insertion.length;
        
        int ubicacion;
        int temp;
        
        for (int i = 0; i < n - 1; i++) {
            ubicacion = i;
            
            for (int j = i + 1; j < n; j++) {
                
                // We find the smallest element
                if (insertion[ubicacion] > insertion[j]) {
                    ubicacion = j;
                }
            }
            
            temp = insertion[i];
            insertion[i] = insertion[ubicacion];
            insertion[ubicacion] = temp;
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
     * Arreglo de 1000 elementos ordenados con selection sort
    */
   public static void main(String[] args) {
       int[] v;
       int[] tiempos = {1000, 3000, 5000, 7000, 10000};

       for (int i = 0; i < tiempos.length; i++) {

           long total = 0;

           //iteramos varias veces para sumar y promediar por cada vector
           for (int k = 0; k < 10; k++) {

               v = rellenar(tiempos[i]);

               long start = System.nanoTime();
               selectionsort(v);
               long end = System.nanoTime();

               total += (end - start);
           }

           double promedio = (total / 10) / 1_000_000.0;

           System.out.println("n = " + tiempos[i] + " | tiempo promedio: " + promedio + " ms");

       }
}