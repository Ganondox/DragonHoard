import javax.swing.*;

public class Drawable {

    JComponent drawable;
    int z;

    static final int GROUND = 0;
    static final int SHADOW = 1;
    static final int PIECE = 2;
    static final int TEXT = 3;


    public Drawable(JComponent drawable, int z) {
        this.drawable = drawable;
        this.z = z;
    }
}
