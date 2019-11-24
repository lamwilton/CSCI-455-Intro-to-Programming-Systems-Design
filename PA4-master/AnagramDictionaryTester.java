import java.io.FileNotFoundException;

public class AnagramDictionaryTester {
   public static void main(String[] args) throws FileNotFoundException {
      AnagramDictionary dict = new AnagramDictionary("testFiles/tinyDictionary.txt");
      System.out.println("Getting Anagrams of [rifel] " + dict.getAnagramsOf("rifel"));
   }
}
