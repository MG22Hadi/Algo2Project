import java.util.*;

public class Permutations {


    public  boolean coverRectangles(int bigRectangleWidth, int bigRectangleHeight, List<Node> smallleafNodes) {
        try {
            boolean[][] matrix = new boolean[bigRectangleHeight][bigRectangleWidth];
            for (int i = 0; i < bigRectangleHeight; i++) {
                for (int j = 0; j < bigRectangleWidth; j++) {
                    matrix[i][j] = false;
                }
            }
  
            for (Node smallleafNode : smallleafNodes) {
                int smallleafNodeWidth = smallleafNode.width;
                int smallleafNodeHeight = smallleafNode.height;
  
                outerloop:
                for (int i = 0; i < bigRectangleHeight; i++) {
                    for (int j = 0; j < bigRectangleWidth; j++) {
                        if (isValidPosition(matrix, bigRectangleWidth, bigRectangleHeight, i, j, smallleafNodeHeight, smallleafNodeWidth)) {
                            for (int k = i; k < i + smallleafNodeHeight; k++) {
                                for (int l = j; l < j + smallleafNodeWidth; l++) {
                                    matrix[k][l] = true;
                                }
                            }
                            break outerloop; // Exit inner loop if successfully placed
                        }
                    }
                }
            }
            // System.out.println("Matrix after filling:");
            // for (int i = 0; i < bigRectangleHeight; i++) {
            //     for (int j = 0; j < bigRectangleWidth; j++) {
            //         System.out.print(matrix[i][j]? "T " : "F ");
            //     }
            //     System.out.println();
            // }
  
            for (int i = 0; i < bigRectangleHeight; i++) {
                for (int j = 0; j < bigRectangleWidth; j++) {
                    if (!matrix[i][j]) {
                        return false;
                    }
                }
            }
  
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("");
            return false;
        }
    }
  
    private  boolean isValidPosition(boolean[][] matrix, int bigRectangleWidth, int bigRectangleHeight,
                                          int row, int col, int smallleafNodeHeight, int smallleafNodeWidth) {
        // Check if the placement goes out of bounds
        return row >= 0 && row < bigRectangleHeight && col >= 0 && col < bigRectangleWidth &&
              !isOverlapping(matrix, bigRectangleWidth, bigRectangleHeight, row, col, smallleafNodeHeight, smallleafNodeWidth);
    }
  
    private  boolean isOverlapping(boolean[][] matrix, int bigRectangleWidth, int bigRectangleHeight,
                                          int row, int col, int smallleafNodeHeight, int smallleafNodeWidth) {
        // Check for overlap within the small leafNode's footprint
        for (int i = row; i < row + smallleafNodeHeight; i++) {
            for (int j = col; j < col + smallleafNodeWidth; j++) {
                if (i < bigRectangleHeight && j < bigRectangleWidth && matrix[i][j]) {
                    return true;
                }
            }
        }
  
        return false;
    }
  
    //تابع لايجاد تباديل الاحرف ووضعها في مصفوفة 
    public  List<List<Node>> getPermutations(List<Node> nodes) {
        List<List<Node>> permutations = new ArrayList<>();
        for (List<Node> permutation : permutations(nodes)) {
            permutations.add(permutation);
        }
        return permutations;
    }
    
    private  Iterable<List<Node>> permutations(List<Node> nodes) {
        if (nodes.size() == 1) {
            List<List<Node>> result = new ArrayList<>();
            result.add(new ArrayList<>(nodes));
            return result;
        }
    
        Node first = nodes.get(0);
        List<Node> rest = new ArrayList<>(nodes);
        rest.remove(0);
    
        List<List<Node>> permutations = new ArrayList<>();
        for (List<Node> permutation : permutations(rest)) {
            for (int i = 0; i <= permutation.size(); i++) {
                List<Node> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(i, first);
                permutations.add(newPermutation);
            }
        }
    
        return permutations;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //تابع لحساب المساحة الكلية للاوراق 
    public  int getTotalArea(List<Node> papers) {
        int totalArea = 0;
        for (Node paper : papers) {
            totalArea += paper.getArea();
        }
        return totalArea;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //تابع لايجاد ابعاد المستطيلات الممكنة من مساحة المستطيل الرئيسي
    public  List<Node> getRectangles(int targetArea) {
        List<Node> rectangles = new ArrayList<>();

        for (int length = 1; length <= Math.sqrt(targetArea); length++) {
            for (int width = 1; width <= targetArea / length; width++) {
                if (length * width == targetArea) {
                    rectangles.add(new Node(length, width));
                    rectangles.add(new Node(width, length));
                }
            }
        }

        return rectangles;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //تابع يستقبل قائمة الابعاد وقائمة التباديل 
    public  boolean isMakeRectangle(List<Node> dimensions, List<List<Node>> permutations){
        int bigRectangleWidth = 0;
        int bigRectangleHeight = 0;
        for (int i = 0; i < dimensions.size(); i++) {
            bigRectangleHeight=dimensions.get(i).height;
            bigRectangleWidth=dimensions.get(i).width;
            for (int j = 0; j < permutations.size(); j++) {
                if (coverRectangles(bigRectangleWidth, bigRectangleHeight, permutations.get(j))) {
                    //System.out.println("The large rectangle can be covered successfully!");
                    return true;
                } 
                
            }
        }
        return false;
    }
    public  int countMakeableRectangles(List<Node> dimensions, List<List<Node>> permutations){
        int count = 0;
        int bigRectangleWidth = 0;
        int bigRectangleHeight = 0;
        for (int i = 0; i < dimensions.size(); i++) {
            bigRectangleHeight=dimensions.get(i).height;
            bigRectangleWidth=dimensions.get(i).width;
            for (int j = 0; j < permutations.size(); j++) {
                if (coverRectangles(bigRectangleWidth, bigRectangleHeight, permutations.get(j))) {
                    count++; // increment the counter
                    //System.out.println("The large rectangle can be covered successfully!");
                } 
            }
        }
        return count;
    }
    public void isRect(List<Node> leafNodes ){
        List<List<Node>> permutations = getPermutations((leafNodes));
        List<Node> rectangles =getRectangles(getTotalArea(leafNodes));
        long startTime = System.currentTimeMillis();
        System.out.println(isMakeRectangle(rectangles, permutations));
        System.out.println(" " + countMakeableRectangles(rectangles, permutations) + " Rectangles");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("time " + executionTime + " ");
    }
   
}
