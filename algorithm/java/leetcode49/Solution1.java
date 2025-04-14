package leetcode49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字母异位词
 * @author rogan
 * @date 2025/4/1
 */
public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 计算每个str的 唯一值，无非是统计m个字母出现了n次。
        // 例如 aeet， a出现1次，e出现2次，t出现1次。
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = compute(str);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        // map values就是结果
        return new ArrayList<>(map.values());
    }

    private static String compute(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char c = array[i];
            charCount.merge(c, 1, (old, val) -> old.intValue() + val);
        }

        List<Character> sortedChar = charCount.keySet().stream()
                .sorted(Character::compareTo)
                .collect(Collectors.toList());


        StringBuilder builder = new StringBuilder();
        for (char c : sortedChar) {
            builder.append(c).append(charCount.get(c));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        {
            String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> lists = solution.groupAnagrams(arr);
            System.out.println(lists);
        }
    }
}