/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree;

/**
 *
 * @author Claire
 */
public class QNode {
    
    // Fields ------------------------------------------------------------------
    double value; 
    QNode[] children = new QNode[4]; 
    
    // Constructor -------------------------------------------------------------
    public QNode(double value){
        this.value = value; 
    }
    
    
}
    