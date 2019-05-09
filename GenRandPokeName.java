//Programmer: Brandon Andrasco COP 2800
//Program: In this program you are asked to input the name of you pokemon, you then input the attack and defense stats
//The enemy is randomly generated and also has randomly generated stats. There is then a battle between the stats that you input and 
//the randomly generated enemies stats. The defense stats stays consistant and the attack is a number between 1 - att for the player and 0 - 13 for the enemy the enemies
//defense stat is randomly generated between 1 and 6 but stays consistant the whole way through. You are welcome to leave before the fight begins.
package pokebattle;

import java.util.Random;


public class GenRandPokeName {
    
    public static String[] RandomPokemon(String[] pokeNames){
		Random rand = new Random();  // Generates random pokemon name based on the list of Pokemon names listed in the main			
 
		for (int i=0; i<pokeNames.length; i++) {
		    int randomPosition = rand.nextInt(pokeNames.length);
		    String temp = pokeNames[i];
		    pokeNames[i] = pokeNames[randomPosition];
		    pokeNames[randomPosition] = temp;      
		}      
		return pokeNames;         
	}
    
}
