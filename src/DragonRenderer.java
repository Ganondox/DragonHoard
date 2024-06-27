import javax.swing.*;
import java.awt.*;

public class DragonRenderer extends JComponent {


    Dragon dragon;

    int x;
    int y;

    static int textWidth = 30;
    static int textHeight= 20;

    Hoard hoard;

    public DragonRenderer(Dragon dragon, int x, int y) {
        this.dragon = dragon;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawString("b: ", x ,y);
        for(int i = 0; i < dragon.bronze.length; i++){
            if(i == hoard.bronze){
                g.drawString("*" + dragon.bronze[i], x + (i + 1)*textWidth,y);
            } else  g.drawString("" + dragon.bronze[i], x + (i + 1)*textWidth,y);
        }

        g.setColor(Color.CYAN);
        g.drawString("s: ", x ,y+textHeight);
        for(int i = 0; i < dragon.silver.length; i++){
            if(i == hoard.silver){
                g.drawString("*" + dragon.silver[i], x + (i + 1)*textWidth,y+textHeight);
            } else  g.drawString("" + dragon.silver[i], x + (i + 1)*textWidth,y+textHeight);
        }
        g.setColor(Color.YELLOW);
        g.drawString("g: ", x ,y+2*textHeight);
        for(int i = 0; i < dragon.gold.length; i++){
            if(i == hoard.gold){
                g.drawString("*" + dragon.gold[i], x + (i + 1)*textWidth,y+2*textHeight);
            } else  g.drawString("" + dragon.gold[i], x + (i + 1)*textWidth,y+2*textHeight);
        }
        g.setColor(Color.MAGENTA);
        g.drawString("a: ", x ,y+3*textHeight);
        for(int i = 0; i < dragon.artifacts.length; i++){
            if(i == hoard.artifacts){
                g.drawString("*" + dragon.artifacts[i], x + (i + 1)*textWidth,y+3*textHeight);
            } else  g.drawString("" + dragon.artifacts[i], x + (i + 1)*textWidth,y+3*textHeight);
        }
        g.setColor(Color.RED);
        g.drawString("G: ", x ,y+4*textHeight);
        for(int i = 0; i < dragon.gems.length; i++){
            if(i == hoard.gems){
                g.drawString("*" + dragon.gems[i], x + (i + 1)*textWidth,y+4*textHeight);
            } else  g.drawString("" + dragon.gems[i], x + (i + 1)*textWidth,y+4*textHeight);
        }
        g.setColor(Color.GREEN);
        g.drawString("f: ", x ,y+5*textHeight);
        for(int i = 0; i < dragon.fossils.length; i++){
            if(i == hoard.fossils){
                g.drawString("*" + dragon.fossils[i], x + (i + 1)*textWidth,y+5*textHeight);
            } else  g.drawString("" + dragon.fossils[i], x + (i + 1)*textWidth,y+5*textHeight);
        }
        g.setColor(Color.BLACK);
        g.drawString("Points: "+ dragon.score(hoard) , x ,y+6*textHeight);
    }





}
