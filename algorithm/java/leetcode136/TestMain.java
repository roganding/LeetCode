package leetcode136;

import unit.Assert;

public class TestMain {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        Assert.assertEquals(1, s.singleNumber(new int[]{2, 2, 1}));
        Assert.assertEquals(1, s.singleNumber(new int[]{1, 2, 4, 4, 2, 1, 1}));
        Assert.assertEquals(0, s.singleNumber(new int[]{0, 100, 100, 100, 100, 999, 999}));
        Assert.assertEquals(-1, s.singleNumber(new int[]{2, 1, 2, 1, 4, 6, 6, 4, -1}));

    }
}