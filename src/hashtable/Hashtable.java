package hashtable;

import java.util.Arrays;

public class Hashtable {

    // Fields -----------------------------------------------------------------
    double[] ht;    // hashtable
    double[] collisions;    // collisions hashtable

    // Constructor ------------------------------------------------------------
    public Hashtable() {
        this.ht = new double[100];    // hashtable
        this.collisions = new double[100];    // collisions hashtable
        Arrays.fill(this.collisions, -1);
    }

    // Methods ----------------------------------------------------------------
    public void visualizeHT() {
    }

}
