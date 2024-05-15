import javax.swing.*;
import java.awt.*;

public class PieceRenderer extends JComponent {

    int x;
    int y;

    static final int CELL_SIZE = 10;

    Polynomio piece;

    public PieceRenderer(int x, int y, Polynomio piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public void paint(Graphics g)    {
        for (int i = 0; i < piece.getHeight(); i++){
            for(int j = 0; j < piece.getWidth(); j++) {
                if(piece.substance[i][j] != null){
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
                    g.fillRect(x + j * CELL_SIZE, y + i * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                }
            }

        }

    }

}
