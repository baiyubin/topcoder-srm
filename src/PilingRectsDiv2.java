import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PilingRectsDiv2 {
    int[] X, Y;
    int N;
    int limit;
    int ret = -1, curr = 0;
    int currX = Integer.MAX_VALUE - 100, currY = Integer.MAX_VALUE - 100;

    public int getmax(int[] X, int[] Y, int limit) {
        N = X.length;
        this.limit = limit;
        this.X = X;
        this.Y = Y;
        solve(0);
        return ret;
    }
    public void solve(int step) {
        if (step == N) return;
        int xi = Math.min(X[step], Y[step]);
        int yi = Math.max(X[step], Y[step]);
        int x = Math.min(currX, xi);
        int y = Math.min(currY, yi);
        if (x * y >= limit) {
            curr++;
            ret = Math.max(ret, curr);
            int prevX = currX, prevY = currY;
            currX = x;
            currY = y;
            solve(step + 1);
            currX = prevX;
            currY = prevY;
            curr--;
        } else {
            solve(step + 1);
        }

    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p1[i]);
        }
        System.out.print("}" + "," + p2);
        System.out.println("]");
        PilingRectsDiv2 obj;
        int answer;
        obj = new PilingRectsDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.getmax(p0, p1, p2);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p3);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p3;
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

        int[] p0;
        int[] p1;
        int p2;
        int p3;

        p0 = new int[] {77, 134, 82, 80, 54, 104, 18, 114, 75, 24, 86, 167, 178, 150, 192, 10, 50, 192, 79, 151, 1, 16, 56, 177, 197, 127, 188, 63, 5, 142, 80, 165, 164, 137, 34};
        p1 = new int[] {128, 42, 156, 153, 191, 115, 90, 166, 126, 102, 198, 9, 152, 102, 105, 3, 135, 21, 28, 39, 161, 32, 86, 44, 46, 152, 156, 58, 40, 74, 192, 194, 60, 167, 151};
        p2 = 728;
        p3 = 30;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;

        // ----- test 4 -----
        p0 = new int[] {3, 6, 5, 8, 2, 9, 14};
        p1 = new int[] {14, 6, 13, 8, 15, 6, 3};
        p2 = 27;
        p3 = 4;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = new int[] {1, 2, 3, 1};
        p1 = new int[] {3, 2, 4, 4};
        p2 = 3;
        p3 = 3;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {4, 7};
        p1 = new int[] {7, 4};
        p2 = 25;
        p3 = 2;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {10};
        p1 = new int[] {10};
        p2 = 9999;
        p3 = -1;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {10};
        p1 = new int[] {3};
        p2 = 30;
        p3 = 1;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {121, 168, 86, 106, 36, 10, 125, 97, 53, 26, 148, 129, 41, 18, 173, 55, 13, 73, 91, 174, 177, 190, 28, 164, 122, 92, 5, 26, 58, 188, 14, 67, 48, 196, 41, 94, 24, 89, 54, 117, 12, 6, 155, 103, 200, 128, 184, 29, 92, 149};
        p1 = new int[] {199, 182, 43, 191, 2, 145, 15, 53, 38, 37, 61, 45, 157, 129, 119, 123, 177, 178, 183, 188, 132, 108, 112, 137, 92, 59, 75, 196, 102, 152, 114, 121, 181, 93, 32, 3, 24, 116, 4, 163, 96, 159, 196, 43, 59, 150, 79, 113, 20, 146};
        p2 = 5345;
        p3 = 24;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
