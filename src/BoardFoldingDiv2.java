import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BoardFoldingDiv2 {
    char[][] p = new char[55][55];

    /**
     * Observations:
     *  1. to have a smaller area folded, the previously folded areas must be foldable in same way
     *  2. each possible fold generates a new segment
     *  3. horizontal folds and vertical folds are independent
     * @param paper
     * @return
     */
    public int howMany(String[] paper) {
        int n = paper.length, m = paper[0].length();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < paper[i].length(); j++) {
                p[i][j] = paper[i].charAt(j);
            }
        }
        int h = count(n, m);
        for (int i = 0; i < 55; ++i) {
            for (int j = i; j < 55; ++j) {
                char swap = p[i][j];
                p[i][j] = p[j][i];
                p[j][i] = swap;
            }
        }
        int v = count(m, n);
        return h * v;
    }
    private int count(int n, int m) {
        boolean[][] seen = new boolean[m + 1][m + 1];
        ArrayDeque<Integer> qStart = new ArrayDeque<Integer>();
        ArrayDeque<Integer> qEnd = new ArrayDeque<Integer>();
        qStart.add(0);
        qEnd.add(m);
        seen[0][m] = true;
        int ret = 0;
        while (!qStart.isEmpty()) {
            int start = qStart.pollFirst(), end = qEnd.pollFirst();
            int width = end - start;
            ret++;
            for (int fold = 2; fold < width + 1; fold += 2) {
                int start2 = start + fold / 2;
                if (!seen[start2][end] && check(0, start, n, fold)) {
                    seen[start2][end] = true;
                    qStart.offerLast(start2);
                    qEnd.offerLast(end);
                }
                int end2 = end - fold / 2;
                if (!seen[start][end2] && check(0, start + width - fold, n, fold)) {
                    seen[start][end2] = true;
                    qStart.offerLast(start);
                    qEnd.offerLast(end2);
                }
            }
        }
        return ret;
    }
    private boolean check(int r, int c, int height, int length) {
        for (int row = r; row < r + height; ++row) {
            int left = c, right = c + length - 1;
            while (left < right) {
                if (p[row][left] != p[row][right]) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        BoardFoldingDiv2 obj;
        int answer;
        obj = new BoardFoldingDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.howMany(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p1);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p1;
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
        int p1;

        // ----- test 3 -----
        p0 = new String[] {"0", "0", "0", "1", "0", "0"};
        p1 = 6;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = new String[] {"10", "11"};
        p1 = 1;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"1111111", "1111111"};
        p1 = 84;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"0110", "1001", "1001", "0110"};
        p1 = 9;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new String[] {"000", "010", "000"};
        p1 = 1;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Little Petya likes puzzles a lot.
    // Recently he has received one as a gift from his mother.
    // The puzzle has the form of a rectangular sheet of paper that is divided into N rows by M columns of unit square cells.
    // Rows are numbered 0 through N-1 from top to bottom, and columns 0 through M-1 from left to right.
    // Each cell is colored either black or white.
    // You are given a description of the paper, the exact format is specified at the end of this problem statement.
    //
    //
    // The goal of the puzzle is to fold the paper.
    // This has to be done in a sequence of turns.
    // In each turn, Petya has to fold the paper according to the rules below.
    // He can end the process after any number of turns (including zero), even if there are still valid ways to fold the paper.
    //
    //
    // In each turn, Petya must follow these steps:
    // To start folding, he must choose a line that is parallel to one of the sides of the paper and passes between two rows/columns of cells.
    // He can then take the smaller part of the paper and fold it on top of the larger part.
    // (If the line divides the current paper in half, he can fold either half on top of the other.)
    // There is one additional restriction:
    // Petya may only perform the fold if all cells of the part that is being folded land on equally-colored cells of the part that remains in place.
    //
    //
    // For example, consider the following paper (with 0 and 1 representing white and black):
    //
    // 10010101
    // 11110100
    // 00000000
    // 01101110
    //
    //
    //
    // Here, Petya could choose the vertical line that goes between the two leftmost columns and the rest of the paper.
    // Note that this is a valid choice: as he makes the fold, the cells from the leftmost two columns will all match their counterparts in the right part of the
    // paper.
    // This is how the paper looks like after the fold (with periods representing empty spaces):
    //
    // ..010101
    // ..110100
    // ..000000
    // ..101110
    //
    //
    //
    // Clearly, even after multiple folds the paper will always look like a subrectangle of the original paper.
    // Two states of the game are considered the same if that rectangle has the same dimensions and the same offset with respect to the original top left corner of
    // the paper.
    // (Note that folding order does not matter. Two different sequences of folding may produce the same final state.)
    //
    //
    // You are given a description of the original state of the paper as a String[] paper. Here N is the number of elements in paper and M is the length of its each element. For each i and j, the character paper[i][j] is either '0' (meaning that the cell (i,j) is white) or '1' (the cell is black).
    // Compute and return the number of possible final states of the game.
    //
    // DEFINITION
    // Class:BoardFoldingDiv2
    // Method:howMany
    // Parameters:String[]
    // Returns:int
    // Method signature:int howMany(String[] paper)
    //
    //
    // CONSTRAINTS
    // -paper will contain between 1 and 50 elements, inclusive.
    // -Each element of paper will contain between 1 and 50 elements, inclusive.
    // -All elements of paper will have the same length.
    // -paper will contain only characters '0' and '1'.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {"10",
    //  "11"}
    //
    // Returns: 1
    //
    // There is no valid way to fold this paper, so there is just one possible outcome.
    //
    // 1)
    // {"1111111",
    //  "1111111"}
    //
    // Returns: 84
    //
    // We can fold it into any of the 84 possible subrectangles of the original rectangle.
    //
    // 2)
    // {"0110",
    //  "1001",
    //  "1001",
    //  "0110"}
    //
    // Returns: 9
    //
    //
    //
    // 3)
    // {"0",
    //  "0",
    //  "0",
    //  "1",
    //  "0",
    //  "0"}
    //
    // Returns: 6
    //
    //
    //
    // 4)
    // {"000",
    //  "010",
    //  "000"}
    //
    // Returns: 1
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
