import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class SelectorController extends MouseInputAdapter implements KeyListener {

    Selector selector;
    Drawer draw;
    JFrame frame;


    public SelectorController(Selector selector, Drawer draw, JFrame frame) {
        this.selector = selector;
        this.draw = draw;
        this.frame = frame;

        draw.add(new Drawable(selector, Drawable.TEXT));
        for(int i = 0; i < selector.caves.length; i++){
            draw.add(new Drawable(selector.caves[i], Drawable.GROUND));
        }
        for(int i = 0; i < selector.dragons.length; i++){
            draw.add(new Drawable(selector.dragons[i], Drawable.TEXT));
        }

        frame.getContentPane().addMouseListener(this);
        frame.setVisible(true);
        frame.repaint();

    }

    public void mousePressed(MouseEvent e) {

        boolean found = false;
        for(int i = 0; i < selector.caves.length; i++){
            CaveRenderer cave = selector.caves[i];

            if (e.getX() >= cave.x && e.getX() < cave.x + cave.mask.length * PieceRenderer.CELL_SIZE && e.getY() >= cave.y && e.getY() < cave.y + cave.mask.length * PieceRenderer.CELL_SIZE){

                selector.curCave = i;
                System.out.println("selected cave "+ i);
                found = true;
                break;

            }
        }
        if(!found){
            for(int i = 0; i < selector.dragons.length; i++){
                DragonRenderer dragon = selector.dragons[i];

                if (e.getX() >= dragon.x && e.getX() < dragon.x + (dragon.dragon.bronze.length+1)*DragonRenderer.textWidth && e.getY() >= dragon.y && e.getY() < dragon.y +7* DragonRenderer.textHeight){

                    selector.curDrag = i;
                    System.out.println("selected dragon "+ i);
                    found = true;
                    break;

                }
            }
        }
        frame.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's'){
            if(selector.curCave > -1 && selector.curDrag > -1){
                selector.done = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
