import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class CaveController extends MouseInputAdapter {


    public void mousePressed(MouseEvent e) {

        System.out.println("also clicked");
        /*System.out.println(e.getX());
        int x = ((e.getX() - pit.x)/PieceRenderer.CELL_SIZE);
        int y = ((e.getY() - pit.y)/PieceRenderer.CELL_SIZE);
        System.out.println(x);
        System.out.println(y);
        System.out.println(pit.pieces.length);
        System.out.println(pit.pieces[0].length);
        piece = pit.pieces[y][x];
        piece.selected = true;
        System.out.println(piece);

         */
    }
}
