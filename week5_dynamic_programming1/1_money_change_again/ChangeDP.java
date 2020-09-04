import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] denominations = { 1, 3, 4 };

        int[] minCoins = new int[m + 1];
        java.util.Arrays.fill(minCoins, 1, m + 1, Integer.MAX_VALUE);

        for (int i = 1; i <= m; i++) {
            for (int d : denominations) {
                if (i >= d) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - d] + 1);
                }
            }
        }
        return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getChange(m));
    }
}
