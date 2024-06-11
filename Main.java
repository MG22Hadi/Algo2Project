import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BinaryTree2 tree1 = new BinaryTree2();
        ArrayList <Node> storeNodes = new ArrayList<>();
        Permutations paper = new Permutations();
        String s= "  (A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
                    
        /*
         * export and import to tree
         */
        Node node =tree1.Import(s);
        System.out.println(node);
        tree1.export(node);
        System.out.println();
        for (Node string : tree1.nodes) {
            string.printH();
        }

        /*
         * export and import to file
         */
        // TreeFile drawerInFile= new TreeFile();
        // drawerInFile.export_(s);
        // System.out.println(drawerInFile.import_());

        /*
         * test some paper if they form a rectangle or no
         */

        // int numberOfPapers=in.nextInt();
        // ArrayList<Node> nodesLists = new ArrayList<>();
        // while (numberOfPapers!=0){
        //     int height= in.nextInt(),width= in.nextInt();
        //     String name=in.next();
        //     Node newNode=new Node(height,width,name);
        //     nodesLists.add(newNode);
        //     numberOfPapers--;
        // }
        // paper.isRect(nodesLists);

        /*
         * Graphical interface for tree and flipping tree by Enter an expression
         */
        GUIinput inputGUI= new GUIinput();

    }
}
