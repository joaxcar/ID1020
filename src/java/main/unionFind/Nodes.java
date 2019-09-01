package unionFind;

class Nodes{
    static void fillnodes(int nodes[]){
        for (int i = 0; i < nodes.length; i++){
            nodes[i] = i;
        }
    }

    static void fillnodes(int nodes[], int number){
        for (int i = 0; i < nodes.length; i++){
            nodes[i] = number;
        }
    }
}
