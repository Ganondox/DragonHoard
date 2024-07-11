import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GUIPlayer extends AI {




    Move move;

    public GUIPlayer(Game g) {
        super.game = g;
        super.player = new Player();
        super.player.controller = this;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Player Name");
        super.player.name = in.nextLine();
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
        Scanner in = new Scanner(System.in);
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


    }
}
