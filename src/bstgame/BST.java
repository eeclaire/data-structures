package bstgame;


import java.util.Random;


public class BST {
    // Fields -----------------------------------------------------------------
    // Probably a root somewhere hurrr
    int [] seq;
    
    
    // Constructors -----------------------------------------------------------    
    public BST (int n){
        // initializes an array of n elements and scrambles them
        this.scrambleArray(n);
    }            
    
    // Methods ----------------------------------------------------------------
    
    // Creates the binary tree data structure from the permuted array
    // Don't forget that in BST left < root < right!
    public void createFromNumberSequence(int[]A){
        int i;
        for (i=0; i<=A.length-1; i++){
            this.add(A[i]);
        }
    }
    
    // Adds each node to the tree (remember: in BST left < root < right)
    public void add (int value){
        System.out.println("Added value = " + value);
    }
    
    // Method to establish the coordinates of the node based on its position
    public void assignNodeCoordinates(){    
    }
    
    // Method to display the tree
    public void visualize(){
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
