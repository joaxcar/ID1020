import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SymbolGraph {

    private String[] toStr;
    private SET<String, Integer> toIndex;
    private final int vertices;
    private Graph g;


    public SymbolGraph(String filename, String delimiter) {

        toIndex = new SET<>();
        Scanner sc;
        File file = new File("/Users/ladmin/skola/kurser/kth-id1020/src/graph/src/" + filename);
        try{
            sc = new Scanner(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            System.out.println("No such file");
            vertices = 0;
            return;
        }

        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(delimiter);
            for (String s : strs) {
                if (! toIndex.contains(s)) {
                    toIndex.add(s, toIndex.size());
                }
            }
        }

        vertices = toIndex.size();
        toStr = new String[vertices];

        for (String s : toIndex.keys()) {
            int i = toIndex.get(s);
            toStr[i] = s;
        }

        g = new Graph(vertices);

        try{
            sc = new Scanner(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            System.out.println("No such file");
            return;
        }

        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(delimiter);
            int v = toIndex.get(strs[0]);
            int w = toIndex.get(strs[1]);
            g.addEdge(v, w);
        }

    }

    public int verticies() {
        return vertices;
    }

    public int edges() {
        return g.connections;
    }

    public Graph graph() {
        return g;
    }

    public String nameOf(int v) {
        return toStr[v];
    }

    public int indexOf(String s) {
        return toIndex.get(s);
    }

    public boolean contains(String s) {
        return toIndex.contains(s);
    }


    public Iterable<Integer> adjacent(int v) {
        return g.adjacent(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            for (Integer j : g.adjacent(i)) {
                sb.append(toStr[i]);
                sb.append(", ");
                sb.append(toStr[j]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SymbolGraph g = new SymbolGraph("data.txt", " ");
        System.out.println(g);
    }
}
