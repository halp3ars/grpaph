import java.util.ArrayList;
import java.util.LinkedList;

public class main {

    private int V;

    private ArrayList<Integer>[] graph;

    main(int v) {
        V = v;
        graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
    }


    void shirina(int v, boolean visited[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.println(v + " ");
            for (int n : graph[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void shirina(int v) {
        shirina(v, new boolean[V]);
    }

    public static void main(String[] args) {
        main graph = new main(7); // v = размер графа

        graph.addConnection(0, 1);
        graph.addConnection(1, 5);
        graph.addConnection(1, 3);
        graph.addConnection(2, 1);
        graph.addConnection(2, 7);
        graph.addConnection(3, 1);
        graph.addConnection(4, 5);
        graph.addConnection(5, 1);
        graph.addConnection(5, 6);
        graph.addConnection(6, 5);

        graph.shirina(0); // откуда стартмуем
    }

    void addConnection(int v, int w) {
        graph[v].add(w);
    }

}

