import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GUITest  {

    public static void main(String[] args) {



        JFrame frame = new JFrame("GUITest");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Drawer draw = new Drawer();
        frame.getContentPane().add(draw);



        Polynomio.material[][] m = new Polynomio.material[3][4];
        m[0][1] = Polynomio.material.bronze;
        m[0][2] = Polynomio.material.silver;
        m[1][0] = Polynomio.material.gold;
        m[1][2] = Polynomio.material.artifacts;
        m[2][0] = Polynomio.material.gems;
        m[2][1] = Polynomio.material.fossils;

        Polynomio p = new Polynomio(m);


         PieceRenderer pr = new PieceRenderer(20, 20, p);

         System.out.println(p);

       // frame.getContentPane().add( pr);


        //generate loot pile
        System.out.println("Admire the loot the dragons collected");
        List<Polynomio> loot = new LinkedList<>();
        PolynomioFactory pf = new PolynomioFactory();
        //int min = 26;
        int min = 26;
        while(pf.getBronze() < min || pf.getSilver() < min || pf.getGold() < min ||
                pf.getArtifacts() < min || pf.getGems() < min || pf.getFossils() < min ){
            Polynomio poly = pf.makePolynomio();
            loot.add(poly);
            System.out.println(poly);
            System.out.println();
            try{
               // TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){

            }
        }

        PitRenderer pit = new PitRenderer(100, 20, loot);
        draw.draw.add(pit);


        Shadow s = new Shadow(pit.pieces, pit.x, pit.y);
        draw.draw.add(s);


        for(PieceRenderer pcrr: pit.renderers){
            draw.draw.add(pcrr);
        }

        GUIController controller = new GUIController(pit, s,frame);
        frame.getContentPane().addMouseListener(controller);
        frame.getContentPane().addMouseMotionListener(controller);



        frame.setVisible(true);

    }


}
