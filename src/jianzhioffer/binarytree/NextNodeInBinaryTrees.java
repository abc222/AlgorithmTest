package jianzhioffer.binarytree;

// 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
// https://www.cnblogs.com/yongh/p/9637187.html

public class NextNodeInBinaryTrees {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            System.out.print("结点为null ");
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.parent != null) {
            if (pNode == pNode.parent.left) {
                return pNode.parent;
            }
            pNode = pNode.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.left = node1;
        node1.parent = node4;
        TreeLinkNode nextNodeOf1 = GetNext(node1);
        TreeLinkNode nextNodeOf2 = GetNext(node2);
        TreeLinkNode nextNodeOf3 = GetNext(node3);
        TreeLinkNode nextNodeOf4 = GetNext(node4);
        if (nextNodeOf1 != null)
            System.out.println("1结点的下一个结点值为：" + nextNodeOf1.val);
        else
            System.out.println("1结点无下一结点");
        if (nextNodeOf2 != null)
            System.out.println("2结点的下一个结点值为：" + nextNodeOf2.val);
        else
            System.out.println("2结点无下一结点");
        if (nextNodeOf3 != null)
            System.out.println("3结点的下一个结点值为：" + nextNodeOf3.val);
        else
            System.out.println("3结点无下一结点");
        if (nextNodeOf4 != null)
            System.out.println("4结点的下一个结点值为：" + nextNodeOf4.val);
        else
            System.out.println("4结点无下一结点");
    }
}
