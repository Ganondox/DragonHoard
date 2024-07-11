import javax.swing.*;
import java.awt.*;

public class HoardRenderer extends JComponent {

    Hoard hoard;
    int x;
    int y;

    public HoardRenderer(Hoard hoard, int x, int y) {
        this.hoard = hoard;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {

        System.out.println("hoarding time");

        g.setColor(Color.ORANGE.darker());
        g.drawString("b: " + hoard.bronze, x,y);
        g.setColor(Color.CYAN.darker());
        g.drawString("s: " + hoard.silver, x + DragonRenderer.textWidth,y);
        g.setColor(Color.YELLOW.darker());
        g.drawString("g: " + hoard.gold, x + 2*DragonRenderer.textWidth,y);
        g.setColor(Color.MAGENTA.darker());
        g.drawString("a: " + hoard.artifacts, x + 3*DragonRenderer.textWidth,y);
        g.setColor(Color.RED.darker());
        g.drawString("G: " + hoard.gems, x + 4*DragonRenderer.textWidth,y);
        g.setColor(Color.GREEN.darker());
        g.drawString("f: " + hoard.fossils, x + 5*DragonRenderer.textWidth,y);
    }
}
