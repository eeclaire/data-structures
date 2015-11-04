/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapheaphoorah;

import simplegui.SimpleGUI;

/**
 *
 * @author Claire
 */
public class Main {
    
    public static SimpleGUI sg = new SimpleGUI();
    
    public static void main(String[] args) {
        
        Heap coolHeap = new Heap();
        
        double value;   // User input
        int num = 0;    // Counter
        
        // User prompt
        sg.print("Enter a value to add to the heap");

        // As long as there are fewer than 20 elements in the array,
        // keep adding them
        while (num<19){
            value = sg.keyReadDouble();
            coolHeap.insert(value);
            //reset colors here
            coolHeap.setGreen();
            coolHeap.sort();
            num++;
            coolHeap.visualize();
        }
           
    }
        
}
