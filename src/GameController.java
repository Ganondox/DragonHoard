import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameController {


    void runGame(Game game){



        //deploy gui
        JFrame frame = new JFrame("Game");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Drawer draw = new Drawer();
        frame.getContentPane().add(draw);

       GUIController controller = new GUIController(frame, game, draw);

        frame.addKeyListener(controller);

        frame.setVisible(true);

        //run game
        System.out.println("Let the game begin!");
        Player current = game.players.get(0);
        while(current != null){
            System.out.println("Turn start");
            try{
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e){

            }
            current = current.controller.makeMove();
            controller.endTurn();
        }
    }
}
