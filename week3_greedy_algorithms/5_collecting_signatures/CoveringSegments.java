import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments);

        List<Integer> pointList = new ArrayList<>();
        int i = 0, n = segments.length;
        while (i < n) {
            int right = segments[i].end;
            pointList.add(right);
            while ((i < n) && (segments[i].start <= right) && (right <= segments[i].end)) {
                i++;
            }
        }

        int[] points = new int[pointList.size()];
        for (int j = 0; j < pointList.size(); j++) {
            points[j] = pointList.get(j);
        }
        return points;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Segment compareSeg) {
            return end - compareSeg.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        scanner.close();
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
