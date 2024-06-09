package soduku;

public class Puzzle {
    int [][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];// IF code does not work, try to use SUBGRID_SIZE

    public Puzzle(){
        super();
    }

    public void newPuzzle(int cellsToGuess){
        int [][] gridExample = {
                {5, 1, 9, 7, 2, 6, 8, 3, 4},
                {2, 8, 6, 3, 4, 5, 1, 9, 7},
                {3, 7, 4, 9, 8, 1, 5, 2, 6},
                {4, 3, 8, 5, 9, 2, 6, 7, 1},
                {6, 9, 2, 4, 7, 8, 3, 1, 5},
                {7, 5, 1, 6, 3, 9, 4, 8, 2},
                {8, 6, 7, 2, 5, 3, 9, 4, 1},
                {1, 4, 3, 8, 6, 7, 2, 5, 9},
                {9, 2, 5, 1, 1, 4, 7, 6, 8}};

        for (int row = 0;row < SudokuConstants.GRID_SIZE;row++){    // If code does not work, try ++row instead of row++
             for (int col = 0; col<SudokuConstants.GRID_SIZE; col ++){
                 numbers[row][col]=gridExample[row][col];
             }
        }
            boolean [][] hardcoded =
                    {{true, true, true, true, true, false, true, true, true},
                            {true, true, true, true, true, true, true, true, false},
                            {true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, false, true, true},
                            {true, true, true, true, true, true, true, true, true},
                            {true, true, false, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, false, true, true, true},
                            {true, true, true, true, true, true, true, true, true}};

        for (int row = 0; row< SudokuConstants.GRID_SIZE; row++){
            for (int col = 0; col< SudokuConstants.GRID_SIZE; col ++){
                isGiven[row][col] = hardcoded[row][col];
            }
        }


    }

}
