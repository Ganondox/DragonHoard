import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GUIPlayer extends AI {




    static int total = 0;
    Move move;

    public GUIPlayer(Game g) {
        total++;
        super.game = g;
        super.player = new Player();
        super.player.controller = this;
        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter in Player Name");
        super.player.name = in.nextLine();*/
        super.player.name = "Player " + total;
    }

    @Override
    int getPoly() {
        move = null;
        while(move == null){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception e){

            }
        }

        return move.poly;
    }

    @Override
    int getRot() {
        return move.rot;
    }

    @Override
    int getX() {
        return move.x;
    }

    @Override
    int getY() {
        return move.y;
    }

    @Override
    void chooseComb(Cave c1, Cave c2, Dragon d1, Dragon d2) {
       /* Scanner in = new Scanner(System.in);
        System.out.println("Top board");
        System.out.println(c1);
        System.out.println("Bottom board");
        System.out.println(c2);
        System.out.println("Top dragon");
        System.out.println(d1);
        System.out.println("Bottom dragon");
        System.out.println(d2);
        System.out.println("Choose top board - y ");
        if(in.nextLine().equals("y")) player.board = c1; else player.board = c2;
        System.out.println("Choose top dragon - y ");
        if(in.nextLine().equals("y")) player.score = d1; else player.score = d2;
        */
        Cave[] caves = new Cave[]{c1, c2};
        Dragon[] dragons = new Dragon[]{d1, d2};
        Selector s = new Selector(caves, dragons, player);

        JFrame frame = new JFrame(player.name);
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Drawer draw = new Drawer();
        frame.getContentPane().add(draw);

        SelectorController controller = new SelectorController(s, draw, frame);
        frame.addKeyListener(controller);


        while(!s.done){
            System.out.println("s");
        }

        player.board = s.caves[s.curCave].cave;
        player.score = s.dragons[s.curDrag].dragon;



    }
}
