import java.util.Scanner;

public class FractionalKnapsack {
    private static class Loot implements Comparable<Loot> {
        double value;
        int weight;
        double valuePerWeight;

        public Loot(int value, int weight) {
            this.value = ((double) value);
            this.weight = weight;
            valuePerWeight = ((double) value / (double) weight);
        }

        public int compareTo(Loot compareLoot) {
            double compareValuePerWeight = compareLoot.valuePerWeight;

            if (valuePerWeight < compareValuePerWeight) {
                return -1;
            } else if (compareValuePerWeight < valuePerWeight) {
                return 1;
            }
            return 0;
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n = values.length;
        Loot[] loots = new Loot[n];

        // build a representation of the input with value per weight ratio
        for (int i = 0; i < n; i++) {
            loots[i] = new Loot(values[i], weights[i]);
        }

        // sort to find out greatest value per weight
        java.util.Arrays.sort(loots, java.util.Collections.reverseOrder());

        // maximize usage of the greatest value per weight ratio
        for (Loot loot : loots) {
            int curWeight = loot.weight;
            double curValue = loot.value;

            if (capacity - curWeight >= 0) {
                capacity -= curWeight;
                value += curValue;
            } else {
                double fraction = ((double) capacity / (double) curWeight);
                value += curValue * fraction;
                break;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
