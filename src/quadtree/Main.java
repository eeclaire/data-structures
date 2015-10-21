/*
 * Claire Durand
 * CIS 2168 - Random Quadtree Lab
 * 10/21/2015
 * 
 * Main Class
 * Instantiates the quad tree object, inserts 101 nodes containing values 0-100
 * traverses the tree recursively to calculate the sum of the node values,
 * then instantiates the visualizer to display the tree
 * 
 */
package quadtree;

import qtvisualizer.*;


public class Main {
    
    public static void main(String[] args) {
        
        // Instantiate a new tree object
        QuadTree qt = new QuadTree();
        
        // For loop to randomly populate the tree with values from 0-100
        int i;
        for (i=0; i<=100; i++){
            qt.insertAtRandomPosition(i);
        }
        
        // Calculate the sum of items in the tree from the root
        qt.sum(qt.root);
        
        // Instantiate the visualizer with the tree root
        QuadTreeViz qtvis = new QuadTreeViz(qt.root);
    }
    
}

// End of Main.java ------------------------------------------------------------