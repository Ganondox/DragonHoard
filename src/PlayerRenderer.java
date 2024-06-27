import javax.swing.*;
import java.awt.*;

public class PlayerRenderer extends JComponent {

    Player player;
    CaveRenderer caveRenderer;
    DragonRenderer dragonRenderer;
    int x;
    int y;

    public PlayerRenderer(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
        caveRenderer = new CaveRenderer(player.board, x , y + DragonRenderer.textHeight);
        caveRenderer.player = this;
        dragonRenderer = new DragonRenderer(player.score, x, y+(player.board.board.length+1)*PieceRenderer.CELL_SIZE+2*DragonRenderer.textHeight);
        dragonRenderer.hoard = caveRenderer.cave.getHoard();

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(player.name, x,y);


    }

}
