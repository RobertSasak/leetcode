/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    // 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int c) {
        if (l1 == null && l2 == null) {
            if (c == 1) {
                return new ListNode(1);
            }
            return null;
        }
        int x = l1 == null ? 0 : l1.val;
        int y = l2 == null ? 0 : l2.val;
        int sum = x + y + c;
        ListNode l = new ListNode(sum % 10);
        l.next = addTwoNumbers(
            l1 == null ? null : l1.next,
            l2 == null ? null : l2.next,
            sum / 10
        );
        return l;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    // c = 0
    // 3 -> 9 -> 1 -> 2
    // 4 -> 5 -> 6
    // 7 -> 4 -> 8 -> 2

    // 0 
    // 7 -> 3
    // 7 
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int c) {
        if (l1 == null && l2 == null) {
            if (c == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }

        if (l1 == null) {
            return addTwoNumbers(l2, null, c);
        }

        int s = l1.val + c;
        ListNode l = new ListNode(0);
        if (l2 != null) {
            s += l2.val;
        }
        l.val = s % 10;
        l.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next, s / 10);
        return l;
    }
}
// @lc code=end

