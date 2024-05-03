import java.util.*;

public class PriorityQ3 {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void slidingWindow(int arr[], int window) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // int i=0,j=2;
        int result[] = new int[arr.length - window + 1];
        for (int i = 0, j = window - 1; j < arr.length; i++, j++) {
            for (int k = i; k <= j; k++) {
                pq.add(arr[k]);
            }
            int max = pq.remove();
            int s = 1;
            while (s <= window - 1) {
                pq.remove();
                s++;
            }
            result[i] = max;
            System.out.print(max + " ");
        }
        System.out.println();

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {

        // int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for (int i = 0; i < pts.length; i++) {
        // int x = pts[i][0];
        // int y = pts[i][1];
        // int sq = x * x + y * y;
        // pq.add(new Point(x, y, sq, i));
        // }

        // // nearest k cars
        // for (int index = 0; index < k; index++) {
        // System.out.println("C" + pq.remove().idx + " ");
        // }

        // int ropes[] = { 2, 3, 3, 4, 6 };
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for (int i = 0; i < ropes.length; i++) {
        // pq.add(ropes[i]);
        // }

        // int cost = 0;
        // while (pq.size() > 1) {
        // int min = pq.remove();
        // int min2 = pq.remove();
        // cost = cost + (min + min2);
        // pq.add(min + min2);
        // }

        // System.out.println(cost);

        // int army[][] = { { 1, 0, 0, 0 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 } };

        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();

        // for (int i = 0; i < army.length; i++) {
        // int count = 0;
        // for (int j = 0; j < army[0].length; j++) {
        // if (army[i][j] == 1) {
        // count++;
        // }
        // }

        // pq.add(new Row(count, i));
        // }

        // for (int i = 0; i < k; i++) {
        // System.out.println("R" + pq.remove().idx);
        // }

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int window = 3;
        slidingWindow(arr, window);

    }
}
