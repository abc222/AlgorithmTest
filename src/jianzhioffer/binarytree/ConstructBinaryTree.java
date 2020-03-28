package jianzhioffer.binarytree;

// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
// 二叉树并输出它的头结点。
// https://www.cnblogs.com/yongh/p/9635690.html
public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode root = reConstructBinaryTree(pre, in);

        preOrderTraverse(root);
        System.out.println( );
        inOrderTraverse(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            System.out.println("输入不合法！");
            return null;
        }
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        TreeNode root = new TreeNode(pre[pStart]);
        if (pStart == pEnd && iStart == iEnd) {
            if (pre[pStart] != in[iStart]) {
                throw new RuntimeException("数组不符合规范！");
            }
            return root;
        }
        int index = iStart;
        while (in[index] != root.value && index <= iEnd) {
            index ++;
        }
        int leftLength = index - iStart;
        if (leftLength > 0) {
            root.leftChild = construct(pre, in, pStart + 1, pStart + leftLength, iStart, index -1);
        }
        if (leftLength < iEnd - iStart) {
            root.rightChild = construct(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
        }
        return root;
    }

    public static void preOrderTraverse(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        } else {
            return;
        }
    }

    public static void inOrderTraverse(TreeNode node) {
        if (node != null) {
            inOrderTraverse(node.leftChild);
            System.out.print(node.value + " ");
            inOrderTraverse(node.rightChild);
        } else {
            return;
        }
    }
}
