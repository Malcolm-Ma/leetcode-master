package linkedList.deleteDuplicates83;

import linkedList.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
