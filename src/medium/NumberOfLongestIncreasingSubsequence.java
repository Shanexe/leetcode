package medium;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 * <p>
 * len[i]表示以nums[i]结尾的最长序列，count[i]表示最长序列的个数
 * 两个数组初始化必须为1
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = nums.length;
        int[] len = new int[l];
        int[] count = new int[l];
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        int max = 0;
        int ret = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                if (len[j] + 1 == len[i]) count[i] += count[j];
                else if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    count[i] = count[j];
                }
            }
            if (max == len[i]) ret += count[i];
            if (max < len[i]) {
                max = len[i];
                ret = count[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2}));
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
