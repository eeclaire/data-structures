/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.awt.Color;
import simplegui.SimpleGUI;

/**
 *
 * @author Claire
 */
public class Main {

    public static SimpleGUI sg = new SimpleGUI();

    public static void main(String[] args) {
        
        // Get the width and the hight of the GUI
        int w = sg.getWidth();
        int h = sg.getHeight();
        
        int count = 0;
        
        // Some set up things
        setGUI(w,h);

        // Do the things to make it a certain size in the constructor
        Hashtable hash = new Hashtable();
        
        // Primer visualization
        hash.visualizeHT(w*2/3+5);
        
        // Fix this so that full hashtable set it false
        while(true){
            
            // Get the coordinates when the user clicks
            int []xy = sg.waitForMouseClick();
            
            // Test the place the user clicked for one of the "buttons"
            
            // User clicked within the coordinates of the "ten more button"
            if(xy[0]>w/3+5 && xy[0]<(w/3+5)+(w/3-5)
                    && xy[1]>(h*9/10-5) && xy[1]<(h*9/10-5)+(h/10)){
                if(count>9){
                    hash.reset();
                    count = 0;
                }
                System.out.println("User asked for 10 more");
                hash.addTen();
                hash.visualizeHT(w*2/3+5);
                count++;
            } 
            
            // User clicked within the coordinates of the "reset button"
            else if (xy[0]>5 && xy[0]<w/3
                    && xy[1]>(h*9/10-5) && xy[1]<(h*9/10-5)+(h/10)){
                System.out.println("User asked to reset");
                
                // I need to create a hash.reset method
                hash.reset();
                hash.visualizeHT(w*2/3+5);
                count = 0;
            }
            
        }
        
    }
    
    public static void setGUI(int w, int h){

        // Draw the first button
        sg.drawFilledBox(5, h*9/10-5, w/3-5, h/10, Color.yellow, 0.5, null);
        sg.drawBox(5, h*9/10-5, w/3-5, h/10, Color.yellow, 0.6, 5, null);
        sg.drawText("Reset", (w/3-5)/2, h*9/10+25);
        
        // Draw the second button
        sg.drawFilledBox(w/3+5, h*9/10-5, w/3-5, h/10, Color.blue, 0.5, null);
        sg.drawBox(w/3+5, h*9/10-5, w/3-5, h/10, Color.blue, 0.6, 5, null); 
        sg.drawText("Add 10 more", w/3+5+(w/3-5)/4, h*9/10+25);
        
        // Draw the third button
        sg.drawFilledBox(w*2/3+5, h*9/10-5, w/3-5, h/10, Color.red, 0.5, null);
        sg.drawBox(w*2/3+5, h*9/10-5, w/3-5, h/10, Color.red, 0.6, 5, null);
        
    }

}
