import java.util.ArrayList;
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
//;ssssssssss
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
      makeTree(temp);

   }
   public void makeTree(String s){
      int sBracket=0, eBracket=0,indexF=0;
      String sub;
      makeTreeStack=new Stack();
      for (int i= 0;i<s.length();i++){
         if(s.charAt(i)=='('&&sBracket==0) {
            sBracket++;
            indexF=i;
            continue;
         }
         if(s.charAt(i)=='('){
            sBracket++;
         }
         if(s.charAt(i)==')')
            eBracket++;
         if(sBracket==eBracket && sBracket>0){
            if((i+1<s.length())&&(s.charAt(i+1)=='-'||s.charAt(i+1)=='|')){
               char op=s.charAt(i+1);
               String opp=String.valueOf(op);
               makeTreeStack.push(opp);
            }
            sub=s.substring(indexF+1,i);
            makeTreeStack.push(sub);
            sBracket=eBracket=0;
         }

      }
      System.out.println(makeTreeStack.toString());
      String t0=makeTreeStack.pop(),t1=makeTreeStack.pop(),t2=makeTreeStack.pop();
      root =new Node(t2);
      root.left=new Node(t1);
      root.right=new Node(t0);

      System.out.println(root.toString());


   }
  
}

