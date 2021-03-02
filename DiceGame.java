
/**
 * Plays the game by rolling a dice and checking to see how many target hits you rolled
 * Also checks to make sure you did not roll a 1 over 50% of the time. 
 *
 * @author (Logan Yeubanks)
 * @version (Version 1)
 */
import java.util.ArrayList;
public class DiceGame
{
    // Instance variables
    private ArrayList<Die> dice;
    private int targetNumber; 
    private int dieType;
    private static final int [] validDieTypes = {4, 6, 8, 10, 12, 20, 100};
    /**
     * Constructor for objects of class DiceGame
     */
    public DiceGame(int targetNumber, int dieType, int howManyDice)
    {
        // initialise instance variables
        final int maxNumberOfDice = 10;
        final int minTargetNumber = 5;
        final int maxTargetNumber = 30;
        // checks to see if all parameters are valid
        if(howManyDice <= maxNumberOfDice && contains(validDieTypes, dieType) && targetNumber >= minTargetNumber && targetNumber <= maxTargetNumber)
        {
            this.targetNumber = targetNumber;
            this.dieType = dieType;
            dice = new ArrayList<>();
            //Populates the dice list
            for (int i = 0; i < howManyDice; i++)
            {
                Die die = new Die(dieType);
                dice.add(die); 
            }
        }
        else
        {
            //Error message that is printed if parameters are not met. 
            System.out.println("Make sure the number of dice is less than 10");
            System.out.println("Make the die type is 4, 6, 8, 10, 12, 20, or 100");
            System.out.print("Make sure the target number is greater than 5 and less than 30");
            System.out.println("Try again");
        }
        
    }

    /**
     * Method that checks to see if elements are in a array
     *
     * @param  array and element
     * @return true or false
     */
    private boolean contains(int [] array, int element)
    {
  
        for(int i:array)
        {
            if(i == element)
            {
                return true;
            }
            
        }
        return false;
    }
    /**
     * Method to play the game. Rolls dice and prints the amount of targets hit
     * or if the roll was a bust. 
     */
    
    public void playGame()
    {
        // running totals for the amound of targets hit and ones rolled
        int numberOfTargetHits = 0;
        int numberOfRolledOnes = 0;
        for(Die die:dice)
        {
            int roll = die.rollDie();
            if(roll == 1)
            {
                numberOfRolledOnes += 1;
            }
            if(roll == targetNumber)
            {
                numberOfTargetHits += 1;
            }
        }
        //checks if the amount of ones rolled is over 50 percent and prints bust if so
        if(numberOfRolledOnes > dice.size() / 2)
        {
            System.out.println("Bust! You lose!");
        }
        //prints the amount of targets hit if the roll was not a bust
        else
        {
         System.out.println("You hit " + numberOfTargetHits + "!");   
        }
        
    }
}
