public class leafNode {
    String name;
    int height;
    int width;
    private leafNode next;
    private leafNode nextInList;

    public leafNode( int height, int width,String name) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.next = nextInList;
    }
    public void setNextInList(leafNode nextInList) {
        this.nextInList = nextInList;
    }
   
    // public leafNode(int height, int width) {
    //     this.height = height;
    //     this.width = width;
    // }
    public leafNode(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString() {
        return  name ;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setNext(leafNode next) {
    
        if (nextInList != null) {
            this.next = nextInList;
        } else {
            this.next = next;
        }
    
    }
    public leafNode getNext() {
        return next;
    }
    public leafNode getNextInList() {
        return nextInList;
    }

    
    
}
