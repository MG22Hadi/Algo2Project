public class Node {
    int height;
    int width;
    String name;
    Node left;
    Node right;
 
    public Node(int height, int width, String name, Node left, Node right) {
       this.height = height;
       this.width = width;
       this.name=name;
       this.left = left;
       this.right = right;
    } 
    public Node(int height, int width, String name){
       this.height = height;
       this.width = width;
       this.name=name;
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Node{" +
                "height=" + height +
                ", width=" + width +
                ", name=" + name +
                ", Right"+ right+
                ", Left"+ left+
                '}';
    }
}