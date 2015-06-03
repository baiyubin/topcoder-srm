import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

// srm659
public class ApplesAndOrangesHard
{
	public int maximumApples(int N, int K, int[] info)
	{
		return 0;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ApplesAndOrangesHard obj;
		int answer;
		obj = new ApplesAndOrangesHard();
		long startTime = System.currentTimeMillis();
		answer = obj.maximumApples(p0, p1, p2);
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
		
		int p0;
		int p1;
		int[] p2;
		int p3;
		
		// ----- test 0 -----
		p0 = 3;
		p1 = 2;
		p2 = new int[]{};
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 10;
		p1 = 3;
		p2 = new int[]{3,8};
		p3 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 9;
		p1 = 4;
		p2 = new int[]{1,4};
		p3 = 5;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 9;
		p1 = 4;
		p2 = new int[]{2,4};
		p3 = 4;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 23;
		p1 = 7;
		p2 = new int[]{3,2,9,1,15,23,20,19};
		p3 = 10;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 1000000000;
		p1 = 17;
		p2 = new int[]{2110119,401933834,401933833,10};
		p3 = 470588238;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Garth likes apples and oranges. Recently he bought N fruits, where each fruit was either an apple or an orange. Then he ate all N fruits in some order. You are given an int K. Garth observed that at every point in time, if he made a list of the last K fruits he ate, there were at most K/2 (rounded down) apples in this list.
	// 
	// 
	// For each valid i, you know that the info[i]-th fruit Garth ate was an apple. (Fruits Garth ate are numbered starting from 1. For example, info[i]=1 means that the very first fruit Garth ate was an apple.)
	// 
	// 
	// Please find and return the maximum number of apples Garth could have eaten.
	// 
	// DEFINITION
	// Class:ApplesAndOrangesHard
	// Method:maximumApples
	// Parameters:int, int, int[]
	// Returns:int
	// Method signature:int maximumApples(int N, int K, int[] info)
	// 
	// 
	// NOTES
	// -If Garth makes his list at a point in time when he ate fewer than K fruits, his list will have fewer than K fruits but the requirement will still be the same: there have to be at most K/2 apples in the list.
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 1,000,000,000, inclusive.
	// -K will be between 2 and min(100,000, N), inclusive.
	// -info will contain between 0 and 50 elements, inclusive.
	// -Each element of info will be between 1 and N, inclusive.
	// -The elements of info will be distinct.
	// -The elements of info will be consistent with Garth's observation.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 3
	// 2
	// {}
	// 
	// Returns: 2
	// 
	// Garth ate N=3 fruites. The requirement is that any K=2 consecutive fruits may contain at most K/2 = 1 apple. As info is empty, you have no additional information about the fruits Garth ate.
	// 
	// 
	// Garth might have eaten an apple, then an orange, then an apple. This satisfies the conditions:
	// 
	// After eating the 1st fruit, the list is [apple].
	// After eating the 2nd fruit, the list is [apple, orange].
	// After eating the 3rd fruit, the list is [orange, apple].
	// 
	// Each list contains at most 1 apple.
	// 
	// 1)
	// 10
	// 3
	// {3, 8}
	// 
	// Returns: 2
	// 
	// All fruits, except for the 3rd and the 8th, must have been oranges.
	// 
	// 2)
	// 9
	// 4
	// {1, 4}
	// 
	// Returns: 5
	// 
	// 
	// 
	// 3)
	// 9
	// 4
	// {2, 4}
	// 
	// Returns: 4
	// 
	// 
	// 
	// 4)
	// 23
	// 7
	// {3, 2, 9, 1, 15, 23, 20, 19}
	// 
	// Returns: 10
	// 
	// 
	// 
	// 5)
	// 1000000000
	// 17
	// {2110119, 401933834, 401933833, 10}
	// 
	// Returns: 470588238
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
