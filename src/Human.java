import java.util.Scanner;

public class Human extends AI{


    public Human(Game g) {
        super();
        super.game = g;
        super.player = new Player();
        super.player.controller = this;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Player Name");
        super.player.name = in.nextLine();
    }

    @Override
    int getPoly() {

        System.out.println(player.board);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Piece ID");
        int id = 0;
        try{
        id = Integer.parseInt(in.nextLine());
        }catch (Exception e){
            id = 0;
        }
        for(int i = 0; i < game.lootpit.size(); i++){
            if (game.lootpit.get(i).id == id){
                return i;
            }
        }
        return 0;
    }

    @Override
    int getRot() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Piece Rotation");
        try{
            return Integer.parseInt(in.nextLine());
        } catch (Exception e){
            return 0;
        }

    }

    @Override
    int getX() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Piece X");
        try{
            return Integer.parseInt(in.nextLine());
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    int getY() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Piece Y");
        try{
            return Integer.parseInt(in.nextLine());
        } catch (Exception e){
            return 0;
        }
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
