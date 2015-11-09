package hashtable;

import java.awt.Color;
import java.util.Arrays;

public class Hashtable {

    // Fields -----------------------------------------------------------------
    double[] ht;    // hashtable
    double[] collisions;    // collisions hashtable

    // Constructor ------------------------------------------------------------
    public Hashtable() {
        this.ht = new double[100];    // hashtable
        this.collisions = new double[100];    // collisions hashtable
        
        // Fills the collisions table with -1 ==> black cell by default
        Arrays.fill(this.collisions, -1);
    }

    // Methods ----------------------------------------------------------------
    
    // Method to display the WHOLE hashtable
    public void visualizeHT() {
        
        // Set some initial values
        int size = 35;
        int x0 = 10;
        int y0 = 10;
        
        // Use current values
        int x = x0;
        int y = y0;
        
        // NOW START DRAWING IT
        for (int i=0; i<100; i++){
            visualizeCell(x, y, size, Color.BLACK);
            
            // Increment the position coordinates
            x += size+5;
            
            // If you get to the end of a 10 cell line, reset the x coordinate
            // and shift the y coordinate down
            if(i%10==9){
                y += size+5;
                x = x0;
            }     
        }   
    }
    
    // Method to display individual cells from the hashtable
    public void visualizeCell(int x, int y, int size, Color cellColor){
        Main.sg.drawFilledBox(x, y, size, size, cellColor, 1, null);       
    }
    
    // Method to calculate color?
    public Color computeCellColor(int collisions){
        //Hey
        
        // Increase the percentage of red with increasing number of collisions
        // Cap that shade of red at 255 (the max color value)
        // Note that we use 7 here because log(100) approx = 7
        int r = (int)(255.0/7.0*collisions);
        r = (int)Math.min(r,255);
        
        // Green should reflect the "opposite" of red (the more collisions, 
        // the higher the red percentage, the smaller the green percentage)
        // Blue should not even exist.
        int g = 255 - r;
        int b = 0;
        
        // Return this new color
        return(new Color(r, g, b));
    }

}
