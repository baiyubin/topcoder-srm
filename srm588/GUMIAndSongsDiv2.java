public class GUMIAndSongsDiv2 {
    /**
     * srm 588
     * @param  duration [description]
     * @param  tone     [description]
     * @param  T        [description]
     * @return          [description]
     */
    public int maxSongs(int[] duration, int[] tone, int T) {
        int n = duration.length;
        int[][] dp = new int[1 << n][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = duration[i];
            if (duration[i] <= T) ans = 1;
        }
        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) continue;
                for (int k = 0; k < n; k++) {
                    if (((i >> k) & 1) == 1) continue;
                    dp[i|1 << k][k] = Math.min(
                                          dp[i|1<<k][k],
                                          dp[i][j] + duration[k] + Math.abs(tone[k] - tone[j])
                                      );
                    if (dp[i|1<<k][k] <= T) {
                        ans = Math.max(ans, Integer.bitCount(i) + 1);
                    }
                }
            }
        }
        return ans;

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
        GUMIAndSongsDiv2 obj;
        int answer;
        obj = new GUMIAndSongsDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.maxSongs(p0, p1, p2);
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

        // ----- test 0 -----
        p0 = new int[] {3,5,4,11};
        p1 = new int[] {2,1,3,1};
        p2 = 17;
        p3 = 3;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {100,200,300};
        p1 = new int[] {1,2,3};
        p2 = 10;
        p3 = 0;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {1,2,3,4};
        p1 = new int[] {1,1,1,1};
        p2 = 100;
        p3 = 4;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {10,10,10};
        p1 = new int[] {58,58,58};
        p2 = 30;
        p3 = 3;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {8,11,7,15,9,16,7,9};
        p1 = new int[] {3,8,5,4,2,7,4,1};
        p2 = 14;
        p3 = 1;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614};
        p1 = new int[] {2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853};
        p2 = 302606;
        p3 = 8;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Gumi loves singing.
    // She knows N songs.
    // The songs are numbered 0 through N-1.
    // She now has some time and she would love to sing as many different songs as possible.
    //
    // You are given a int[] duration.
    // For each i, duration[i] is the duration of song i in Gumi's time units.
    //
    // Gumi finds it difficult to sing songs with quite different tones consecutively.
    // You are given a int[] tone with the following meaning:
    // If Gumi wants to sing song y immediately after song x, she will need to spend |tone[x]-tone[y]| units of time resting between the two songs.
    // (Here, || denotes absolute value.)
    //
    // You are also given an int T.
    // Gumi has T units of time for singing.
    // She can start singing any song she knows immediately at the beginning of this time interval.
    // Compute the maximal number of different songs she can sing completely within the given time.
    //
    // DEFINITION
    // Class:GUMIAndSongsDiv2
    // Method:maxSongs
    // Parameters:int[], int[], int
    // Returns:int
    // Method signature:int maxSongs(int[] duration, int[] tone, int T)
    //
    //
    // CONSTRAINTS
    // -duration and tone will each contain between 1 and 15 elements, inclusive.
    // -duration and tone will contain the same number of elements.
    // -Each element of duration will be between 1 and 100,000, inclusive.
    // -Each element of tone will be between 1 and 100,000, inclusive.
    // -T will be between 1 and 10,000,000, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {3, 5, 4, 11}
    // {2, 1, 3, 1}
    // 17
    //
    // Returns: 3
    //
    // There are four songs.
    // Two songs have tone 1 and their durations are 5 and 11, respectively.
    // One song has tone 2 and its duration is 3.
    // One song has tone 3 and its duration is 4.
    // Gumi has 17 units of time to sing.
    //
    // It is impossible for Gumi to sing all four songs she knows within the given time: even without the breaks the total length of all songs exceeds 17.
    //
    // Here is one way how she can sing three songs:
    // First, she sings song 0 in 3 units of time.
    // Second, she waits for |2-3|=1 unit of time and then sings song 2 in 4 units of time.
    // Finally, she waits for |3-1|=2 units of time and then sings song 1 in 5 units of time.
    // The total time spent is 3+1+4+2+5 = 15 units of time.
    //
    //
    // 1)
    // {100, 200, 300}
    // {1, 2, 3}
    // 10
    //
    // Returns: 0
    //
    // In this case, T is so small that she can't sing at all.
    //
    // 2)
    // {1, 2, 3, 4}
    // {1, 1, 1, 1}
    // 100
    //
    // Returns: 4
    //
    // There is plenty of time, so she can sing all 4 songs.
    //
    //
    // 3)
    // {10, 10, 10}
    // {58, 58, 58}
    // 30
    //
    // Returns: 3
    //
    //
    //
    // 4)
    // {8, 11, 7, 15, 9, 16, 7, 9}
    // {3, 8, 5, 4, 2, 7, 4, 1}
    // 14
    //
    // Returns: 1
    //
    //
    //
    // 5)
    // {5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614}
    // {2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}
    // 302606
    //
    // Returns: 8
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
