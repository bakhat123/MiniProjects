import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame {
    private JButton[] button = new JButton[15];
    private JLabel screen;
    private JPanel p1, p2;

    private double temp;
    private char operator;

    Calculator() {
        super("Calculator");
        p1 = new JPanel();
        p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 3));

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color buttonColor = new Color(200, 200, 200);
        Color functionButtonTextColor = Color.WHITE;

        for (int i = 9; i >= 0; i--) {
            button[i] = new JButton("" + i);
            button[i].setFont(buttonFont);
            button[i].setBackground(buttonColor);
            p2.add(button[i]);
        }

        button[10] = new JButton("+");
        button[11] = new JButton("-");
        button[12] = new JButton("*");
        button[13] = new JButton("/");
        button[14] = new JButton("=");

        for (int i = 10; i < 15; i++) {
            button[i].setFont(buttonFont);
            button[i].setBackground(buttonColor);
            button[i].setForeground(functionButtonTextColor);
            p2.add(button[i]);
        }

        screen = new JLabel(" ");
        screen.setFont(new Font("Arial", Font.PLAIN, 30)); // Screen font
        p1.add(screen);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        for (int i = 0; i < 10; i++) {
            final int c = i;
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = button[c].getText();
                    String p = screen.getText();
                    screen.setText(p + s);
                }
            });
        }

        for (int i = 10; i < 14; i++) {
            final char op = button[i].getText().charAt(0);
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!screen.getText().isEmpty()) {
                        temp = Double.parseDouble(screen.getText());
                        screen.setText(" "); // Clear the screen
                        operator = op; // Store the operator
                    }
                }
            });
        }

        button[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!screen.getText().isEmpty()) {
                    double b = Double.parseDouble(screen.getText());
                    double result = 0;
                    switch (operator) {
                        case '+':
                            result = temp + b;
                            break;
                        case '-':
                            result = temp - b;
                            break;
                        case '*':
                            result = temp * b;
                            break;
                        case '/':
                            if (b != 0) {
                                result = temp / b;
                            } else {
                                JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                                screen.setText(" ");
                                return;
                            }
                            break;
                    }
                    screen.setText(String.valueOf(result));
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }}
