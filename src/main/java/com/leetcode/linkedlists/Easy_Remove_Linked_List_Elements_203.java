package com.leetcode.linkedlists;

public class Easy_Remove_Linked_List_Elements_203 {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode front = curr.next;
            if (curr.val == val) {
                if (prev != null) {
                    prev.next = front;
                } else {
                    head = front;
                }
            } else {
                prev = curr;
            }
            curr = front;
        }
        return head;
    }

    public static ListNode removeElementsWithDummyNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
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

//        ListNode result = removeElements(node1, 3);
        ListNode result2 = removeElementsWithDummyNode(node1, 3);
    }
}
