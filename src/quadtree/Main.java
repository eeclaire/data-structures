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
public class Main {
    
    public static void main(String[] args) {
        
        QuadTree qt = new QuadTree();
        
        // For loop to populate the tree with values from 0-100
        int i;
        for (i=0; i<=100; i++){
            qt.insertAtRandomPosition(i);
        }
        
        // Do the sum thing
        qt.sum(qt.root);
    }
    
}
