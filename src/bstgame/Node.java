package bstgame;

import java.awt.Color;




public class Node {
    
    // Fields -----------------------------------------------------------------
    int value;
    boolean status; // 0 is filled, 1 if empty (can still be clicked)
    
    // Parameters for SimpleGUI (coordinates and size)
    int px;     
    int py; 
    int sizeX;
    int sizeY;
    
    
    // Child nodes
    Node LChild;
    Node RChild;
    
    // Constructors -----------------------------------------------------------
    public Node(int value){
        this.value = value;
        
        this.sizeX = 40;
        this.sizeY = 40;
    }
    
    // Methods ----------------------------------------------------------------
    
    // Method for how to display in SimpleGUI
    public void visualize(){
        // Needs to check if node is empty (can still be clicked) or if it is 
        // filled (shows the correctly guessed value)
        
        // Draw the ellipse
        Main.sg.drawFilledEllipse(this.px, this.py, this.sizeX, this.sizeY, Color.RED, 1,"");
    }
    
    // I think should return whether click was inside 
    public boolean isInside(int x, int y){
        return false;
    }
    
}
