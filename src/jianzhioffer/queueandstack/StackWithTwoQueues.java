package jianzhioffer.queueandstack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int v) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(v);
            return;
        }
        if (queue1.isEmpty()) {
            queue2.add(v);
            return;
        }
        if (queue2.isEmpty()) {
            queue1.add(v);
            return;
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer)null;
    }

    public static void main(String[] args) {
        StackWithTwoQueues qs = new StackWithTwoQueues();
        qs.push(2);
        qs.push(4);
        qs.push(7);
        qs.push(5);
        System.out.println(qs.pop());
        System.out.println(qs.pop());

        qs.push(1);
        System.out.println(qs.pop());
    }
}
