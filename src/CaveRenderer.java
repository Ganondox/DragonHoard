import javax.swing.*;
import java.awt.*;

public class CaveRenderer extends JComponent {

    Cave cave;
    int x;
    int y;
    PieceRenderer[][] mask;
    PieceRenderer rock;

    HoardRenderer hoard;

    PlayerRenderer player;


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

        hoard = new HoardRenderer(cave.getHoard(),x, y + (cave.board.length+1)*PieceRenderer.CELL_SIZE);
        player = null;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < cave.board.length; i++) {
            for (int j = 0; j < cave.board[0].length; j++) {
                if (cave.board[i][j] != null) {
                    switch (cave.board[i][j]) {
                        case gems:
                            g.setColor(Color.RED.darker());
                            break;
                        case bronze:
                            g.setColor(Color.ORANGE.darker());
                            break;
                        case gold:
                            g.setColor(Color.YELLOW.darker());
                            break;
                        case fossils:
                            g.setColor(Color.GREEN.darker());
                            break;
                        case silver:
                            g.setColor(Color.CYAN.darker());
                            break;
                        case artifacts:
                            g.setColor(Color.MAGENTA.darker());
                            break;
                        case rock:
                            g.setColor(Color.RED.darker().darker());
                        default:
                            break;
                    }

                } else {
                    if( (i + j) % 2 == 0){
                        g.setColor(Color.ORANGE.darker().darker().darker());
                    } else {
                        g.setColor(Color.ORANGE.darker().darker());
                    }

                }
                g.fillRect(x + j * PieceRenderer.CELL_SIZE, y + i * PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE);

            }

        }
    }
}
