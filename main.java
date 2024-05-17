import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Tree tree = new Tree();
//        String s="(B[20,10]|C[30,10]) | A[20,10]";
//        String s="(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
//        String s="A[20,10] | (B[20,10]|C[30,10])";
//        String s="E[40,30] - F[40,20]";
//        tree.Import(s);
        Scanner in=new Scanner(System.in);
        ArrayList<Node> nodes=new ArrayList();
        System.out.println("Enter Num of pieces");
        int num= in.nextInt();
        while (num!=0){
            int height= in.nextInt() ,width= in.nextInt();
            String name=in.next();
            Node newNode=new Node(height,width,name);
            nodes.add(newNode);

            num--;
        }
        System.out.println("Adding is done");
        System.out.println(tree.isRec(nodes));

     }
}
