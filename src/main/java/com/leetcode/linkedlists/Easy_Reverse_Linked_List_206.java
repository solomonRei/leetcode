package com.leetcode.linkedlists;

import java.util.Stack;

public class Easy_Reverse_Linked_List_206 {

    public static ListNode reverseLinkedListOnlyValues(ListNode head) {

        Stack<Integer> values = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            values.push(curr.val);
            curr = curr.next;
        }

        ListNode curr1 = head;
        while(curr1 != null) {
            curr1.val = values.pop();
            curr1 = curr1.next;
        }

        return head;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    public static ListNode reverseLinkedListRecursion(ListNode head) {
        // Базовый случай: если список пустой или состоит из одного элемента, просто возвращаем head
        if (head == null || head.next == null) {
            return head;
        }

        // Рекурсивно разворачиваем оставшуюся часть списка, начиная со следующего узла
        ListNode reversedHead = reverseLinkedList(head.next);

        // Меняем направление связи: следующий элемент должен теперь указывать на текущий
        head.next.next = head;

        // Устанавливаем следующий элемент у текущего узла в null, так как он должен стать концом списка
        head.next = null;

        // Возвращаем новый head развернутого списка
        return reversedHead;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        node1.next = node2;
        node2.next = node3;
        ListNode result = reverseLinkedList(node1);
    }
}
