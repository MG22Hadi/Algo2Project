public class Main {
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        //String s="(A|(B|C))-(D|(E-F))";
        //String s="((B|C)|A)|(D|(E-F))";
        //String s="((A|G)-(B|C))-(D|(E-F))";
        //String s="(A[2,10] | (B[20,10]|C[3,10])) - (D[130,50] | (E[40,30] - F[40,20]))";
        String s= "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
        //String s="(A|(B|C))-(D|(E-F))";
        Node node =tree.storeNum(s);
        System.out.println(node);
       // tree.export(node);
        //System.out.println(tree.isWithinBrackets(s, 17));
        //IsRectengle isRectengle = new IsRectengle();
        InputGUI inputGUI= new InputGUI();
    }
}
