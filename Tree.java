import java.util.ArrayList;
import java.util.Stack;

//(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))
public class Tree {
   static ArrayList <Node>nodesList;
   static Stack<String> makeTreeStack;
   static Node root ;

   public static Node Import(String str){
      int x=0;
      String temp="";
      nodesList= new ArrayList();

      for(int i= 0;i<str.length();i++){
         // تجريد العبارة من الارقام
         if(Character.isAlphabetic(str.charAt(i))||str.charAt(i)=='('||str.charAt(i)==')'||str.charAt(i)=='|'||str.charAt(i)=='-' ){
            temp+=str.charAt(i);
         }
         //Store nodes in ArrayList
         if (Character.isAlphabetic(str.charAt(i))){

            String heightS =str.substring(i+2,i+4);
            int heightI = Integer.parseInt(heightS);
            String widthS=str.substring(i+5,i+7);
            int widthI= Integer.parseInt(widthS);
            Node newNode= new Node(heightI,widthI ,String.valueOf(str.charAt(i)));
            nodesList.add(newNode);
            
         }
      }
      
      root = makeTree(str, root);

      return root;
   }
   static ArrayList <Node> storeStrings = new ArrayList<>();
   public static Node makeTree(String str,Node root){
      
      int sBracket=0, eBracket=0,indexF=0,tempR=0;
      String sub;
      makeTreeStack=new Stack();
      boolean flag=str.charAt(0)=='(';
      //يقسم النص الى قوسين واشارة
      for (int i= 0;i<str.length();i++) {
         if (flag) {
            if (str.charAt(i) == '(' && sBracket == 0) {
               sBracket++;
               indexF = i;
               continue;
            }
            if (str.charAt(i) == '(')
               sBracket++;

            if (str.charAt(i) == ')')
               eBracket++;

            if (sBracket == eBracket && sBracket > 0) {
               flag=false;
               //خزننا الرووت
               if ((i + 1 < str.length()) && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '|')) {
                  char op = str.charAt(i + 1);
                  String opp = String.valueOf(op);
                  makeTreeStack.push(opp);
                  
               }
               sub = str.substring(indexF + 1, i);
               makeTreeStack.push(sub);
               sBracket = eBracket = 0;
               if ((i + 1 < str.length()) && (str.charAt(i+2)=='('))
                  flag=true;
            }
         }else{
            if(Character.isAlphabetic(str.charAt(i))){
               // لتخزين الرروت
               if ((i + 1 < str.length()) && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '|')) {
                  char op = str.charAt(i + 1);
                  String opp = String.valueOf(op);
                  makeTreeStack.push(opp);
               }
               String temp=String.valueOf(str.charAt(i));
               makeTreeStack.push(temp);
               if ((i + 1 < str.length()) && (str.charAt(i+2)=='('))
                  flag=true;

            }
         }
      }
      if(makeTreeStack.size()>1){
      String t0=makeTreeStack.pop(),t1=makeTreeStack.pop(),t2=makeTreeStack.pop();
      root = new Node(t2);
      root.left=makeTree(t1,new Node(t1));
      root.right=makeTree(t0,new Node(t0));
      
      }else{
         String t0=makeTreeStack.pop();
         root = new Node(t0);
         
      }
      if(tempR==0)
         root=root;
      tempR++;
      return root;
   }
public static void main(String[] args) {
    String s= "A[20,10] | (B[20,10]|C[30,10])";
    Import(s);
   //  for (Node string : storeStrings) {
   //    System.out.println(string);
   //  }
    
}
   

  
}
