import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TaroString {
    public String getAnswer(String S) {
        char[] s = S.toCharArray();
        String result = "";
        for ( char c : s ) {
            if (c == 'C' || c == 'A' || c == 'T') result += c;
        }
        return result.equals("CAT") ? "Possible" : "Impossible";
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
        System.out.println("]");
        TaroString obj;
        String answer;
        obj = new TaroString();
        long startTime = System.currentTimeMillis();
        answer = obj.getAnswer(p0);
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

        String p0;
        String p1;

        // ----- test 0 -----
        p0 = "XCYAZTX";
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "CTA";
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "ACBBAT";
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "SGHDJHFIOPUFUHCHIOJBHAUINUIT";
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "CCCATT";
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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
