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

        
            BST bst = new BST(10);
            bst.assignCoordinates();
            bst.visualize();

            // Displaying the GUI at the end seems to help?
            setUpGUI();

            bst.startGame();
        
        while (true) {
            bst = new BST(10);
            bst.assignCoordinates();
            bst.visualize();

            // Displaying the GUI at the end seems to help?
            setUpGUI();

            bst.startGame();
        }
    }

    public static void setUpGUI() {
        sg.maximizeGUIonScreen();
    }
}
