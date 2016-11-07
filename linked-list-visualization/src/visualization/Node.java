/*
 * Claire Durand
 * CIS 2168 Assignment 2
 * September 16th 2015
 *
 * Node Class
 *
 * Contains the constructor to attach the reference to the house object. Also 
 * contains a reference to the next node. 
 * 
 */

package visualization;

public class Node {
    // Fields -----------------------------------------------------------------
    House house;    // reference to House data
    Node next;      // reference to next node in the linked list
    
    // Constructor ------------------------------------------------------------
    public Node(House house) {
        
        this.house = house; // set the reference
        
    }
    
}
