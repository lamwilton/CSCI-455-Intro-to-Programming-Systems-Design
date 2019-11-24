// Name: Ting Fung Lam
// USC NetID: tingfunl
// CS 455 PA1
// Fall 2019

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * CoinSimComponent class
 * This component draws the three bars using the Bar class
 */

/**
 * @author Administrator
 *
 */
public class CoinSimComponent extends JComponent {
   private static final long serialVersionUID = 1L;
   private int numTrials;
   private int twoHeads;
   private int twoTails;
   private int headTails;
   public static final int BAR_WIDTH = 50;
   public static final int VERTICAL_BUFFER = 40;
   public static final double PERCENT = 100;
      
   /**
      Creates the three bars. Given the parameters from the CoinTossSimulator class which are the results of the coin tosses
   
      @param numTrials  number of trials
      @param twoHeads  number of Two Heads
      @param twoTails  number of Two Tails
      @param headTails  number of A head and a tail
   */
   public CoinSimComponent(int numTrials, int twoHeads, int twoTails, int headTails) {
      this.numTrials = numTrials;
      this.twoHeads = twoHeads;
      this.twoTails = twoTails;
      this.headTails = headTails;
   }
   
   /**
    * Paints the three bars with labels
    * @param g  the graphics context
    */
   public void paintComponent(Graphics g) {  
      Graphics2D g2 = (Graphics2D) g;
      int windowWidth = getWidth();
      int windowHeight = getHeight();
      // Percentages
      int twoHeadsRatio = (int) Math.round(twoHeads / (double) numTrials * PERCENT);
      int twoTailsRatio = (int) Math.round(twoTails / (double) numTrials * PERCENT);
      int headTailsRatio = (int) Math.round(headTails / (double) numTrials * PERCENT);
      // Labels
      String twoHeadsLabel = "Two Heads: " + twoHeads + " (" + twoHeadsRatio + "%)";
      String twoTailsLabel = "Two Tails: " + twoTails + " (" + twoTailsRatio + "%)";
      String headTailsLabel = "A Head and a Tail: " + headTails + " (" + headTailsRatio + "%)";
      // Scales
      double scale = (windowHeight - VERTICAL_BUFFER) / (double) PERCENT;
      
      // Create and draw the three Bar objects
      Bar barTwoHeads = new Bar(windowHeight - VERTICAL_BUFFER, windowWidth * 1/4 - BAR_WIDTH / 2, 
            BAR_WIDTH, twoHeadsRatio, scale, Color.red, twoHeadsLabel);
      Bar barTwoTails = new Bar(windowHeight - VERTICAL_BUFFER, windowWidth * 3/4 - BAR_WIDTH / 2, 
            BAR_WIDTH, twoTailsRatio, scale, Color.blue, twoTailsLabel);
      Bar barHeadTails = new Bar(windowHeight - VERTICAL_BUFFER, windowWidth * 1/2 - BAR_WIDTH / 2, 
            BAR_WIDTH, headTailsRatio, scale, Color.green, headTailsLabel);
      barTwoHeads.draw(g2);
      barTwoTails.draw(g2);
      barHeadTails.draw(g2);
   }


}
