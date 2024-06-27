import javax.swing.*;
import java.awt.*;

public class KeyInstructions extends JComponent {

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("s - confirm move " + "\r\n" +
                " k - rotate", 100,500);


    }
}
