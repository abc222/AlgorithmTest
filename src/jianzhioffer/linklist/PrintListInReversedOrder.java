package jianzhioffer.linklist;

import java.util.Stack;

public class PrintListInReversedOrder {

    public static void main(String[] args) {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        ListNode3.next=ListNode4;
        ListNode4.next=ListNode5;
        System.out.println("采用栈：");
        printListReversingly_Iteratively(ListNode1);
        System.out.println("采用递归：");
        printListReversingly_Recursively(ListNode1);
    }

    public static void printListReversingly_Iteratively(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
    }

    public static void printListReversingly_Recursively(ListNode node) {
        if (node != null) {
            printListReversingly_Iteratively(node.next);
            System.out.print(node.value + " ");
        } else {
            return;
        }
    }
}
