package unionFind;

public class WeightedQuickUnion implements UnionFind{
  private int[] nodes;
  private int[] weights;

  public WeightedQuickUnion(int size){
    nodes = new int[size];
    weights = new int[size];
    Nodes.fillnodes(nodes);
    Nodes.fillnodes(weights, 1);
  }

  
  public boolean find(int a, int b){
    return root(a) == root(b);
  }

  public void union(int a, int b){
    int rootA = root(a);
    int rootB = root(b);

    if (weights[rootA] >= weights[rootB]){
      setRoot(rootA,rootB);
    } else {
      setRoot(rootB,rootA);
    }
  }

  private void setRoot(int root, int node){
      nodes[node] = root;
      weights[root] += weights[node];
  }

  private int root(int node){
    int root = node;
    while (root != nodes[root]){
      root = nodes[root];
    }
    return root;
  }
}
