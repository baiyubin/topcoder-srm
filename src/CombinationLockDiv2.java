import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CombinationLockDiv2 {
    int N, MaxP;
    int[] diff;
    int[][][] dp;

    public int minimumMoves(String S, String T) {
        N = S.length();
        diff = new int[N];
        for (int i = 0; i < N; ++i) {
            diff[i] = T.charAt(i) - S.charAt(i);
            if (diff[i] < 0) diff[i] += 10;
        }
        MaxP = 9 * N;
        dp = new int[N + 1][MaxP + 1][2];
        for (int i = 0; i < N + 1; ++i) {
            for (int j = 0; j < MaxP + 1; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return cost(0, 0, 0);
    }

    /**
     * cost of arranging [p, N] using only direction 'up'
     * @param  p  pos
     * @param  d  sum distance of [0, p) in direction 'up'
     * @param  up direction
     * @return    cost
     */
    private int cost(int p, int d, int up) {
        if (dp[p][d][up] != -1) return dp[p][d][up];
        if (p == N) return dp[p][d][up] = 0;

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < MaxP + 1; ++j) {
                if (isValid(p, j, i)) {
                    if (up != i) {
                        ret = Math.min(ret, j + cost(p + 1, j, i));
                    } else {
                        if (d >= j) {
                            ret = Math.min(ret, cost(p + 1, j, i));
                        } else {
                            ret = Math.min(ret, (j - d) + cost(p + 1, j, i));
                        }
                    }
                }
            }
        }
        return dp[p][d][up] = ret;
    }

    public boolean isValid(int p, int j, int i) {
        j = j % 10;
        return (i == 0) ? (j == diff[p]) : (j == (10 - diff[p]) % 10);
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
        System.out.println("]");
        CombinationLockDiv2 obj;
        int answer;
        obj = new CombinationLockDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.minimumMoves(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p2);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p2;
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

        String p0;
        String p1;
        int p2;

        // ----- test 0 -----
        p0 = "123";
        p1 = "112";
        p2 = 1;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "1";
        p1 = "7";
        p2 = 4;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "607";
        p1 = "607";
        p2 = 0;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "1234";
        p1 = "4567";
        p2 = 3;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "020";
        p1 = "909";
        p2 = 2;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = "4423232218340";
        p1 = "6290421476245";
        p2 = 18;
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
