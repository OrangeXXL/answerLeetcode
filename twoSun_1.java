import java.util.HashMap;
import java.util.Map;

/**
 * Created by WenXun on 2017/12/21.
 * The first leetcode problems add two sum from array
 */
/**
 * n的时间复杂度。用target - num[i] 循环i，这样再一趟循环之内就能找到值。
 * 对于不符合条件的便循环就边将其值连同index插入map，找到之后返回当前index
 * 和target-index的值对应的index
 * */
public class twoSun_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int val = nums[i];
            if (map.containsKey(target-val))
                return new int[] {map.get(target-val), i};
            map.put(val, i);
        }
        throw new IllegalArgumentException("not two param");
    }
}
