/*
 * Claire Durand
 * CIS 2168 Assignment 2
 * September 16th 2015
 *
 * LinkedList Class
 * 
 * Class that contains the single linked list data structure and its addFirst
 * and traverseList methods.
 * 
 */

package visualization;

import java.awt.Color;
import simplegui.SimpleGUI;


public class LinkedList {

    // Fields -----------------------------------------------------------------
    SimpleGUI sg = Visualization.sg;    // pull down the static sg object
    Node START;     // Tracks where the Linked List starts

    // Constructors -----------------------------------------------------------

    // Method to replace the first element in the Linked List and give it the
    // reference to the old first element.
    public void addFirst() {
        // I think you need a new house object to pass into Node
        House house = new House();
        house.drawHouse();      // Display the house on the SimpleGUI

        // Create a new Node with the house you just created
        Node recentNode = new Node(house);  

        recentNode.next = START;    // place old first ref into the .next field
        START = recentNode;     // your new START is now the new house!

        // Draw connections between houses on the SimpleGUI
        if (START.next != null) {
            this.drawConnections(START.house.x, START.house.y, START.next.house.x, START.next.house.y, Color.ORANGE);
        }

    }

    
    // Method to traverse through the linked list, repaint houses & connections
    public void traverseList() {
        Node current = START;   // set your current at the start

        // As long as you haven't reached the end of the list...
        while (current != null) {   

            char c = sg.keyReadChar();  // wait for user input before moving on

            current.house.repaintHouse();   // repaint the house in the gui

            // also redraw the connection in red
            if (current.next != null) {
                this.drawConnections(current.house.x, current.house.y, current.next.house.x, current.next.house.y, Color.red);
            }

            // Print out the house no. (most recent will have the highest no.)
            // and inform user if the last house is reached
            System.out.println("House no. " + current.house.number); // + print
            if (current.next == null)
                System.out.println("You've reached the first house built!");

            // reset current in order to move down
            current = current.next;
        }

    }

    public void drawConnections(int xStart, int yStart, int xEndHouse, int yEndHouse, Color c) {
        // presumably some traverse and drawLines or some shit
        sg.drawLine(xStart, yStart, xEndHouse + 50, yEndHouse + 50, c, 1, 4, null);
    }

}
