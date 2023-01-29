public class Cave {

    Polynomio.material[][] board;
    int bronze;
    int silver;
    int gold;
    int artifacts;
    int gems;
    int fossils;

    public Cave(int width, int height) {
        board = new Polynomio.material[height][width];
    }

    public Cave(Polynomio.material[][] board, int bronze, int silver, int gold, int artifacts, int gems, int fossils) {
        this.board = board;
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
        this.artifacts = artifacts;
        this.gems = gems;
        this.fossils = fossils;
    }

    public void addRock(int x, int y){
        board[y][x] = Polynomio.material.rock;
    }

    public boolean checkRock(int x, int y){
        return board[y][x] == Polynomio.material.rock;
    }

    public void incrementValue(Polynomio.material material){
        switch (material){
            case bronze:
                bronze++;
                break;
            case silver:
                silver++;
                break;
            case gold:
                gold++;
                break;
            case artifacts:
                artifacts++;
                break;
            case gems:
                gems++;
                break;
            case fossils:
                fossils++;
                break;
        }
    }

    boolean addPolynomio(Polynomio p, int x, int y){
        if(canAdd(p, x, y)){
            for(int i = 0; i < p.getHeight(); i++){
                for(int j = 0; j < p.getWidth(); j++){
                    if(p.getMaterial(j,i) != null) {
                        board[i + y][j + x] = p.getMaterial(j,i);
                    }
                }
            }
            return true;
        }
        return false;
    }

    boolean canAdd(Polynomio p, int x, int y){
        //check in bounds
        if(x < 0 || y < 0 || x + p.getWidth() > board[0].length || y + p.getHeight() > board.length ) return false;
        //check no collisions
        for(int i = 0; i < p.getHeight(); i++){
            for(int j = 0; j < p.getWidth(); j++){
                if(p.getMaterial(j,i) != null && board[i + y][j + x] != null) return false;
            }
        }
        return true;

    }

    boolean canAdd(Polynomio p){
        for(int i = 0; i < board.length; i++){
            for(int j = 0;  j < board[0].length; j++){
                if(canAdd(p,j,i)) return true;
                p.rotate90();
                if(canAdd(p,j,i)) return true;
                p.rotate90();
                if(canAdd(p,j,i)) return true;
                p.rotate90();
                if(canAdd(p,j,i)) return true;
                p.rotate90();
            }
        }
        return false;
    }

    Hoard getHoard(){
        Hoard hoard = new Hoard(bronze,silver,gold,artifacts,gems,fossils);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != null) {
                    switch (board[i][j]) {
                        case bronze:
                            hoard.incBronze();
                            break;
                        case silver:
                            hoard.incSilver();
                            break;
                        case gold:
                            hoard.incGold();
                            break;
                        case artifacts:
                            hoard.incArtifacts();
                            break;
                        case gems:
                            hoard.incGems();
                            break;
                        case fossils:
                            hoard.incFossils();
                            break;

                    }
                }
            }

        }
        return hoard;
    }

    @Override
    public String toString() {
        String string = "[";
        for(int i = 0; i < board.length; i++) {
            string += "\n";
            for (int j = 0; j < board.length; j++) {

                string += Polynomio.toText(board[i][j]);

            }
            string += "\n";
        }
        string += "]\n";
        string += "Bronze: ";
        string += bronze;
        string += "\n";
        string += "Silver: ";
        string += silver;
        string += "\n";
        string += "Gold: ";
        string += gold;
        string += "\n";
        string += "Artifacts: ";
        string += artifacts;
        string += "\n";
        string += "Gems: ";
        string += gems;
        string += "\n";
        string += "Fossils: ";
        string += fossils;
        return string;
    }

    Cave copy(){
        Polynomio.material[][] copy = new Polynomio.material[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                copy[i][j] = board[i][j];
            }
        }
        return new Cave(copy,bronze,silver,gold,artifacts,gems,fossils);
    }
}
