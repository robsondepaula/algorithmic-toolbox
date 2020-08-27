import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentRefills = 0;
        int lastRefills = 0;
        int numRefills = 0;
        int n = stops.length;

        int traject[] = new int[n + 2];
        traject[0] = 0;
        for (int i = 0; i < n; i++) {
            traject[i + 1] = stops[i];
        }
        traject[n + 1] = dist;

        n = traject.length;
        while (currentRefills < (n - 1)) {
            lastRefills = currentRefills;
            while ((traject[currentRefills + 1] - traject[lastRefills]) <= tank) {
                currentRefills++;
                if (currentRefills == (n - 1)) {
                    break;
                }
            }
            if (currentRefills == lastRefills) {
                return -1;
            }
            if (currentRefills < (n - 1)) {
                numRefills++;
            }
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
