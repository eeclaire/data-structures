/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree;

import java.util.Random;

 
public class QuadTree {
    
    // Fields -----------------------------------------------------------------
    QNode root;
    QNode[] children = new QNode[4];
    
    // Methods ----------------------------------------------------------------
    
    // Method to populate the tree with a single new node with an input value v
    public void insertAtRandomPosition(double v){
        
        // Create the new node to be placed
        QNode newNode = new QNode(v);
        
        Random rand = new Random();
        
        if (root == null){
            root = newNode;
            return;
        }
        
        QNode current = root;
        
        while (true){
            // generate a random number between 0 (inclusive) and 4 (exclusive)
            int r = rand.nextInt(4);
            
            // If the random child of this node is free, give it the new node. 
            // Otherwise, check a random child of this child.
            if (current.children[r] == null){
                current.children[r] = newNode;
            } else {
                current = current.children[r];
            }
        }
    }

    
}
