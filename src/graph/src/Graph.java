import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Graph {

    final int vertices;
    int connections;
    Bag<Integer>[] adjacent;


    public Graph(int vertices) {
        this.vertices = vertices;
        connections = 0;
        adjacent = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<>();
        }
    }

    //public Graph(InputStream in) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(in));
        // br.
    //}

    public int verticies() {
        return vertices;
    }

    public int edges() {
        return connections;
    }

    public void addEdge(int v, int w) {
        if (! adjacent[v].contains(w)) {
            adjacent[v].add(w);
            adjacent[w].add(v);
            connections++;
        }
    }

    public Iterable<Integer> adjacent(int v) {
        return adjacent[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            for (Integer j : adjacent[i]) {
                sb.append(i);
                sb.append(", ");
                sb.append(j);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(4,3);
        g.addEdge(3,4);
        System.out.println(g);
        g.addEdge(2,3);
        g.addEdge(4,4);
        g.addEdge(1,4);
        System.out.println(g);
    }
}
