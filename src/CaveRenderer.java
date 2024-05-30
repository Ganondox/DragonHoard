import javax.swing.*;
import java.awt.*;

public class CaveRenderer extends JComponent {

    Cave cave;
    int x;
    int y;
    PieceRenderer[][] mask;
    PieceRenderer rock;


    public CaveRenderer(Cave cave, int x, int y) {
        this.cave = cave;
        this.x = x;
        this.y = y;
        rock = new PieceRenderer(0,0,null);
        mask = new PieceRenderer[cave.board.length][cave.board[0].length];
        for(int i = 0; i < mask.length; i++){
            for(int j = 0; j < mask[0].length; j++){
                if(cave.board[i][j] == Polynomio.material.rock){
                    mask[i][j] = rock;
                }
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < cave.board.length; i++) {
            for (int j = 0; j < cave.board[0].length; j++) {
                if (cave.board[i][j] != null) {
                    switch (cave.board[i][j]) {
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
                        case rock:
                            g.setColor(Color.RED.darker());
                        default:
                            break;
                    }

                } else {
                    if( (i + j) % 2 == 0){
                        g.setColor(Color.ORANGE.darker().darker());
                    } else {
                        g.setColor(Color.ORANGE.darker());
                    }

                }
                g.fillRect(x + j * PieceRenderer.CELL_SIZE, y + i * PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE);

            }

        }
    }
}
