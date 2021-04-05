package contest.hard;

/**
 * You are given an array nums that consists of positive integers.
 *
 * The GCD of a sequence of numbers is defined as the greatest integer that divides all the numbers in the sequence evenly.
 *
 * For example, the GCD of the sequence [4,6,16] is 2.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * Return the number of different GCDs among all non-empty subsequences of nums.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [6,10,3]
 * Output: 5
 * Explanation: The figure shows all the non-empty subsequences and their GCDs.
 * The different GCDs are 6, 10, 3, 2, and 1.
 * Example 2:
 *
 * Input: nums = [5,15,40,5,6]
 * Output: 7
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 2 * 10^5
 *
 * 求所有含有某个因子的所有数的gcd，如果最终的gcd等于该因子，则结果+1
 */
public class NumberOfDifferentSubsequencesGCDs {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] gcd = new int[200001];
        for (int i : nums) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    int factor = i / j;
                    if (gcd[j] == 0) {
                        gcd[j] = i;
                    } else {
                        gcd[j] = gcd(i, gcd[j]);
                    }
                    if (gcd[factor] == 0) {
                        gcd[factor] = i;
                    } else {
                        gcd[factor] = gcd(i, gcd[factor]);
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 1; i < gcd.length; i++) {
            if (gcd[i] == i) ret++;
        }
        return ret;

    }

    private int gcd(int m, int n) {
        while (n != 0) {
            m %= n;
            m ^= n;
            n ^= m;
            m ^= n;
        }
        return m;
    }
}
