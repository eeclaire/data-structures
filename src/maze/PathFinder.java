/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;

    public PathFinder(Maze iMaze) {
        maze = iMaze;
    }

    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();

        //* INSERT YOUR CODE HERE *//
        int currentRow = startRow;
        int currentColumn = startColumn;
        
        if (maze.isExit(currentRow,currentColumn)){
            // add block to linked list
            myPath.add(new Coordinate(currentRow, currentColumn));
            // #treasureFound
            // return true? Or return the linked list, not sure yet
        }
        

        // bogus code. REPLACE THIS ---------------------------
        myPath.add(new Coordinate(startRow, startColumn));
        System.out.print("This cell has the following walls: ");
        if (maze.hasNorthWall(startRow, startColumn)) {
            System.out.print("North ");
        }
        if (maze.hasSouthWall(startRow, startColumn)) {
            System.out.print("South ");
        }
        if (maze.hasEastWall(startRow, startColumn)) {
            System.out.print("East ");
        }
        if (maze.hasWestWall(startRow, startColumn)) {
            System.out.print("West ");
        }
        System.out.println("");
        // end bogus code -----------------------
                

        return (myPath);
    }
}
