package com.algorithm;

public class LC0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;
        head = newNode;
        return head;
    }
}
