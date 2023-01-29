public class Dragon {

    int[] bronze;
    int[] silver;
    int[] gold;
    int[] artifacts;
    int[] gems;
    int[] fossils;

    public Dragon(int[] bronze, int[] silver, int[] gold, int[] artifacts, int[] gems, int[] fossils) {
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
        this.artifacts = artifacts;
        this.gems = gems;
        this.fossils = fossils;
    }

    int score(Hoard hoard){
        int sum = 0;
        if(hoard.getBronze() >= bronze.length){
            sum += bronze[bronze.length - 1];
        } else {
            sum += bronze[hoard.getBronze()];
        }
        if(hoard.getSilver() >= silver.length){
            sum += silver[silver.length - 1];
        } else {
            sum += silver[hoard.getSilver()];
        }
        if(hoard.getGold() >= gold.length){
            sum += gold[gold.length - 1];
        } else {
            sum += gold[hoard.getGold()];
        }
        if(hoard.getArtifacts() >= artifacts.length){
            sum += artifacts[artifacts.length - 1];
        } else {
            sum += artifacts[hoard.getArtifacts()];
        }
        if(hoard.getGems() >= gems.length){
            sum += gems[gems.length - 1];
        } else {
            sum += gems[hoard.getGems()];
        }
        if(hoard.getFossils() >= fossils.length){
            sum += fossils[fossils.length - 1];
        } else {
            sum += fossils[hoard.getFossils()];
        }
        return sum;
    }

    @Override
    public String toString() {
        String string = "Bronze: ";
        for(int i = 0; i < bronze.length; i++){
            string += bronze[i] + " ";
        }
        string += "\n";
        string += "Silver: ";
        for(int i = 0; i < silver.length; i++){
            string += silver[i] + " ";
        }
        string += "\n";
        string += "Gold: ";
        for(int i = 0; i < gold.length; i++){
            string += gold[i] + " ";
        }
        string += "\n";
        string += "Artifacts: ";
        for(int i = 0; i < artifacts.length; i++){
            string += artifacts[i] + " ";
        }
        string += "\n";
        string += "Gems: ";
        for(int i = 0; i < gems.length; i++){
            string += gems[i] + " ";
        }
        string += "\n";
        string += "Fossils: ";
        for(int i = 0; i < fossils.length; i++){
            string += fossils[i] + " ";
        }
        return string;
    }
}
