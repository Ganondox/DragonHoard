public class PolynomioFactory {

    int bronze = 1;
    int silver = 1;
    int gold = 1;
    int artifacts = 1;
    int gems = 1;
    int fossils = 1;

    public int getBronze() {
        return bronze;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }

    public int getArtifacts() {
        return artifacts;
    }

    public int getGems() {
        return gems;
    }

    public int getFossils() {
        return fossils;
    }

    Polynomio makePolynomio(){


        //generate least prevalant material
        Polynomio.material target = Polynomio.material.bronze;
        if(silver < bronze){
            target = Polynomio.material.silver;
            if(gold < silver){
                target = Polynomio.material.gold;
                if(artifacts < gold){
                    target = Polynomio.material.artifacts;
                    if(gems < artifacts){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < artifacts){
                            target = Polynomio.material.fossils;
                        }
                    }
                } else {
                    if(gems < gold){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < gold){
                            target = Polynomio.material.fossils;
                        }
                    }
                }
            } else {
                if(artifacts < silver){
                    target = Polynomio.material.artifacts;
                    if(gems < artifacts){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < artifacts){
                            target = Polynomio.material.fossils;
                        }
                    }
                } else {
                    if(gems < silver){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < silver){
                            target = Polynomio.material.fossils;
                        }
                    }
                }

            }
        } else {
            if(gold < bronze){
                target = Polynomio.material.gold;
                if(artifacts < gold){
                    target = Polynomio.material.artifacts;
                    if(gems < artifacts){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < artifacts){
                            target = Polynomio.material.fossils;
                        }
                    }
                } else {
                    if(gems < gold){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < gold){
                            target = Polynomio.material.fossils;
                        }
                    }
                }
            } else {
                if(artifacts < bronze){
                    target = Polynomio.material.artifacts;
                    if(gems < artifacts){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < artifacts){
                            target = Polynomio.material.fossils;
                        }
                    }
                } else {
                    if(gems < bronze){
                        target = Polynomio.material.gems;
                        if(fossils < gems){
                            target = Polynomio.material.fossils;
                        }
                    } else {
                        if(fossils < bronze){
                            target = Polynomio.material.fossils;
                        }
                    }
                }
            }
        }

        //tetrominos - bronze and gems
        //pentrominos - silver and fossils
        //hexominos - gold and artifacts
        Polynomio poly;
        int size = 0;
        switch (target){
            case bronze:
                size = 4;
                bronze++;
                System.out.println("BRONZE");
                break;
            case silver:
                size = 5;
                silver++;
                System.out.println("SILVER");
                break;
            case gold:
                size = 6;
                gold++;
                System.out.println("GOLD");
                break;
            case gems:
                size = 4;
                gems++;
                System.out.println("GEMS");
                break;
            case fossils:
                size = 5;
                fossils++;
                System.out.println("FOSSILS");
                break;
            case artifacts:
                size = 6;
                artifacts++;
                System.out.println("ARTIFACTS");
                break;


        }
        poly = new Polynomio(size + 2, size + 2);
        poly.setMaterial(1 + (int)(Math.random() * size),1 + (int)(Math.random() * size), target);
        for(int i = 1; i < size; i++){
            int x = 1 + (int)(Math.random() * size);
            int y = 1 + (int)(Math.random() * size);
            while(poly.getMaterial(x,y) != null ||
                    (poly.getMaterial(x-1, y) == null && poly.getMaterial(x+1, y) == null
             && poly.getMaterial(x, y-1) == null && poly.getMaterial(x, y+1) == null)){
                 x = 1 + (int)(Math.random() * size);
                 y = 1 + (int)(Math.random() * size);
            }
            //generation probabilities weighted by size and amount of each piece
            double bronzeWeight = 0;
            double silverWeight = 0;
            double goldWeight = 0;
            double artifactsWeight = 0;
            double gemsWeight = 0;
            double fossilsWeight = 0;

            switch (size){
                case 4:
                    bronzeWeight = 0.5 * 1.0/bronze;
                    gemsWeight = 0.5 * 1.0/gems;
                    silverWeight = 0.2 * 1.0/silver;
                    fossilsWeight = 0.2 * 1.0/fossils;
                    goldWeight = 0.1 * 1.0/gold;
                    artifactsWeight = 0.1 * 1.0/artifacts;
                    break;
                case 5:
                    bronzeWeight = 0.1 * 1.0/bronze;
                    gemsWeight = 0.1 * 1.0/gems;
                    silverWeight = 0.4 * 1.0/silver;
                    fossilsWeight = 0.4 * 1.0/fossils;
                    goldWeight = 0.2 * 1.0/gold;
                    artifactsWeight = 0.2 * 1.0/artifacts;
                    break;
                case 6:
                    bronzeWeight = 0.2 * 1.0/bronze;
                    gemsWeight = 0.2 * 1.0/gems;
                    silverWeight = 0.1 * 1.0/silver;
                    fossilsWeight = 0.1 * 1.0/fossils;
                    goldWeight = 0.3 * 1.0/gold;
                    artifactsWeight = 0.3 * 1.0/artifacts;
                    break;

            }
            double totalweight = bronzeWeight + silverWeight + goldWeight + artifactsWeight + fossilsWeight + gemsWeight;
            double selection = Math.random() * totalweight;
            if(selection < bronzeWeight){
                bronze++;
                poly.setMaterial(x, y, Polynomio.material.bronze);
            } else {
                selection -= bronzeWeight;
                if(selection < silverWeight){
                    silver++;
                    poly.setMaterial(x, y, Polynomio.material.silver);
                } else {
                    selection -= silverWeight;
                    if(selection < goldWeight){
                        gold++;
                        poly.setMaterial(x, y, Polynomio.material.gold);
                    } else {
                        selection -= goldWeight;
                        if(selection < artifactsWeight){
                            artifacts++;
                            poly.setMaterial(x, y, Polynomio.material.artifacts);
                        } else {
                            selection -= artifactsWeight;
                            if(selection < gemsWeight){
                                gems++;
                                poly.setMaterial(x, y, Polynomio.material.gems);
                            } else {
                                if(selection > fossilsWeight + gemsWeight){
                                    System.out.println("ERROR");
                                }
                                fossils++;
                                poly.setMaterial(x, y, Polynomio.material.fossils);
                            }
                        }
                    }
                }
            }
        }

        poly.condense();
        return poly;

    }
}
