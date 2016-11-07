/*
 * Claire Durand
 * CIS 2168 Assignment 2
 * September 16th 2015
 *
 * House Class
 *
 * Class contains methods to draw the house on the SimpleGUI 
 * to decorate the SimpleGUI. The main instatiates a LinkedList object and 
 * creates 10 houses, numbering them in order of creation. It also traverses
 * through the houses coloring them red instead of orange.
 * 
 */

package visualization;

import java.awt.Color;
import simplegui.SimpleGUI;
import java.util.Random;

public class House {
    
    // Fields -----------------------------------------------------------------
    SimpleGUI sg = Visualization.sg;   // gotta be able to draw on something
    int x;  // x coordinate for the top left corner of the house
    int y;  // y coordinate for the top left corner of the house

    int number; // keep track of the order of the house
        
    // Methods ----------------------------------------------------------------
    
    // Method to draw the house on the Simple GUI using its fields
    public void drawHouse(){
        this.createRandCoord();     // generate some random coords for the house
        sg.drawFilledBox(x, y, 50, 50, Color.ORANGE, 1, null);  // draw it there

    }
    
    // Method to repaint the house once we get to traversing the linked list
    public void repaintHouse(){
        // it'd be cool to actually delete the previous filled box instead of
        // just painting over. Look into using a string name to delete it
        
        // In the meantime, just draw a different colored house on top:
        sg.drawFilledBox(x, y, 50, 50, Color.RED, 1, null);

    }
    
    // Method to generate some random coordinates for the house
    public void createRandCoord(){
        // Create a Randomizer object
        Random rand = new Random();
        
        // Randomize house location
        this.x = rand.nextInt(950); // 950 is the max width in pixels
        this.y = rand.nextInt(550); // 550 is the max height in pixels
    }
    
}
