public class Runner{

   public static void main(String[] args){
        unionFind.UnionFind test = new unionFind.WeightedQuickUnion(10);
        System.out.println(test.find(1,2));
        test.union(1,3);
        test.union(3,4);
        test.union(2,5);
        test.union(6,5);
        test.union(6,3);
        System.out.println(test.find(1,2));
    }
}
