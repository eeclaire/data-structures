/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Point;
import java.util.LinkedList;

public class Main implements MazeListener {

    Maze maze;

    public Main() {
        // a 30 rows x 50 columns maze
        maze = new Maze(30, 50);

        // register object of class Main to the maze
        maze.addMazeListener(this);
    }

    public LinkedList myRecursion(int row, int col) {
        LinkedList<Point> ll = new LinkedList();
        for (int i = 10; i < 20; i++) {
            ll.addFirst(new Point(i, i));
        }
        return(ll);
    }

    public void MazeClicked(int row, int col) {
        System.out.println("You clicked " + row + " " + col + ". ");
        //System.out.println("The data at this position is: " + maze.getMazeData(row, col));
        PathFinder p = new PathFinder(maze);
        LinkedList ll = p.findPath(row, col);
        maze.showPath(ll.iterator());
    }

    public static void main(String[] args) {
        new Main();
    }
}
