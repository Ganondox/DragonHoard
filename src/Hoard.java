public class Hoard {

    int bronze;
    int silver;
    int gold;
    int artifacts;
    int gems;
    int fossils;

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

    public Hoard(int bronze, int silver, int gold, int artifacts, int gems, int fossils) {
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
        this.artifacts = artifacts;
        this.gems = gems;
        this.fossils = fossils;
    }

    void incBronze(){
        bronze++;
    }

    void incSilver(){
        silver++;
    }

    void incGold(){
        gold++;
    }


    void incArtifacts(){
        artifacts++;
    }

    void incGems(){
        gems++;
    }

    void incFossils(){
        fossils++;
    }

}
