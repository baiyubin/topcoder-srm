import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class WinterAndReindeers {
    /**
     * SRM 601
     * @param  allA [description]
     * @param  allB [description]
     * @param  allC [description]
     * @return      [description]
     */
    public int getNumber(String[] allA, String[] allB, String[] allC) {
        return 1;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, String[] p2, boolean hasAnswer, int p3) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p1[i] + "\"");
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p2.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p2[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        WinterAndReindeers obj;
        int answer;
        obj = new WinterAndReindeers();
        long startTime = System.currentTimeMillis();
        answer = obj.getNumber(p0, p1, p2);
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

        String[] p0;
        String[] p1;
        String[] p2;
        int p3;

        // ----- test 0 -----
        p0 = new String[] {"X"};
        p1 = new String[] {"X", "Y"};
        p2 = new String[] {"X"};
        p3 = 1;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"ABCXD"};
        p1 = new String[] {"BCDEF"};
        p2 = new String[] {"CD"};
        p3 = 3;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"WE", "LOVE"};
        p1 = new String[] {"WORKING", "FOR", "SANTA"};
        p2 = new String[] {"JK"};
        p3 = 0;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {"ABCDE"};
        p1 = new String[] {"CDEAB"};
        p2 = new String[] {"B"};
        p3 = 2;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new String[] {"ABCABDEGAXAHDJBAAHFJDXBB", "ABHFHCDALFDJDBBA", "BABBAXAXXX"};
        p1 = new String[] {"ABLOCBAXBAHAJDXBIJKA", "JBABCDAHKFIUDALPJAH", "AABACX"};
        p2 = new String[] {"AXBADXBBAB", "CDD"};
        p3 = 23;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
