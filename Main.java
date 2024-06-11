import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BinaryTree tree= new BinaryTree();
        Tree tree1 = new Tree();
        ArrayList <Node> storeNodes = new ArrayList<>();
        Permutations paper = new Permutations();
        String s= " A[20,10] | (B[20,10]|C[30,10])";
        /*
         * export and import to tree
         */
        Node node =tree.exportTotree(s);
       System.out.println(node);
        //System.out.println();
        // tree.import__(node);
        // System.out.println();
        // for (Node string : tree.nodes) {
        //     string.printH();
        // }

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
