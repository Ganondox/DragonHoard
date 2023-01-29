public class DragonFactory {

    final  int RESOURCE_MAX = 20;

    Dragon makeDragon(){
        double luck = 1.0; //balances generation - increase when unlucky generation occur, decrease when lucky generation occurs
        int bronzeConstant = (int) (1 + Math.random() * 5);
        int[] bronze = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            bronze[i] = i * bronzeConstant;
        }
        luck = 3.0/bronzeConstant;
        int silverConstant = (int) (1 + bronzeConstant + Math.random() * 3 * luck);
        int[] silver = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            silver[i] = i * silverConstant;
        }
        luck *= 5.0/silverConstant;
        int goldConstant = (int) (1 + silverConstant + Math.random() * 3 * luck);
        int[] gold = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            gold[i] = i * goldConstant;
        }
        luck *= 7.0/goldConstant;
        double artifactConstant = (int) (1 + goldConstant + Math.random() * 3 * luck);
        int[] artifacts = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            artifacts[i] = (int)(i*i*artifactConstant/RESOURCE_MAX) + 1;
        }
        luck *= 9.0/artifactConstant;
        double gemConstant = (int) (1 + artifactConstant + Math.random() * 3 * luck);
        int[] gems = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            gems[i] = (int)(Math.sqrt(i)*gemConstant) + 1;
        }
        luck *= 11.0/gemConstant;
        double fossilConstant = (int) (1 + gemConstant + Math.random() * 3 * luck);
        int[] fossils = new int[RESOURCE_MAX];
        for(int i = 0; i < RESOURCE_MAX; i++){
            fossils[i] = (int)(1.5*fossilConstant*i*i/RESOURCE_MAX - fossilConstant*i*i*i/(RESOURCE_MAX*RESOURCE_MAX)) + 1;
        }
        return  new Dragon(bronze,silver,gold,artifacts,gems,fossils);

    }

}
