import javax.swing.*;
import java.awt.*;

public class TurnRender extends JComponent {

    Game game;
    int x;
    int y;

    public TurnRender(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g)    {

        g.setColor(Color.black);

        if(game.players.size() > 0) {

            String cur = game.players.get(game.turn).name;

            g.drawString(cur + "'s Turn", x, y);
        } else {

            g.drawString(game.winner + " won!", x, y);

        }

    }

}
