/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
/*

L1: null
L2: null

         P
H: 1 2 4 6

[5]\n[]
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode h = new ListNode(0);
        ListNode p = h;
        while (true) {
            if (l1 == null) {
                p.val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                p.val = l1.val;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                p.val = l1.val;
                l1 = l1.next;
            } else {
                p.val = l2.val;
                l2 = l2.next;
            }
            
            if (l1 == null && l2 == null) {
                return h;
            }
            p.next = new ListNode(0);
            p = p.next;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
// @lc code=end

