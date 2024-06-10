
public class Node {
    int height;
    int width;
    String name;
    Node left;
    Node right;
    Node root;
    
    public Node( int height, int width,String name){
       this.height = height;
       this.width = width;
       this.name=name;
    }
    public Node(String name, Node left, Node right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }
    public Node(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void printH(){
        System.out.println("name =" + name + "  hight ="+ height + "  width =" + width);
    }
    @Override
    public String toString() {
        return "Node [height=" + height + ", width=" + width + ", name=" + name + ", left=" + left + ", right=" + right
                + "]";
    }
    public int getArea() {
        return height * width;
    }
    
 
 }