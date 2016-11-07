/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.LinkedList;

public class PathFinder {

    // Fields -----------------------------------------------------------------
    Maze maze;

    // Create direction booleans that indicate direction you came from
    boolean dirNorth;
    boolean dirSouth;
    boolean dirWest;
    boolean dirEast;

    // Contstructors ----------------------------------------------------------
    public PathFinder(Maze iMaze) {
        maze = iMaze;

        // Clear the directions (you don't come from anywhere until you start 
        // working recursively
        dirNorth = false;
        dirSouth = false;
        dirWest = false;
        dirEast = false;
    }

    // Methods ----------------------------------------------------------------
    
    
    // Method to initiate the recursive method
    //
    // INPUT:   int startRow - the row of the clicked box
    //          int startColumn - the column of the clicked box
    // OUTPUT:  LinkedList - the linked list containing the coordinates of the boxes on the path to the exit
    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        
        // Instantiate the linked list that will contain the path
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
        
        // Enter into the recursive method, setting all directions to false
        traversePath(startRow, startColumn, false, false, false, false, myPath);

        // Return whatever path linked list you have
        return (myPath);
    }
    
    // Recursive method to move through the maze and check for the exit.
    // Adds boxes to the linked list if they are on the path to the exit.
    //
    // INPUT:   int r - the row coordinate of the current position
    //          int c - the column coordinate of the current position
    //          boolean dirNorth - did we come from the North?
    //          boolean dirSouth - did we come from the South?
    //          boolean dirWest - did we come from the West?
    //          boolean dirEast - did we come from the East?
    //          Linked List myPath - linked list to add the path to the exit to
    // OUTPUT:  LinkedList - the linked list containing the coordinates of the boxes on the path to the exit
    public boolean traversePath(int r, int c, boolean dirNorth, boolean dirSouth, boolean dirWest, boolean dirEast, LinkedList<Coordinate> myPath) {

        // default for treasure found is false (will be set if exit is found)
        boolean treasure = false;

        // I'm too lazy to change all of the row and col variables to the input r and c:
        int row = r;
        int col = c;

        // Base case:
        if (maze.isExit(row, col)) {

            // Add the exit to the linked list
            myPath.add(new Coordinate(row, col));
            
            // Return true to set treasure and start adding everything
            return true;
        } // Recursive case:
        else {
            // Check the north side if no wall and not coming from the north
            if (dirNorth == false && maze.hasNorthWall(row, col) == false) {

                // Go north from south (set dirSouth in order not to go back where you already checked)
                treasure = traversePath(row - 1, col, false, true, false, false, myPath);
                // If statement to add to the linked list coming back up from the stack
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    // return true in order to maintain treasure & keep adding to the list
                    return true;
                }
            }
            // Check the south side if no wall and not coming from the south
            if (dirSouth == false && maze.hasSouthWall(row, col) == false) {

                // Go south from north (set dirSouth in order not to go back where you already checked)
                treasure = traversePath(row + 1, col, true, false, false, false, myPath);
                // If statement to add to the linked list coming back up from the stack
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    // return true in order to maintain treasure & keep adding to the list
                    return true;
                }
            }
            // Check the west side if no wall and not coming from the west
            if (dirWest == false && maze.hasWestWall(row, col) == false) {

                // Go west from east (set dirEast in order not to go back where you already checked)
                treasure = traversePath(row, col - 1, false, false, false, true, myPath);
                // If statement to add to the linked list coming back up from the stack
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
            // Check the east side if no wall and not coming from the east
            if (dirEast == false && maze.hasEastWall(row, col) == false) {

                // Go east from west (set dirWest in order not to go back where you already checked)
                treasure = traversePath(row, col + 1, false, false, true, false, myPath);
                // If statement to add to the linked list coming back up from the stack
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
            
            // If you reach this point, you want to return the false that is in treasure
            return treasure;
        } // end of recursive case

    }
}
