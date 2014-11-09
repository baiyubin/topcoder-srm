public class ArcadeManao
{
    int n, m;
	public int shortestLadder(String[] level, int coinRow, int coihnColumn)
	{
        n = level.length;
        m = level[0].length();
        for (int ret = 0; ret <= 50; ret++) {
            char[][] mat = new char[n][m];
            for (int i = 0; i < n; i++) {
                mat[i] = level[i].toCharArray();
            }
            dfs(n - 1, 0, mat, ret);
            if (mat[coinRow - 1][coinColumn - 1] == 'T') return ret;
        }
        return -1;
    }

    private void dfs(int i, int j, char[][] mat, int len) {
        int left = j, right = j;
        for (int k = j; k < m; k++) {
            if (mat[i][k] == 'X') {
                mat[i][k] = 'T';
                right = k;
            } else {
                break;
            }
        }
        for (int k = Math.max(0, j - 1); k >= 0; k--) {
            if (mat[i][k] == 'X') {
                mat[i][k] = 'T';
                left = k;
            } else {
                break;
            }
        }
        for (int row = Math.max(0, i - len); row <= Math.min(n - 1, i + len); row++) {
            for (int k = left; k <= right; k++) {
                if (mat[row][k] == 'X') dfs(row, k, mat, len);
            }
        }
    }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1 + "," + p2);
		System.out.println("]");
		ArcadeManao obj;
		int answer;
		obj = new ArcadeManao();
		long startTime = System.currentTimeMillis();
		answer = obj.shortestLadder(p0, p1, p2);
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
		int p1;
		int p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new String[]{"XXXX....","...X.XXX","XXX..X..","......X.","XXXXXXXX"};
		p1 = 2;
		p2 = 4;
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"XXXX","...X","XXXX"};
		p1 = 1;
		p2 = 1;
		p3 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"..X..",".X.X.","X...X",".X.X.","..X..","XXXXX"};
		p1 = 1;
		p2 = 3;
		p3 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"X"};
		p1 = 1;
		p2 = 1;
		p3 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"XXXXXXXXXX","...X......","XXX.......","X.....XXXX","..XXXXX..X",".........X",".........X","XXXXXXXXXX"};
		p1 = 1;
		p2 = 1;
		p3 = 2;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// You might remember the old computer arcade games. Here is one about Manao.
	// 
	// The game level is an NxM grid of equal cells. The bottom of some cells has a platform at which Manao can stand. All the cells in the bottommost row contain a platform, thus covering the whole ground of the level. The rows of the grid are numbered from 1 to N starting from the top and the columns are numbered from 1 to M starting from the left. Exactly one cell contains a coin and Manao needs to obtain it.
	// 
	// Initially, Manao is standing on the ground, i.e., in the bottommost row. He can move between two horizontally adjacent cells if both contain a platform. Also, Manao has a ladder which he can use to climb. He can use the ladder to climb both up and down. If the ladder is L units long, Manao can climb between two cells (i1, j) and (i2, j) if both contain a platform and |i1-i2| <= L. Note that Manao carries the ladder along, so he can use it multiple times. You need to determine the minimum ladder length L which is sufficient to acquire the coin.
	// 
	// Take a look at the following picture. On this level, Manao will manage to get the coin with a ladder of length 2.
	// 
	// 
	// 
	// You are given a int[] level containing N elements. The j-th character in the i-th row of level is 'X' if cell (i+1, j+1) contains a platform and '.' otherwise. You are also given ints coinRow and coinColumn. The coin which Manao seeks is located in cell (coinRow, coinColumn) and it is guaranteed that this cell contains a platform.
	// 
	// Return the minimum L such that ladder of length L is enough to get the coin. If Manao can perform the task without using the ladder, return 0.
	// 
	// DEFINITION
	// Class:ArcadeManao
	// Method:shortestLadder
	// Parameters:String[], int, int
	// Returns:int
	// Method signature:int shortestLadder(String[] level, int coinRow, int coinColumn)
	// 
	// 
	// NOTES
	// -Manao is not allowed to fall. The only way in which he may change his vertical coordinate is by using the ladder.
	// 
	// 
	// CONSTRAINTS
	// -level will contain N elements, where N is between 1 and 50, inclusive.
	// -Each element of level will be M characters long, where M is between 1 and 50, inclusive.
	// -Each element of level will consist of '.' and 'X' characters only.
	// -The last element of level will be entirely filled with 'X'.
	// -coinRow will be between 1 and N, inclusive.
	// -coinColumn will be between 1 and M, inclusive.
	// -level[coinRow - 1][coinColumn - 1] will be 'X'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"XXXX....",
	//  "...X.XXX",
	//  "XXX..X..",
	//  "......X.",
	//  "XXXXXXXX"}
	// 2
	// 4
	// 
	// Returns: 2
	// 
	// The example from the problem statement.
	// 
	// 1)
	// {"XXXX",
	//  "...X",
	//  "XXXX"}
	// 1
	// 1
	// 
	// Returns: 1
	// 
	// Manao can use the ladder to climb from the ground to cell (2, 4), then to cell (1, 4) and then he can walk right to the coin.
	// 
	// 2)
	// {"..X..",
	//  ".X.X.",
	//  "X...X",
	//  ".X.X.",
	//  "..X..",
	//  "XXXXX"}
	// 1
	// 3
	// 
	// Returns: 4
	// 
	// With a ladder of length 4, Manao can first climb to cell (5, 3) and then right to (1, 3).
	// 
	// 3)
	// {"X"}
	// 1
	// 1
	// 
	// Returns: 0
	// 
	// Manao begins in the same cell as the coin.
	// 
	// 4)
	// {"XXXXXXXXXX",
	//  "...X......",
	//  "XXX.......",
	//  "X.....XXXX",
	//  "..XXXXX..X",
	//  ".........X",
	//  ".........X",
	//  "XXXXXXXXXX"}
	// 1
	// 1
	// 
	// Returns: 2
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
