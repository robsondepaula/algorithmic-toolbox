import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + 1;
            if (i % 2 == 0)
                a[i] = Math.min(1 + a[i / 2], a[i]);
            if (i % 3 == 0)
                a[i] = Math.min(1 + a[i / 3], a[i]);
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (a[n - 1] == a[n] - 1) {
                n = n - 1;
            } else if ((n % 2 == 0) && (a[n / 2] == a[n] - 1)) {
                n = n / 2;
            } else if ((n % 3 == 0) && (a[n / 3] == a[n] - 1)) {
                n = n / 3;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
