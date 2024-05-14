import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game extends JFrame {
    private JButton[] buttons = new JButton[9];
    private String[] board = new String[9];
    private int count = 0;

    Game() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        getContentPane().setBackground(Color.BLACK);
        Border purpleBorder = BorderFactory.createLineBorder(Color.MAGENTA, 5);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].setForeground(Color.RED);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setBorder(purpleBorder);

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton)e.getSource();
                    if (!clickedButton.getText().equals("")) {
                        return;
                    }
                    if (count % 2 == 0) {
                        clickedButton.setText("X");
                        clickedButton.setForeground(Color.CYAN);
                    } else {
                        clickedButton.setText("O");
                        clickedButton.setForeground(Color.RED);
                    }
                    count++;
                    checkForWin();
                }
            });
            add(buttons[i]);
        }
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkForWin() {
        for (int i = 0; i < 9; i++) {
            board[i] = buttons[i].getText();
        }
        if (       (board[0].equals("X") && board[1].equals("X") && board[2].equals("X"))
                || (board[3].equals("X") && board[4].equals("X") && board[5].equals("X"))
                || (board[6].equals("X") && board[7].equals("X") && board[8].equals("X"))
                || (board[0].equals("X") && board[3].equals("X") && board[6].equals("X"))
                || (board[1].equals("X") && board[4].equals("X") && board[7].equals("X"))
                || (board[2].equals("X") && board[5].equals("X") && board[8].equals("X"))
                || (board[0].equals("X") && board[4].equals("X") && board[8].equals("X"))
                || (board[2].equals("X") && board[4].equals("X") && board[6].equals("X"))) {
            JOptionPane.showMessageDialog(null, "Player 1 wins!");
            resetGame();
        }

        if (        (board[0].equals("O") && board[1].equals("O") && board[2].equals("O"))
                || (board[3].equals("O") && board[4].equals("O") && board[5].equals("O"))
                || (board[6].equals("O") && board[7].equals("O") && board[8].equals("O"))
                || (board[0].equals("O") && board[3].equals("O") && board[6].equals("O"))
                || (board[1].equals("O") && board[4].equals("O") && board[7].equals("O"))
                || (board[2].equals("O") && board[5].equals("O") && board[8].equals("O"))
                || (board[0].equals("O") && board[4].equals("O") && board[8].equals("O"))
                || (board[2].equals("O") && board[4].equals("O") && board[6].equals("O"))) {
            JOptionPane.showMessageDialog(null, "Player 2 wins!");
            resetGame();
        }

    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
            button.setForeground(Color.RED); // Reset text color
        }
        count = 0;
    }
}

public class Main{
    public static void main(String[] args) {
        new Game();
    }
}

