/******************************************************************************
 *  Compilation:  javac Polya.java
 *  Execution:    java Polya N
 *  
 *  Fraction of time you return to the origin when taking a random 
 *  walk in 3D (limiting the number of steps to, say, 1000).
 *
 *  % java Polya 10000
 *  Fraction returning to origin = 0.3293
 *
 *  % java Polya 10000
 *  Fraction returning to origin = 0.3341
 *
 *  Remark: if there is no limit on the maximum number of steps,
 *  then the fraction of random walks that return to the origin
 *  is approximately .3405 (Polya's random walk constant).
 *  
 *    http://mathworld.wolfram.com/PolyasRandomWalkConstants.html
 *
 ******************************************************************************/

public class Polya { 
    public static void main(String[] args) {
        int MAX_STEPS = 1000;
        int TRIALS    = Integer.parseInt(args[0]);

        // number of times returning to origin
        int yes = 0;

        for (int t = 0; t < TRIALS; t++) {
            // current location (x, y, z)
            int x = 0, y = 0, z = 0;

            for (int i = 0; i < MAX_STEPS; i++) {

                // pick one of 6 random directions
                int r = StdRandom.uniform(6);
                if      (r == 0) x++;
                else if (r == 1) x--;
                else if (r == 2) y++;
                else if (r == 3) y--;
                else if (r == 4) z++;
                else             z--;

                // returned to origin
                if ((x == 0) && (y == 0) && (z == 0)) {
                    yes++;
                    break;
                }
            }
        }

        // print results
        double fraction = 1.0 * yes / TRIALS;
        System.out.println("Fraction returning to origin = " + fraction);
    }

}
