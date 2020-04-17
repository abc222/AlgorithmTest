package linkedlist;

public class AddTwoLists {

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.data + l2.data;
            if (sum > 9) {
                node.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                node.next = new ListNode(sum);
                carry = 0;
            }
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            node.next = new ListNode(l1.data + carry);
            l1 = l1.next;
            node = node.next;
            node.next = l1;
            return dummy.next;
        } else if (l2 != null) {
            node.next = new ListNode(l2.data + carry);
            l2 = l2.next;
            node = node.next;
            node.next = l2;
            return dummy.next;
        } else {
            if (carry == 1) {
                node.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
}
