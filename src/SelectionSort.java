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
    
    /**
     * Arreglo de 1000 elementos ordenados con selection sort
    */
   public static void main(String[] args) {
       Random random = new Random();
       int[] v = new int[1000];
       
       for (int i = 0; i < v.length; i++) {
           v[i] = random.nextInt(100 + 1);
       }
       // tiempo de ejecucion
       long start = System.nanoTime();

        selectionsort(v);

        long end = System.nanoTime();
        
        for (int i : v) {
            System.out.println(i);
        }
        
        System.out.println("Tiempo: " + ((end - start) / 1_000_000.0) + " ns");
    }
}