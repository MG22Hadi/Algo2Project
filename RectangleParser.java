import java.util.Stack;

public class RectangleParser {
    public static Rectangle parseRectangle(String expression) {
        // tokenize the expression
        String[] tokens = expression.split("\\s+");

        // create a stack to store the rectangles
        Stack<Rectangle> stack = new Stack<>();

        // iterate over the tokens
        for (String token : tokens) {
            if (token.equals("|")) {
                // check if the stack has at least two elements
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid expression");
                }
                // pop two rectangles from the stack and combine them horizontally
                Rectangle r2 = stack.pop();
                Rectangle r1 = stack.pop();
                stack.push(new Rectangle(r1.getWidth() + r2.getWidth(), Math.max(r1.getHeight(), r2.getHeight())));
            } else if (token.equals("-")) {
                // check if the stack has at least two elements
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid expression");
                }
                // pop two rectangles from the stack and combine them vertically
                Rectangle r2 = stack.pop();
                Rectangle r1 = stack.pop();
                stack.push(new Rectangle(Math.max(r1.getWidth(), r2.getWidth()), r1.getHeight() + r2.getHeight()));
            } else if (token.startsWith("(") && token.endsWith(")")) {
                // create a new rectangle from the token
                String[] dims = token.substring(1, token.length() - 1).split(",");
                int width = Integer.parseInt(dims[0].replaceAll("[^0-9]", ""));
                int height = Integer.parseInt(dims[1].replaceAll("[^0-9]", ""));
                stack.push(new Rectangle(width, height));
            } else if (token.equals("(") || token.equals(")")) {
                // ignore parentheses
                continue;
            } else {
                // create a new rectangle from the token
                String[] dims = token.split(",");
                int width = Integer.parseInt(dims[0].replaceAll("[^0-9]", ""));
                int height = Integer.parseInt(dims[1].replaceAll("[^0-9]", ""));
                stack.push(new Rectangle(width, height));
            }
        }

        // check if the stack has exactly one element
        if (stack.size() != 1) {
            throw new RuntimeException("Invalid expression");
        }

        // return the final rectangle
        return stack.pop();
    }

    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        String expression = "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
        Rectangle result = parseRectangle(expression);
        System.out.println("Width: " + result.getWidth() + ", Height: " + result.getHeight());
    }
}