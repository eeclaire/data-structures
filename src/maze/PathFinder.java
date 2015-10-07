/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;

    boolean dirNorth;
    boolean dirSouth;
    boolean dirWest;
    boolean dirEast;

    //boolean found;
    //boolean treasure = false;
    public PathFinder(Maze iMaze) {
        maze = iMaze;

        dirNorth = false;
        dirSouth = false;
        dirWest = false;
        dirEast = false;
        //this.dirNorth = 0;
        //found = false;
    }

    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();

        //boolean end = false;
        // Enter into the recursive method
        traversePath(startRow, startColumn, false, false, false, false, myPath);

        // return whatever path linked list you have
        return (myPath);
    }

    public boolean traversePath(int r, int c, boolean dirNorth, boolean dirSouth, boolean dirWest, boolean dirEast, LinkedList<Coordinate> myPath) {

        //LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
        boolean treasure = false;

        int row = r;
        int col = c;

        // Base case:
        if (maze.isExit(row, col)) {
            // set the listener boolean to true
            treasure = true;
            //found = true;
            myPath.add(new Coordinate(row, col));
            return true;
        } // Recursive case:
        else {
            // Check the north side if no wall and not coming from the north
            if (dirNorth == false && maze.hasNorthWall(row, col) == false) {

                // Go north from south
                treasure = traversePath(row - 1, col, false, true, false, false, myPath);
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
            // Check the south side if no wall and not coming from the south
            if (dirSouth == false && maze.hasSouthWall(row, col) == false) {

                // Go south from north
                treasure = traversePath(row + 1, col, true, false, false, false, myPath);
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
            // Check the west side if no wall and not coming from the west
            if (dirWest == false && maze.hasWestWall(row, col) == false) {

                // Go west from east
                treasure = traversePath(row, col - 1, false, false, false, true, myPath);
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
            // Check the east side if no wall and not coming from the east
            if (dirEast == false && maze.hasEastWall(row, col) == false) {

                // Go east from west
                treasure = traversePath(row, col + 1, false, false, true, false, myPath);
                if (treasure == true) {
                    // if the treasure has been found, add this to the linked list path
                    myPath.add(new Coordinate(row, col));
                    return true;
                }
            }
/*
            if (treasure == true) {
                // if the treasure has been found, add this to the linked list path
                myPath.add(new Coordinate(row, col));
                return true;
            }
*/
            return treasure;
        } // end of recursive case

    }

}
