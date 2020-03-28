package linkedlist;

// 用快慢指针判断链表是否有环
public class IsListHasCycle {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
        System.out.println(calCycleLength(node1));
        System.out.println(calCyclePoint(node1).data);
    }

    public static boolean isCycle(Node node) {
        Node node1 = node;
        Node node2 = node;
        while (node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                return true;
            }
        }
        return false;
    }

    // 求环的长度
    public static int calCycleLength(Node node) {
        Node node1 = node;
        Node node2 = node;
        int meetCount = 0;
        int stepcount = 0;
        while (node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (meetCount == 1) {
                stepcount++;
            } else if (meetCount == 2) {
                return stepcount;
            }
            if (node1 == node2) {
                meetCount++;
            }
        }
        return 0;
    }

    // 求入环点
    public static Node calCyclePoint(Node node) {
        Node node1 = node;
        Node node2 = node;
        while (node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                node2 = node;
                break;
            }
        }
        while (node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == node2) {
                return node1;
            }
        }
        return null;
    }
}
