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
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[8]; //array to store all function Buttons
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton; //Function Buttons
    JPanel panel;
    Font myFont = new Font("Arial", 1, 20);
    double num1 = (double)0.0F;
    double num2 = (double)0.0F;
    double result = (double)0.0F;
    char operator;

    Calculator() {
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(500, 600);
        this.frame.setLayout((LayoutManager)null);
        textField = new JTextField();
        textField.setBounds(85, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        delButton.setBounds(0, 200, 250, 50);
        clrButton.setBounds(250, 200, 250, 50);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
    }
}
