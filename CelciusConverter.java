import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scale Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(170, 260, 150, 30);
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
        textField.setBorder(BorderFactory.createLineBorder(Color.red, 4));

        JLabel jLabel = new JLabel();
        jLabel.setBounds(170,300,150,30);
        jLabel.setBackground(Color.WHITE);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jLabel.setBorder(BorderFactory.createLineBorder(Color.red, 4));

        JButton button = new JButton();
        button.setBounds(170, 340, 80, 25);
        button.setBackground(Color.white);
        button.setText("Click");
        button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.red,4));


        JLabel jLabel2 = new JLabel();
        jLabel2.setBounds(20,0,500,200);
        jLabel2.setBackground(Color.WHITE);
        jLabel2.setText("Celsius converter");
        jLabel2.setForeground(Color.red);
        jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 60));

        frame.add(textField);
        frame.add(jLabel);
        frame.add(button);
        frame.add(jLabel2);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float fahrenheit = Float.parseFloat(textField.getText());
                float celsius = (float) 5/9 *(fahrenheit - 32);

                jLabel.setText(Float.toString(celsius));

            }
        });
        frame.setVisible(true);
    }
}
