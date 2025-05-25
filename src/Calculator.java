import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
    Font myFont = new Font("Arial", Font.BOLD, 20);
    double num1 = 0.0;
    double num2 = 0.0;
    double result = 0.0;
    char operator = 0;
    Calculator() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(516, 600);
        this.frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(100, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("←");
        clrButton = new JButton("Alles Löschen");
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = equButton;
        funcButtons[5] = decButton;
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

        delButton.setBounds(0, 500, 250, 50);
        clrButton.setBounds(250, 500, 250, 50);

        panel = new JPanel();
        panel.setBounds(0, 100, 500, 400);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.DARK_GRAY);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(funcButtons[0]);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(funcButtons[1]);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(funcButtons[2]);
        panel.add(funcButtons[5]);
        panel.add(numButtons[0]);
        panel.add(funcButtons[4]);
        panel.add(funcButtons[3]);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        //zahlen
        if (Arrays.stream(numButtons).anyMatch(button -> button == e.getSource())) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numButtons[i]) {
                    String text = textField.getText();
                    text = text + numButtons[i].getText();
                    textField.setText(text);
                }
            }
        }
        //operatoren
        else if (Arrays.stream(funcButtons).limit(4).anyMatch(button -> button == e.getSource()))
        {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            if (e.getSource() == funcButtons[0]) operator = '+';
            if (e.getSource() == funcButtons[1]) operator = '-';
            if (e.getSource() == funcButtons[2]) operator = '*';
            if (e.getSource() == funcButtons[3]) operator = '/';
        }
        //zurückbutton
        if (e.getSource() == funcButtons[6]) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    text = text.substring(0, text.length() - 1);
                    textField.setText(text);
                }
        }
        //löschen
        else if (e.getSource() == funcButtons[7])
        {
                textField.setText("");
                num1 = 0.0;
                num2 = 0.0;
                result = 0.0;
                operator = 0;
        }
        //dezimalpunkt
        else if (e.getSource() == funcButtons[5]) {
            String text = textField.getText();
            if (!text.contains(".")) {
                textField.setText(text + ".");
            }
        }
        //equals
        if (e.getSource() == funcButtons[4]) {
            if (operator == 0) return;
            switch (operator) {
                case '+':
                    num2 = Double.parseDouble(textField.getText());
                    result = num1 + num2;
                    textField.setText(String.valueOf(result));
                    break;
                case '-':
                    num2 = Double.parseDouble(textField.getText());
                    result = num1 - num2;
                    textField.setText(String.valueOf(result));
                    break;
                case '*':
                    num2 = Double.parseDouble(textField.getText());
                    result = num1 * num2;
                    break;
                case '/':
                    num2 = Double.parseDouble(textField.getText());
                    if (num2 == 0) {
                        textField.setText("Division durch Null nicht möglich");
                        operator = 0;
                        num1 = 0;
                        num2 = 0;
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            operator = 0;
            num1=result;
        }
    }
}
