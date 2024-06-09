import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BinaryTree tree= new BinaryTree();
        //String s="(A|(B|C))-(D|(E-F))";
        //String s="((B|C)|A)|(D|(E-F))";
        //String s="((A|G)-(B|C))-(D|(E-F))";
        //String s="(A[2,10] | (B[20,10]|C[3,10])) - (D[130,50] | (E[40,30] - F[40,20]))";
        String s= "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
        //String s="(A|(B|C))-(D|(E-F))";
        Node node =tree.storeNum(s);
        //System.out.println(node);
       // tree.export(node);
        //System.out.println(tree.isWithinBrackets(s, 17));
        //IsRectengle isRectengle = new IsRectengle();
        //InputGUI inputGUI= new InputGUI();
        int numberOfPapers=in.nextInt();
        ArrayList<Node> nodesList = new ArrayList<>();
        while (numberOfPapers!=0){
            int height= in.nextInt(),width= in.nextInt();
            String name=in.next();
            Node newNode=new Node(height,width,name);
            nodesList.add(newNode);
            numberOfPapers--;
        }
    }
}
