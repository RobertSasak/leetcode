/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        HashSet<ListNode> h = new HashSet<ListNode>();
        while (headA != null) {
            h.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (h.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //                    
    //           1 => 2 => 3 => 4 => 5 => 6 =>
    //                |
    // 10=>11 => 12 => 

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        } 
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        ListNode tailB = headB;
        while (tailB.next != null) {
            tailB = tailB.next;
        } 
        if (tailA != tailB) {
            return null;
        }
        
        ListNode i = headA;
        ListNode j = headB;
        while (i != j) {
            if (i.next == null) {
                i = headB;
            } else {
                i = i.next;
            }
            if (j.next == null) {
                j = headA;
            } else {
                j = j.next;
            }
        }
        return i;
    }

    public ListNode getIntersectionNodeBruteforce(ListNode headA, ListNode headB) {
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }
}
// @lc code=end

