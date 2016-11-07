package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class Maze extends JFrame implements ActionListener{
    private final int   DEFAULTCHAMBERSIZE=8;
    
    //
    private byte [][]   theMaze;    // the maze, containing chambers
    private JPanel      mazePanel;
    private Container   cp;
    private long        count;
    private MazeListener mazeListener;
    
    // -------------------------------------------------------------------------
    // inner class MyPanel
    // -------------------------------------------------------------------------
    private class MyPanel extends JPanel implements MouseListener{
        int chamberSize;
        
        public MyPanel(){  
            // where to go now ?
            int noRows=theMaze.length;
            int noColumns=theMaze[0].length;
             
            chamberSize = DEFAULTCHAMBERSIZE;
            if (Math.max(noRows,noColumns)<100)
                chamberSize=DEFAULTCHAMBERSIZE*2;
            else if (Math.max(noRows,noColumns)>200)
                chamberSize = DEFAULTCHAMBERSIZE/2;

            setPreferredSize(new Dimension(noColumns * chamberSize, noRows * chamberSize));
            addMouseListener(this);
        }
        
        public void paint(Graphics g){
            int noRows=theMaze.length;
            int noColumns=theMaze[0].length;
            for (int r=0;r<noRows;r++){
                for (int c=0; c<noColumns; c++){
                    int w=theMaze[r][c];
                    int posX=c*chamberSize;
                    int posY=r*chamberSize;
                    if ((w & 0x20) != 0)
                        g.setColor(Color.green);          // the exit
                    else if((w & 0x10) != 0)
                        g.setColor(Color.red);            // path
                    else
                        g.setColor(Color.orange);         // default background
                
                    g.fillRect(posX,posY,chamberSize,chamberSize);
                    
                    // the walls
                    g.setColor(Color.black);
                    int cs = chamberSize -1;
                    if ((w & 1)==1) 
                        g.drawLine(posX,posY,posX+cs,posY);
                    if ((w & 2)==2) 
                        g.drawLine(posX,posY,posX,posY+cs);
                    if ((w & 4)==4) 
                        g.drawLine(posX,posY+cs,posX+cs,posY+cs);
                    if ((w & 8)==8) 
                        g.drawLine(posX+cs,posY,posX+cs,posY+cs);
                }
            }
        }
        
        public void mouseClicked(MouseEvent e) {
        }
        
        public void mouseEntered(MouseEvent e) {
        }
        
        public void mouseExited(MouseEvent e) {
        }
        
        public void mousePressed(MouseEvent e) {
            // clear old path entries
            int noRows=theMaze.length;
            int noColumns=theMaze[0].length;
            for (int r=0;r<noRows;r++){
                for (int c=0; c<noColumns; c++){
                    theMaze[r][c] = (byte)(theMaze[r][c] & 0x2f); 
                }
            }
            
            // get mouse position
            int x=e.getX();
            int y=e.getY();
            int col=(int)Math.floor(x/chamberSize);
            int row=(int)Math.floor(y/chamberSize);
            
            // if a listener is registered: call MazeClicked
            if (mazeListener != null){
                mazeListener.MazeClicked(row,col);
            }
            else
                System.out.println("As long as nothing is registered, a click won't do too much...");
        }
        
        public void mouseReleased(MouseEvent e) {
        }
        
    }
    // -------------------------------------------------------------------------
    
    // -------------------------
    // Constructor
    // -------------------------
    public Maze(int r, int c) {
        super("The Maze");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp=getContentPane();
        cp.setLayout(new BorderLayout());
        JButton b1=new JButton("New Maze");
        b1.setBackground(Color.CYAN);
        b1.addActionListener(this);
        cp.add(b1,BorderLayout.SOUTH);
              
        generate(r,c);  // generate maze, draw it on panel, pack
        
        setVisible(true);
    }
    
    // -----------------------------------------
    // add listener, typically a path generator
    // -----------------------------------------
    public void addMazeListener(MazeListener ml){
        mazeListener = ml;
    }
    
    public void showPath(Iterator i){
        while(i.hasNext()){
            Coordinate p=(Coordinate)i.next();
            int row=(int)p.row;
            int col=(int)p.column;
            theMaze[row][col] |= (byte)0x10;
            repaint();
        }
    }
    
    public byte getMazeData(int r,int c){
        return(theMaze[r][c]);
    }

    public boolean hasNorthWall(int r, int c){
        return((getMazeData(r, c)& 1) != 0);
    }
    public boolean hasWestWall(int r, int c){
        return((getMazeData(r, c)& 2) != 0);
    }
    public boolean hasSouthWall(int r, int c){
        return((getMazeData(r, c)& 4) != 0);
    }
    public boolean hasEastWall(int r, int c){
        return((getMazeData(r, c)& 8) != 0);
    }
    public boolean isExit(int r, int c){
        return((getMazeData(r, c)& 32) != 0);
    }
    
    // -------------------------
    // Maze Generation Entry
    // -------------------------
    public boolean generate(int rows, int columns){        
        // initialize: all walls up, path=false => 0x0f
        theMaze = new byte[rows][columns];
        for (int r=0;r<rows;r++){
            for (int c=0;c<columns;c++){
                theMaze[r][c]=0x0f;
            }
        }
        
        // pick a start point
        int startR=(int)Math.floor(Math.random()*rows);
        int startC=(int)Math.floor(Math.random()*rows);
        count = 0;
        
        // and generate
        boolean done = false;
        try{
            generateRec(startR,startC,0);
            // set exit point to 0,0
            theMaze[0][0] |= 0x20;      // 0x20: exit
            mazePanel = new MyPanel();      // create and add new panel
            done = true;
        }
        catch(Exception er){
            mazePanel = new JPanel();
            mazePanel.setPreferredSize(new Dimension(500,300));
            mazePanel.add(new Label("Sorry, size is too big: Stack Overflow"));
            done = false;
        }
        finally{
            // add panel to frame
            if (mazePanel != null){
                cp.remove(mazePanel);
            }
            cp.add(mazePanel,BorderLayout.CENTER);
            pack();
            repaint(); 
        }
        return false;
    }
    
    // -------------------------
    // Recursive Maze Generation
    // -------------------------
    private void generateRec(int r, int c, int direction){
        // tear down wall towards source direction
        switch(direction){
            case 1: theMaze[r][c] -= 4;break;
            case 2: theMaze[r][c] -= 8;break;
            case 4: theMaze[r][c] -= 1;break;
            case 8: theMaze[r][c] -= 2;break;
        }
        count++;        // another chamber processed.
        
        // where to go now ?
        int noRows=theMaze.length;
        int noColumns=theMaze[0].length;
        
        // base case 1: all chambers finished
        if (count == noRows*noColumns){
            return; 
        }

        // recursive case: while there are walkable directions: walk
        while (true){
            // find walkable directions
            boolean dir1,dir2,dir4,dir8;
            dir1=dir2=dir4=dir8=false;
            if (r>0 && (theMaze[r-1][c]==0x0f)) dir1=true;
            if (c>0 && (theMaze[r][c-1]==0x0f)) dir2=true;
            if (r<noRows-1 && (theMaze[r+1][c]==0x0f)) dir4=true;
            if (c<noColumns-1 && (theMaze[r][c+1]==0x0f)) dir8=true;
            
            
            // base case 2: no walkable directions left
            if ((dir1 | dir2 | dir4 | dir8) == false)
                break;
            
            boolean picked=false;
            do{
                int d=(int)Math.floor(Math.random()*4); // direction 0-3
                switch(d){
                    case 0: if (dir1){
                        picked=true;
                        theMaze[r][c] -= 1;
                        generateRec(r-1,c,1);
                        dir1=false;
                        break;
                    }
                    case 1: if (dir2){
                        picked=true;
                        theMaze[r][c] -= 2;
                        generateRec(r,c-1,2);
                        dir2=false;
                        break;
                    }
                    case 2:if (dir4){
                        picked=true;
                        theMaze[r][c] -= 4;
                        generateRec(r+1,c,4);
                        dir4=false;
                        break;
                    }
                    case 3:if (dir8){
                        picked=true;
                        theMaze[r][c] -= 8;
                        generateRec(r,c+1,8);
                        dir8=false;
                        break;
                    }
                }
            }while(!picked);
        }
        // base case2n cont'd: no more walkable directions left
        return;
    }
    
    // ---------------------------
    // toString: returns maze data
    // ---------------------------
    public String toString(){
        int noRows=theMaze.length;
        int noColumns=theMaze[0].length;
        
        String s="";
        for (int r=0;r<noRows;r++){
            for (int c=0;c<noColumns;c++){
                s=s + theMaze[r][c] + " ";
            }
            s=s+"\n";
        }
        return(s);
    }
   
    // ---------------------------------
    // Action Performed
    // --------------------------------
    public void actionPerformed(ActionEvent e) {
        int noRows=theMaze.length;
        int noColumns=theMaze[0].length;
        generate(noRows,noColumns);
    }
}
