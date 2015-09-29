package shape_abstraction_bonus;
/*
 * Claire Durand
 * CIS 2168 - Shape Abstraction Lab
 * 09/23/2015

 * Point class
 * Contains x and y coordinates and the significance value of the point
 */
public class Point {
    
    // Fields -----------------------------------------------------------------
    int x;  // x coordinate
    int y;  // y coordinate
   
    double s;  // significance value
    
    // Constructor ------------------------------------------------------------
    public Point (int x, int y){
        this.x = x;         
        this.y = 700-y;     // flip the deer
    }
        
}
