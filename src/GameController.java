import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameController {

    void runGame(){
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
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){

            }
        }

        List<Player> players = new LinkedList<>();
        Game game = new Game(loot,players);
        //generate players
        AI hom = new Human(game);
        CaveFactory cf = new CaveFactory();
        DragonFactory df = new DragonFactory();
        hom.chooseComb(cf.MakeCave(), cf.MakeCave(), df.makeDragon(), df.makeDragon());
        players.add(hom.player);
        for(int i = 0; i < 3; i++){
            AI drag = new GreedyDragon(game);
            cf = new CaveFactory();
            df = new DragonFactory();
            drag.chooseComb(cf.MakeCave(), cf.MakeCave(), df.makeDragon(), df.makeDragon());
            players.add(drag.player);
        }

        //run game
        System.out.println("Let the game begin!");
        Player current = players.get(0);
        while(current != null){
            System.out.println("Turn start");
            try{
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e){

            }
            current = current.controller.makeMove();
        }
    }
}
