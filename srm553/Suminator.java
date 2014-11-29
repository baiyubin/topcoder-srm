import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Suminator
{
    static int INF = (int) 1e9;
	public int findMissing(int[] program, int wantedResult)
	{
		int pos = 0;
        int n = program.length;
        for (int i = 0; i < n; i++) {
            if (program[i] == -1) {
                pos = i;
                break;
            }
        }
        program[pos] = 0;
        long r0 = execute(program);
        if (r0 == wantedResult) {
            return 0;
        }
        program[pos] = -1;
        long r1 = execute(program);
        program[pos] = 1;
        long r2 = execute(program);
        long candidate = wantedResult - r2 + 1;
        if (r1 == r2 || r2 > wantedResult || candidate > INF) {
            return -1;
        } else {
            return (int) (candidate % (INF + 1));
        }
    }

    private long execute(int[] program) {
        Stack<Long> s = new Stack<Long>();
        for (int i = 0; i < program.length; i++) {
            if (program[i] == 0) {
                long n1 = 0, n2 = 0;
                if (!s.isEmpty()) {
                    n1 = s.pop();
                }
                if (!s.isEmpty()) {
                    n2 = s.pop();
                }
                s.push(n1 + n2);
            } else {
                s.push((long) program[i]);
            }
        }
        if (s.isEmpty()) {
            return 0;
        } else {
            return s.pop();
        }
    }


    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		Suminator obj;
		int answer;
		obj = new Suminator();
		long startTime = System.currentTimeMillis();
		answer = obj.findMissing(p0, p1);
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
		
		int[] p0;
		int p1;
		int p2;
        // ----- test 0 -----
        p0 = new int[]{279808452, 620805437, 83635404, 838871679, 857178021, 691041863, 84348544, 575676690, 0, 910430492, 0, 215400751, 238179932, 0, 525142367, 0, 0, 0, 11990241, 957341740, 0, 0, 934141887, 418006881, 0, 267811800, 555461679, 0, 432168824, 835612860, 0, 0, 0, 568807639, 201562867, 0, 47484219, 0, 0, 934223454, 110523480, 0, -1, 0};
        p1 = 925423618;
        p2 = -1;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

		// ----- test 0 -----
		p0 = new int[]{7,-1,0};
		p1 = 10;
		p2 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{100,200,300,0,100,-1};
		p1 = 600;
		p2 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{-1,7,3,0,1,2,0,0};
		p1 = 13;
		p2 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{-1,8,4,0,1,2,0,0};
		p1 = 16;
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{1000000000,1000000000,1000000000,1000000000,-1,0,0,0,0};
		p1 = 1000000000;
		p2 = -1;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{7,-1,3,0};
		p1 = 3;
		p2 = -1;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Suminator is a very limited programming language.
	// A program in this language is simply a sequence of nonnegative integers.
	// The program is evaluated using a stack of nonnegative integers.
	// Initially, the stack is empty.
	// Trying to pop an element from an empty stack returns a zero.
	// (Alternately, you can imagine that the stack already contains a sufficient number of zeros in the beginning.)
	// 
	// A Suminator program is evaluated using the following algorithm:
	// 
	// for i = 0 to length(program) - 1 {
	//     if ( program[i] is 0) {
	//          Pop the top two elements from the stack, add them together
	//          and push the result to the top of the stack.
	//     } else {
	//          Push program[i] to the top of the stack.
	//     }
	// }
	// Pop the top element of the stack and print it.
	// 
	// For example, when executing the program {1}, we first push the 1 to the stack, and then we print it. 
	// When executing the program {5,0,1,2,0}, we take the following steps:
	// 
	// We push the 5 to the top of the stack.
	// We pop the top two elements (5 and 0), add them together and push the result (5).
	// We push the 1 to the top of the stack.
	// We push the 2 to the top of the stack. At this moment, the stack contains the values 5, 1, and 2 (from bottom to top).
	// We pop the top two elements (2 and 1), add them together and push the result (3).
	// We print the top element of the stack: the number 3. Note that the stack also contains the value 5, which is ignored.
	// 
	// 
	// You are given a int[] program containing a Suminator program (a sequence of nonnegative integers), in which one of the elements of the sequence was changed to -1.
	// You are also given a int wantedResult.
	// Your task is to change the -1 back to a nonnegative integer X in such a way that the resulting program prints the number wantedResult.
	// Return X.
	// If there are multiple possible values of X, return the smallest one.
	// If there is no way to make the program print wantedResult, return -1 instead.
	// 
	// DEFINITION
	// Class:Suminator
	// Method:findMissing
	// Parameters:int[], int
	// Returns:int
	// Method signature:int findMissing(int[] program, int wantedResult)
	// 
	// 
	// NOTES
	// -The return value always fits into an int. This follows from the constraints and the nature of the problem.
	// 
	// 
	// CONSTRAINTS
	// -program will contain between 1 and 50 elements, inclusive.
	// -Each element of program will be between -1 and 1000000000 (10^9), inclusive.
	// -program will contain -1 exactly once.
	// -wantedResult will be between 1 and 1000000000 (10^9), inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {7,-1,0}
	// 10
	// 
	// Returns: 3
	// 
	// 
	// 
	// 1)
	// {100, 200, 300, 0, 100, -1}
	// 600
	// 
	// Returns: 0
	// 
	// 
	// 
	// 2)
	// {-1, 7, 3, 0, 1, 2, 0, 0}
	// 13
	// 
	// Returns: 0
	// 
	// We can replace the first element with many other values, but 0 is the smallest that achieves the wanted result.
	// 
	// 3)
	// {-1, 8, 4, 0, 1, 2, 0, 0}
	// 16
	// 
	// Returns: -1
	// 
	// It does not matter what value we use in the first element of the array, the result will always be 15.
	// 
	// 4)
	// {1000000000, 1000000000, 1000000000,  1000000000, -1, 0, 0, 0, 0}
	// 1000000000
	// 
	// Returns: -1
	// 
	// It does not matter what we replace the -1 with, the result will be larger than 1000000000.
	// 
	// 5)
	// {7, -1, 3, 0}
	// 3
	// 
	// Returns: -1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
