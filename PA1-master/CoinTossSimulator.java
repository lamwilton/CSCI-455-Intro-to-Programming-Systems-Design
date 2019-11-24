// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA1
// Fall 2019
import java.util.Random;
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
   private Random generator = new Random();
   private int twoHeads;
   private int twoTails;
   private int headTails;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      int i;
      for (i = 1; i <= numTrials; i++) {
         int result = generator.nextInt(2) + generator.nextInt(2);   //Flips two coin and add results
         if (result == 0)  //NOR
            twoHeads++;
         else if (result == 1)   //XOR
            headTails++;
         else  //AND
            twoTails++;
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return getTwoHeads() + getTwoTails() + getHeadTails(); 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;
   }

}
