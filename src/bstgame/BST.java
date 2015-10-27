package bstgame;


import java.util.Random;


public class BST {
    // Fields -----------------------------------------------------------------
    // Probably a root somewhere hurrr
    Node root;
    int [] seq;
    
    int offsetX;
    int offsetY;
    
    
    // Constructors -----------------------------------------------------------    
    public BST (int n){
        // initializes an array of n elements and scrambles them
        this.scrambleArray(n);
        this.createFromNumberSequence(seq);
        
        this.offsetX = Main.sg.getWidth()/2;
        this.offsetY = 100;
    }            
    
    // Methods ----------------------------------------------------------------
    
    // Creates the binary tree data structure from the permuted array
    public void createFromNumberSequence(int[]A){
        int i;
        for (i=0; i<=A.length-1; i++){
            this.add(A[i]);
        }
    }
    
    // Adds each node to the tree (remember: in BST left < root < right)
    public void add (int value){
        //System.out.println("Value to add = " + value);
        
        // Process to search through the tree for correct placement begins here
        //
        Node newNode = new Node(value);
        
        // If this is the first element added to the tree
        if(root==null){
            root = newNode;
            return;
        }
        
        // Make a current node to keep track of position without losing root
        Node current = root;
        
        while(true){
            // Figure out if the value is smaller than the node
            if (value < current.value){
                // Check if left child is empty
                if (current.LChild == null){
                    current.LChild = newNode;
                    return;
                }
                else{
                    current = current.LChild;
                }
            }
            
            // Figure out if the value is larger than the node
            else if (value > current.value){
                // Check if left child is empty
                if (current.RChild == null){
                    current.RChild = newNode;
                    return;
                }
                else{
                    current = current.RChild;
                }
            } 
            
            // Theoretically, this shouldn't happen
            else{
                System.out.println("Error, two numbers with the same value.");
                return;
            }
        }
    }
    
    // Method to establish the coordinates of the node based on its position
    public void assignCoordinates(){ 
        
        // This alternates between 683 and 320... Welp
        System.out.println("Width of screen: " + Main.sg.getWidth()/2);
        
        int X = Main.sg.getWidth()/2 - root.sizeX/2;  // width of simpleGUI / 2 (parametrize)
        
        X = 683 - root.sizeX/2;     // Dr. Lakamper, I'm mad that I have to hardcode this!
        int Y = 100;   // enough for the radius of the circle to fit (parametrize)
        
        assignCoordinatesRec(root, X, Y, X/2, Y);
    }
    
    public void assignCoordinatesRec(Node n, int px, int py, int offX, int offY){
        
        // If you've reach a leaf, return
        if (n == null)
            return;
        // Otherwise, keep assigning nodes relative to their parent
        else {
            // Assign the current node's position
            n.px = px;
            n.py = py;
            
            // Try assigning the child nodes' position relative to this one
            assignCoordinatesRec(n.LChild, n.px-offX, n.py+offY, offX/2, offY);
            assignCoordinatesRec(n.RChild, n.px+offX, n.py+offY, offX/2, offY);
        }
    }
    
    // Method to display the tree
    public void visualize(){
        visualizeRec(root, null);
    }
    
    // Recursive method to display the tree
    public void visualizeRec(Node n, Node parent){
        
        // If you're reaching past a leaf, return
        if (n == null)
            return;
        
        // Else do cool visualization stuff
        else{
            int offset = n.sizeX/2;
          
            // Draw the line that connects to the parent as long as not root
            if (parent != null) {
                Main.sg.drawLine(n.px+offset, n.py, parent.px+offset, parent.py+2*offset);
            }
            
            // Draw the node itself
            n.visualize();
            
            // Recursively draw the children
            visualizeRec(n.LChild, n);
            visualizeRec(n.RChild, n);
        }
    }
    
    public void scrambleArray(int n){
        
        Random rand = new Random();
        int i;
        
        // Make the array n elements long
        this.seq = new int[n];
        
        // For every element in the sequence, find a random empty array placement
        for (i=1; i<=n; i++){
            // Keep trying a new number until you find an empty location in the array
            while (true){
                int r = rand.nextInt(n);    
                
                if (this.seq[r] == 0){
                    this.seq[r] = i;     // assign that sequence element to the spot in the array
                    break; 
                }
            }      
        }
    }    
}
