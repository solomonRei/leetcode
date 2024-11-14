package com.leetcode.linkedlists;

import java.util.HashMap;

public class Easy_Remove_Duplicates_from_Sorted_List_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, ListNode> duplicates = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null) {
            if (duplicates.containsKey(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                duplicates.put(curr.next.val, curr.next);
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = deleteDuplicates(node1);
    }
}
