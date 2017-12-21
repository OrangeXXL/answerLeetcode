/**
 * Created by WenXun on 2017/12/15.
 * leetcode problems palindrome number judgement
 */
import Tools.PrintTools;
public class palindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        PrintTools pr = new PrintTools();
        if (x < 0 || (x != 0 && x % 10==0)) return false;

        int resVal = 0; //记录该数的一半
        while (x > resVal){
            resVal = resVal * 10 + x % 10;
            x /= 10;
        }
        return  x == resVal || x == resVal / 10;
    }

    // 另一种解法 速度更快
    public boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        int h=1;
        // 这里可以确定数字最高位的尺度
        while(x/h>=10)
            h = h * 10;

        while(x>0)
        {
            //在这里比较最高位和最低位
            if(x/h!=x%10){
                return false;
            }
            //将第一个数字剔除
            x=x%h;
            //将最后一个数字剔除
            x=x/10;
            //讲最高为的尺度向后挪一位
            h=h/100;
        }
        return true;
    }

    public static void main(String[] args){
        boolean flag = isPalindrome(121);
        System.out.println(flag);
    }
}
