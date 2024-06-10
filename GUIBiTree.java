import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIBiTree extends JFrame {
    private Node binaryRoot;

    public GUIBiTree(Node binaryRoot) {
        // خصائص الفريم والبانيل
        this.binaryRoot = binaryRoot;
        this.setTitle("Binary Tree Drawing");
        this.setSize(800, 800);
        this.setBounds(710, 20, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a dark gray background
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                drawBTree(g, binaryRoot, 300, 50, 200);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);

        panel.add(Box.createVerticalGlue());

        JLabel thankLabel = new JLabel("Thank");
        thankLabel.setForeground(Color.pink);
        panel.add(thankLabel);

        panel.setPreferredSize(new Dimension(800, 1000));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                panel.repaint();
            }
        });

        this.setContentPane(scrollPane);
        setVisible(true);
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
    
   
