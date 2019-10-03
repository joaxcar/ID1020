public class BFSPaths {
    private final int s;
    private int[] edgeTo;
    private boolean[] marked;
    private Queue<Integer> q;

    public BFSPaths(Graph g, int s) {
        this.s = s;
        edgeTo = new int[g.verticies()];
        marked = new boolean[g.verticies()];
        q = new Queue<>();
        findPaths(g, s);
    }

    private void findPaths(Graph g, int v) {
        q.enqueue(v);
        while (! q.isEmpty()) {
            int cur = q.dequeue();
            marked[cur] = true;
            for (Integer i : g.adjacent(cur)) {
                if (! marked[i]) {
                    edgeTo[i] = cur;
                    q.enqueue(i);
                }
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
        BFSPaths p = new BFSPaths(g,1);
        if (p.hasPath(5)) {
            for (Integer i : p.pathTo(7)) {
                System.out.println(i);
            }
        }
    }
}
