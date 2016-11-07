/*
 * Claire Durand
 * CIS 2168 Assignment 1 (Slider Bonus version)
 * September 1st 2015
 *
 * GUI Test Class
 * Implements a listener and provides the required callback methods
 * 
 */
package cis2168_assignment1_bonus;

import simplegui.GUIListener;

public class GUITest implements GUIListener{
    private GUI g;

    // Main -------------------------------------------------------------------
    public static void main(String[] args) {
        GUITest listener = new GUITest();   // implement in order to do things
    }
    
    // Constructors -----------------------------------------------------------
    public GUITest(){
        g = new GUI();  // implement the bespoke GUI manipulation class, GUI
        g.sg.registerToGUI(this);   // places the GUI in the event list
    }
        
    // Callback methods -------------------------------------------------------
    @Override
    public void reactToSlider(int i) {
        g.showGUI();    // display the GUI
        g.drawGrid(i);  // manipulate the GUI
        System.out.println("Slider value: " + i);   // for debugging purposes
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
}   // end GUITest class

