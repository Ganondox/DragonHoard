import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class GUIController extends MouseInputAdapter implements KeyListener {

    PitRenderer pit;
    CaveRenderer[] caves;
    CaveRenderer cur = null;
    boolean set = false;
    int oldx = 0;
    int oldy = 0;
    PieceRenderer piece;
    Shadow shadow;
    JFrame frame;
    int rotations = 0;


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

        //reset piece on cancel
        if(set) {
            set = false;
            shadow.x = ((oldx - pit.x)/PieceRenderer.CELL_SIZE);
            shadow.y = ((oldy - pit.y)/PieceRenderer.CELL_SIZE);
            shadow.pit = pit.pieces;
            shadow.pitx = pit.x;
            shadow.pity = pit.y;
            placePiece(true);
        }

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
        if(piece != null) {
            piece.x = e.getX();
            piece.y = e.getY();
            System.out.println("drag");

            //target
           setShadow(e);



            frame.repaint();
        }
    }


    private void setShadow(MouseEvent e){
        shadow.visible = false;
        if (piece.x >= pit.x && piece.x < pit.x + pit.PIT_WIDTH * PieceRenderer.CELL_SIZE && piece.y >= pit.y && piece.y < pit.y + pit.pieces.length * PieceRenderer.CELL_SIZE){
            shadow.pit = pit.pieces;
            shadow.pitx = pit.x;
            shadow.pity = pit.y;
            shadow.x = ((e.getX() - pit.x)/PieceRenderer.CELL_SIZE);
            shadow.y = ((e.getY() - pit.y)/PieceRenderer.CELL_SIZE);
            cur = null;
            shadow.visible = true;
            System.out.println("in pit");
        } else {
            System.out.println("out pit");
            for(int i = 0; i < caves.length; i++){
                CaveRenderer cave = caves[i];
                if (piece.x >= cave.x && piece.x < cave.x + cave.mask.length * PieceRenderer.CELL_SIZE && piece.y >= cave.y && piece.y < cave.y + cave.mask.length * PieceRenderer.CELL_SIZE){
                    shadow.pit = cave.mask;
                    shadow.pitx = cave.x;
                    shadow.pity = cave.y;
                    shadow.x = ((e.getX() - cave.x)/PieceRenderer.CELL_SIZE);
                    shadow.y = ((e.getY() - cave.y)/PieceRenderer.CELL_SIZE);
                    cur = cave;
                    shadow.visible = true;
                    System.out.println("in cave "+ i);
                    break;
                }
            }
        }

        shadow.piece = piece;
    }

    public void placePiece(boolean reset){
        if(reset){
            while(rotations > 0){
                piece.piece.rotate270();
                rotations--;
            }
        }
        shadow.test();
        if(shadow.good){

            //move is set if piece placed in cave
            if(cur != null && !reset){
                oldx = piece.homex;
                oldy = piece.homey;
                set = true;
            }

            piece.homex = (shadow.x * PieceRenderer.CELL_SIZE) + shadow.pitx;
            piece.homey = (shadow.y * PieceRenderer.CELL_SIZE) + shadow.pity;
            //clear old piece location
            if(reset) {
                for (int i = 0; i < cur.mask.length; i++) {
                    for (int j = 0; j < cur.mask[0].length; j++) {
                        if (cur.mask[i][j] == piece) cur.mask[i][j] = null;
                    }
                }
                cur = null;
            } else{
                for (int i = 0; i < pit.pieces.length; i++) {
                    for (int j = 0; j <pit.pieces[0].length; j++) {
                        if (pit.pieces[i][j] == piece) pit.pieces[i][j] = null;
                    }
                }
            }
            //set in new location
            for (int i = 0; i < piece.piece.getWidth(); i++) {
                for (int j = 0; j < piece.piece.getHeight(); j++) {
                    if(piece.piece.substance[j][i] != null)
                        shadow.pit[shadow.y + j][shadow.x + i] = piece;
                }
            }

        } else {
            while(rotations > 0){
                piece.piece.rotate270();
                rotations--;
            }
        }

        piece.goHome();
        frame.repaint();
        piece.selected = false;
        if(!set) piece = null;
        shadow.visible = false;
    }

    public void mouseReleased(MouseEvent e){
        if(piece != null){
            setShadow(e);
            placePiece(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
        switch(e.getKeyChar()){
            case 's':
                System.out.println("set");
                if(set){
                    set = false;
                    cur.cave.addPolynomio(piece.piece, (piece.x - cur.x)/PieceRenderer.CELL_SIZE, (piece.y - cur.y)/PieceRenderer.CELL_SIZE);
                    piece.piece = null;
                    cur.hoard.hoard = cur.cave.getHoard();
                    if(cur.player != null) {
                        cur.player.dragonRenderer.hoard = cur.cave.getHoard();
                    }
                    cur = null;
                    rotations = 0;

                    frame.repaint();

                }
                break;
            case 'k':
                if(piece != null && !set){
                    piece.piece.rotate90();
                    rotations++;
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
