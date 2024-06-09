package soduku;


import javax.swing.*;
import java.awt.*;

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
        cells [0][0].status= CellStatus.GIVEN;
            /* common listener input here
            add common listener to all editable cells
             */

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

}