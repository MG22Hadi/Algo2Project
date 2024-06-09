import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

//(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))
public class BinaryTree {
   ArrayList<Node> nodesList= new ArrayList<>();
   Node root ;

   public Node storeNum(String str){
    int x=0,f=0,k=0;
    String temp="";
    String str1="";
       for(int i= 0;i<str.length();i++){
        if(Character.isAlphabetic(str.charAt(i))||str.charAt(i)=='('||str.charAt(i)==')'||str.charAt(i)=='|'||str.charAt(i)=='-' ){
            temp+=str.charAt(i);
            for(int j=i;j<str.length();j++){
                if(str.charAt(j)==','){
                    f=j;

                }
                if(str.charAt(j)==']'){
                    k=j;
                    break;
                }
            }
        }
         //Store nodes in ArrayList
         if (Character.isAlphabetic(str.charAt(i))){
            str1+=str.charAt(i);
            String heightS =str.substring(i+2,f);
            int heightI = Integer.parseInt(heightS);
            String widthS=str.substring(f+1,k);
            int widthI= Integer.parseInt(widthS);
            Node newNode= new Node(heightI,widthI ,str1);
            nodesList.add(newNode); 
            str1="";     
         }
       }
    return exportTotree(temp);
   }
   
   ArrayList <Node> storeStrings = new ArrayList<>();
   Node rootNode = new Node("r", null, null);
   Node newNode,leftNode,rightNode;
    /*
     * function to set a public nodes in tree 
     */
    public Node exportTotree(String str){
        
        int indexOfRoot=0;
       for(int i=0;i<str.length();i++){
        String str1 = "";
        String strleft = "";
        String strright = "";
          if (str.charAt(i)=='|' || str.charAt(i)=='-') {
            if (str.charAt(i-1)==')' && str.charAt(i+1)=='('&& !(isWithinBrackets(str, i))) {
                str1+=str.charAt(i);
                newNode = new Node(str1, null, null);
               indexOfRoot=i;
               rootNode.root = newNode;
               storeStrings.add(newNode);
            }
            else if (str.charAt(i-1)==')' && str.charAt(i+1)=='('&& (isWithinBrackets(str, i))) {
                str1+=str.charAt(i);
               newNode = new Node(str1, null, null);
               storeStrings.add(newNode);
            }
            else if ((Character.isAlphabetic(str.charAt(i-1)) && str.charAt(i+1)=='(') ) {
                strleft+=str.charAt(i-1);
                str1+=str.charAt(i);
                leftNode= new Node(strleft,null,null);
               newNode = new Node(str1, leftNode , null);
               storeStrings.add(newNode);
              
            }
            else if ((Character.isAlphabetic(str.charAt(i+1)) && str.charAt(i-1)==')') ) {
                strright+=str.charAt(i+1);
                str1+=str.charAt(i);
                rightNode= new Node(strright,null,null);
               newNode = new Node(str1,null,rightNode);
               storeStrings.add(newNode);
               
            }
            else if (Character.isAlphabetic(str.charAt(i-1))&& Character.isAlphabetic(str.charAt(i+1))) {
                strleft+=str.charAt(i-1);
                str1+=str.charAt(i);
                strright+=str.charAt(i+1);
                leftNode= new Node(strleft,null,null);
                rightNode= new Node(strright,null,null);
                newNode = new Node(str1, leftNode,rightNode);
                storeStrings.add(newNode);
            }
          } 
        }

      rootNode =makeTree(storeStrings,  rootNode.root);

      for (Node node : nodesList) {
        for (Node node2 : storeStrings) {
            if (node2.name.equals(node.name)) {
                node2.height= node.height;
                node2.width = node.width;
            }
            if ( node2.left.name.equals(node.name)) {
                node2.left.height= node.height;
                node2.left.width = node.width;
            }
            if ( node2.right.name.equals(node.name)) {
                node2.right.height= node.height;
                node2.right.width = node.width;
            }
        }
      }
     
      return rootNode;
    }
    /*
     * function to set rest of right and left nodes
     */
    public Node makeTree(ArrayList<Node>arrayList,Node root){
        int indexOfRoot1=0;
        
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i)==root) {
                indexOfRoot1=i;
            }
            if ((arrayList.get(i)!=root)) {
                if ((arrayList.get(i).right)== null&&(arrayList.get(i).left)!= null) {
                    if ((arrayList.get(i)!=root)) {
                        arrayList.get(i).right=arrayList.get(i+1);
                    }
                }
                if ((arrayList.get(i).left)== null&&(arrayList.get(i).right)!= null) {
                    if ((arrayList.get(i)!=root)) {
                        arrayList.get(i).left=arrayList.get(i-1);
                    }
                }
                if ((arrayList.get(i).right)==null&&(arrayList.get(i).left)== null) {
                    if ((arrayList.get(i)!=root)) {
                        arrayList.get(i).left=arrayList.get(i-1);
                        arrayList.get(i).right=arrayList.get(i+1);
                    }
                }
            } 
        }
        
        //set root
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i)== root) {
                for (int k=0;k<arrayList.size();k++) {
                    if ((i!=k)) {
                        if (((arrayList.get(k).left.name).equals("|")|| (arrayList.get(k).left.name).equals("-"))&& ((arrayList.get(k).right.name).equals("|")|| (arrayList.get(k).right.name).equals("-"))) {
                            if (k>indexOfRoot1) {
                                root.right= arrayList.get(k);
                            }
                            else{
                                root.left= arrayList.get(k);
                            }    
                        }
                        if ((((arrayList.get(k).right.name).equals("|")|| (arrayList.get(k).right.name.equals("-"))))) {
                            if (k>indexOfRoot1) {
                                root.right= arrayList.get(k);
                            }
                            else{
                                root.left= arrayList.get(k);
                            }    
                        }
                        if ((arrayList.get(k).left.name.equals("-"))||((arrayList.get(k).left.name.equals("|")))) {
                            if (k>indexOfRoot1) {
                                root.right= arrayList.get(k);
                                
                            }
                            else{
                                root.left= arrayList.get(k);
                               
                            }    
                        }   
                    }
                }
            }
        }
        
        return root;       
    }
    /*
     * 
     */
    public void export(Node root){
        if (root == null) {
            return;
        }
        export(root.left);
        System.out.print(root.name + "");
        export(root.right);
    }
    /*
     * function to know if a char within a brackets or no
     */
    public static boolean isWithinBrackets(String string, int index) {
        Deque<Character> stack = new ArrayDeque<>();
        int count=0;
        for (int i = 0; i < string.length(); i++) {
            char x = string.charAt(i);
            if ((x== string.charAt(index) )&& (stack.isEmpty())&& (i==index)) {
                return false;
            }
            if ((x== string.charAt(index) )&& !(stack.isEmpty())&& (i==index)) {
                if (count==0) {
                    return false;
                }
                if (count>=1) {
                    return true;
                }
            }
            if (x=='(') {
                stack.push(x);
                count++;
            }
            if (x==')') {
                stack.pop();
                count--;
            }
        }

        return false;
    }

  
}

