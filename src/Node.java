


public class Node {
    
    // Fields -----------------------------------------------------------------
    int value;
    boolean status; // 0 is filled, 1 if empty (can still be clicked)
    
    Node LChild;
    Node RChild;
    
    // Constructors -----------------------------------------------------------
    public Node(int value){
        this.value = value;
    }
    
    // Methods ----------------------------------------------------------------
    
    // Method for how to display in SimpleGUI
    public void visualize(){
        // Needs to check if node is empty (can still be clicked) or if it is 
        // filled (shows the correctly guessed value)
    }
    
    // I think should return whether click was inside 
    public boolean isInside(int x, int y){
        return false;
    }
    
}
