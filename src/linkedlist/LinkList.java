package linkedlist;

public class LinkList {

    public ListNode first;  //头结点
    private int pos = 0;    //节点的位置

    public LinkList() {
        this.first = null;
    }

    // 插入一个头结点
    public void addFirstNode(int data) {
        ListNode listNode = new ListNode(data);
        listNode.next = first;
        first = listNode;
    }

    // 删除一个头结点 并返回
    public ListNode deleteFirestNode() {
        ListNode tempListNode = first;
        first = tempListNode.next;
        return tempListNode;
    }

    // 在任意位置插入 index后
    public void add(int data, int index) {
        ListNode listNode = new ListNode(data);
        ListNode previous = first;
        ListNode current = first;
        while (pos != index) {
            previous = current;
            current = current.next;
            pos ++;
        }
        listNode.next = current;
        previous.next = listNode;
        pos = 0;
    }

    // 删除任意位置的节点并返回
    public ListNode deleteByPos(int index) {
        ListNode previous, current;
        previous = first;
        current = first;
        while (pos != index) {
            pos ++;
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    // 根据节点的data删除节点，仅删除第一个
    public ListNode deletaByData(int data) {
        ListNode previous, current;
        previous = first;
        current = first;
        while (current.data != data) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    // 显示所有节点信息
    public void show() {
        ListNode current = first;
        while (current != null) {
            current.show();
            current = current.next;
        }
        System.out.println();
    }

    // 根据数据查找节点信息
    public ListNode findByData(int data) {
        ListNode current = first;
        while (current.data != data) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
}
