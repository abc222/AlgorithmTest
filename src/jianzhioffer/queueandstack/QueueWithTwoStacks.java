package jianzhioffer.queueandstack;

import java.util.Stack;

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        Queue queue = queueWithTwoStacks.new  Queue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    class Queue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int v) {
            stack1.push(v);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty())
                    throw new RuntimeException("队列为空！");
                else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
            }
            return stack2.pop();
        }
    }
}
