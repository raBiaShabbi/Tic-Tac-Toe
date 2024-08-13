import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame frame;
    static JPanel panel;
    static JButton []buttons = new JButton[9];
    static boolean isPlayerOneTurn = true;
    static int count = 0;

    public static void main(String[] args) {
        frame = new JFrame("Tic Tac Toe");

        ImageIcon icon = new ImageIcon("C:/Users/saadm/OneDrive/Desktop/summer bootcamp/A6/Tic Tac Toe/img.png");
        Image image = icon.getImage();

        Image resizedImage = image.getScaledInstance(32,32,Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        frame.setIconImage(resizedIcon.getImage());

        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setBounds(500,200,500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBorder(new LineBorder(Color.RED,8));
        panel.setBounds(43,30,400,400);
        panel.setLayout(new GridLayout(3,3));
        panel.setVisible(true);

        int option = JOptionPane.showConfirmDialog(frame, "Do you want to start the game?", "Start Game", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            game();

        }
        else{
            frame.dispose();
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void game(){
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("my font",Font.PLAIN,60));
            buttons[i].setFocusPainted(false);
            panel.add(buttons[i]);
            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttons[finalI].getText().equals("")) {
                        if (isPlayerOneTurn) {
                            buttons[finalI].setText("O");
                            buttons[finalI].setBackground(Color.PINK);
                        } else {
                            buttons[finalI].setText("X");
                            buttons[finalI].setBackground(Color.PINK);
                        }
                    }
                    count++;
                    isPlayerOneTurn = !isPlayerOneTurn;

                    if(!checkForWin()){
                        checkForDraw();
                    }
                }
            });
        }
    }

    private static void checkForDraw(){
        if (count == 9) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            closeGame();
        }
    }

    public static boolean checkForWin(){
        if (checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8)) {
            announceWinner();
            return true;
        }

        else if (checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8)) {
            announceWinner();
            return true;
        }

        else if (checkLine(0, 4, 8) || checkLine(2, 4, 6)) {
            announceWinner();
            return true;
        }

        return false;
    }

    public static boolean checkLine(int a , int b , int c){
        String str1 = buttons[a].getText();
        String str2 = buttons[b].getText();
        String str3 = buttons[c].getText();

        if(!(str1.isEmpty()) && str1.equals(str2) && str2.equals(str3)){
            return true;
        }
        return false;
    }

    public static void announceWinner(){
        String winner = new String();
        if (!isPlayerOneTurn){
            winner = "Player One (o)";
        }
        else {
            winner = "Player Two (X)";
        }

        JOptionPane.showMessageDialog(frame, winner + " wins!");
        closeGame();
    }

    private static void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
            button.setBackground(Color.PINK);
        }
        isPlayerOneTurn = true;
        count = 0;
    }

    private static void closeGame() {
        int option = JOptionPane.showConfirmDialog(frame, "Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            frame.dispose();
        }
    }
}