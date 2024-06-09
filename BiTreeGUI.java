import javax.swing.*;
import java.awt.*;

public class BiTreeGUI extends JFrame {
    private Node binaryRoot;

    public BiTreeGUI(Node binaryRoot) {
        // خصائص الفريم والبانيل
        this.binaryRoot = binaryRoot;
        this.setTitle("Binary Tree Drawing");
        this.setSize(800, 800);
        this.setBounds(710, 20, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a dark gray background
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 2000); // set a large preferred height
            }
        };
        panel.setBackground(Color.darkGray);

        // // Create a JScrollPane and add the panel to it
        // JScrollPane scrollPane = new JScrollPane(panel);
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // // Add the scroll pane to the frame
        // this.setContentPane(scrollPane);

        // setLocationRelativeTo(null);
        this.add(panel);
        this.setVisible(true);
    }

    // تابع جاهز بالسوينغ لاستدعي بقلبو توابع الرسم
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.drawBTree(g, binaryRoot, 350, 50, 200);
    }

    //تابع رسم الشجرةالثنائية عالواجهة
    private void drawBTree(Graphics g, Node node, int x, int y, int xOffset) {
        if (node != null) {
            g.setColor(new Color(93, 250, 240));
            g.fillOval(x, y, 60, 60);
            g.setColor(new Color(46, 69, 68));
            Font font = new Font("Arial", Font.PLAIN, 20); // مشان تحديد حجم الأحرف
            g.setFont(font);
            g.drawString(String.valueOf(node.name),  x + 21, y + 35);

        if (node.left != null) {
                g.setColor(Color.white);
                g.drawLine(x + 30, y + 60, x - xOffset + 30, y + 120);
                g.setColor(new Color(93, 250, 240));
                this.drawBTree(g, node.left, x - xOffset, y + 120, xOffset / 2);
            }

        if (node.right != null) {
                g.setColor(Color.white);
                g.drawLine(x + 30, y + 60, x + xOffset + 30, y + 120);
                g.setColor(new Color(93, 250, 240));
                this.drawBTree(g, node.right, x + xOffset, y + 120, xOffset / 2);

            }
        }
    }
}
    
   
