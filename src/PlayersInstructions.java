import javax.swing.*;
import java.awt.*;

public class PlayersInstructions extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Press 0-4 to select the number of people playing " , 100,100);
    }

}
