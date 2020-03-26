package linkedlist;

public class LinkList {

    public Node first;  //头结点
    private int pos = 0;    //节点的位置

    public LinkList() {
        this.first = null;
    }

    // 插入一个头结点
    public void addFirstNode(int data) {
        Node node = new Node(data);
        node.next = first;
        first = node;
    }

    // 删除一个头结点 并返回
    public Node deleteFirestNode() {
        Node tempNode = first;
        first = tempNode.next;
        return tempNode;
    }

    // 在任意位置插入 index后
    public void add(int data, int index) {
        Node node = new Node(data);
        Node previous = first;
        Node current = first;
        while (pos != index) {
            previous = current;
            current = current.next;
            pos ++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }

    // 删除任意位置的节点并返回
    public Node deleteByPos(int index) {
        Node previous, current;
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
    public Node deletaByData(int data) {
        Node previous, current;
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
        Node current = first;
        while (current != null) {
            current.show();
            current = current.next;
        }
        System.out.println();
    }

    // 根据数据查找节点信息
    public Node findByData(int data) {
        Node current = first;
        while (current.data != data) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
}
