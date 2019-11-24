// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA1
// Fall 2019

/**
 * CoinTossSimulatorTester class
 * A program to test the CoinTossSimulator class
 * @author Administrator
 */
public class CoinTossSimulatorTester {
   
   /**
    * Runs the test with a certain number of trials. Avoids repeating same lines of code
    * @param num  number of trials 
    * @param total  total numbers of trials 
    * @param simulator  CoinTossSimulator object
    */
   private static int RunTest(int num, int total, CoinTossSimulator simulator) {
      boolean correct = false;
      simulator.run(num);
      total = total + num;
      System.out.println("After run(" + num + "):");
      System.out.println("Number of trials [exp:" + total + "]: " + simulator.getNumTrials());
      System.out.println("Two-head tosses: " + simulator.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
      if (simulator.getNumTrials() == total) {
         correct = true;
      }
      System.out.println("Tosses add up correctly? " + correct);
      return total; // Updates the number of trials counter
   }
   /**
    * Main method
    * @param args
    */
   public static void main(String[] args) {
      int total = 0; // Counter for the total number of trials 
      boolean correct = false;
      CoinTossSimulator simulator = new CoinTossSimulator();
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:" + total + "]: " + simulator.getNumTrials());
      System.out.println("Two-head tosses: " + simulator.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
      if (simulator.getNumTrials() == total) {
         correct = true;
      }
      System.out.println("Tosses add up correctly? " + correct);
      
      total = RunTest(1, total, simulator);
      total = RunTest(10, total, simulator);
      total = RunTest(100, total, simulator);  
      
      simulator.reset();
      total = 0 ;
      System.out.println("After reset:");
      System.out.println("Number of trials [exp:0]: " + simulator.getNumTrials());
      System.out.println("Two-head tosses: " + simulator.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
      if (simulator.getNumTrials() != total) {
         correct = false;
      }
      System.out.println("Tosses add up correctly? " + correct);
      
      total = RunTest(1000, total, simulator);
   }

}
