package unionFind;

public interface UnionFind{
    boolean connected(int a, int b);
    void join(int a, int b);
}
