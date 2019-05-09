//Programmer: Brandon Andrasco COP 2800
//Program: In this program you are asked to input the name of you pokemon, you then input the attack and defense stats
//The enemy is randomly generated and also has randomly generated stats. There is then a battle between the stats that you input and 
//the randomly generated enemies stats. The defense stats stays consistant and the attack is a number between 1 - att for the player and 0 - 13 for the enemy the enemies
//defense stat is randomly generated between 1 and 6 but stays consistant the whole way through. You are welcome to leave before the fight begins.
package pokebattle;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import static pokebattle.GenRandPokeName.RandomPokemon;
import static pokebattle.Pokemon.getRandomNumber;


public class PokeBattle {

    public static void main(String[] args) throws Exception {
        // creating variables
        Random rand = new Random();
        boolean success = false;
        int count = 0;
        int attStat = 0;
        int defStat = 0;
        int neg = 0;
        

        Scanner input = new Scanner(System.in);//scanner for user input
        String[] pokeNames = {"Charmander", "Squirtle", 
            "Pikachu", "Pidgey", "Bulbasaur", "Caterpie" };//string for GenRandPokeName
        
        Pokemon player = new Pokemon(50);//instances for the constructors
        Pokemon enemy = new Pokemon(50);//instances for the constructors
        
        enemy.setDef(getRandomNumber(1,6));//uses the method in a seperate class the generate a random number between the values for the enemies defence
        
        Introduction();//calls the introduction method
        
        //prompt for input for the name of the Pokemon
        System.out.println("What would you like the name of your Pokemon to be?");
        player.setName(input.nextLine());
        System.out.printf("Your Pokemon's name is: %s", player.getName());
        
        Instructions();//method for instructions
        
        //this entire do while loop asks for the input of attack and defense, checks to make sure they are and integer, 
        //and also checks to make sure the total is less than 10 and not less than 0
        do{
            if(count >= 1){
                System.out.printf("You attack and defense stats totalled %d, and did not follow the critia.%n"
                        + "Please enter the attack and defense that will equal 10 total.%n", attStat + defStat);count--;
            }
        while(!success || attStat <= 0){//while loop while it is true or while the attack input is less than or equal to 0
            neg = 0;//resets the increment for negative number input
            try{//checks for input int
            System.out.println("What would you like to set your attack to?");
            attStat = input.nextInt();
            success = true;   
            }catch(InputMismatchException e){//throws exceptions for inputs that are not int
                input.next();
                System.out.println("You have not entered a valid input.");
            }
            if(attStat <= 0)//if statement to increment if attack is set to a negative or zero
                neg++;
            if(neg >= 1)//displays if attack stat is negative
                System.out.println("Please enter a positive number.");   
        }
        player.setAtt(attStat);//sets the attack stat for the player
        success = false;
        while(!success || defStat < 0){//while loop while it is true or while the defense input is less than or equal to 0
            neg = 0;
            try{//checks for input int
            System.out.println("What would you like to set your def to?");
            defStat = input.nextInt();
            success = true;
            }catch(InputMismatchException e){//throws exceptions for inputs that are not int
                input.next();
                System.out.println("You have not entered a valid input.");
            }
            if(defStat < 0)//if statement to increment if defense is set to a negative
                neg++;
            if(neg >= 1)//displays if defense stat is negative
                System.out.println("Please enter a non-negative number.");
        }
        success = false;
        player.setDef(defStat);//sets the defense stat for the player
        count++;
        }while((attStat + defStat) > 10 || (attStat + defStat) < 0);
        
        String[] temp = RandomPokemon(pokeNames);//sets the random pokemon name to a consistant string array value so it is not constantly random
        System.out.printf("%nYour opponent will be: %s%n", temp[1]);//displays the opponents name
        
            System.out.println("Would you like to begin the battle?(Yes or No)");
            if(input.next().equalsIgnoreCase("no")){//ends the battle completely if no is input
                System.out.println("You have fled the battle...");
                return;
            }
        
            //displays the beginning battle sequence
        System.out.printf("%s jumps into battle with %s%n%n", player.getName(), temp[1]);
        do//do while loop that displays the battle sequence between the player and the enemy based on the stats associated with each
        {
            player.setTempDmg(player.dmg() - enemy.getDef());//sets the temp damage using the formula written
            enemy.setHp(enemy.getHp() - player.getTempDmg());//updates the enemies hp stat
            System.out.println(player.getName() + " does "+ player.getTempDmg() + " damage to " + temp[1] + ". " + temp[1] + " has " + enemy.getHp() + " more hitpoints");
            if(enemy.getHp() < 1)//if enemy dies before player this breaks out of the loop
                break;
            
            enemy.setDmg(enemy.eDmg() - player.getDef());//sets the enemies damage
            if(enemy.getDmg() < 0)//if the damage is less the 0 based on the defense of the player, the dmg is  set to 0
                enemy.setDmg(0);
            player.setHp(player.getHp() - enemy.getDmg()); //updates the players hp
            System.out.println(temp[1] + " does "+ enemy.getDmg() + " damage to " + player.getName() + ". " + player.getName() + " has " + player.getHp() + " more hitpoints\n");
                
        }while(player.getHp() >= 1 && enemy.getHp() >= 1);
        if(player.getHp() < 1){//displays if player dies
            System.out.println(player.getName() + " has feinted...");
        }
        else //displays if enemy dies
            System.out.println(temp[1] + " has feinted...");
    }
    
    //Introduction for the user to read and interact with later
    public static void Introduction(){
        System.out.println("Welcome to the Pokemon Creation Lab.\nWith our tools you can name and customize the attack and defense of your pokemon."); 
    }
    //Instructions for the program inputs
    public static void Instructions(){
        System.out.println("\nYou are allowed to use 10 points total in your customization of attack and defense.\n"
                + "Your attack will generate a random attack between zero and your Max attack.\nYour defense will be "
                + "a set number based on your choice. (Remember: you do not know who you are up against)");
    }
}
