
/**
 * Describes what a die is and gives a method to roll it randomly
 *
 * @author (Logan)
 * @version (a version number or a date)
 */
import java.util.Random;
public class Die
{
    // instance variables
    private int max;
    private Random rand;
    
    /**
     * Constructor for objects of class Die
     */
    public Die(int max)
    {
        // initialise instance variables
        this.max = max;
        rand = new Random();
    }

    /**
     * rolls the die randomly and adds 1 if the roll is equal to the max, which is also the type of die used
     * 
     * @return runningTotal;
     */
    public int rollDie()
    {
        int runningTotal = 0;
        int recentRoll = rand.nextInt(max) + 1;
        runningTotal += recentRoll;
        while(recentRoll == max)
        {
            recentRoll = rand.nextInt(max) + 1;
            runningTotal += recentRoll; 
        }
        return runningTotal;
    }
}
