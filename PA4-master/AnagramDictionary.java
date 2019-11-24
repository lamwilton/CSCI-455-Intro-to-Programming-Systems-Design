// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA4
// Fall 2019

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   
   private Map<String, ArrayList<String>> aMap;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      aMap = new HashMap<>();
      File file = new File(fileName);
      Scanner in = new Scanner(file);
      while (in.hasNext()) {
         String word = in.next();
         String wordSort = sortString(word);
         // if canon key does not exist
         if (!aMap.containsKey(wordSort)) {
            aMap.put(wordSort, new ArrayList<>(Collections.singletonList(word)));
         }
         // if exists, get Arraylist value, add word, and put it back to map
         else {
            ArrayList<String> temp = aMap.get(wordSort);
            temp.add(word);
            aMap.put(wordSort, temp);
         }
      }
   }

   /**
    * Sort the string in alphabetical order
    * @param word  input string
    * @return sorted string
    */
   private String sortString(String word) {
      char[] wordArr = word.toCharArray(); // Convert to char Array, sort, and convert back to String
      Arrays.sort(wordArr);
      return new String(wordArr);
   }


   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      String wordSort = sortString(s);
      return aMap.get(wordSort);
   }
   
   
}
