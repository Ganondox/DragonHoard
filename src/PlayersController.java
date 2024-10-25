import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayersController implements KeyListener {


    int players = -1;

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key" + e.getKeyChar());
        switch (e.getKeyChar()) {
            case '0':
                players = 0;
                break;
            case '1':
                players = 1;
                break;
            case '2':
                players = 2;
                break;
            case '3':
                players = 3;
                break;
            case '4':
                players = 4;
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
