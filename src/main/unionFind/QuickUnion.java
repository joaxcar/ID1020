package unionFind;

public class QuickUnion implements UnionFind{

  private int[] nodes;

  public QuickUnion(int size){
    nodes = new int[size];
    Nodes.fillnodes(nodes);
  }

  @Override
  public boolean find(int a, int b){
    int indexRootA = findRoot(a);
    int indexRootB = findRoot(b);
    boolean connected = indexRootA == indexRootB;
    return connected;
  }

  @Override
  public void union(int a, int b){
    int indexRootB = findRoot(b);
    nodes[indexRootB] = a;
  }

  private int findRoot(int node){
    while(node != nodes[node]){
      node = nodes[node];
    }
    return node;
  }
}
      




