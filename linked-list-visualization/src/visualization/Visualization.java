/*
 * Claire Durand
 * CIS 2168 Assignment 2
 * September 16th 2015
 *
 * Visualization Class
 *
 * Main class of the program. Instantiates a SimpleGUI and a canvas object
 * to decorate the SimpleGUI. The main instatiates a LinkedList object and 
 * creates 10 houses, numbering them in order of creation. It also traverses
 * through the houses coloring them red instead of orange.
 * 
 */
package visualization;

import java.util.Set;
import simplegui.SimpleGUI;

/*
 * Visualization class
 */
public class Visualization {

   
    public static SimpleGUI sg = new SimpleGUI();   // SimpleGUI object
    public static ScreenCanvas toile = new ScreenCanvas();  // to draw on sg

    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        
        // Set up and show the GUI
        toile.setupCanvas();
        
        // Here is where we instantiate objects etc...
        LinkedList ll = new LinkedList();
        
        // Build 10 elements (houses) in the linked list
        for (i=0;i<10;i++){
            ll.addFirst();
            ll.START.house.number = i;
        }
        
        ll.traverseList();  // traverse houses here
    }
      
}
