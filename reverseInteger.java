/**
 * Created by WenXun on 2017/12/15.
 * leetcode problems 7 reverse integer
 */
public class reverseInteger {
    public static int reverse(int x) {
        int ret = 0;
        while (x != 0){
            int tail = x % 10;
            int revsInt = ret * 10 + tail;
             if ((revsInt - tail) / 10 != ret) return 0;
            ret = revsInt;
            x /= 10;
        }
        return ret;
    }

    public static void main(String[] args){
        int val = reverse(23);
        System.out.print(val);
    }
}
