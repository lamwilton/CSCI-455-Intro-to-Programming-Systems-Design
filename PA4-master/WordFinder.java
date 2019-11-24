// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA4
// Fall 2019

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the program
 */
public class WordFinder {
   public static void main(String[] args) {
      // Read File Name
      String fileName = "sowpods.txt";
      if (args.length > 0) {
         fileName = args[0];
      }
      // Open the file and create dictionary
      try {
         AnagramDictionary dict = new AnagramDictionary(fileName);
         System.out.println("Type . to quit.");
         // Get user input
         Scanner in = new Scanner(System.in);
         String input = "";
         while (true) {
            System.out.print("Rack? ");
            if (in.hasNext()) {
               input = in.next();
            }
            if (input.equals(".")) {
               return;
            }
            // Make new rack and output all found words
            ArrayList<String> words = findWords(dict, input);
            System.out.println("We can make " + words.size() + " words from \"" + input + "\"");

            // Make scores table and output final results
            if (words.size() > 0) {
               ScoreTable table = new ScoreTable(words);
            }
         }
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found! Filename: " + fileName);
         System.exit(-1);
      }
   }

   /**
    * Find all words from input using dictionary
    * @param dict  dictionary object
    * @param input  input string by user
    * @return  ArrayList of found words
    */
   private static ArrayList<String> findWords(AnagramDictionary dict, String input) {
      Rack rack = new Rack(input);
      ArrayList<String> rackList = rack.getRackList();
      ArrayList<String> words = new ArrayList<>();

      for (String subset : rackList) {
         ArrayList<String> anagramsSubset = dict.getAnagramsOf(subset);
         if (anagramsSubset != null) {
            words.addAll(anagramsSubset);
         }
      }
      return words;
   }
}
