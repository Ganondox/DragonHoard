public class CaveFactory {

    Cave MakeCave(){
        Cave cave = new Cave(7,7);

        //add rocks - 40 free cells
        for(int i = 0; i < 9; i++){
            int x = (int) (Math.random() * 7);
            int y = (int) (Math.random() * 7);
            while(cave.checkRock(x,y)){
                x = (int) (Math.random() * 7);
                y = (int) (Math.random() * 7);
            }
            cave.addRock(x,y);
        }
        //add initial treasure
        for(int i = 0; i < 2; i++){
            int metal = (int)(Math.random() * 3);
            switch (metal){
                case 0:
                    cave.incrementValue(Polynomio.material.gold);
                    break;
                case 1:
                    cave.incrementValue(Polynomio.material.silver);
                    break;
                case 2:
                    cave.incrementValue(Polynomio.material.bronze);
                    break;
            }
            for(int j = 0; j < metal; j++){
                int misc = (int)(Math.random() * 3);
                switch (misc){
                    case 0:
                        cave.incrementValue(Polynomio.material.artifacts);
                        break;
                    case 1:
                        cave.incrementValue(Polynomio.material.gems);
                        break;
                    case 2:
                        cave.incrementValue(Polynomio.material.fossils);
                        break;
                }
            }

        }

        return cave;
    }



}
