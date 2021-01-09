package com.algorithm;

public class LC0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int curListSize = lists.length;
        while (curListSize > 1) {
            int span = (curListSize + 1) / 2;
            for (int index = 0; index < curListSize / 2; ++index) {
                lists[index] = mergeTwoList(lists[index], lists[index + span]);
            }
            curListSize = span;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;

        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
