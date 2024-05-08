
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Polynomio> lootpit;
    List<Player> players;
    int turn = 0;
    String winner;
    int highscore = 0;

    public Game(List<Polynomio> lootpit, List<Player> players) {
        this.lootpit = lootpit;
        this.players = players;
    }

    //returns the player whose turn is next, and null if it's over
    Player makeTurn(Player player, int poly, int rotation, int x, int y){
        if(player == players.get(turn)){
            Polynomio loot = lootpit.get(poly);
            for(int i = 0; i < rotation; i++){
                loot.rotate90();
            }
            if(player.board.canAdd(loot, x, y)){
                //player adds loot
                System.out.println(player.name);
                System.out.println("Before:");
                System.out.println(player.board);
                System.out.println("Adding");
                System.out.println(loot);
                System.out.println("ID: " + loot.id);
                System.out.println("at " + x +"," + y);
                player.board.addPolynomio(loot, x, y);
                System.out.println("After:");
                System.out.println(player.board);
                lootpit.remove(poly);

                //next turn
                turn++;
                if(turn == players.size()) turn = 0;
                boolean foundMove = false;
                while(!foundMove && players.size() > 0){
                    //check if the player has any valid moves
                    for(int i = 0; i < lootpit.size(); i++){
                        if(players.get(turn).board.canAdd(lootpit.get(i))){
                            foundMove = true;
                        }

                    }
                    //cash in players once they can't move anymore
                    if(!foundMove){
                        int score = players.get(turn).score.score(players.get(turn).board.getHoard());
                        if(score > highscore){
                            winner = players.get(turn).name;
                            highscore = score;
                        }
                        players.remove(turn);
                        if(turn == players.size()) turn = 0;
                    }
                }
                if(players.size() == 0){
                    System.out.println(winner + " won");
                    return null;
                }
                return players.get(turn);
            }
            //invalid move, nothing changes
            System.out.println("Invalid move");
            return players.get(turn);
        }
        //not your turn, nothing changes
        System.out.println("Not your turn");
        return players.get(turn);
    }

}
