/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstgame;

import java.util.Arrays;
import simplegui.SimpleGUI;

/**
 *
 * @author Claire
 */
public class Main {
    
    public static SimpleGUI sg = new SimpleGUI();   // SimpleGUI object
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //sg.pauseProgram(500);
        //sg.wait(1000);
        //sg.delay(1000);
        BST bst = new BST(4);
        bst.assignCoordinates();
        bst.visualize();
        //bst.createFromNumberSequence(bst.seq);
        //sg.pauseProgram(1000);
        
        // Displaying the GUI at the end seems to help?
        setUpGUI();
        
        bst.startGame();
        
        
        
        //Main.sg.drawText("Click on these numbers in order: ", Main.sg.getWidth(), 70);
    }
    
    public static void setUpGUI(){
        sg.maximizeGUIonScreen();
    }
}
