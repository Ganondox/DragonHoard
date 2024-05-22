import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Drawer extends JComponent {

    List<JComponent> draw = new LinkedList<>();

    public void paint(Graphics g)    {
        for(JComponent c : draw){
            c.paint(g);
        }
    }
}
