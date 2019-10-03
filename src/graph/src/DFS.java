public class DFS {
    private boolean[] marks;
    int count = 0;

    public DFS(Graph g, int s) {
        marks = new boolean[g.verticies()];
        search(g, s);
    }

    private void search(Graph g, int s) {
        marks[s] = true;
        count++;
        for (Integer i : g.adjacent(s)) {
            if (! marks[i]) {
                search(g, i);
            }
        }

    }

    public boolean marked(int v) {
        return marks[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,7);
        g.addEdge(7,9);
        DFS dfs = new DFS(g, 1);
        System.out.println(dfs.marked(7));
        System.out.println(dfs.count());
    }
}
