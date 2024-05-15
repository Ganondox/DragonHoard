import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class GUIController extends MouseInputAdapter {

    PitRenderer pit;


    public void mousePressed(MouseEvent e) {

        System.out.println("clicked");
    }



}
