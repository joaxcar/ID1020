public class Runner{

   public static void main(String[] args){
        unionFind.UnionFind test = new unionFind.QuickFind(10);
        System.out.println(test.find(1,2));
        test.union(1,2);
        System.out.println(test.find(1,2));
    }
}
