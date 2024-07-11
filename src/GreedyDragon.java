import java.util.concurrent.TimeUnit;

public class GreedyDragon extends AI{

    int rot;
    int x;
    int y;


    public GreedyDragon(Game g) {
        super();
        super.game = g;
        super.player = new Player();
        super.player.controller = this;
        String name = "";
        int syl = (int)(Math.random() * 5);
        switch(syl){
                case 0:
                    name += "Snar";
                    break;
                case 1:
                    name += "Gol";
                    break;
                case 2:
                    name += "Kem";
                    break;
                case 3:
                    name += "Pith";
                    break;
                case 4:
                    name += "Drug";
                    break;


        }
        syl = (int)(Math.random() * 5);
        switch(syl){
            case 0:
                name += "gar";
                break;
            case 1:
                name += "lil";
                break;
            case 2:
                name += "glee";
                break;
            case 3:
                name += "mam";
                break;
            case 4:
                name += "tag";
                break;


        }

        syl = (int)(Math.random() * 5);
        switch(syl){
            case 0:
                name += "eleene ";
                break;
            case 1:
                name += "azona ";
                break;
            case 2:
                name += "igok ";
                break;
            case 3:
                name += "uslan ";
                break;
            case 4:
                name += "omeg ";
                break;


        }
        name += "the ";
        syl = (int)(Math.random() * 5);
        switch(syl){
            case 0:
                name += "licker ";
                break;
            case 1:
                name += "biter ";
                break;
            case 2:
                name += "scorcher ";
                break;
            case 3:
                name += "devourer ";
                break;
            case 4:
                name += "admirer ";
                break;


        }
        name += "of ";
        syl = (int)(Math.random() * 5);
        switch(syl){
            case 0:
                name += "sheep ";
                break;
            case 1:
                name += "men ";
                break;
            case 2:
                name += "women ";
                break;
            case 3:
                name += "other dragons ";
                break;
            case 4:
                name += "dogs ";
                break;


        }
        super.player.name = name;



    }

    @Override
    int getPoly() {

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }

        int max = 0;
        int value = 0;
        for(int i = 0; i < game.lootpit.size(); i++){
            Polynomio piece = game.lootpit.get(i);
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < player.board.board.length; k++){
                    for(int l = 0; l < player.board.board[0].length; l++){
                        Cave test = player.board.copy();
                        if(test.addPolynomio(piece,l,k)) {
                            int score = player.score.score(test.getHoard());
                            if (score > value) {
                                max = i;
                                rot = j;
                                x = l;
                                y = k;
                                value = score;
                            }
                        }
                    }
                }
                piece.rotate90();
            }
        }
        return max;
    }

    @Override
    int getRot() {
        return rot;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    void chooseComb(Cave c1, Cave c2, Dragon d1, Dragon d2) {

        int value = d1.score(c1.getHoard());
        player.score = d1;
        player.board = c1;
        if(d1.score(c2.getHoard()) > value){
            value = d1.score(c2.getHoard());
            player.score = d1;
            player.board = c2;

        }
        if(d2.score(c2.getHoard()) > value){
            value =   d2.score(c2.getHoard());
            player.score = d2;
            player.board = c2;
        }
        if(d2.score(c1.getHoard()) > value){
            value =   d2.score(c1.getHoard());
            player.score = d2;
            player.board = c1;
        }

    }
}
