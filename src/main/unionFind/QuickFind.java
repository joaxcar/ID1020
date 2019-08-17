package unionFind;
public class QuickFind implements UnionFind {
    private int[] nodes;

    public QuickFind(int size){
        nodes = new int[size];
        fillnodes();
    }

    private void fillnodes(){
        for (int i = 0; i < nodes.length; i++){
            nodes[i] = i;
        }
    }

    @Override
    public boolean connected(int a, int b){
        return nodes[a] == nodes[b];
    }
    
    @Override
    public void join(int a, int b){
        for (int i = 0; i < nodes.length; i++){
            if (nodes[i] == nodes[a]){
                nodes[i] = nodes[b];
            }
        }
    }
}
