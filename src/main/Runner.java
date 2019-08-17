public class Runner{

    public static void main(String[] args){
        unionFind.UnionFind test = new unionFind.QuickFind(10);
        System.out.println(test.connected(1,2));
        test.join(1,2);
        System.out.println(test.connected(1,2));
    }
}
