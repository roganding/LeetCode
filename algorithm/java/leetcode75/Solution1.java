package leetcode75;

public class Solution1 {

    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        for(int i =0; i < nums.length; i++) {
            int val = nums[i];
            if (val == 0) {
                redCount++;
            } else if (val == 1) {
                whiteCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < redCount) {
                nums[i] = 0;
            } else if (i < redCount + whiteCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        {
            int[] arr = {2, 0, 2, 1, 1, 0};
            solution.sortColors(arr);
            System.out.println(arr[0] == 0);
        }
    }
}