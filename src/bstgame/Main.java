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

        int numOfNodes = 10;
        
        // Initial run. Instantiate a BST, assign coordinates, show them,
        // set up the GUI, and go through the game.
        BST bst = new BST(numOfNodes);
        bst.assignCoordinates();
        bst.visualize();

        // Displaying the GUI at the end seems to help?
        setUpGUI();

        // Start the game sequence
        bst.startGame();
        
        // Keep playing the game forever
        while (true) {
            
            // Initial run. Instantiate a BST, assign coordinates, show them,
            // set up the GUI, and go through the game.
            bst = new BST(numOfNodes);
            bst.assignCoordinates();
            bst.visualize();

            // Displaying the GUI at the end seems to help?
            setUpGUI();

            // Start the game sequence
            bst.startGame();
        }
    }

    // Method to set up the GUI
    public static void setUpGUI() {
        sg.maximizeGUIonScreen();
    }
}
