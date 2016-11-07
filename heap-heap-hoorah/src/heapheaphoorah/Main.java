/*
 * Claire Durand
 *
 * November 4th 2015
 *
 * CIS 2168 - Heap Visualization
 * Program to mimick adding elements to a heap represented using an array
 *
 * Main class
 */

package heapheaphoorah;

import simplegui.SimpleGUI;

public class Main {
    
    static int width = 1320;
    static int height = 300;
    
    // Create the simpleGUI object to frame the arrays
    public static SimpleGUI sg = new SimpleGUI(width, height);
    
    public static void main(String[] args) {
        
        // Instantiate the heap object
        Heap coolHeap = new Heap();
        
        double value;   // User input
        int num = 0;    // Counter
        
        // User prompt
        sg.print("Enter a value to add to the heap");
        
        // Display the original arrays to the user
        coolHeap.visualize();

        // As long as there are fewer than 20 elements in the array,
        // keep adding them
        while (num<20){
            
            // Read user input
            value = sg.keyReadDouble();
            
            // Append the value to the end of the array to make it complete
            coolHeap.insert(value);
            
            // Reset the array cells to green if they are under the last index
            coolHeap.setGreen();    
            
            // Sort the array so that it obeys the structure of a heap
            coolHeap.sort();
            
            // Display the arrays to the user
            coolHeap.visualize();
             
            // Increment the count to keep track of number of values in array
            num++;
        }
           
    }
        
}
