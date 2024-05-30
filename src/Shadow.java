import javax.swing.*;
import java.awt.*;

public class Shadow extends JComponent {

    PieceRenderer piece;
    PieceRenderer[][] pit;
    int pitx;
    int pity;
    int x;
    int y;
    boolean good = false;
    boolean visible = false;

    public Shadow(PieceRenderer[][] pit, int pitx, int pity) {
        this.pit = pit;
        this.pitx = pitx;
        this.pity = pity;
    }

    public void test(){
        good = true;
        if(pit.length >= y + piece.piece.getHeight() && pit[0].length >= x + piece.piece.getWidth()) {
            for (int i = 0; i < piece.piece.getWidth(); i++) {
                for (int j = 0; j < piece.piece.getHeight(); j++) {
                    if (piece.piece.substance[j][i] != null) {
                        if (pit[y + j][x + i] != null && pit[y + j][x + i] != piece) good = false;
                    }

                }

            }
        } else {
            good = false;
        }
    }


    public void paint(Graphics g)    {

        if(visible) {

            test();

            if (good) g.setColor(Color.LIGHT_GRAY);
            else g.setColor(Color.DARK_GRAY);



            for (int i = 0; i < piece.piece.getHeight(); i++) {
                for (int j = 0; j < piece.piece.getWidth(); j++) {
                    if (piece.piece.substance[i][j] != null) {
                        g.fillRect(pitx + (x + j) * PieceRenderer.CELL_SIZE, pity + (y + i) * PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE);
                    }
                }

            }
        }
    }

}
