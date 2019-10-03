public class DFSPaths {
    private final int s;
    private int[] edgeTo;
    private boolean[] marked;

    public DFSPaths(Graph g, int s) {
        edgeTo = new int[g.verticies()];
        marked = new boolean[g.verticies()];
        this.s = s;
        findPath(g, s);
    }

    private void findPath(Graph g, int v) {
            marked[v] = true;
            for (Integer i : g.adjacent(v)) {
                if (! marked[i]) {
                    edgeTo[i] = v;
                    findPath(g, i);
                }
            }

    }

    public boolean hasPath(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> q = new Stack<>();
        int cur = v;
        while (cur != s) {
            q.push(cur);
            cur = edgeTo[cur];
        }
        q.push(s);
        return q;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1,2);
        g.addEdge(2,7);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(5,7);
        DFSPaths p = new DFSPaths(g,1);
        if (p.hasPath(5)) {
            for (Integer i : p.pathTo(7)) {
                System.out.println(i);
            }
        }
    }
}
