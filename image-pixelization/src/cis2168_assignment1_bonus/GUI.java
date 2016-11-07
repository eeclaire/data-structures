
/*
 * Claire Durand
 * CIS 2168 Assignment 1 (Slider Bonus version)
 * September 1st 2015
 *
 * GUI Class
 * Starts up a SimpleGUI, loads an image, draws a grid with a cellsize 
 * determined by the slider, and pixelizes the image to that cellsize
 * 
 */

package cis2168_assignment1_bonus;


import java.awt.Color;
import simplegui.DrwImage;
import simplegui.RGB;
import simplegui.SimpleGUI;

class GUI {

    // Fields -----------------------------------------------------------------
    
    // Create an image object
    DrwImage img = new DrwImage("testImage.jpg");
    
    // Define convenient variables for later
    int w = img.getWidth(); // we're going to need these
    int h = img.getHeight();

    // Create a SimpleGUI object with the dimensions of the image
    SimpleGUI sg = new SimpleGUI(w, h);

    
    // Methods ----------------------------------------------------------------
    
    // Set up the GUI (titles, centers & loads the image into the GUI)
    public void showGUI() {
        sg.setTitle("Pixelization with Slider");
        sg.centerGUIonScreen();
        sg.drawImage(img, 0, 0, w, h, "");
    }

    // Draw the grid dots to illustrate cellsize and pixelate accordingly
    public void drawGrid(int slide) {
        Color c = new Color(255, 0, 0);
        RGB rgb_value = new RGB();  // the 
        RGB new_rgb = new RGB();    // the RGB for the pixelated cell
        int s = sg.getSliderValue();

        int i, j;

        int r = 255;
        int g = 255;
        int b = 255;

        for (i = 0; i < (h - s); i = i + s) {  // w-s
            for (j = 0; j < (w - s); j = j + s) {
                sg.drawDot(j, i, 2, c, 1, "");
                new_rgb = getAverageRGB(i, j, s);
                pixelate(j, i, s, new_rgb);
            }   // end j for loop
        }   // end i for loop

    }

    // 
    public RGB getAverageRGB(int rowInit, int colInit, int d) {
        // Declare iteration variables
        int m, n;

        // Initialize some largely useless variables
        int r_avg = 0;
        int g_avg = 0;
        int b_avg = 0;

        // RGB class to return the average red, green, and blue values
        RGB rgb_avg = new RGB();

        // Delcare variables to determine the sum of each row
        int redRSum, greenRSum, blueRSum;   
        
        // Declare and initialize variables for the sum of row by column
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;  // total sum

        
        // Loop through pixels in cell and sum up r, g, and b values
        for (m = rowInit; m < (rowInit + d -1); m++) {

            // Reinitialize the row sums
            redRSum = 0;
            greenRSum = 0;
            blueRSum = 0;

            // Loop through pixels in cell and sum column's r, g, and b values
            for (n = colInit; n < (colInit + d -1); n++) {

                // Obtain each pixel's RGB value
                RGB rgb = new RGB();
                rgb = img.getPixelRGB(n, m);

                // Add the current pixel r, g, b values to the row's sums
                redRSum = redRSum + rgb.r;
                greenRSum = greenRSum + rgb.g;
                blueRSum = blueRSum + rgb.b;
            }   // end n for (pixels in ONE row of the cell)

            // Add the current row's r, g, b sums to the total sums
            redSum = redSum + redRSum;  
            greenSum = greenSum + greenRSum;    
            blueSum = blueSum + blueRSum;

        }   // end m for (full grid)

        // Calculate average r, g, b values for the cell and cast into int
        r_avg = (int) (redSum / (d * d));
        g_avg = (int) (greenSum / (d * d)); 
        b_avg = (int) (blueSum / (d * d));  

        // Set return RGB object fields equal to the appropriate r, g, b values
        rgb_avg.r = r_avg;
        rgb_avg.g = g_avg;
        rgb_avg.b = b_avg;

        // Return RGB object
        return rgb_avg;
    }

    // Method to "replace" the cell (actually only prints over)
    // with a filled box of the average RGB value of the cell
    public void pixelate(int x, int y, int size, RGB color_rgb) {

        // Create a color object from the input RGB values
        Color avg = new Color(color_rgb.r, color_rgb.g, color_rgb.b);

        // Print out the box (0.7 transparency to check result against original)
        sg.drawFilledBox(x, y, size, size, avg, 0.7, null);

    }
}   // end GUI class