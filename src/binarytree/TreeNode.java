package binarytree;

public class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int n) {
        value = n;
    }

    public void show() {
        System.out.print(value + " ");
    }
}
