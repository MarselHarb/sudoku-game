package soduku;


import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class GameBoardPanel extends JPanel {
    /* private static final long serialVersionUID = 1L;
    check how this code runs without serialization */

    public static final int CELL_SIZE = 60;
    public static final int BOARD_WIDTH = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;


    private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    private Puzzle puzzle = new Puzzle();

    public GameBoardPanel(){

        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE,SudokuConstants.GRID_SIZE));
        for (int row = 0; row< SudokuConstants.GRID_SIZE; ++ row){
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++ col ){
                cells[row][col]= new Cell(row,col);
                super.add(cells[row][col]);
            }

        }
        KeyInputListener keyListener = new KeyInputListener();
        MouseInputListener mouseListener = new MouseInputListener();

        for (int row =0; row<SudokuConstants.GRID_SIZE; ++row){
            for (int col = 0; col<SudokuConstants.GRID_SIZE; ++col){
                if (cells[row][col].isEditable()){
                    cells[row][col].addKeyListener(keyListener);
                    cells[row][col].addMouseListener(mouseListener);

                }
            }
        }


        super.setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));
    }

    public void newGame(){
        puzzle.newPuzzle(2);
        // this is used to set up the difficulty of the gameBoard

        for (int row = 0; row<SudokuConstants.GRID_SIZE; ++row){
            for (int col = 0; col<SudokuConstants.GRID_SIZE; ++col){
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
    }



    public boolean isSolved(){
        for (int row =0; row< SudokuConstants.GRID_SIZE; ++row){
            for (int col = 0; col< SudokuConstants.GRID_SIZE; ++ col){
                if (cells[row][col].status==CellStatus.GUESS|| cells[row][col].status == CellStatus.WRONG){
                    return false;
                }
            }
        }
        return true;
    }

    //define a listener Inner class for all the editable cells

    public static class KeyInputListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Handle key typed event
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    // Define a MouseListener Inner class for all the editable cells
    public static class MouseInputListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Cell sourceCell = (Cell) e.getSource();
            System.out.println("Cell clicked: " + sourceCell.getText());
            // You can add additional logic for mouse click if needed
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Handle mouse pressed event
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Handle mouse released event
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Handle mouse entered event
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Handle mouse exited event
        }
    }
}