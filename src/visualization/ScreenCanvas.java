/*
 * Claire Durand
 * CIS 2168 Assignment 2
 * September 16th 2015
 *
 * ScreenCanvas Class
 *
 * This is where the SimpleGUI setup happens, and where we want to place
 * decorations to draw on the SimpleGUI, such as the green island background.
 * 
 */

package visualization;


import java.awt.Color;
import simplegui.SimpleGUI;


public class ScreenCanvas {
    
    // Fields -----------------------------------------------------------------
    SimpleGUI sg = Visualization.sg;    // pull down the static SimpleGUI object
    
    // Methods ----------------------------------------------------------------
    public void setupCanvas(){
        
        // Show the GUI
        showGUI();
        
        // paint a green "island"
        sg.drawFilledBox(0, 0, 1000, 600, Color.green, 0.2, null);   
    }
    
    // Set up the GUI (titles, centers & loads the image into the GUI)
    public void showGUI() {
        sg.setTitle("Linked List Visualization");
        sg.maximizeGUIonScreen();
    }
}
