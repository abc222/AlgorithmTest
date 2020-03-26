package linkedlist;

// 合并有序链表 顺序从小到大
public class MergeTwoLists {

    public static void main(String[] args) {

        LinkList linkList1 = new LinkList();
        for (int i = 7;i > 0;i --) {
            linkList1.addFirstNode(i);
        }
        linkList1.show();
        LinkList linkList2 = new LinkList();
        for (int i = 8;i > 5;i --) {
            linkList2.addFirstNode(i);
        }
        linkList2.show();
        Node l3 = mergeTwoLists2(linkList1.first, linkList2.first);
        while (l3 != null) {
            System.out.print(l3.data + " ");
            l3 = l3.next;
        }
    }

    // 方法1 递归
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // 方法2 迭代
    public static Node mergeTwoLists2(Node l1, Node l2) {
        Node preHead = new Node(-1);
        Node prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
