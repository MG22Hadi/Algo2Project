public class main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        String s="(A[20,10] | (B[20,10]|C[30,10]))- (D[30,50] | (E[40,30] - F[40,20]))";
        tree.Import(s);
     }
}
