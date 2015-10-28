package bstgame;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class BST {

    // Fields -----------------------------------------------------------------
    // Probably a root somewhere hurrr
    Node root;
    private int[] seq;

    private int offsetX;
    private int offsetY;
    
    private boolean searching;
    private boolean gameEnded;

    // Constructors -----------------------------------------------------------    
    public BST(int n) {
        // initializes an array of n elements and scrambles them
        this.seq = this.scrambleArray(n);

        // Print out the tree order of things, for my reference
        System.out.println(Arrays.toString(seq));

        // Build a tree from this array
        this.createFromNumberSequence(seq);

        this.offsetX = Main.sg.getWidth() / 2;
        this.offsetY = 80;
    }

    // Methods ----------------------------------------------------------------
    // Creates the binary tree data structure from the permuted array
    private void createFromNumberSequence(int[] A) {
        int i;
        for (i = 0; i <= A.length - 1; i++) {
            this.add(A[i]);
        }
    }

    // Adds each node to the tree (remember: in BST left < root < right)
    private void add(int value) {
        //System.out.println("Value to add = " + value);

        // Process to search through the tree for correct placement begins here
        //
        Node newNode = new Node(value);

        // If this is the first element added to the tree
        if (root == null) {
            root = newNode;
            return;
        }

        // Make a current node to keep track of position without losing root
        Node current = root;

        while (true) {
            // Figure out if the value is smaller than the node
            if (value < current.value) {
                // Check if left child is empty
                if (current.LChild == null) {
                    current.LChild = newNode;
                    return;
                } else {
                    current = current.LChild;
                }
            } // Figure out if the value is larger than the node
            else if (value > current.value) {
                // Check if left child is empty
                if (current.RChild == null) {
                    current.RChild = newNode;
                    return;
                } else {
                    current = current.RChild;
                }
            } // Theoretically, this shouldn't happen
            else {
                System.out.println("Error, two numbers with the same value.");
                return;
            }
        }
    }

    // Method to establish the coordinates of the node based on its position
    public void assignCoordinates() {

        // This alternates between 683 and 320... Welp
        System.out.println("Width of screen: " + Main.sg.getWidth() / 2);

        int X;// = Main.sg.getWidth()/2 - root.sizeX/2;  // width of simpleGUI / 2 (parametrize)

        X = 683 - root.sizeX / 2;     // Dr. Lakamper, I'm mad that I have to hardcode this!
        int Y = 80;   // enough for the radius of the circle to fit (parametrize)

        // Start recursing through the tree to assign coordinates based on structure
        assignCoordinatesRec(root, X, Y, X / 2, Y);
    }

    // Recursive method to establish the coordinates of the nodes
    private void assignCoordinatesRec(Node n, int px, int py, int offX, int offY) {

        // If you've reach a leaf, return
        if (n == null) {
            return;
        } // Otherwise, keep assigning nodes relative to their parent
        else {
            // Assign the current node's position
            n.px = px;
            n.py = py;

            // Try assigning the child nodes' position relative to this one
            assignCoordinatesRec(n.LChild, n.px - offX, n.py + offY, offX / 2, offY - 5);
            assignCoordinatesRec(n.RChild, n.px + offX, n.py + offY, offX / 2, offY - 5);
        }
    }

    // Method to display the tree
    public void visualize() {
        visualizeRec(root, null);
    }

    // Recursive method to display the tree
    private void visualizeRec(Node n, Node parent) {

        // If you're reaching past a leaf, return
        if (n == null) {
            return;
        } // Else do cool visualization stuff
        else {
            int offset = n.sizeX / 2;

            // Draw the line that connects to the parent as long as not on root
            if (parent != null) {
                Main.sg.drawLine(n.px + offset, n.py, parent.px + offset, parent.py + 2 * offset);
            }

            // Draw the node itself
            n.visualize();

            // Recursively draw the children
            visualizeRec(n.LChild, n);
            visualizeRec(n.RChild, n);
        }
    }

    // Method to return random-order array of a sequence from 1 to n
    private int[] scrambleArray(int n) {

        Random rand = new Random();
        int i;

        // Make an array n elements long
        int[] a = new int[n];

        // For every element in the sequence, find a random empty array placement
        for (i = 1; i <= n; i++) {

            // Keep trying a new number until you find an empty location in the array
            while (true) {
                int r = rand.nextInt(n);

                if (a[r] == 0) {
                    a[r] = i;     // assign that sequence element to the spot in the array
                    break;
                }
            }
        }

        return a;
        //System.out.println(Arrays.toString(seq));
    }

    // Method to engage the "game" including UI stuff
    public void startGame() {

        
        int l = this.seq.length;

        // Create and initialize scrambled array
        int[] arrayToDisplay;
        arrayToDisplay = this.scrambleArray(l);

        // Display the array to the user in the order the Nodes should be clicked
        this.displayArray(arrayToDisplay);

        // Iterate through the array in the order in which the Nodes should be 
        //clicked, waiting for the user to click a node
        int i;
        for (i = 0; i < l; i++) {

            // Variable that indicates that we are still searching for this value
            searching = true;
            
            // Finds if this click position corresponds to a node
            while (searching) {
                // Wait for user action (fake event-based)
                int[] xy = Main.sg.waitForMouseClick();
                
                // traverse through the tree, 
                // if you find a node for which xy fits in the area, check value
                // if matches, YAY (call redisplay node), if not, BOO, you lose
                traverseTree(xy[0], xy[1], arrayToDisplay[i], i);
                
                if(gameEnded)
                    return;
            }
        }
    }

    // Method to start traversing through the tree
    private void traverseTree(int x, int y, int val, int i){
        
        traverseTreeRec(this.root, x, y, val, i);
        return;
    }
    
    // Method to recursively traverse through the tree
    private void traverseTreeRec(Node node, int x, int y, int val, int i) {

        // Reaching past a leaf, return out
        if (node == null) {
            return;
        } 
        
        // If the click is in range of the node, check whether the sequence 
        // value matches up with the value of the node. If it does, redraw
        // the node to display the number and clear the boolean that indicates
        // that the game is searching for the correct mouse click. If it is the 
        // last value in the sequence, engage the sequence for "Game has been 
        // won!" If the values don't match up, the user lost: engage the 
        // sequence for "Game has been lost!"
        // If the click is not in the range, keep traversing through
        else {
            if (node.isInside(x, y)) {
                if (val == node.value) {
                    if (i==this.seq.length-1)
                        wonGame();
                    else{
                        redrawNode(node);
                        searching = false;
                    }
                    return;
                } else {
                    lostGame();                   
                    return;
                }
            } else {
                traverseTreeRec(node.LChild, x, y, val, i);
                traverseTreeRec(node.RChild, x, y, val, i);
            }
        }
    }

    // Method to display a newly scrambled version of the array in the order
    // that he or she should click the nodes
    private void displayArray(int[] x) {

        // Print out to user. Sure glad that setFont is not actually a method?
        //Main.sg.drawText("Click on these numbers in order: "
          //      + Arrays.toString(x), Main.sg.getWidth(), 25);
        Main.sg.drawText("Click on these numbers in order: "
                + Arrays.toString(x), 25, 25);
    }

    // Method to draw a "found" version of the node 
    private void redrawNode(Node node){
        // Redraw white background
        Main.sg.drawFilledEllipse(node.px, node.py, node.sizeX, node.sizeY, Color.WHITE, 1, null);
        
        // Draw border
        Main.sg.drawEllipse(node.px, node.py, node.sizeX, node.sizeY, Color.BLACK, 1, 2, null);
        
        // Write the number
        Main.sg.drawText(Integer.toString(node.value), node.px+20, node.py+25, Color.BLACK, 1, null);
        
        //Main.sg.drawText("Click " + arrayToDisplay[i] + " next.", Main.sg.getWidth(), 50, Color.BLACK, 1, "Next");
        Main.sg.eraseSingleDrawable("Next");
        
        //Main.sg.drawText("Click " + 1000 + " next.", Main.sg.getWidth(), 50, Color.BLACK, 1, "Next");
        
    }

    // Method to stop iterating through the tree, clear the scene, and 
    // indicating to the user that he or she won
    private void wonGame(){
        
        // Set the variable to end to exit out of this game
        gameEnded = true;
        
        // Clear the screen
        Main.sg.eraseAllDrawables();
        
        // Display a message to the user to let him/her know he/she won, and
        // delete the message after a few seconds to make way for the new game
        Main.sg.drawText("Congratulations, you won! Try again!", Main.sg.getWidth()/2, Main.sg.getHeight()/2, Color.BLACK, 1, "WON");
        Main.sg.pauseProgram(2000);
        Main.sg.eraseSingleDrawable("WON");
    }
    
    // Method to stop iterating through the tree, clear the scene, and 
    // indicating to the user that he or she lost
    private void lostGame(){
       
        // Set the variable to end to exit out of this game
        gameEnded = true;
        
        // Clear the screen
        Main.sg.eraseAllDrawables();
        
        // Display a message to the user to let him/her know he/she lost, and
        // delete the message after a few seconds to make way for the new game
        Main.sg.drawText("You lost! Try again...", Main.sg.getWidth()/2, Main.sg.getHeight()/2, Color.BLACK, 1, "LOST");
        Main.sg.pauseProgram(2000);
        Main.sg.eraseSingleDrawable("LOST");
    }
}
