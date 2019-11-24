// Name: Ting Fung Lam
// USC NetID: tingfunl
// CSCI455 PA2
// Fall 2019

import java.util.ArrayList;
import java.util.Random;
/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total 
  number of cards is for the game by changing NUM_FINAL_PILES, below.  
  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.  (See comments 
  below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt 
   // description for details.
   
   public static final int ARRAY_SIZE = CARD_TOTAL + 1; 
   //Must add 1 more space in case all piles have size of 1
   /**
      Representation invariant:

      piles array sum must always add up to CARD_TOTAL
      1 <= numPiles <= piles.length
      the piles are in piles locs [0, numPiles - 1]
      [numpiles, piles.length - 1] must be zeros
   */
   
   // <add instance variables here>
   private Random generator = new Random();
   private int piles[];
   private int numPiles;
 
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of 
      cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to 
      SolitaireBoard.CARD_TOTAL
      @param piles  Contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      this.piles = new int[ARRAY_SIZE];  
      for (int i = 0; i < piles.size(); i++) {
         this.piles[i] = piles.get(i);
      }
      numPiles = 0;
      // sample assert statement (you will be adding more of these calls)
      // this statement stays at the end of the constructor.
      assert isValidSolitaireBoard();   
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      piles = new int[ARRAY_SIZE]; //Automatically initialize to 0
      int currentSum = 0;
      for (int i = 0; i < ARRAY_SIZE; i++) {
         if (currentSum != CARD_TOTAL) { //Check if there are cards left
            piles[i] = generator.nextInt(CARD_TOTAL - currentSum) + 1; // Zeros not allowed
            currentSum = currentSum + piles[i];
         }
      }
      numPiles = 0;
      assert isValidSolitaireBoard();
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration 
      according to the rules of Bulgarian solitaire: Takes one card from each
      pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {  
      //Time complexity should be 2n, n for counting, n for subtracting 1. 
      numPiles = countPiles();
      for (int i = 0; i < numPiles; i++) {
         piles[i]--;
      }
      piles[numPiles] = numPiles;   //Make the new pile
      removeZeros();
      assert isValidSolitaireBoard(); 
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, 
      there are NUM_FINAL_PILES piles that are of sizes 
      1, 2, 3, . . . , NUM_FINAL_PILES, 
      in any order.
      @return done true if the program converges
   */
   
   public boolean isDone() {  //Time complexity should be O(2n)
      boolean done = false;
      int[] count = new int[NUM_FINAL_PILES];
      for (int i : piles) {   //Count how many times each number occur
         if (i > 0 && i <= NUM_FINAL_PILES) {
            count[i - 1]++; 
         }
      }
      done = true;
      for (int i = 0; i < NUM_FINAL_PILES; i++) {  //Done if each number appear exactly once
         if (count[i] != 1) {
            done = false;
         }
      }
      assert isValidSolitaireBoard();
      return done;
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {
      String x = "";
      for (int i : piles) {
         if (i > 0) {
            x += i + " ";
         }
      }
      assert isValidSolitaireBoard(); 
      return x;
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      numPiles = countPiles();
      int sum = 0;
      boolean valid = false;
      boolean noZeros = true;
      for (int i = 0; i < numPiles; i++) {  //Check if each number is non-zero positive and calculate sum
         if (piles[i] > 0) {
            sum += piles[i];
         }
         else {
            return false;  //Removed break; for style
         }
      }
      if (sum == CARD_TOTAL && noZeros == true) {
         valid = true;
      }
      return valid;
   }
   

   // <add any additional private methods here>
   // add method to remove zeros and count number of piles
   /** 
    * Counting the number of piles in the array, or number of non-zero positive integers at the beginning
    * @return numPiles The number of piles
    */
   private int countPiles() {
      numPiles = 0;
      for (int i : this.piles) {
         if (i > 0) {
            numPiles++;
         }
         else {
            return numPiles;  //Replaced break; with early return
         }
      }
      return numPiles;
   }
   /**
    * Remove zero gaps in arrays by creating a new array and overwrite
    */
   private void removeZeros() {
      int count = 0; //Count how many positive non zero numbers
      for (int i = 0; i < ARRAY_SIZE; i++) {
         if (piles[i] > 0) {
            piles[count] = piles[i];
            count++;
         }
      }
      for (int i = count; i < ARRAY_SIZE; i++) {
         piles[i] = 0; // Fill end of array with 0s
      }
   }
}
