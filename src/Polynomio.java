public class Polynomio {

    enum material {bronze, silver, gold, artifacts, gems, fossils, rock}

    material[][] substance;


    int getWidth(){
        return substance[0].length;
    }

    int getHeight(){
        return substance.length;
    }

    material getMaterial(int x, int y){
        return substance[y][x];
    }

    void setMaterial(int x, int y, material m){
        substance[y][x] = m;
    }


    public Polynomio(int width, int height) {
        this.substance = new material[height][width];
    }

    public Polynomio(material[][] substance) {
        this.substance = substance;
    }




    public void condense(){
        boolean found = false;
        int startx = 0;
        for(int j = 0; j < substance[0].length; j++){
            for(int i = 0; i < substance.length; i++){
                if(substance[i][j] != null) found = true;
            }
            if(found){
                break;
            }
            startx++;
        }
        found = false;
        int starty = 0;
        for(int i = 0; i < substance.length; i++){
            for(int j = 0; j < substance[0].length; j++){
                if(substance[i][j] != null) found = true;
            }
            if(found){
                break;
            }
            starty++;
        }
        found = false;
        int endx = substance[0].length;
        for(int j = substance[0].length - 1; j > -1; j--){
            for(int i = 0; i < substance.length; i++){
                if(substance[i][j] != null) found = true;
            }
            if(found){
                break;
            }
            endx--;
        }
        found = false;
        int endy = substance.length;
        for(int i = substance.length-1; i > -1; i--){
            for(int j = 0; j < substance[0].length; j++){
                if(substance[i][j] != null) found = true;
            }
            if(found){
                break;
            }
            endy--;
        }

        material[][] condensed = new material[endy - starty][ endx - startx];
        for(int i = starty; i < endy; i++){
            for(int j = startx; j < endx; j++){
                condensed[i - starty][j - startx] = substance[i][j];
            }
        }
        substance = condensed;
    }

    public void rotate270(){
       material[][] rotate = new material[substance[0].length][substance.length];
       for(int i = 0; i < rotate.length; i++){
           for(int j = 0; j < rotate[0].length; j++){
               rotate[i][j] = substance[j][substance[0].length-i-1];
           }
       }
       substance = rotate;
    }

    public void rotate90(){
        material[][] rotate = new material[substance[0].length][substance.length];
        for(int i = 0; i < rotate.length; i++){
            for(int j = 0; j < rotate[0].length; j++){
                rotate[i][j] = substance[rotate[0].length-j-1][i];
            }
        }
        substance = rotate;
    }

    public static char toText(material m){
        if(m == null) return ' ';
        switch (m){
            case bronze:
                return 'b';
            case silver:
                return 's';
            case gold:
                return 'g';
            case artifacts:
                return 'a';
            case gems:
                return 'G';
            case fossils:
                return 'f';
            case rock:
                return 'O';
            default:
                return '?';
        }
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = 0; i < substance.length; i++) {
            for (int j = 0; j < substance[0].length; j++) {

                string += toText(substance[i][j]);
            }
            string += "\n";
        }
        string += getWidth() + "x" + getHeight();
        return string;
    }
}
