import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))
public class Tree {
   ArrayList nodesList;
   Stack<String> makeTreeStack;
   Node root ;

   public void Import(String str){
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

      System.out.println(temp);
      makeTree(temp ,root);
      addToStack();

   }
   public Node makeTree(String s,Node root){
      int sBracket=0, eBracket=0,indexF=0,tempR=0;
      String sub;
      makeTreeStack=new Stack();
      boolean flag=s.charAt(0)=='(';
      //يقسم النص الى قوسين واشارة
      for (int i= 0;i<s.length();i++) {
         if (flag) {
            if (s.charAt(i) == '(' && sBracket == 0) {
               sBracket++;
               indexF = i;
               continue;
            }
            if (s.charAt(i) == '(')
               sBracket++;

            if (s.charAt(i) == ')')
               eBracket++;

            if (sBracket == eBracket && sBracket > 0) {
               flag=false;
               //خزننا الرووت
               if ((i + 1 < s.length()) && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '|')) {
                  char op = s.charAt(i + 1);
                  String opp = String.valueOf(op);
                  makeTreeStack.push(opp);
               }
               sub = s.substring(indexF + 1, i);
               makeTreeStack.push(sub);
               sBracket = eBracket = 0;
               if ((i + 1 < s.length()) && (s.charAt(i+2)=='('))
                  flag=true;
            }
         }else{
            if(Character.isAlphabetic(s.charAt(i))){
               // لتخزين الرروت
               if ((i + 1 < s.length()) && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '|')) {
                  char op = s.charAt(i + 1);
                  String opp = String.valueOf(op);
                  makeTreeStack.push(opp);
               }
               String temp=String.valueOf(s.charAt(i));
               makeTreeStack.push(temp);
               if ((i + 1 < s.length()) && (s.charAt(i+2)=='('))
                  flag=true;

            }
         }
      }
//      System.out.println(makeTreeStack.toString());

      if(makeTreeStack.size()>1){
      String t0=makeTreeStack.pop(),t1=makeTreeStack.pop(),t2=makeTreeStack.pop();
      root =new Node(t2);
      root.left=makeTree(t1,new Node(t1));
      root.right=makeTree(t0,new Node(t0));
      }else{
         String t0=makeTreeStack.pop();
         root =new Node(t0);

      }
      if(tempR==0)
         this.root=root;
      tempR++;
     
      return root;
   }

   public void addToStack(){
      System.out.println(root);
   }

   public boolean isRec(ArrayList nodesList){
      //System.out.println(nodesList);

      for(int i=0;i<nodesList.size();i++){
         Node a=(Node) nodesList.get(i);
         for(int j=i+1;j<nodesList.size();j++){
            Node b=(Node) nodesList.get(j);
            if(a.width == b.width){
               int height=a.height+ b.height,width= a.width;
               String name="("+a.name+"|"+b.name+")";
               Node newNode=new Node(height,width,name);
               nodesList.addFirst(newNode);
               nodesList.remove(a);
               nodesList.remove(b);
               a=newNode;
               j--;
               i=nodesList.indexOf(a)-1;
//               if(i==0){
//                  i=-1;
//               }else {
//                  i=0;
//               }

            }else if(a.height == b.height){
               int height=a.height,width= a.width+b.width;
               String name="("+a.name+"-"+b.name+")";
               Node newNode=new Node(height,width,name);
               nodesList.addFirst(newNode);
               nodesList.remove(a);
               nodesList.remove(b);
               a=newNode;
               j--;
               i=nodesList.indexOf(a)-1;

//               if(i==0){
//                  i=-1;
//               }else {
                  //i=0;
//               }
            }
         }
      }



      System.out.println(nodesList);
      if(nodesList.size()==1){
         return true;
      }else {
         return false;
      }

   }
  
}
