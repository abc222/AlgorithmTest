package binarytree;

import java.util.Stack;

// https://blog.csdn.net/fengrunche/article/details/52305748
public class BinaryTree {

    private Node root = null;

    BinaryTree(int value) {
        root.value = value;
        root.leftChild = null;
        root.rightChild = null;
    }

//    public Node findKey(int value) {}   //查找
//    public String insert(int value) {}  //插入
//    public void inOrderTraverse() {}    //中序遍历递归操作
//    public void inOrderByStack() {}     //中序遍历非递归操作
//    public void preOrderTraverse() {}  //前序遍历
//    public void preOrderByStack() {}   //前序遍历非递归操作
//    public void postOrderTraverse() {} //后序遍历
//    public void postOrderByStack() {}  //后序遍历非递归操作
//    public int getMinValue() {} //得到最小(大)值
//    public boolean delete(int value) {} //删除

    // 查找数据
    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (current.value == value) {
                return current;
            } else if (current.value > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null)
                return null;
        }
    }

    // 插入数据
    public String insert(int value) {
        String error = null;
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.value) {
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else if (value > current.value) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                } else {
                    error = "insert fail, the binary tree have this value";
                }
            }
        }
        return error;
    }

    // 中序遍历 递归
    public void inOrderTraverse() {
        System.out.println("中序遍历：");
        inOrderTraverse(root);
    }

    public void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        node.show();
        inOrderTraverse(node.rightChild);
    }

    /**
     * 中序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     **/
    public void inOrderByStack() {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current.show();
                current = current.rightChild;
            }
        }
    }

    // 前序遍历 递归
    public void preOrderTraverse() {
        System.out.println("前序遍历：");
        preOrderTraverse(root);
    }

    public void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        node.show();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 前序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void preOrderByStack() {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current.show();
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.rightChild;
            }
        }
    }

    // 后序遍历 递归
    public void postOrderTraverse() {
        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }

    public void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.show();
    }

    /**
     * 后序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    // 还不太懂
    public void postOrderByStack() {
        Node current = root;
        Node preNode = null;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.peek().rightChild;
                if (current == null || current == preNode) {
                    current = stack.pop();
                    current.show();
                    preNode = current;
                    current = null;
                }
            }
        }
    }
}
