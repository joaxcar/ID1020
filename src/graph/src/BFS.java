public class BFS {

    Queue<Integer> q;
    private final int s;
    private boolean[] marked;
    private int count = 0;

    public BFS(Graph g, int s) {
        this.s = s;
        q = new Queue<>();
        marked = new boolean[g.verticies()];
        search(g, s);
    }

    private void search(Graph g, int s) {
        q.enqueue(s);
        while (! q.isEmpty()) {
            int cur = q.dequeue();
            marked[cur] = true;
            count++;
            for (Integer i : g.adjacent(cur)) {
                if (!marked[i]) {
                    q.enqueue(i);
                }
            }
        }
    }

    private boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,7);
        BFS dfs = new BFS(g, 1);
        System.out.println(dfs.marked(7));
        System.out.println(dfs.count());
    }
}
