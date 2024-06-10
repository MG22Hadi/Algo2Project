import java.util.ArrayList;

public class SwapExprission {
    static ArrayList  <Node > swapNodes= new ArrayList<Node>();
    public Node swapExprission(Node node){
        export(node);
        for (Node node2 : swapNodes) {
                int temp= node2.height;
                node2.height=node2.width;
                node2.width=temp;
            
            if (node2.name.equals("|")) {
                node2.name = "-";
            }
            else if (node2.name.equals("-")) {
                node2.name = "|";
            }
        }    
       return node;
    }
    public void export(Node node){
        if (node == null) {
            return;
        }
        export(node.left);
        swapNodes.add(node);
        export(node.right);
    }
    
}
