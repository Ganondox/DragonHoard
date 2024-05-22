import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIController extends MouseInputAdapter {

    PitRenderer pit;
    PieceRenderer piece;
    Shadow shadow;
    JFrame frame;

    public GUIController(PitRenderer pit) {
        this.pit = pit;
    }

    public GUIController(PitRenderer pit, JFrame frame) {
        this.pit = pit;
        this.frame = frame;
    }

    public GUIController(PitRenderer pit, Shadow shadow, JFrame frame) {
        this.pit = pit;
        this.shadow = shadow;
        this.frame = frame;
    }

    public void mousePressed(MouseEvent e) {

        System.out.println("clicked");
        System.out.println(e.getX());
        int x = ((e.getX() - pit.x)/PieceRenderer.CELL_SIZE);
        int y = ((e.getY() - pit.y)/PieceRenderer.CELL_SIZE);
        System.out.println(x);
        System.out.println(y);
        System.out.println(pit.pieces.length);
        System.out.println(pit.pieces[0].length);
        piece = pit.pieces[y][x];
        piece.selected = true;
        System.out.println(piece);
    }

    public void mouseDragged(MouseEvent e){
        if(piece != null){
            piece.x = e.getX();
            piece.y = e.getY();
            System.out.println("drag");

            //target

            shadow.x = ((e.getX() - pit.x)/PieceRenderer.CELL_SIZE);
            shadow.y = ((e.getY() - pit.y)/PieceRenderer.CELL_SIZE);
            shadow.piece = piece;
            shadow.visible = true;



            frame.repaint();
        }
    }

    public void mouseReleased(MouseEvent e){
        if(piece != null){
            shadow.x = ((e.getX() - pit.x)/PieceRenderer.CELL_SIZE);
            shadow.y = ((e.getY() - pit.y)/PieceRenderer.CELL_SIZE);
            shadow.test();
            if(shadow.good){
                piece.homex = (shadow.x * PieceRenderer.CELL_SIZE) + pit.x;
                piece.homey = (shadow.y * PieceRenderer.CELL_SIZE) + pit.y;
                for(int i = 0; i < pit.pieces.length; i++){
                    for(int j = 0; j < pit.WIDTH; j++){
                       if(pit.pieces[i][j] == piece) pit.pieces[i][j] = null;
                    }
                }
                for (int i = 0; i < piece.piece.getWidth(); i++) {
                    for (int j = 0; j < piece.piece.getHeight(); j++) {
                       if(piece.piece.substance[j][i] != null)
                        pit.pieces[shadow.y + j][shadow.x + i] = piece;
                    }
                }
            }
            piece.goHome();
            frame.repaint();
            piece.selected = false;
            piece = null;
            shadow.visible = false;
        }
    }

}
