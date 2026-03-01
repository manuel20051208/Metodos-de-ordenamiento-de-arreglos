import java.util.Random;

public class SelectionSort {
    static void main(String[] args) {
        Random random = new Random();
        int [] v;

        v = new int[1000];
        int n;
        n = v.length;

        for (int i = 0; i < n; i++) {
            v[i] = random.nextInt(999);
        }

        int minimo;
        int ubicacion;
        int temp;

        for (int i = 0; i < n; i++) {
            minimo = v[i];
            ubicacion = i;
            for (int j = i; j < n; j++) {
                if (minimo > v[j]){
                    minimo = v[j];
                    ubicacion = j;
                }
            }
            temp = v[i];
            v[i] = minimo;
            v[ubicacion] = temp;
        }

        for (int i : v) {
            System.out.println(i);
        }
    }
}