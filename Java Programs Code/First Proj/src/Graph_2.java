import java.util.*;

public class Graph_2 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void calcInDeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calcInDeg(graph, indeg);

        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void printAllpaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllpaths(graph, e.dest, dest, path + src);
        }
    }

    // static class Pair implements Comparable<Pair> {
    // int n;
    // int path;

    // public Pair(int n, int path) {
    // this.n = n;
    // this.path = path;
    // }

    // @Override
    // public int compareTo(Pair p2) {
    // return this.path - p2.path;
    // }
    // }

    // public static void dijkstra(ArrayList<Edge> graph[], int src) {
    // int dist[] = new int[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // boolean visited[] = new boolean[graph.length];
    // PriorityQueue<Pair> pq = new PriorityQueue<>();
    // pq.add(new Pair(src, 0));
    // while (!pq.isEmpty()) {
    // Pair curr = pq.remove();
    // if (!visited[curr.n]) {
    // visited[curr.n] = true;
    // // neighbours
    // for (int i = 0; i < graph[curr.n].size(); i++) {
    // Edge e = graph[curr.n].get(i);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.wt;
    // if (dist[u] + wt < dist[v]) { // update dist of src to v
    // dist[v] = dist[u] + wt;
    // pq.add(new Pair(v, dist[v]));
    // }
    // }
    // }
    // }

    // // print all source to vertices shortest dist
    // for (int i = 0; i < dist.length; i++) {
    // System.out.print(dist[i] + " ");
    // }

    // System.out.println();
    // }

    public static void bellmannford(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        for (int i = 0; i < V - 1; i++) {
            // edges
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v] && dist[u] != Integer.MAX_VALUE) { // condn says u is not infinite
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

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

    public static void prims(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.v]) {
                visited[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("MInm cost of mst is = " + finalCost);
    }

    public static void main(String[] args) {

        // BFS topological sort
        // int v = 6;
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // for (int i = 0; i < v; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 1, 1));

        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));

        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // topSort(graph);

        // All paths from source to destination thro dfs
        // int v = 6;
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // for (int i = 0; i < v; i++) {
        // graph[i] = new ArrayList<>();
        // }
        // graph[0].add(new Edge(0, 3, 1));

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 1, 1));

        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));

        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // printAllpaths(graph, 5, 1, "");

        // // Dijkstra's Algorithm Question

        // int v = 6;
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // for (int i = 0; i < v; i++) {
        // graph[i] = new ArrayList<>();
        // }
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        // // graph[5].add(new Edge(5, 0, 1));
        // // graph[5].add(new Edge(5, 2, 1));

        // int src = 0;

        // dijkstra(graph, src);

        // // bellmann ford algo

        // int v = 5;
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // for (int i = 0; i < v; i++) {
        // graph[i] = new ArrayList<>();
        // }
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));
        // // graph[4].add(new Edge(4, 5, 5));

        // bellmannford(graph, 0);

        // Prims algo question

        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        prims(graph);

    }
}
