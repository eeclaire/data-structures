package hashtable;

import static hashtable.Main.sg;
import java.awt.Color;
import java.util.Arrays;

public class Hashtable {

    // Fields -----------------------------------------------------------------
    double[] ht;    // hashtable
    int[] collisions;    // collisions hashtable
    int totalColls;    // total collision counter

    // Constructor ------------------------------------------------------------
    public Hashtable() {
        this.ht = new double[100];    // hashtable
        this.collisions = new int[100];    // collisions hashtable
        
        this.totalColls = 0;    // Clear the total count
        
        // Fills the hashtable array with -1
        Arrays.fill(this.ht, -1);
        
        // Fills the collisions table with -1 ==> black cell by default
        Arrays.fill(this.collisions, -1);
    }

    // Methods ----------------------------------------------------------------
    
    // Method to display the WHOLE hashtable
    public void visualizeHT(int w) {
        
        int h = Main.sg.getHeight();
        
        // Set some initial values
        int size = 35;
        int x0 = 10;
        int y0 = 10;
        
        // Use current values
        int x = x0;
        int y = y0;
        
        // NOW START DRAWING IT
        for (int i=0; i<100; i++){
            visualizeCell(x, y, size, this.collisions[i]);
            
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
        
        // Erase the previous collision total and write the new one
        Main.sg.eraseSingleDrawable("collisions");
        Main.sg.drawText("Total: "+this.totalColls+" collisions", w+(w/2)/4, 
                h*9/10+25, Color.BLACK, 1, "collisions");
        
    }
    
    // Method to display individual cells from the hashtable
    private void visualizeCell(int x, int y, int size, int coll){
        
        // Compute the appropriate color for this number of collisions
        Color cellColor = computeCellColor(coll);
        
        // Redraw the box with the appropriate cell color
        Main.sg.drawFilledBox(x, y, size, size, cellColor, 1, null);       
    }
    
    // Method to calculate color given the number of collision in a cell
    private Color computeCellColor(int collisions){
        
        // If the cell doesn't exist yet (collisions=-1), 
        // the cell should be black
        if(collisions<0){
            return Color.black;
        }
        
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
        while(this.ht[index] != -1){
            this.totalColls++;
            this.collisions[index]++;
            index++;
                        
            // Create a "wrap" for the linear probing
            if(index>99){
                index = 0;
            }
        }
        
        // Once we reach an index with no value in the hashtable cell, 
        // set it to the value we want to save
        this.ht[index] = value;
        this.collisions[index] = 0;
                
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
    
    // Method to reset the hashtable to its empty state & clear collisions
    public void reset(){
        
        this.totalColls = 0;
        
        // Fills the hashtable array with -1
        Arrays.fill(this.ht, -1);
        
        // Fills the collisions table with -1 ==> black cell by default
        Arrays.fill(this.collisions, -1);
    }
}
