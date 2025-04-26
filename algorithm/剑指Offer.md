### Page39 数组中重复的数字
> 在长度为n的数组里所有的数字在 0 ~ n-1 范围内。数组中某些数字是重复的，但不知道有几个数字重复了。
> 也不知道每个数字重复了几次。  
> 请找出数组中任意一个重复的数字。

输入：{2,3,1,0,2,5,3} 输出：2或3

数组范围也很关键，0~n-1，可以用数组下标标记法。

```java
public class Solution {
  /** hash表存储再查询 */
  public int findRepeat(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for(int i = 0; i < nums.length; i++) {
      Integer count = map.get(nums[i]);
      if (count == null) {
          map.put(nums[i], 1);
      } else {
          return nums[i];
      }
    }
    return -1;
  }
}
```