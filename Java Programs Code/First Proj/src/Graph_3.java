import java.util.*;

public class Graph_3 {

    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
    // for (int i = 0; i < graph.length; i++) {
    // graph[i] = new ArrayList<>();
    // }

    // for (int i = 0; i < flights.length; i++) {
    // int src = flights[i][0];
    // int dest = flights[i][1];
    // int wt = flights[i][2];

    // Edge e = new Edge(src, dest, wt);
    // graph[src].add(e);
    // }
    // }

    // public static int cheapestFlight(int n, int flights[][], int src, int dest,
    // int k) {
    // ArrayList<Edge> graph[] = new ArrayList[n];

    // createGraph(flights, graph);

    // int dist[] = new int[n];
    // for (int i = 0; i < n; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // Queue<Info> q = new LinkedList<>();
    // q.add(new Info(0, 0, 0));
    // while (!q.isEmpty()) {
    // Info curr = q.remove();

    // if (curr.stops > k) {
    // break;
    // }

    // for (int i = 0; i < graph[curr.v].size(); i++) {
    // Edge e = graph[curr.v].get(i);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.wt;

    // if (curr.cost + wt < dist[v] && curr.stops <= k) {
    // dist[v] = curr.cost + wt;
    // q.add(new Info(v, dist[v], curr.stops + 1));
    // }

    // }
    // }

    // if (dist[dest] == Integer.MAX_VALUE) {
    // return -1;
    // } else {
    // return dist[dest];
    // }
    // }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(int cities[][], ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < cities.length; i++) {
            int src = i;
            for (int j = 0; j < cities[i].length; j++) {
                int dest = j;
                int wt = cities[i][j];
                Edge e = new Edge(src, dest, wt);
                graph[src].add(e);
            }
        }
    }

    public static void connectCities(int cities[][]) {
        ArrayList<Edge> graph[] = new ArrayList[cities.length];
        createGraph(cities, graph);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int finalCost = 0;
        boolean visited[] = new boolean[cities.length];

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.v]) {
                visited[curr.v] = true;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    int neighbours = e.dest;
                    finalCost += e.wt;
                    pq.add(new Pair(neighbours, e.wt));
                }
            }
        }

        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        // int n = 4;
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
        // }, { 2, 3, 200 } };
        // int src = 0;
        // int dest = 3;
        // int k = 1;

        // System.out.println(cheapestFlight(n, flights, src, dest, k));

        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        connectCities(cities);

    }
}
