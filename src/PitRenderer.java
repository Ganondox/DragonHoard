import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class PitRenderer extends JComponent {

    PieceRenderer[][] pieces;
    List<PieceRenderer> renderers;
     static final int WIDTH = 20;

     int x;
     int y;

    public PitRenderer(int ix, int iy,List<Polynomio> pit) {
         x = ix;
         y = iy;
        int offset = 0;
        int height = 0;
        renderers = new LinkedList<>();
        List<PieceRenderer[]> pieceMolder = new LinkedList<>();
        for(Polynomio p :pit){
            if(offset + p.getWidth() > WIDTH){
                //start new row
                offset = 0;
                height = 0;
                pieceMolder.add(new PieceRenderer[WIDTH]);
            }
            while(height < p.getHeight()){
                //expand row
                pieceMolder.add(new PieceRenderer[WIDTH]);
                height++;
            }
            //add piece to mold
            PieceRenderer pr = new PieceRenderer( x + offset * PieceRenderer.CELL_SIZE, y + PieceRenderer.CELL_SIZE * (pieceMolder.size() - height), p);
            for (int i = 0; i < p.getHeight(); i++) {
                for (int j = 0; j < p.getWidth(); j++) {
                    if(p.substance[i][j] != null) pieceMolder.get(pieceMolder.size() - height + i)[j+offset] = pr;
                }
            }
            offset += p.getWidth() + 1;
            renderers.add(pr);

        }
        pieces = new PieceRenderer[pieceMolder.size()][WIDTH];
        for(int i = 0; i < pieceMolder.size(); i++){
            pieces[i] = pieceMolder.get(i);
        }
    }

    public void paint(Graphics g)    {

        for(int i = 0; i < pieces.length; i++){
            for(int j = 0; j < WIDTH; j++){
                if((i + j)% 2 == 0){
                    g.setColor(Color.GRAY);
                } else {
                    g.setColor(Color.BLACK);
                }
                if(pieces[i][j] != null) g.setColor(Color.WHITE);
                g.fillRect(x + j * PieceRenderer.CELL_SIZE, y + i * PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE, PieceRenderer.CELL_SIZE);

            }
        }

        /*for(PieceRenderer p: renderers){
            p.paint(g);
        }

         */
    }


}
