package linkedlist;

// 用快慢指针判断链表是否有环
public class IsListHasCycle {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;
        System.out.println(isCycle(listNode1));
        System.out.println(calCycleLength(listNode1));
        System.out.println(calCyclePoint(listNode1).data);
    }

    public static boolean isCycle(ListNode listNode) {
        ListNode listNode1 = listNode;
        ListNode listNode2 = listNode;
        while (listNode1.next != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
            if (listNode1 == listNode2) {
                return true;
            }
        }
        return false;
    }

    // 求环的长度
    // 环长 = 每一次速度差* 前进次数
    // 速度相差1，环长 = 第二次相遇距离第一次相遇的前进次数
    public static int calCycleLength(ListNode listNode) {
        ListNode listNode1 = listNode;
        ListNode listNode2 = listNode;
        int meetCount = 0;
        int stepcount = 0;
        while (listNode1.next != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
            if (meetCount == 1) {
                stepcount++;
            } else if (meetCount == 2) {
                return stepcount;
            }
            if (listNode1 == listNode2) {
                meetCount++;
            }
        }
        return 0;
    }

    // 求入环点
    // 第一次相遇时，慢指针走了 D + S1
    // 快指针走了 D + S1 + n（S1 + S2）
    // 2（D + S1） = D + S1 + n（S1 + S2）
    // 整理得：D = （n-1)（S1 + S2) + S2
    // 所以第一次相遇以后，把一个指针放回头节点，两个指针每次走一步，再一次相遇的地方就是入环点
    public static ListNode calCyclePoint(ListNode listNode) {
        ListNode listNode1 = listNode;
        ListNode listNode2 = listNode;
        while (listNode1.next != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
            if (listNode1 == listNode2) {
                listNode2 = listNode;
                break;
            }
        }
        while (listNode1.next != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
            if (listNode1 == listNode2) {
                return listNode1;
            }
        }
        return null;
    }
}
