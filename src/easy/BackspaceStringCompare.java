package easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> stackS = new LinkedList<>();
        LinkedList<Character> stackT = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            } else stackS.push(c);
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            } else stackT.push(c);
        }
        return stackS.equals(stackT);
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
