import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    JFrame frame = new JFrame("Rechner");
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[8];
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton decButton;
    JButton equButton;
    JButton delButton;
    JButton clrButton;
    JPanel panel;
    Font myFont = new Font("Arial", 1, 35);
    double num1 = (double)0.0F;
    double num2 = (double)0.0F;
    double result = (double)0.0F;
    char operator;

    Calculator() {
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(500, 600);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
    }
}
