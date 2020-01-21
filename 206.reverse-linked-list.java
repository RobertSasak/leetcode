/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    // head: null 
    // node => null

    // node => 4
    // head => null

    // head => null
    // node => 6 => 4
    // t => null

    // head => null
    // node => 3 => 2 => 1
    // t => null
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode t;
        while (head != null) {
            if (node == null) {
                node = head;
                head = head.next;
                node.next = null;
            } else {
                t = head.next;
                head.next = node;
                node = head;
                head = t;
            }
        }
        return node;
    }


    // head null
    // => null

    // head => 1
    // a => null
    // b => 1
    // t => null
    // => 1

    // a => null
    // b => 
    // t => null
    // => 3 => 2 => 1 => null
    public ListNode recerseListRecursive(ListNode head) {
        return recerseListRecursive(head, null);
    }

    public ListNode recerseListRecursive(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        ListNode t = a.next;
        a.next = b;
        b = a;
        a = t;
        return recerseListRecursive(a, b);
    }


}
// @lc code=end

