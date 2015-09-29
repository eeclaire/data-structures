package shape_abstraction_bonus;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import simplegui.SimpleGUI;

/*
 * Claire Durand
 * CIS 2168 - Shape Abstraction Lab
 * 09/23/2015

 * Main class
 * Contains all the methods and stuff that actually happens (read point list 
 * from file, display deer, remove least significant points, etc...)
 */
public class Shape_Abstraction {
    public SimpleGUI sg = new SimpleGUI();   // SimpleGUI object
    public LinkedList<Point> ll = new LinkedList<Point>(); // Linked list object

    // Methods ---------------------
    // Reads all of the coordinate points from the file, makes a Point object with them
    // and adds the Point into the Linked List
    public void readFile(String fn) {

        File file = new File(fn);

        try {
            Scanner input = new Scanner(file);

            while (input.hasNextInt()) {
                // Create a new point with the two coords on the line
                Point pt = new Point(input.nextInt(), input.nextInt());

                // Add this new point to the Linked List
                ll.addLast(pt);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("HELP WORLD SHIT GOT CRAY!");
            Logger.getLogger(Shape_Abstraction.class.getName()).log(Level.SEVERE, null, ex);
        }

    } // end readFile

    // Method to print out the deer by traversing through the list
    public void printOGDeer() {

        int i;
        ListIterator li = ll.listIterator();

        // iterate through the Linked List using a for loop and the size of the list
        for (i = 0; i < (ll.size() - 1); i++) {
                // draw lines connecting the points
                sg.drawLine(ll.get(i).x, ll.get(i).y, ll.get(i + 1).x, ll.get(i + 1).y, 2);
        }

    }

    // Method to obtain the significance value of all of the points
    public void calculateSig() {
        int i;

        double l1;   // between Point and previous point
        double l2;   // between Point and next point
        double h;    // hypothenuse
        double dx, dy;

        ListIterator li = ll.listIterator();

        for (i = 1; i < (ll.size() - 1); i++) {
            if (li.hasNext()) {

                // get the length of the first segment
                dx = Math.abs(ll.get(i).x - ll.get(i + 1).x);
                dy = Math.abs(ll.get(i).y - ll.get(i + 1).y);

                l1 = Math.sqrt(dx * dx + dy * dy);

                // get the length of the second segment
                dx = Math.abs(ll.get(i).x - ll.get(i - 1).x);
                dy = Math.abs(ll.get(i).y - ll.get(i - 1).y);

                l2 = Math.sqrt(dx * dx + dy * dy);

                // find the length of the hypothenuse
                dx = Math.abs(ll.get(i+1).x - ll.get(i - 1).x);
                dy = Math.abs(ll.get(i+1).y - ll.get(i - 1).y);
                
                h = Math.sqrt(dx * dx + dy * dy);

                System.out.println("");
                ll.get(i).s = l1 + l2 - h;    // seg significance value
                
            }

        }

    }

    // Method that calculates the significance value of each point and removes
    // the node with the smallest significance value. 
    // Input n - desired integer number of nodes in the list
    public void removeElements(int n) {

        // items keeps track of how many nodes are in the linked list
        int items = ll.size();

        // as long as we have more nodes than desired, keep removing
        while (items >= n) {
            calculateSig(); 
            removeSmallestElement();
            items = ll.size();
        }
    }

    // Method that iterates through the linked list, saves the significance 
    // values into an array, sorts it to find the smallest significance value,
    // then iterates through the list again to look for an remove the node
    // with the smallest significance value
    public void removeSmallestElement() {

        int i;
        ListIterator li = ll.listIterator();
        double[] values = new double[ll.size()];

        // Set the first and last significance values to infinity
        values[0] = Double.POSITIVE_INFINITY;
        values[ll.size() - 1] = Double.POSITIVE_INFINITY;

        for (i = 1; i < (ll.size() - 1); i++) {
            if (li.hasNext()) {
                values[i] = ll.get(i).s;
                //System.out.println("value at "+i+ " = "+values[i]);
            }
        }

        Arrays.sort(values);    // Sort the array

        double minSig = values[0];  // set the smallest significance value

        for (i = 1; i < (ll.size() - 1); i++) {
            if (li.hasNext()) {
                // if you reach the smallest node, draw it in red and remove it
                if (ll.get(i).s == minSig) {
                    sg.drawDot(ll.get(i).x, ll.get(i).y, 5, Color.red, 1, null);
                    ll.remove(i);   // built-in remove-by-index method
                    break;
                }
            }
        }
    }    
}
