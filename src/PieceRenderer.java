import javax.swing.*;
import java.awt.*;

public class PieceRenderer extends JComponent {

    int x;
    int y;

    int homex;
    int homey;

    static final int CELL_SIZE = 10;

    Polynomio piece;

    boolean selected = false;

    public PieceRenderer(int x, int y, Polynomio piece) {
        this.x = x;
        this.y = y;
        homex = x;
        homey = y;
        this.piece = piece;

    }

    public void paint(Graphics g)    {
        if(piece != null) {
            for (int i = 0; i < piece.getHeight(); i++) {
                for (int j = 0; j < piece.getWidth(); j++) {
                    if (piece.substance[i][j] != null) {
                        switch (piece.substance[i][j]) {
                            case gems:
                                g.setColor(Color.RED);
                                break;
                            case bronze:
                                g.setColor(Color.ORANGE);
                                break;
                            case gold:
                                g.setColor(Color.YELLOW);
                                break;
                            case fossils:
                                g.setColor(Color.GREEN);
                                break;
                            case silver:
                                g.setColor(Color.CYAN);
                                break;
                            case artifacts:
                                g.setColor(Color.MAGENTA);
                                break;
                            default:
                                break;
                        }
                        if (selected) g.setColor(makeTranslucent(g.getColor()));
                        g.fillRect(x + j * CELL_SIZE, y + i * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                    }
                }

            }

        }

    }

    public void goHome(){
        x = homex;
        y = homey;
    }

    public static Color makeTranslucent(Color original){
        float red = original.getRed()/256.0f;
        float green = original.getGreen()/256.0f;
        float blue = original.getBlue()/256.0f;
        return new Color(red, green, blue ,0.5f);
    }
}
