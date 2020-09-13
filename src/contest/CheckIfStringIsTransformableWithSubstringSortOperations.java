package contest;

import java.util.LinkedList;

/**
 * Given two strings s and t, you want to transform string s into string t using the following operation any number of times:
 *
 * Choose a non-empty substring in s and sort it in-place so the characters are in ascending order.
 * For example, applying the operation on the underlined substring in "14234" results in "12344".
 *
 * Return true if it is possible to transform string s into string t. Otherwise, return false.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "84532", t = "34852"
 * Output: true
 * Explanation: You can transform s into t using the following sort operations:
 * "84532" (from index 2 to 3) -> "84352"
 * "84352" (from index 0 to 2) -> "34852"
 * Example 2:
 *
 * Input: s = "34521", t = "23415"
 * Output: true
 * Explanation: You can transform s into t using the following sort operations:
 * "34521" -> "23451"
 * "23451" -> "23415"
 * Example 3:
 *
 * Input: s = "12345", t = "12435"
 * Output: false
 * Example 4:
 *
 * Input: s = "1", t = "2"
 * Output: false
 *
 *
 * Constraints:
 *
 * s.length == t.length
 * 1 <= s.length <= 105
 * s and t only contain digits from '0' to '9'.
 *
 * 统计s每个字符的位置，一个一个字符pop掉，期间保证stacks中不会有更大的字符在右边，因为只能升序。
 */
public class CheckIfStringIsTransformableWithSubstringSortOperations {
    public boolean isTransformable(String s, String t) {
        LinkedList<Integer>[] stacks = new LinkedList[10];
        for (int i = 0; i < 10; i++) stacks[i] = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) stacks[s.charAt(i) - '0'].push(i);

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = t.charAt(i) - '0';
            if (stacks[digit].size() == 0) {
                return false;
            }
            int last = stacks[digit].pop();
            for (int j = digit + 1; j < stacks.length; j++) {
                if (!stacks[j].isEmpty() && stacks[j].peek() > last) {
                    return false;
                }
            }
        }
        return true;
    }
}
