//Programmer: Brandon Andrasco COP 2800
//Program: In this program you are asked to input the name of you pokemon, you then input the attack and defense stats
//The enemy is randomly generated and also has randomly generated stats. There is then a battle between the stats that you input and 
//the randomly generated enemies stats. The defense stats stays consistant and the attack is a number between 1 - att for the player and 0 - 13 for the enemy the enemies
//defense stat is randomly generated between 1 and 6 but stays consistant the whole way through. You are welcome to leave before the fight begins.
package pokebattle;

import java.util.Random;

public class Pokemon {
    //initiating private variables for the getters/setters and also methods
    private int attack;
    private int defense;
    private int hp;
    private String name;
    private int att;
    private int def;
    private int dmg;
    private int tDmg;
    private int eDmg;
    private int enemyDmg;
    Random rand = new Random();
    
  //constructor for the pokemon to give initial health points
    public Pokemon(int hp){
        this.hp = hp;
    }
    //returns random integer between 0 and 13 for the enemies damage points
    public int eDmg(){
    eDmg = rand.nextInt(13);
    return eDmg;
    }
    //returns random attack damage for player based on their attack stat they input, and also makes the attack 1 if the attack stat is 1
    public int dmg(){
    dmg = rand.nextInt(att);
    if(att == 1)
        dmg = 1;
    return dmg;
    }
    //sets the temporary damage for the player
    public void setTempDmg(int tDmg){
        this.tDmg = dmg;
    }
    //sets the temporary damage for the enemy
    public void setDmg(int enemyDmg){
        this.enemyDmg = enemyDmg;
    }
    //gets the temporary damage for the enemy
    public int getDmg(){
    return enemyDmg;
    }
    //gets the temporary damage for the player
    public int getTempDmg(){
        return tDmg;
    }
    //gets the attack stat for the player
    public int getAtt(){  
        return att;
    }
    //sets the attack stat for the player
    public void setAtt(int att){
        this.att = att;
    }
    //gets the defense state for the player
    public int getDef(){
        return def;
    }
    //sets the defense stat for the player
    public void setDef(int def){
        this.def = def;
    }
    //gets the hp for both player and enemy
    public int getHp(){
        return hp;
    }
    //sets the hp for both player and 
    public void setHp(int hp){
        this.hp = hp;
    }
    //gets the name for the player
    public String getName(){
        return name;
    }
    //sets the name for the player
    public void setName(String name){
        this.name = name;
    }
    //gets a random number between and certain set of values
    public static int getRandomNumber(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) +1) + min;
    }

}
