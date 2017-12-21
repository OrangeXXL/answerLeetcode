import java.util.HashMap;
import java.util.Map;

/**
 * Created by WenXun on 2017/12/21.
 * The first leetcode problems add two sum from array
 */
/**
 * n��ʱ�临�Ӷȡ���target - num[i] ѭ��i��������һ��ѭ��֮�ھ����ҵ�ֵ��
 * ���ڲ����������ı�ѭ���ͱ߽���ֵ��ͬindex����map���ҵ�֮�󷵻ص�ǰindex
 * ��target-index��ֵ��Ӧ��index
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
