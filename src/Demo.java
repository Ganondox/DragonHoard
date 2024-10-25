import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String args[]){
        System.out.println("Beginning Game");

        //generate loot pile
        System.out.println("Admire the loot the dragons collected");
        List<Polynomio> loot = new LinkedList<>();
        PolynomioFactory pf = new PolynomioFactory();
        while(pf.getBronze() < 26 || pf.getSilver() < 26 || pf.getGold() < 26 ||
                pf.getArtifacts() < 26 || pf.getGems() < 26 || pf.getFossils() < 26 ){
            Polynomio poly = pf.makePolynomio();
            loot.add(poly);
            System.out.println(poly);
            System.out.println();
            try{
                TimeUnit.SECONDS.sleep(0);
            } catch (Exception e){

            }
        }

        List<Player> players = new LinkedList<>();
        Game game = new Game(loot,players);

        //deploy gui
        JFrame frame = new JFrame("Players");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Drawer draw = new Drawer();
        frame.getContentPane().add(draw);

       PlayersController controller = new PlayersController();

        frame.addKeyListener(controller);

        draw.add(new Drawable(new PlayersInstructions(), Drawable.TEXT));

        frame.setVisible(true);

        while(controller.players==-1){
           System.out.println("is"+controller.players);
        }

        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        frame.setVisible(false);

        //generate players
        int people = controller.players;
        CaveFactory cf = new CaveFactory();
        DragonFactory df = new DragonFactory();
        for(int i =0; i < people; i++){
            AI hom = new GUIPlayer(game);
            hom.chooseComb(cf.MakeCave(), cf.MakeCave(), df.makeDragon(), df.makeDragon());
            players.add(hom.player);
        }



        for(int i = 0; i < 4 - people; i++){
            AI drag = new GreedyDragon(game);
            cf = new CaveFactory();
            df = new DragonFactory();
            drag.chooseComb(cf.MakeCave(), cf.MakeCave(), df.makeDragon(), df.makeDragon());
            players.add(drag.player);
        }

        new GameController().runGame(game);



    }
}
