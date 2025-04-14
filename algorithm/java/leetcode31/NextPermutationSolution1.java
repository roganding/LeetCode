package leetcode31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 2025-03-02
 * XTransfer 面试题
 *  举例：1 2 4 3 ——  1 3 2 4
 *  num[i] > num[0] 所以存在比原序列大的数，例如 2 1 4 3
 *  从第一位开始尝试纠正，是否修改取决于第一位在右边数组是不是最大的数：
 *  第一位是1， 右边数组[2, 4, 3] 不是降序，所以右边243不是最大的数，那么1 就不用动
 *  第二位是2， 右边数据 [4, 3] 是降序，已经是 [4,3]组合里最大的数。
 *
 *
 *  若要比当前序列大，必须修改第二位。
 *  那么怎么选择数字呢？应该从右边数组中选择刚刚比这一位大的数，在[4,3]里选择3。
 *  剩下的数字[2, 4] 只需要做升序排列即可（升序就是最小）。
 *
 *
 *  怎么判断是不是最大的数？ 排序下来发现从第一到最后都是降序
 *
 *
 *  4 4 4 3
 */
public class NextPermutationSolution1 {

    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;

        int prevMax = nums[len - 1];
        int changeStartPos = -1;

        // 从数组右端往左看，
        for (int i = len - 2; i >= 0; i--) {
            if ((prevMax = Math.max(nums[i], prevMax)) == nums[i]) {
                continue;
            }
            changeStartPos = i;
            break;
        }

        if (changeStartPos == -1) {
            // 已经是最大的数
            for (int i = 0; i < ( len/2 ); i++) {
                int tmp = nums[i];
                nums[i] = nums[len - 1 - i];
                nums[len - 1 - i] = tmp;
            }
            System.out.println();
            return;
        }

        
        // 找到右边刚刚大于changeStartPos位置元素的值。因为从右往左肯定是升序，所以找到第一个就行。
        int swapPos = changeStartPos;
        for (int i = len - 1; i > changeStartPos; i--) {
            if (nums[i] > nums[changeStartPos]) {
                swapPos = i;
                break;
            }
        }
        
        // swap
        int tmp = nums[swapPos];
        nums[swapPos] =  nums[changeStartPos];
        nums[changeStartPos] = tmp;


        // 剩下的排序
        List<Integer> list = new ArrayList<>();
        for (int i = changeStartPos + 1; i < len; i++) {
            list.add(nums[i]);
        }

        List<Integer> sorted = list.stream().sorted(Integer::compare).collect(Collectors.toList());
        for (int i = 0; i < sorted.size(); i++) {
            nums[changeStartPos + 1 + i] = sorted.get(i);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        NextPermutationSolution1 solution = new NextPermutationSolution1();
        {
            int[] arr = new int[] {1, 3, 5, 4, 2};
            solution.nextPermutation(arr);
            System.out.println(arr[0] == 1);
            System.out.println(arr[1] == 4);
            System.out.println(arr[2] == 2);
            System.out.println(arr[3] == 3);
            System.out.println(arr[4] == 5);
        }
        {
            // 已经是最大
            int[] arr = new int[] {3, 1};
            solution.nextPermutation(arr);
            System.out.println(arr[0] == 1);
            System.out.println(arr[1] == 3);
        }
        {
            int[] arr = new int[] {1, 3};
            solution.nextPermutation(arr);
            System.out.println(arr[0] == 3);
            System.out.println(arr[1] == 1);
        }
        {
            int[] arr = new int[] {5};
            solution.nextPermutation(arr);
            System.out.println(arr[0] == 5);
        }
    }
}