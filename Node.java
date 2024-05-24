public class Node {
    int height;
    int width;
    Character name;
    Node left;
    Node right;
    Node root;
    public Node(int height, int width, Character name, Node left, Node right) {
       this.height = height;
       this.width = width;
       this.name=name;
       this.left = left;
       this.right = right;
    } 
    public Node( int height, int width,Character name){
       this.height = height;
       this.width = width;
       this.name=name;
    }
    
 
    public Node(Character name, Node left, Node right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }
    public Node(Character name) {
        this.name = name;
    }
 
    
    public void printH(){
        System.out.println("name =" + name + "  hight ="+ height + "  width =" + width);
    }
    @Override
    public String toString() {
        return "Node [height=" + height + ", width=" + width + ", name=" + name + ", left=" + left + ", right=" + right
                + "]";
    }
 
 }