import java.util.ArrayList;
import java.util.List;

/**
 * Created by WenXun on 2018/1/2.
 * leetcode problems 3 num sums in array S
 */
public class sum3_15 {
    public static List<List<Integer>> threeSum(int[] nums) {

    }

    public List<Integer> getResList(int a, int b, int c){
        List<Integer> ret = new ArrayList<Integer>();
        if (a + b + c == 0) {
            ret.add(a);
            ret.add(b);
            ret.add(c);
        }
        return ret;
    }
}
