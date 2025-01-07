package leetcode232;

import java.util.Stack;

/**
 * 题目：用两个栈实现一个队列
 * 分析：
 * 1.队列特点：先进先出
 * 提示：
 * 1.Java 里的栈数据结构：Stack<E>
 * @author rogan
 * @date 2025/1/7
 */
public class MyQueue1 {

    private Stack<Integer> tail;

    private Stack<Integer> capacity;


    public MyQueue1() {
        this.tail = new Stack<>();
        this.capacity = new Stack<>();
    }

    /**
     * 元素x 推到队列末尾
     * @param x
     */
    public void push(int x) {
        if (tail.isEmpty()) {
            tail.push(x);
            // capacity 全部转入 tail
            while (!capacity.isEmpty()) {
                Integer head = capacity.pop();
                tail.push(head);
            }
            return;
        }

        capacity.push(x);
    }

    /**
     * 从开头移除元素并返回该元素
     * @return
     */
    public int pop() {
        if (!tail.isEmpty()) {
            return tail.pop();
        }

        while (!capacity.isEmpty()) {
            Integer head = capacity.pop();
            tail.push(head);
        }
        return tail.pop();
    }

    /**
     * 返回队列开头的元素
     * @return
     */
    public int peek() {
        if (!tail.isEmpty()) {
            return tail.peek();
        }
        while (!capacity.isEmpty()) {
            Integer head = capacity.pop();
            tail.push(head);
        }
        return tail.peek();
    }

    /**
     * 队列内元素是否为空
     * @return
     */
    public boolean empty() {
        return tail.isEmpty() && capacity.isEmpty();
    }
}