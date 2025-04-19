package leetcode438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到字符串中所有的字母异位词
 *
 * @author rogan
 * @date 2025/4/19 14:47
 */
public class Solution1 {


    // 用pKey 识别异位词
    // 26个字母，每个位置各有几个
    // 0 位置是P 所有字母char 相加之和
    private int[] pKey = new int[27];

    /**
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> results = new ArrayList<>();

        int subLength = p.length();
        pKey = convertKey(p);


        int[] iKey = new int[27];

        char[] array = s.toCharArray();
        for (int i = 0; i + subLength - 1 < array.length; i++) {
            // 计算 [i,j]
            if (i == 0) {
                iKey = convertKey(s.substring(0, subLength));
            } else {

                // 删除前一个，加后一个
                char prevChar = array[i-1];
                char newLastChar = array[i + subLength - 1];
                iKey[prevChar - 'a' + 1]--;
                iKey[newLastChar - 'a' + 1]++;
                iKey[0] = iKey[0] - prevChar + newLastChar;
            }

            if (iKey[0] == pKey[0] && isEqual(iKey, pKey)) {
                results.add(i);
            }
        }
        return results;
    }

    private static int[] convertKey(String str) {
        int[] key = new int[27];

        int sum = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int idx = array[i] - 'a' + 1;
            key[idx]++;

            sum += array[i];
        }
        key[0] = sum;
        return key;
    }

    private static boolean isEqual(int[] k1, int[] k2) {
        for (int i = 0; i < k1.length; i++) {
            if (k1[i] != k2[i]) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Solution1 s = new Solution1();
        {
            List<Integer> list = s.findAnagrams("cbaebabacd", "abc");
            System.out.println(list);
        }

    }
}