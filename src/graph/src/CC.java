public class CC {

    private boolean[] marked;
    private int[] id;
    private int s;
    private int component = 0;
    private int count = 0;

    public CC(Graph g) {
        marked = new boolean[g.verticies()];
        id = new int[g.verticies()];
        search(g);
    }

    private void search(Graph g) {
        for (int i = 0; i < g.verticies(); i++) {
            s = i;
            if (! marked[s]) {
                dfs(g, s);
                component++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        id[v] = component;
        for (Integer i : g.adjacent(v)) {
            if (! marked[i]) {
                dfs(g, i);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1,2);
        g.addEdge(2,7);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(5,7);
        CC cc = new CC(g);
        System.out.println(cc.connected(1, 5));
        System.out.println(cc.id(5));
        System.out.println(cc.connected(1, 6));
        System.out.println(cc.id(6));
    }
}
