// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA4
// Fall 2019

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Table of final results of each word and its score
 */
public class ScoreTable {
   private static final int[] POINTS = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

   public ScoreTable(ArrayList<String> words) {
      WordScore[] table = new WordScore[words.size()];
      for (int i = 0; i < words.size(); i++) {
         table[i] = new WordScore(words.get(i));
      }
      Arrays.sort(table);
      // Print final results
      System.out.println("All of the words with their scores (sorted by score):");
      for (ScoreTable.WordScore i : table) {
         System.out.println(i.score + ": " + i.word);
      }
   }


   /**
    * Inner class of each object containing one word and its score
    */
   class WordScore implements Comparable<WordScore> {
      private int score;
      private String word;

      public WordScore(String word) {
         this.word = word;
         this.score = calScore();
      }

      /**
       * Implementation of comparable class
       * First compare score, then compare word
       * @param other  Another object of WordScore
       * @return  positive or negative number
       */
      @Override
      public int compareTo(WordScore other) {
         if (score != other.score) {
            return other.score - score;
         }
         return word.compareTo(other.word);
      }

      /**
       * Calculate score of the word
       * @return score
       */
      public int calScore() {
         int score = 0;
         String wordLow = word.toLowerCase();
         char[] wordArr = wordLow.toCharArray();
         for (char c : wordArr) {
            score += POINTS[c-'a'];
         }
         return score;
      }
   }
}
