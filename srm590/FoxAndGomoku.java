import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FoxAndGomoku {
    /**
     * SRM 590
     * @param board
     * @return
     */
    public String win(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[][] c = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'o') {
                    c[i][j+1] = c[i][j] + 1;
                } else {
                    c[i][j+1] = 0;
                }
            }
        }
        if (check(c)) return "found";

        c = new int[n+1][m+1];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i].charAt(j) == 'o') {
                    c[i+1][j] = c[i][j] + 1;
                } else {
                    c[i+1][j] = 0;
                }
            }
        }
        if (check(c)) return "found";

        c = new int[n+1][m+1];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i].charAt(j) == 'o') {
                    c[i+1][j+1] = c[i][j] + 1;
                } else {
                    c[i+1][j+1] = 0;
                }
            }
        }
        if (check(c)) return "found";

        c = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i-1].charAt(j) == 'o') {
                    c[i][j] = c[i - 1][j + 1] + 1;
                } else {
                    c[i][j] = 0;
                }
            }
        }
        if (check(c)) return "found";
        return "not found";

    }

    private boolean check(int[][] c) {
        for (int[] a : c) {
            for (int i : a) {
                if (i >= 5) return true;
            }
        }
        return false;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        FoxAndGomoku obj;
        String answer;
        obj = new FoxAndGomoku();
        long startTime = System.currentTimeMillis();
        answer = obj.win(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p1 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p1);
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

        String[] p0;
        String p1;

        // ----- test 0 -----
        p0 = new String[] {"....o.","...o..","..o...",".o....","o.....","......"};
        p1 = "found";
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"oooo.",".oooo","oooo.",".oooo","....."};
        p1 = "not found";
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"oooo.",".oooo","oooo.",".oooo","....o"};
        p1 = "found";
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {"o.....",".o....","..o...","...o..","....o.","......"};
        p1 = "found";
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new String[] {"o....","o.o..","o.o.o","o.o..","o...."};
        p1 = "found";
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new String[] {"..........","..........","..oooooo..","..o.......","..o.......","..oooooo..",".......o..",".......o..","..oooooo..",".........."};
        p1 = "found";
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = new String[] {"..........","..........","..oooo.o..","..o.......","..o.......","..o.oooo..",".......o..",".......o..","..oooo.o..",".........."};
        p1 = "not found";
        all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
        // ------------------

        // ----- test 7 -----
        p0 = new String[] {"ooooo","ooooo","ooooo","ooooo","ooooo"};
        p1 = "found";
        all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
        // ------------------

        // ----- test 8 -----
        p0 = new String[] {".....",".....",".....",".....","....."};
        p1 = "not found";
        all_right = KawigiEdit_RunTest(8, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Fox Ciel is going to play Gomoku with her friend Fox Jiro.
    // Ciel plays better, so before they start she allowed Jiro to put some of his pieces on the board.
    //
    //
    // You are given a String[] board that represents a square board.
    // The character board[i][j] represents the cell with coordinates (i,j).
    // Each of those characters is either '.' (representing an empty cell) or 'o' (representing a cell with Jiro's piece).
    //
    //
    // Of course, Ciel does not want Jiro to win the game before she has a chance to play.
    // Thus she now has to check the board and determine whether there are five consecutive tokens somewhere on the board.
    //
    //
    // Determine whether there are 5 consecutive cells (horizontally, vertically, or diagonally) that contain Jiro's tokens.
    // Return "found" (quotes for clarity) if there are five such cells anywhere on the board.
    // Otherwise, return "not found".
    //
    // DEFINITION
    // Class:FoxAndGomoku
    // Method:win
    // Parameters:String[]
    // Returns:String
    // Method signature:String win(String[] board)
    //
    //
    // CONSTRAINTS
    // -n will be between 5 and 15, inclusive.
    // -board will contain exactly n elements.
    // -Each element in board will contain exactly n characters.
    // -Each character in board will be 'o' or '.'.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {"....o.",
    //  "...o..",
    //  "..o...",
    //  ".o....",
    //  "o.....",
    //  "......"}
    //
    // Returns: "found"
    //
    // There is five continue pieces diagonally.
    //
    // 1)
    // {"oooo.",
    //  ".oooo",
    //  "oooo.",
    //  ".oooo",
    //  "....."}
    //
    //
    // Returns: "not found"
    //
    // There is no five-in-a-row on this board.
    //
    // 2)
    // {"oooo.",
    //  ".oooo",
    //  "oooo.",
    //  ".oooo",
    //  "....o"}
    //
    //
    // Returns: "found"
    //
    // Five consecutive tokens can be found in the following cells: (0,0), (1,1), (2,2), (3,3), and (4,4).
    //
    // 3)
    // {"o.....",
    //  ".o....",
    //  "..o...",
    //  "...o..",
    //  "....o.",
    //  "......"}
    //
    // Returns: "found"
    //
    //
    //
    // 4)
    // {"o....",
    //  "o.o..",
    //  "o.o.o",
    //  "o.o..",
    //  "o...."}
    //
    // Returns: "found"
    //
    //
    //
    // 5)
    // {"..........",
    //  "..........",
    //  "..oooooo..",
    //  "..o.......",
    //  "..o.......",
    //  "..oooooo..",
    //  ".......o..",
    //  ".......o..",
    //  "..oooooo..",
    //  ".........."}
    //
    //
    //
    // Returns: "found"
    //
    //
    //
    // 6)
    // {"..........",
    //  "..........",
    //  "..oooo.o..",
    //  "..o.......",
    //  "..o.......",
    //  "..o.oooo..",
    //  ".......o..",
    //  ".......o..",
    //  "..oooo.o..",
    //  ".........."}
    //
    //
    // Returns: "not found"
    //
    //
    //
    // 7)
    // {"ooooo",
    //  "ooooo",
    //  "ooooo",
    //  "ooooo",
    //  "ooooo"}
    //
    // Returns: "found"
    //
    //
    //
    // 8)
    // {".....",
    //  ".....",
    //  ".....",
    //  ".....",
    //  "....."}
    //
    // Returns: "not found"
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
