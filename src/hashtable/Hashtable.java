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
    public void visualizeHT(int w) {
        
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
        
        Main.sg.drawText("Hardcoded 0 for now", w, y);
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
    
    // Method to add a single element to the hash table
    // Note: I don't like how this works because it assumes 0 is not a value
    private void addOne(double value){
        
        // The hash function rounds the value
        int index = (int) Math.round(value);
        
        // The result is then modded by the number of elements in the array
        // to ensure that the calculated index will fall within the array
        index = index%100;
        
        // Until the hashtable element doesn't have anything in it, 
        // increment the number of collisions in that cell, then incremenet
        // the index to linearly probe the hashtable
        while(this.ht[index] != 0){
            this.collisions[index]++;
            index++;
        }
        
        // Once we reach an index with no value in the hashtable cell, 
        // set it to the value we want to save
        this.ht[index] = value;
                
    }

    // Method to randomly generate 10 values in the range [0, 1000] 
    // and place them in the hashtable
    public void addTen(){
        
        int i;
        double v;   // randomly generated value  
        
        // One by one, generate 10 numbers and place them in the hastable
        for(i=0; i<10; i++){
            v = Math.random()*1000;
            this.addOne(v);
        }
    }
}
