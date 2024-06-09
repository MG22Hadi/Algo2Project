import java.util.ArrayList;
import java.util.List;

public class RectangleCover {

    public static boolean coverRectangles(int bigRectangleWidth, int bigRectangleHeight, List<leafNode> smallleafNodes) {
        boolean[][] matrix = new boolean[bigRectangleHeight][bigRectangleWidth];

        for (leafNode smallleafNode : smallleafNodes) {
            int smallleafNodeWidth = smallleafNode.width;
            int smallleafNodeHeight = smallleafNode.height;

            outerloop:
            for (int i = 0; i < bigRectangleHeight; i++) {
                for (int j = 0; j < bigRectangleWidth; j++) {
                    if (isValidPosition(matrix, i, j, smallleafNodeHeight, smallleafNodeWidth)) {
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
        
            System.out.println("Matrix after filling:");
                for (int i = 0; i < bigRectangleHeight; i++) {
                    for (int j = 0; j < bigRectangleWidth; j++) {
                        System.out.print(matrix[i][j]? "T " : "F ");
                    }
                    System.out.println();
                }
        for (int i = 0; i < bigRectangleHeight; i++) {
            for (int j = 0; j < bigRectangleWidth; j++) {
                if (!matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidPosition(boolean[][] matrix, int row, int col, int smallleafNodeHeight, int smallleafNodeWidth) {
        return row >= 0 && row + smallleafNodeHeight <= matrix.length && col >= 0 && col + smallleafNodeWidth <= matrix[0].length &&
              !isOverlapping(matrix, row, col, smallleafNodeHeight, smallleafNodeWidth);
    }

    private static boolean isOverlapping(boolean[][] matrix, int row, int col, int smallleafNodeHeight, int smallleafNodeWidth) {
        for (int i = row; i < row + smallleafNodeHeight; i++) {
            for (int j = col; j < col + smallleafNodeWidth; j++) {
                if (matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<leafNode> smallleafNodes = new ArrayList<>();
        smallleafNodes.add(new leafNode(20, 10));
        smallleafNodes.add(new leafNode(20, 10));
        smallleafNodes.add(new leafNode(30, 10));
        smallleafNodes.add(new leafNode(30, 50));
        smallleafNodes.add(new leafNode(40, 30));
        smallleafNodes.add(new leafNode(40, 20));
        //smallleafNodes.add(new leafNode(3, 3));
        // smallleafNodes.add(new leafNode(4, 3));
        // smallleafNodes.add(new leafNode(5, 5));
        // smallleafNodes.add(new leafNode(1, 5));
        // smallleafNodes.add(new leafNode(6, 2));
        // smallleafNodes.add(new leafNode(6, 3));
        // smallleafNodes.add(new leafNode(14, 1));
        
        int bigRectangleWidth = 70;
        int bigRectangleHeight = 60;

        if (coverRectangles(bigRectangleWidth, bigRectangleHeight, smallleafNodes)) {
            System.out.println("The large rectangle can be covered successfully!");
        } else {
            System.out.println("The large rectangle cannot be covered.");
        }
    }
}