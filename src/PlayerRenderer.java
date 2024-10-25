import javax.swing.*;
import java.awt.*;

public class PlayerRenderer extends JComponent {

    Player player;
    CaveRenderer caveRenderer;
    DragonRenderer dragonRenderer;
    int x;
    int y;

    int HOARD_WIDTH = 180;

    public PlayerRenderer(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
        caveRenderer = new CaveRenderer(player.board, x, y + DragonRenderer.textHeight);
        caveRenderer.player = this;
        dragonRenderer = new DragonRenderer(player.score, x + HOARD_WIDTH, y+DragonRenderer.textHeight+5);
        dragonRenderer.hoard = caveRenderer.cave.getHoard();

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(player.name, x,y);


    }

}
