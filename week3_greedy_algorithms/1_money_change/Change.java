import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int c1 = 1;
        int c5 = 5;
        int c10 = 10;
        int change = 0;
        int c = 0;

        if (m >= 10) {
            c = m / c10;
            m -= c * c10;
            change += c;
        }
        if (m >= 5) {
            c = m / c5;
            m -= c * c5;
            change += c;
        }
        if (m >= 1) {
            change += m / c1;
        }

        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
