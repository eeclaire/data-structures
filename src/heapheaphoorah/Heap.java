package heapheaphoorah;

import java.util.Arrays;


public class Heap {
    // Fields -----------------------------------------------------------------
    int [] heap;
    int [] heapCp;
    int lastIndex;  // Keeps track of the next available position in the array
    
    // Constructor ------------------------------------------------------------
    public Heap(){
        // Fix the size of the heap to be 20 elements 
        this.heap = new int[20];
        this.heapCp = new int[20];
        this.lastIndex = 0;
    }
    
    // Methods ----------------------------------------------------------------
    
    // Method to add a new element in the heap
    public void insert(int value){
        
        this.heapCp = Arrays.copyOf(heap, heap.length);  // Both pointers point to the original pointer
        
        // Add the new value at the end of the heap and increment the next 
        // available position in the array
        this.heap[lastIndex] = value;
        this.lastIndex++;    
        
        swap();
        // Should call sort  
    }
    
    // Method to bring the newest element to the top of whichever tree it should be
    // at the top of ("Every root of every subtree contains the respective min")
    // I could modularize this and return a different array, but wouldn't that
    // create a new array in memory? How do I modularize without being memory inefficient?
    private void swap(){
        
        // Variable to keep track of the newest element
        int currentIndex = lastIndex-1;
        
        int currentParentIndex;
        
        // As long as the new element isn't the respective min of its subtree...
        while (currentIndex!=0){
            
            currentParentIndex = computeParentIndex(currentIndex);
            
            // If your element is NOT smaller than its parent, you're done!
            if(this.heap[currentIndex] >= this.heap[currentParentIndex]){
                break;
            }
            else{
                int temp = this.heap[currentIndex];  // save the value
                this.heap[currentIndex] = this.heap[currentParentIndex];
                this.heap[currentParentIndex] = temp;
                
                // Make sure you switch to the new index of the new element
                currentIndex = currentParentIndex;
            }
        }
    }
    
    // Convenience method to compute and return the parent index of the current index
    private int computeParentIndex(int childIndex){
        
        int parentIndex;
        
        // if your child index is even
        if(childIndex%2 == 0){
            parentIndex = (childIndex-1)/2;
        } else{
            parentIndex = (childIndex-2)/2;
        }
        return parentIndex;
    }
}
