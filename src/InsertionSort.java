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
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(v[j] > v[])
            }
        }

        for (int i : v) {
            System.out.println(i);
        }
    }
}
