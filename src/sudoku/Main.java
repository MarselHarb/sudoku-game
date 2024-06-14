package sudoku;


import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Main extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

     GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    public Main() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(btnNewGame);
        cp.add(controlPanel, BorderLayout.SOUTH);

        btnNewGame.addActionListener(e -> board.newGame());

        board.newGame();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}