import java.util.Random;

public class InsertionSort {
    static void main(String[] args) {

        Random random = new Random();
        int[] v;

        v = new int[10000];
        int n;
        n = v.length;

        for (int i = 0; i < n; i++) {
            v[i] = random.nextInt(1000 + 1);
        }

        int ordenado;
        for (int i = 1; i < n; i++) {
            ordenado = v[i];
            int j = i - 1;
            while(j >= 0 && v[j] > ordenado){
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = ordenado;
        }

        for (int i : v) {
            System.out.println(i);
        }
    }
}
