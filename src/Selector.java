import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Selector extends JComponent {


    public CaveRenderer[] caves;
    DragonRenderer[] dragons;
    Player player;
    int curCave;
    int curDrag;
    boolean done = false;


    public Selector(Cave[] ocaves, Dragon[] odragons, Player player) {
        caves = new CaveRenderer[ocaves.length];
        dragons = new DragonRenderer[odragons.length];
        for (int i = 0; i < ocaves.length; i++) {
            caves[i] = new CaveRenderer(ocaves[i], 100, 100 + i * (100 + ocaves[0].board.length * PieceRenderer.CELL_SIZE));
        }
        for (int i = 0; i < odragons.length; i++) {
            dragons[i] = new DragonRenderer(odragons[i], 500, 100 + i * (100 + 7 * DragonRenderer.textHeight));
        }
        this.player = player;

        curDrag = -1;
        curCave = -1;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(player.name + ", pick your cave and your dragon, press s to start", 200, 50);
        //g.setColor(PieceRenderer.makeTranslucent(Color.WHITE));
        if (curDrag > -1) {
            DragonRenderer cur = dragons[curDrag];
            g.drawRect(cur.x - 10, cur.y - DragonRenderer.textHeight - 10, (cur.dragon.bronze.length + 1) * DragonRenderer.textWidth + 20, 7 * DragonRenderer.textHeight + 20);

        }
        if (curCave > -1) {
            CaveRenderer cur = caves[curCave];
            g.drawRect(cur.x - 10, cur.y - 10, cur.mask.length * PieceRenderer.CELL_SIZE + 20, cur.mask.length * PieceRenderer.CELL_SIZE + 20);

        }


    }

}
