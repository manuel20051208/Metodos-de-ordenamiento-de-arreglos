import java.util.Random;

public class SelectionSort {
    public static void insertionSort(int [] insertion){

        Random random = new Random();

        int n;
        n = insertion.length;


        for (int i = 0; i < n; i++) {
            insertion[i] = random.nextInt(999);
        }

        int minimo;
        int ubicacion;
        int temp;

        for (int i = 0; i < n - 1; i++) {
            minimo = insertion[i];
            ubicacion = i;
            for (int j = i + 1; j < n; j++) {
                if (minimo > insertion[j]){
                    minimo = insertion[j];
                    ubicacion = j;
                }
            }
            temp = insertion[i];
            insertion[i] = minimo;
            insertion[ubicacion] = temp;
        }

        for (int i : insertion) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        int [] v = new int[1000];
        insertionSort(v);
    }
}