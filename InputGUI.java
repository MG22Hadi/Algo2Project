import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class InputGUI extends JFrame {
    BinaryTree tree = new BinaryTree();
    String str = "";
    JTextField textField = new JTextField("Write your Excpression");
    Font font = new Font("Arial", Font.PLAIN, 20); // مشان تحديد حجم الأحرف
    JButton button = new JButton("Click");
     public InputGUI(){
        this.setTitle("Input Of BinaryTree");
        this.setBounds(100, 20, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField.setBounds(100,300,600,200);
        button.setBounds(330, 530, 150, 70);
        button.setBackground(new Color(93, 250, 240));
        textField.setFont(font);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                textField.setText("");
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                str = textField.getText();
                BiTreeGUI biTreeGUI = new BiTreeGUI(tree.storeNum(str));
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        panel.add(textField);
        panel.add(button);
        this.setContentPane(panel);
        this.setVisible(true);

       
        
    }
    
}
