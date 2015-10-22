
import java.util.Random;


public class BST {
    // Fields -----------------------------------------------------------------
    // Probably a root somewhere hurrr
    int [] seq;
    
    
    // Constructors -----------------------------------------------------------    
    public BST (int n){
        
        Random rand = new Random();
        int i;
        
        // Make the array n elements long
        seq = new int[n];
        
        for (i=1; i<=n; i++){
            // Keep trying a new number until you find an empty location in the array
            while (true){
                int r = rand.nextInt(n);    
            }
        }
    }
    
    // Methods ----------------------------------------------------------------
    
    // Creates the binary tree data structure from the permuted array
    // Don't forget that in BST left < root < right!
    public void createFromNumberSequence(int[]A){       
    }
    
    // Adds each node to the tree (remember: in BST left < root < right)
    public void add (int value){
    }
    
    // Method to establish the coordinates of the node based on its position
    public void assignNodeCoordinates(){    
    }
    
    // Method to display the tree
    public void visualize(){
    }
    
}
