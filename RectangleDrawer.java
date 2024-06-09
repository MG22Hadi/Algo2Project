import javax.swing.*;
import java.awt.*;

public class RectangleDrawer extends JFrame {
    private Node regtangleNode;
    JLabel label1= new JLabel("Rectangle before Flipping ");
    JLabel label2= new JLabel("Flipping a rectangle");
    Font font = new Font("Arial", Font.PLAIN, 20); // مشان تحديد حجم الأحرف

    public RectangleDrawer(Node regtangleNode) {
        //خصائص الفريم والبانيل
        this.regtangleNode = regtangleNode;
        this.setTitle("Rectangle swaping");
        this.setSize(800, 800);
        this.setBounds(710, 50, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label1.setBounds(200, 50, 300, 70);
        label1.setFont(font);
        label1.setForeground(Color.WHITE);
        label2.setBounds(200, 350, 300, 70);
        label2.setFont(font);
        label2.setForeground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);
        panel.add(label1);
        panel.add(label2);
        this.setContentPane(panel);
       // setLocationRelativeTo(null);
        this.setVisible(true);

    }

    // تابع جاهز بالسوينغ لاستدعي بقلبو توابع الرسم
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.drawRectangle(g, regtangleNode, regtangleNode.height, regtangleNode.width, 200,200,180);
        this.drawRectangle(g, regtangleNode, regtangleNode.width, regtangleNode.height, 300, 200,470);

    }

    //تابع رسم الشجرةالثنائية عالواجهة
    private void drawRectangle(Graphics g, Node node, int height, int width, int xOffset, int x,int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(99, 238, 229));
        g2d.fillRect(x,y, height, width);
        //g2d.drawRect();
        
    }
    
}
