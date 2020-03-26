package binarytree;

public class Node {

    int value;
    Node leftChild;
    Node rightChild;

    Node(int n) {
        value = n;
    }

    public void show() {
        System.out.print(value + " ");
    }
}
