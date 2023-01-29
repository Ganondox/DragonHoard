public class Test {

    public static void main(String args[]){

        Polynomio.material[][] m = new Polynomio.material[3][4];
        m[0][1] = Polynomio.material.bronze;
        m[0][2] = Polynomio.material.silver;
        m[1][0] = Polynomio.material.gold;
        m[1][2] = Polynomio.material.artifacts;
        m[2][0] = Polynomio.material.gems;
        m[2][1] = Polynomio.material.fossils;

        Polynomio p = new Polynomio(m);

        System.out.println(p);
        p.rotate90();
        System.out.println();
        System.out.println(p);
        p.rotate270();
        System.out.println();
        System.out.println(p);

        Cave cave = new Cave(7, 7);
        cave.addPolynomio(p, 3, 3);
        System.out.println(cave);

        System.out.println(new DragonFactory().makeDragon());
        System.out.println(new CaveFactory().MakeCave());

        PolynomioFactory pf = new PolynomioFactory();
        while(pf.getBronze() < 26 || pf.getSilver() < 26 || pf.getGold() < 26 ||
                pf.getArtifacts() < 26 || pf.getGems() < 26 | pf.getFossils() < 26 ){
            Polynomio poly = pf.makePolynomio();
            System.out.println(poly);
            System.out.println();
        }
        System.out.println("Bronze: " + pf.getBronze());
        System.out.println("Silver: " + pf.getSilver());
        System.out.println("Gold: " + pf.getGold());
        System.out.println("Artifacts: " + pf.getArtifacts());
        System.out.println("Gems: " + pf.getGems());
        System.out.println("Fossils: " + pf.getFossils());


        System.out.println("Begining Game");
        new GameController().runGame();

    }


}
