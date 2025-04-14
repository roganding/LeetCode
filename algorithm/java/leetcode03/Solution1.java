package leetcode03;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长的无重复子数组
 *
 * 滑动窗口
 *
 * @author rogan
 * @date 2025/4/14 17:49
 */
public class Solution1 {

    /**
     * 思路：左指针，右指针
     * 左指针不动，右指针移动一次，先判断新元素是否在set里，再添加新元素
     * 如果不在，说明没有重复，右指针继续右移；如果有，那么元素出现重复，需要左指针右移，
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s ==null || s.isEmpty()) {
            return 0;
        }
        int longest = 0;

        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = i; i < array.length && j < array.length; i++) {

            while (!set.contains(array[j])) {
                set.add(array[j]);
                j++;
                if (j >= array.length) {
                    break;
                }
            }
            // 此时 j 出现重复元素

            longest = Math.max(longest, j - i);

            set.remove(array[i]);
        }
        return longest;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdef"));
        // 3

        System.out.println(lengthOfLongestSubstring("pwwkew"));
        // 3

        System.out.println(lengthOfLongestSubstring("bbbbb"));
        // 1

    }
}