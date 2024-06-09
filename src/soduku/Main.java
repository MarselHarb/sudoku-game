package soduku;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    /* private static final long serialVersionUID = 1L;
    run the code without it, see if you get errors.
     */

    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    public Main(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        cp.add(btnNewGame, BorderLayout.SOUTH);
        btnNewGame.addActionListener(e -> board.newGame());

        board.newGame();

        setSize (800,600);// see if this can be replaced by pack()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main ();
            }
        });
    }


}
