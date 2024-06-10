package soduku;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;


public class Cell extends JTextField{
                                         //TODO  private static final long serialVersionUID = 1L;  // to prevent serial warning

    public static final Color BACKGROUND_Given = new Color(240,240,240);
    public static final Color FOREGROUND_Given = Color.BLACK;
    public static final Color BACKGROUND_Guess = Color.YELLOW;
    public static final Color FOREGROUND_NOT_Given =Color.GRAY;
    public static final Color BACKGROUND_Correct = new Color(0,216,0);
    public static final Color BACKGROUND_Wrong = new Color (216,0,0);
    public static final Font FONT_Numbers = new Font("OCR A Extended",Font.PLAIN,28);

    int row,col;
    int number;
    CellStatus status;

    public Cell(int row, int col){
        super();
        this.row=row;
        this.col=col;
    super.setHorizontalAlignment(JTextField.CENTER);
    super.setFont(FONT_Numbers);
    }
    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.GUESS;
        paint();
    }

    public void paint(){
        if(status == CellStatus.GIVEN) {
            super.setText(number + "");
            super.setEditable(false);
            super.setBackground(BACKGROUND_Given);
            super.setForeground(FOREGROUND_Given);
        } else if (status == CellStatus.GUESS){
            super.setText("");
            super.setEditable(true);
            super.setBackground(BACKGROUND_Guess);
            super.setForeground(FOREGROUND_NOT_Given);
        } else if (status == CellStatus.CORRECT){
            super.setBackground(BACKGROUND_Correct);
        } else if (status == CellStatus.WRONG){
            super.setBackground(BACKGROUND_Wrong);
        }
    }
}

