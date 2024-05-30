import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Drawer extends JComponent {

    List<Drawable> draw = new LinkedList<>();

    public void paint(Graphics g)    {
        for(Drawable c : draw){
            c.drawable.paint(g);
        }
    }

    public void add(Drawable d){
        boolean in = false;
        for(int i = 0; i < draw.size() && !in; i++){
            if(draw.get(i).z > d.z){
                draw.add(i, d);
                in = true;
            }
        }
        if(!in){
            draw.add(d);
        }
    }
}
