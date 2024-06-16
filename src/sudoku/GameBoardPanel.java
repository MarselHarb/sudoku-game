package sudoku;


import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class GameBoardPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final int CELL_SIZE = 60;
    public static final int BOARD_WIDTH = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;

    private final Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    private final Puzzle puzzle = new Puzzle();

    public GameBoardPanel() {
        super.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col] = new Cell(row, col);
                gridPanel.add(cells[row][col]);
            }
        }

        KeyInputListener keyListener = new KeyInputListener();
        MouseInputListener mouseListener = new MouseInputListener();

        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {

                cells[row][col].addKeyListener(keyListener);
                cells[row][col].addMouseListener(mouseListener);

            }
        }
        super.add(gridPanel, BorderLayout.CENTER);

        JButton checkButton = new JButton("Check Solution");
        checkButton.addActionListener(e -> {
            if (isSolved()) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've solved the puzzle!");
            } else {
                JOptionPane.showMessageDialog(null, "The puzzle is not solved yet.");
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(checkButton);
        super.add(controlPanel, BorderLayout.SOUTH);
        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    public void newGame() {
        puzzle.newPuzzle(5);

        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
    }

    public boolean isSolved() {
//TODO transfer to streams ( 2d arrays to 1d and find wrong)
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                Cell cell = cells[row][col];
                if(cell.status.equals(CellStatus.GIVEN))
                    continue;
                if(cell.getText().equals(String.valueOf(cell.getNumber()))){
                    cell.setStatus(CellStatus.CORRECT);
                } else {
                    cell.setStatus(CellStatus.WRONG);
                }
                cell.paint();

            }
        }
        //TODO transfer to streams ( 2d arrays to 1d and find wrong)
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                if (cells[row][col].status == CellStatus.GUESS || cells[row][col].status == CellStatus.WRONG) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static class KeyInputListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            Cell sourceCell = (Cell) e.getSource();
            String inputText = String.valueOf(e.getKeyChar());
            System.out.println(inputText);

            if (isNumeric(inputText)) {
                int numberIn = Integer.parseInt(inputText);
                System.out.println("You entered " + numberIn);
                sourceCell.setText(inputText);

//                if (numberIn == sourceCell.number) {
//                    sourceCell.status = CellStatus.CORRECT;
//                } else{
//                    sourceCell.status = CellStatus.WRONG;
//                }


            } else {
                System.out.println("Invalid input");
                sourceCell.setStatus(CellStatus.GUESS);

            }
            sourceCell.paint();

            e.consume();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }


    }

    public static class MouseInputListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Cell sourceCell = (Cell) e.getSource();
            System.out.println("Cell clicked: " + sourceCell.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
