import java.io.*;
import java.util.Scanner;

/*
Write a program based on DFS which can answer questions of the type:
"Find the a path from X to Y"
Which should result in a list of vertices traversed from X to Y if there is a path.

DFS:
Enter a start location:
CT
Enter a destination:
NJ
Path from CT to NJ:
CT RI MA VT NY PA WV VA MD DE NJ
 */
public class AssignmentOneDFS {

    public static void main(String[] args) {

        SymbolGraph sg = new SymbolGraph(args[0], " ");
        Graph g = sg.graph();

        Scanner sc = new Scanner(new InputStreamReader(System.in));


        while (true){
            System.out.println("Enter a start location: ");
            String from = sc.next();
            if (! sg.contains(from)) {
                System.out.println("Location not in graph");
                continue;
            }
            System.out.println("Enter a destination: ");
            String to = sc.next();
            if (! sg.contains(to)) {
                System.out.println("Destination not in graph");
                continue;
            }
            int v = sg.indexOf(from);
            int w = sg.indexOf(to);

            DFSPaths dfs = new DFSPaths(g, v);
            if (dfs.hasPath(w)) {
                System.out.println("Path from " + from + " to " + to + ":");
                for (Integer i : dfs.pathTo(w)) {
                    System.out.print(sg.nameOf(i) + " ");
                }
                System.out.println();
            }
            else {

                System.out.println("No such path!");
            }
        }
    }
}
