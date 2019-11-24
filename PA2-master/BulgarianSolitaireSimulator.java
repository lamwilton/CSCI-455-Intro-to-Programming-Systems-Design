// Name: Ting Fung Lam
// USC NetID: tingfunl
// CSCI455 PA2
// Fall 2019
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Main program for simulating Bulgarian Solitare
 * @author Administrator
 *
 */

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
      
      // <add code here>
      Scanner in = new Scanner(System.in);
      SolitaireBoard solitaireBoard = new SolitaireBoard(); //Random initialzation
      System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
      if (userConfig) {
         solitaireBoard = start(solitaireBoard, in);
      }
      System.out.println("Initial configuration: " + solitaireBoard.configString());
      int roundCount = 0;
      while (!solitaireBoard.isDone()) {
         solitaireBoard.playRound();
         roundCount++;
         System.out.println("[" + roundCount + "] Current configuration: " + solitaireBoard.configString());
         if (singleStep) { //single stepping
            System.out.print("<Type return to continue>");
            in.nextLine();
         }
      }
      System.out.println("Done!");
   }
   
   // <add private static methods here>
   /**
    * Start of program if userconfig is true, Getting user input. Also checks for input error. 
    * Overwrites random genenated array reference
    * @param solitaireBoard  Input the old SolitaireBoard object
    * @param in  Scanner object
    * @return solitaireBoard Return the initialized SolitaireBoard object
    */
   private static SolitaireBoard start(SolitaireBoard solitaireBoard, Scanner in) {
         int sum = 0;
         ArrayList<Integer> piles = new ArrayList<Integer>();
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         while (sum != SolitaireBoard.CARD_TOTAL) {
            System.out.println("Please enter a space-separated list of positive integers followed by newline:");
            String input = in.nextLine();
            Scanner lineScanner = new Scanner(input);
            int x = 1;  //Assigning a non-zero positive integer, break command removed
            boolean valid = true;
            while (lineScanner.hasNextInt()) {
               x = lineScanner.nextInt();
               if (x <= 0) {
                  valid = false; // Check for zeros and negatives
               }
               sum += x;
               piles.add(x);
            }
            if (sum != SolitaireBoard.CARD_TOTAL || !valid) {
               System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL);
               sum = 0; //reset if error occurs
               piles = new ArrayList<Integer>();
            }
            lineScanner.close();
         }
         solitaireBoard = new SolitaireBoard(piles);  //Create another object according to user input
      return solitaireBoard;
   }
}
