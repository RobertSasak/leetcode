/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    // nil => nil
    // 5=> 5
    //   c
    // 4 5 => 4 5
    //    c
    // 2->nil
    // c
    // 2 2 2
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;
        while (c != null && c.next != null) {
            if (c.val == c.next.val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return head;
    }
}
// @lc code=end

