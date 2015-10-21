/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree;

import qtvisualizer.QuadTreeNode;

/**
 *
 * @author Claire
 */
public class QNode implements QuadTreeNode{
    
    // Fields ------------------------------------------------------------------
    double value; 
    QNode[] children = new QNode[4]; 
    
    // Constructor -------------------------------------------------------------
    public QNode(double value){
        this.value = value; 
    }
    
    public QuadTreeNode[] getChildren(){
        // I guess I have to do something here?
        
        // I guess I return a QNode array?
        return children;
    }
    
    
}
    