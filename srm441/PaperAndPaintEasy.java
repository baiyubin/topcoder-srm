import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * 441
 */
public class PaperAndPaintEasy {
    public long computeArea(int width, int height, int xfold, int cnt, int x1, int y1, int x2, int y2) {
        long filled = 0L;
        if (xfold * 2 > width) {
            xfold = width - xfold;
        }
        int yfold = height/(cnt + 1);
        filled += 2L * (cnt + 1L) * overlap(0, 0, xfold - 1, yfold - 1, x1, y1, x2 - 1, y2 - 1);
        filled += (cnt + 1L) * overlap(xfold, 0, width - xfold - 1, yfold - 1, x1, y1, x2 - 1, y2 - 1);
        return 1L * width * height - filled;
    }

    private long overlap(int r1minx, int r1miny, int r1maxx, int r1maxy, int r2minx, int r2miny, int r2maxx, int r2maxy) {
        int minX = Math.max(r1minx, r2minx);
        int minY = Math.max(r1miny, r2miny);
        int maxX = Math.min(r1maxx, r2maxx);
        int maxY = Math.min(r1maxy, r2maxy);
        if (minX <= maxX && minY <= maxY) {
            return 1L * (maxX - minX + 1) * (maxY - minY + 1);
        } else {
            return 0L;
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, boolean hasAnswer, long p8) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6 + "," + p7);
        System.out.println("]");
        PaperAndPaintEasy obj;
        long answer;
        obj = new PaperAndPaintEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.computeArea(p0, p1, p2, p3, p4, p5, p6, p7);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p8);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p8;
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
        } else if ((endTime - startTime) / 1000.0 >= 2) {
            System.out.println("FAIL the timeout");
            res = false;
        } else if (hasAnswer) {
            System.out.println("Match :-)");
        } else {
            System.out.println("OK, but is it right?");
        }
        System.out.println("");
        return res;
    }
    public static void main(String[] args) {
        boolean all_right;
        all_right = true;

        int p0;
        int p1;
        int p2;
        int p3;
        int p4;
        int p5;
        int p6;
        int p7;
        long p8;

        // ----- test 0 -----
        p0 = 5;
        p1 = 6;
        p2 = 2;
        p3 = 2;
        p4 = 1;
        p5 = 1;
        p6 = 3;
        p7 = 2;
        p8 = 21L;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 3;
        p1 = 13;
        p2 = 1;
        p3 = 0;
        p4 = 1;
        p5 = 8;
        p6 = 2;
        p7 = 12;
        p8 = 35L;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 12;
        p1 = 12;
        p2 = 7;
        p3 = 3;
        p4 = 3;
        p5 = 1;
        p6 = 6;
        p7 = 2;
        p8 = 124L;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 4;
        p1 = 5;
        p2 = 4;
        p3 = 0;
        p4 = 0;
        p5 = 0;
        p6 = 1;
        p7 = 1;
        p8 = 19L;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 4;
        p1 = 8;
        p2 = 4;
        p3 = 3;
        p4 = 0;
        p5 = 1;
        p6 = 2;
        p7 = 2;
        p8 = 24L;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = 4;
        p1 = 8;
        p2 = 3;
        p3 = 0;
        p4 = 1;
        p5 = 1;
        p6 = 3;
        p7 = 2;
        p8 = 30L;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Onise likes to play with paper and paint.  He has a piece of paper with dimensions width x height.  He does the following steps with the paper:
    //
    //
    // Fold the paper along the line x = xfold (the left side of the paper is folded over the right side).
    // Divide the paper vertically into cnt+1 equal sections.  Then, cnt times, take the topmost section and fold it over the section below it.
    // Paint a rectangle with the lower-left corner at (x1, y1) and the upper-right corner at (x2, y2).  Note that (0, 0) is now the lower-left corner of the paper in its current folded state, not its original state.  The paint will seep through all the layers of the folded paper.  See the image below for clarification.
    // Unfold the paper.
    //
    //
    // For example, let's say Onise has a piece of paper that is 5 x 6.  He performs the described steps where xfold is 2, cnt is 2, and the coordinates of the painted rectangle's corners are (1, 1) and (3, 2).  The following will happen (note that the paper starts out blue in the images and gets painted white):
    //
    // ?
    // ?
    // ?
    // ?
    // ?
    //
    //
    // You are given ints width and height, and ints xfold, cnt, x1, y1, x2 and y2.  Return the total area of of the paper that is not covered in paint after Onise is done.
    //
    // DEFINITION
    // Class:PaperAndPaintEasy
    // Method:computeArea
    // Parameters:int, int, int, int, int, int, int, int
    // Returns:long
    // Method signature:long computeArea(int width, int height, int xfold, int cnt, int x1, int y1, int x2, int y2)
    //
    //
    // CONSTRAINTS
    // -width and height will be between 1 and 10^9, inclusive.
    // -xfold will be between 0 and width, inclusive.
    // -cnt will be between 0 and 1000, inclusive.
    // -cnt+1 will be a divisor of height.
    // -0 <= x1 < x2 <= max(xfold, width-xfold) and 0 <= y1 < y2 <= height/(cnt+1).
    //
    //
    // EXAMPLES
    //
    // 0)
    // 5
    // 6
    // 2
    // 2
    // 1
    // 1
    // 3
    // 2
    //
    // Returns: 21
    //
    // The example from the problem statement.
    //
    // 1)
    // 3
    // 13
    // 1
    // 0
    // 1
    // 8
    // 2
    // 12
    //
    // Returns: 35
    //
    // 2)
    // 12
    // 12
    // 7
    // 3
    // 3
    // 1
    // 6
    // 2
    //
    // Returns: 124
    //
    // 3)
    // 4
    // 5
    // 4
    // 0
    // 0
    // 0
    // 1
    // 1
    //
    // Returns: 19
    //
    // 4)
    // 4
    // 8
    // 4
    // 3
    // 0
    // 1
    // 2
    // 2
    //
    // Returns: 24
    //
    // 5)
    // 4
    // 8
    // 3
    // 0
    // 1
    // 1
    // 3
    // 2
    //
    // Returns: 30
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
