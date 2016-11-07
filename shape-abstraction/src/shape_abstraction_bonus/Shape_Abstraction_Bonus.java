/*
 * Claire Durand
 * CIS 2168 - Shape Abstraction Lab
 * 09/23/2015

 * Listener Class
 */
package shape_abstraction_bonus;

import simplegui.GUIListener;

public class Shape_Abstraction_Bonus implements GUIListener{
    private Shape_Abstraction sa;

    // Main -------------------------------------------------------------------
    public static void main(String[] args) {
        // Implement a listener
        Shape_Abstraction_Bonus listener = new Shape_Abstraction_Bonus();
    }
    
    // Constructors -----------------------------------------------------------
    public Shape_Abstraction_Bonus(){
        // register to the GUI
        sa = new Shape_Abstraction();
        sa.sg.registerToGUI(this);
        
        // Set title
        sa.sg.setTitle("Shape Abstraction - move the slider left to see the shape abstract!");
        
        // Read in the points from the shapelist.txt file
        String filename;
        filename = "shapelist.txt"; // variable for file name
        sa.readFile(filename);
        
        // print out the original deer
        sa.printOGDeer(); 
    }
    
    // Callback methods -------------------------
    @Override
    public void reactToSlider(int i) {
        
        // reset the screen
        sa.sg.eraseAllDrawables();
        //System.out.println("Slider: "+i);
        
        // scale the slider value
        int n = i*(400/138)+38;
         
        // remove elements in the linked list as appropriate and reprint deer
        sa.removeElements(n);
        sa.printOGDeer();   
    }

    @Override
    public void reactToButton1() { 
        // Do nothing
    }

    @Override
    public void reactToButton2() {
        // Do nothing
    }

    @Override
    public void reactToSwitch(boolean bln) {
         // Do nothing
    }
}   // end listener

    

