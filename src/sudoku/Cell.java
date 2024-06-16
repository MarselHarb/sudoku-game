package sudoku;



import java.awt.Font;
import java.io.Serial;
import javax.swing.JTextField;

public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L; // to prevent serial warning


    public static final Font FONT_Numbers = new Font("OCR A Extended", Font.PLAIN, 28);

    int row, col;

    public int getNumber() {
        return number;
    }

    int number;

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    CellStatus status;

    public Cell(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_Numbers);
    }

    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.GUESS;
        paint();
    }

    public void paint() {
        if(status.equals(CellStatus.GIVEN)){
            super.setText(String.valueOf(number));
        }

            super.setEditable(status.isEditable());
            super.setBackground(status.getBackgroundColor());
            super.setForeground(status.getForegroundColor());

    }
}
