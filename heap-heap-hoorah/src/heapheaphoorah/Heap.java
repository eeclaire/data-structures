/*
 * Claire Durand
 *
 * November 4th 2015
 *
 * CIS 2168 - Heap Visualization
 * Program to mimick adding elements to a heap represented using an array
 *
 * Heap class
 * Decribes the behavior of a heap
 */

package heapheaphoorah;

import java.awt.Color;
import java.util.Arrays;

public class Heap {

    // Fields -----------------------------------------------------------------
    double[] heap;
    double[] heapCp;

    // Keeps track of what colors should be what in the heap and its copy
    // 0 = grey; 1 = green; 2 = red
    int[] color;
    int[] colorCp;
    
    int lastIndex;  // Keeps track of the next available position in the array

    // Constructor ------------------------------------------------------------
    public Heap() {
        
        // Fix the size of the heap and its descriptors to be 20 elements 
        this.heap = new double[20];
        this.heapCp = new double[20];
        this.color = new int[20];
        this.colorCp = new int[20];
        
        // Initialize the location of the current index
        this.lastIndex = 0;
    }

    // Methods ----------------------------------------------------------------
    // Method to add a new element, value, in the heap
    public void insert(double value) {

        // Save a copy of the array to compare to the new array
        this.heapCp = Arrays.copyOf(heap, heap.length);   
        
        // Add the new value at the end of the heap and increment the next 
        // available position in the array
        this.heap[lastIndex] = value;
        this.lastIndex++;
    }

    // Method to bring the newest element to the top of whichever tree it should be
    // at the top of ("Every root of every subtree contains the respective min")
    // I could modularize this and return a different array, but wouldn't that
    // create a new array in memory? How do I modularize without being memory inefficient?
    public void sort() {

        // Variable to keep track of the newest element
        int currentIndex = lastIndex - 1;

        int currentParentIndex;

        // As long as the new element isn't the respective min of its subtree...
        while (currentIndex != 0) {
            // Compute the index of the parent of the current index
            currentParentIndex = computeParentIndex(currentIndex);

            // If your element is NOT smaller than its parent, you're done!
            if (this.heap[currentIndex] >= this.heap[currentParentIndex]) {
                break;
            } else {
                double temp = this.heap[currentIndex];  // save the value
                this.heap[currentIndex] = this.heap[currentParentIndex];
                this.heap[currentParentIndex] = temp;

                //Set the color index to the indeces that we switched to red
                this.color[currentIndex] = 2;
                this.color[currentParentIndex] = 2;

                // Make sure you switch to the new index of the new element
                currentIndex = currentParentIndex;
            }
        }
    }

    // Convenience method to compute and return the parent index of the current index
    private int computeParentIndex(int childIndex) {

        int parentIndex;

        // Slightly different formula to find parent depending on whether index is even or odd
        if (childIndex % 2 == 1) {
            parentIndex = (childIndex - 1) / 2;
        } else {
            parentIndex = (childIndex - 2) / 2;
        }

        //System.out.println("Parent index: " + parentIndex);
        return parentIndex;
    }

    // Method to display the two arrays and their potential contents
    public void visualize() {
        // Set the top left corner of the array display
        int x0 = Main.sg.getWidth() / 20;
        int y0 = Main.sg.getHeight() / 4;

        // Set size
        int w = 60;

        // Print out which heap we're displaying
        Main.sg.drawText("Old heap:", x0-5, y0-15);
        
        // Show the old heap first
        visualizeHeap(x0, y0, w, this.heapCp, this.colorCp);
        
        // Print out which heap we're displaying
        Main.sg.drawText("New heap:", x0-5, y0+85);
        
        // The display the new and improved heap!
        visualizeHeap(x0, y0+100, w, this.heap, this.color);
    }

    // Function to set green the color of the array cells under the currentIndex
    public void setGreen(){
        int i;
        
        // For all cells in the array
        for(i=0; i<20; i++){
            
            // Set the default green for the newest array
            if (i<this.lastIndex){
                this.color[i] = 1;
            }
            
            // Set the default green for the old array
            if (i<this.lastIndex-1){
                this.colorCp[i] = 1;
            }
        }
    }
    
    // Given a heap array and its color array, print it out appropriately
    public void visualizeHeap(int x, int y, int w, double a[], int c[]) {

        // For all of the cells in the array
        int i;
        for (i = 0; i < 20; i++) {

            // Depending on the value in the color array, display the box with 
            // a certain color. Display the number if the color is red or green.
            if (c[i] == 2) {
                Main.sg.drawFilledBox(x, y, w, w, Color.RED, 1, null);
                Main.sg.drawText(Double.toString(a[i]), x + 20, y + 30, Color.WHITE, 1, null);
            } else if (c[i] == 1) {
                Main.sg.drawFilledBox(x, y, w, w, Color.GREEN, 1, null);
                Main.sg.drawText(Double.toString(a[i]), x + 20, y + 30, Color.WHITE, 1, null);
            } else {
                Main.sg.drawFilledBox(x, y, w, w, Color.GRAY, 1, null);
            }

            // Draw the outline of each box
            Main.sg.drawBox(x, y, w, w);

            // Shift right by one box width to display the next element box
            x += w;
        }
    }

}
