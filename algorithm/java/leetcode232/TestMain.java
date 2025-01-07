package leetcode232;

import unit.Assert;

public class TestMain {

    public static void main(String[] args) {
        MyQueue1 queue = new MyQueue1();

        queue.push(1);
        Assert.assertEquals(1, queue.peek());

        queue.push(2);

        Assert.assertEquals(1, queue.pop());
        Assert.assertEquals(2, queue.pop());

        Assert.assertEquals(true, queue.empty());

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        Assert.assertEquals(1, queue.peek());

        Assert.assertEquals(1, queue.pop());
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.peek());

    }
}