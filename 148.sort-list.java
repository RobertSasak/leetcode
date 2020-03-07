/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode a) {
        if (a == null) {
            return null;
        }        
        if (a.next == null) {
            return a;
        }
        ListNode b = split(a);
        a = sortList(a);
        b = sortList(b);
        return merge(a, b);
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) {
            cur.next = b;
        } else {
            cur.next = a;
        }
        return fakeHead.next;
    }

    ListNode split(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode fast = head;
        ListNode slow = fakeHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    // ListNode combine(ListNode a, ListNode b) {
    //     if (a == null) {
    //         return b;
    //     }
    //     while (a.next != null) {
    //         a = a.next;
    //     }
    //     a.next = b;
    //     return a;
    // }
}
// @lc code=end

