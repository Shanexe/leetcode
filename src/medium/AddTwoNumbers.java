package medium;

import common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = (l1.val + l2.val) % 10;
        boolean carry = (l1.val + l2.val) >= 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode head = new ListNode(remainder);
        ListNode ret = head;
        while (l1 != null || l2 != null || carry) {
            int t = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (carry ? 1 : 0);
            remainder = t % 10;
            carry = t >= 10;
            head.next = new ListNode(remainder);
            head = head.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return ret;
    }
}
