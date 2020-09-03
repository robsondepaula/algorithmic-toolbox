import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int leftMajor = getMajorityElement(a, left, (left + right - 1) / 2 + 1);
        int rightMajor = getMajorityElement(a, (left + right - 1) / 2 + 1, right);

        int leftFreq = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == leftMajor) {
                leftFreq++;
            }
        }
        if (leftFreq > (right - left) / 2) {
            return leftMajor;
        }

        int rightFreq = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == rightMajor) {
                rightFreq++;
            }
        }
        if (rightFreq > (right - left) / 2) {
            return rightMajor;
        }

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
