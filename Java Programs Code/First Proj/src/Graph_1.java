
import java.util.*;

import java.util.Stack;

public class Graph_1 {

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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs2(ArrayList<Edge> graph[], int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfsutil(graph, visited);
            }
        }
    }

    public static void bfsutil(ArrayList<Edge> graph[], boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs2(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        // visited
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs2(graph, e.dest, visited);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfsutil(graph, i, visited);
        }
    }

    public static void dfsutil(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        // visited
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsutil(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int par) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            // case 3
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, curr)) {
                    return true;
                }
                // case 1
            } else if (visited[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing continue
        }
        return false;

    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                return detectCycleUtil(graph, visited, i, -1);
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // if no color given then do coloration and checking BFS
                q.add(i);
                color[i] = 0; // yellow default color
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // neigh is e.dest
                        int neigh = e.dest;
                        if (color[neigh] == -1) {
                            if (color[curr] == 0) {
                                color[neigh] = 1;
                            } else {
                                color[neigh] = 0;
                            }
                            q.add(neigh);
                        } else if (color[neigh] == color[curr]) {
                            return false; // Not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (stack[neigh] == true) {
                return true;
            }
            if (!visited[neigh] && isCycleUtil(graph, neigh, visited, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSortUtil(graph, i, visited, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            if (!visited[neighbour]) {
                topSortUtil(graph, neighbour, visited, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {

        // int v = 5;
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // // converting null to empty arraylist
        // for (int i = 0; i < v; i++) { // here we have initialized/Allocated the AL to
        // each cell
        // graph[i] = new ArrayList<>(); // Nothing but memory allocation
        // }

        // // 0 -> vertex
        // graph[0].add(new Edge(0, 1, 5));

        // // 1 vertex
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));

        // // 2 vertex
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));

        // // 3 vertex
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));

        // // 4 vertex
        // graph[4].add(new Edge(4, 2, 2));

        // // 2's neighbour
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge e = graph[2].get(i);
        // System.out.println("2 -> " + e.dest);
        // }

        // int v = 7;
        // ArrayList<Edge> graph2[] = new ArrayList[v];
        // createGraph(graph2);

        // bfs2(graph, 0);
        // dfs(graph, 0, new boolean[v]);
        // System.out.println(hasPath(graph, 0, 1, new boolean[v]));

        // bfs(graph);
        System.out.println();
        // dfs(graph2);
        System.out.println();
        // dfs2(graph2, 0, new boolean[v]);

        // int k = 5;
        // ArrayList<Edge> graph[] = new ArrayList[k];

        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 1, 1));

        // graph[3].add(new Edge(3, 0, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 3, 1));

        // System.out.println(detectCycle(graph));

        // Bipartite graph question

        // int k = 5;
        // ArrayList<Edge> graph[] = new ArrayList[k];

        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));

        // System.out.println(isBipartite(graph));

        // // Cycle detection in ccase of directed graph

        // int k = 4;
        // ArrayList<Edge> graph[] = new ArrayList[k];

        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // // graph[1].add(new Edge(1, 3, 1));

        // // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 0, 1));
        // // graph[3].add(new Edge(3, 4, 1));

        // // graph[4].add(new Edge(4, 2, 1));
        // // graph[4].add(new Edge(4, 3, 1));

        // System.out.println(isCycle(graph));

        int k = 6;
        ArrayList<Edge> graph[] = new ArrayList[k];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

        topSort(graph);

    }
}
