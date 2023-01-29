public abstract class AI {

    Player player;
    Game game;

    Player makeMove(){
       return game.makeTurn(player,getPoly(),getRot(), getX(), getY());
    }

    abstract int getPoly();
    abstract int getRot();
    abstract int getX();
    abstract int getY();
    abstract void chooseComb(Cave c1, Cave c2, Dragon d1, Dragon d2);

}
