package sudoku;

import java.awt.*;

public enum CellStatus {
    GIVEN(Color.WHITE,Color.black,false),
    GUESS(Color.yellow, Color.gray,true),
    CORRECT(Color.green,Color.gray,true),
    WRONG(Color.red,Color.gray,true);

    private final Color backgroundColor;
    private final Color foregroundColor;
    private final boolean editable;



    CellStatus(Color backgroundColor, Color foregroundColor, boolean editable) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.editable = editable;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public Color getForegroundColor() {
        return foregroundColor;
    }

    public boolean isEditable() {
        return editable;
    }
}

