public class Node {
    int height;
    int width;
    Character name;
    Tree left;
    Tree right;
 
    public Node(int height, int width, Character name, Tree left, Tree right) {
       this.height = height;
       this.width = width;
       this.name=name;
       this.left = left;
       this.right = right;
    } 
    public Node(int height, int width, Character name){
       this.height = height;
       this.width = width;
       this.name=name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "height=" + height +
                ", width=" + width +
                ", name=" + name +
                '}';
    }
}