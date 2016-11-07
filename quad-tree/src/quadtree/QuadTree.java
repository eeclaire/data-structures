/*
 * Claire Durand
 * CIS 2168 - Random Quadtree Lab
 * 10/21/2015
 * 
 * QuadTree Class
 * Implements the QuadTreeNode interface. 
 * Class to describe the nodes of the quad tree. Each node has one value (set 
 * 0-100 in main) and 4 possible node children. The class defines the interface
 * getChildren method by returning the children of each node to be displayed.
 * 
 */
package quadtree;

import java.util.Random;

 
public class QuadTree {
    
    // Fields -----------------------------------------------------------------
    QNode root;
    
    // Methods ----------------------------------------------------------------
    
    // Method to populate the tree with a single new node with an input value v
    public void insertAtRandomPosition(double v){
        
        // Create the new node to be placed
        QNode newNode = new QNode(v);
        
        // Create new randomizer object
        Random rand = new Random();
        
        // If there is no root node yet, place the new node there
        if (root == null){
            root = newNode;
            return;
        }
        
        // Make a current node to keep track of position without losing root
        QNode current = root;
        
        while (true){
            // generate a random number between 0 (inclusive) and 4 (exclusive)
            int r = rand.nextInt(4);
            
            // If the random child of this node is free, give it the new node
            // and break out of the loop.
            // Otherwise, check a random child of this child.
            if (current.children[r] == null){
                current.children[r] = newNode;
                break;
            } else {
                current = current.children[r];    
            }
        }
    }

    // Method to traverse the tree and sum up the nodes
    public double sum(QNode root){
        
        // Create the variable to hold the sum
        double sum;
        
        // Call recursive sum function for sum of the node values under root
       sum = sumRecursive(root);
       
       // Print out the result, for verification purposes
       System.out.println("Sum = " + sum);
       
       // Return the sum of the 
       return sum;      
    }
    
    // Method to sum up all of the values under and including a node
    public double sumRecursive(QNode node){
        
        // Base case - if you've reached a leaf
        if((node.children[0] ==  null)
                && (node.children[1] == null)
                && (node.children[2] == null)
                && (node.children[3] == null)){
            return node.value;
        }
        
        // Recursive case - if any of the children are not null,
        // go into them and retrieve their children's values
        else{
            double midSum = 0;
            
            if((node.children[0]) != null)
                    midSum = midSum + sumRecursive(node.children[0]);
            if((node.children[1]) != null)
                    midSum = midSum + sumRecursive(node.children[1]);
            if((node.children[2]) != null)
                    midSum = midSum + sumRecursive(node.children[2]);
            if((node.children[3]) != null)
                    midSum = midSum + sumRecursive(node.children[3]);
            
            // Return both the current value and the value recursed up
            return midSum + node.value;
        }    
    }
}

// End of QuadTree.java --------------------------------------------------------
