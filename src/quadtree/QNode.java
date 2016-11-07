/*
 * Claire Durand
 * CIS 2168 - Random Quadtree Lab
 * 10/21/2015
 * 
 * QNode Class
 * Implements the QuadTreeNode interface. 
 * Class to describe the nodes of the quad tree. Each node has one value (set 
 * 0-100 in main) and 4 possible node children. The class defines the interface
 * getChildren method by returning the children of each node to be displayed.
 * 
 */
package quadtree;

import qtvisualizer.QuadTreeNode;

public class QNode implements QuadTreeNode{
    
    // Fields -----------------------------------------------------------------
    double value; 
    QNode[] children = new QNode[4]; 
    
    // Constructor ------------------------------------------------------------
    public QNode(double value){     
        this.value = value;     // set node value to input value
    }
    
    
    // Methods ----------------------------------------------------------------
    @Override
    public QuadTreeNode[] getChildren(){
        // Return the children of the node in order to visualize them
        return children;
    }   
}

// End of QNode.java -----------------------------------------------------------