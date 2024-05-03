import java.util.*;

public class Dis_Joint_Sets {

    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA; // A is new parent
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges); // sorting done on basis of the wt of edges
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < v - 1; i++) {
            Edge e = edges.get(i);
            // (src,dest,wt)

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
            }
            mstCost += e.wt;
            count++;
        }
        System.out.println("Min cost is = " + mstCost);

    }

    public static void helper(int[][] image, int sr, int sc, int color, boolean visited[][], int orgColor) {
        if (sr < 0 || sr > 0 || sr > image.length || sc > image[0].length || visited[sr][sc]
                || image[sr][sc] != orgColor) {
            return;

        }
        // left
        helper(image, sr, sc - 1, color, visited, orgColor);
        // right
        helper(image, sr, sc + 1, color, visited, orgColor);
        // top
        helper(image, sr - 1, sc, color, visited, orgColor);
        // bottom
        helper(image, sr + 1, sc, color, visited, orgColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {

        // //Union find or disjoint sets implementation
        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        kruskalsMST(edges, v);

        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println(floodFill(image, 1, 1, 2));
    }
}
