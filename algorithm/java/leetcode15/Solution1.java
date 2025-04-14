package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 三数之和
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * @author rogan
 * @date 2025/4/13 9:53
 */
public class Solution1 {


    /**
     * 难点在于怎么不重复。
     *
     * 只有一个办法：排序 + 双指针
     *
     * 从第一个数遍历，第二个数和第三数相加是否满足条件；第二个和第四个，一直到第5个和第二个满足要求，第三个和第六个也可能满足要求
     * 从第二个遍历，
     * 。。。
     * 从第5个遍历，
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();


        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());


        for (int i = 0; i < list.size(); i++) {
            int first = list.get(i);
            // 排序后，如果最小的数是正数，那么不可能存在和为0的三个数
            if (first > 0) {
                break;
            }

            // 结果去重。如果前一个数和当前一样，那么前一个已经计算过了
            if (i > 0 && list.get(i - 1) == first) {
                continue;
            }

            int secondIdx = i + 1;
            int thirdIdx = list.size() - 1;
            while (secondIdx < thirdIdx) {
                int second = list.get(secondIdx);
                int third = list.get(thirdIdx);
                int sum = first + second + third;
                if (sum == 0) {
                    combinations.add(Arrays.asList(first, second, third));

                    // 因为可能有重复数字，所以解可能重复。题目要求去除重复的解
                    while (secondIdx < thirdIdx && second == list.get(secondIdx+1)) {
                        secondIdx++;
                    }

                    // 还得再移一位，才是不重复的解
                    secondIdx++;
                    thirdIdx--;
                    continue;
                }

                // 和小于0，说明 second 数太小，需要大一点
                if (sum < 0) {
                    secondIdx++;
                } else {
                    // sum > 0
                    thirdIdx--;
                }

            }
        }

        return combinations;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
        //

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // 2个结果
    }
}