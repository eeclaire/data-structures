/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstgame;

import simplegui.SimpleGUI;

/**
 *
 * @author Claire
 */
public class Main {
    
    public static SimpleGUI sg = new SimpleGUI();   // SimpleGUI object
    
    public static void main(String[] args) {
        // TODO code application logic here
        setUpGUI();
        
        BST bst = new BST(9);
        bst.assignCoordinates();
        bst.visualize();
        //bst.createFromNumberSequence(bst.seq);
    }
    
    public static void setUpGUI(){
        sg.maximizeGUIonScreen();
    }
}
