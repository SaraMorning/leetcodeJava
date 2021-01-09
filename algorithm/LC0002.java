package com.algorithm;

import java.util.*;

public class LC0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        int carr = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (first != null && second != null) {
            int sum = first.val + second.val + carr;
            cur.next = new ListNode(sum % 10);
            carr = sum / 10;
            first = first.next;
            second = second.next;
            cur = cur.next;
        }
        while (first != null) {
            if (carr == 0) {
                cur.next = first;
                break;
            }
            int sum = first.val + carr;
            cur.next = new ListNode(sum % 10);
            carr = sum / 10;
            first = first.next;
            cur = cur.next;
        }
        while (second != null) {
            if (carr == 0) {
                cur.next = second;
                break;
            }
            int sum = second.val + carr;
            cur.next = new ListNode(sum % 10);
            carr = sum / 10;
            second = second.next;
            cur = cur.next;
        }
        if (carr != 0) {
            cur.next = new ListNode(carr);
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}


