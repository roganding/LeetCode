package leetcode287;

import unit.Assert;

public class TestMain {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        Assert.assertEquals(9, s.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
        // 2-9-1-5-3-6-8-7-9-1-5-3-6-8-7-9
        // 2,9
        // 9,5
        // 1,6
        // 5,7
        // 3,1
        // 6,3
        // 8,8
        // 从0，8 开始
        // 2, 7
        // 9, 9
        Assert.assertEquals(2, s.findDuplicate(new int[]{2, 2, 1}));

        Assert.assertEquals(2, s.findDuplicate(new int[]{1, 3, 4, 2, 2}));

        Assert.assertEquals(3, s.findDuplicate(new int[]{3, 1, 3, 4, 2}));

        Assert.assertEquals(3, s.findDuplicate(new int[]{3, 3, 3, 2, 3}));

    }
}