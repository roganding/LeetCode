package leetcode225;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 用队列实现栈
 * 栈特点：先进后出
 * @author rogan
 * @date 2025/1/7
 */
public class MyStack {

    private Queue<Integer> tail;

    private Queue<Integer> capacity;

    // 想半天觉得需要记录容器元素的数量
    private int size;

    public MyStack() {
        this.capacity = new ArrayBlockingQueue<>(10);
        this.tail = new ArrayBlockingQueue<>(10);
    }

    /**
     * 压入栈顶
     * @param x
     */
    public void push(int x) {
        capacity.offer(x);
        size++;
    }

    /**
     * 移除并返回栈顶元素
     * @return
     */
    public int pop() {
        for (int i = 0; i < size - 1; i++) {
            tail.offer(capacity.poll());
        }
        Integer top = capacity.poll();
        size--;

        Queue<Integer> tmp = tail;
        tail = capacity; // empty
        capacity = tmp;
        return top;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public int top() {
        for (int i = 0; i < size - 1; i++) {
            tail.offer(capacity.poll());
        }
        Integer top = capacity.poll();

        Queue<Integer> tmp = tail;
        tail = capacity; // empty
        capacity = tmp;
        capacity.offer(top);
        return top;
    }

    public boolean empty() {
        return tail.isEmpty() && capacity.isEmpty();
    }
}