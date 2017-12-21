/**
 * Created by WenXun on 2017/12/15.
 * leetcode problems palindrome number judgement
 */
import Tools.PrintTools;
public class palindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        PrintTools pr = new PrintTools();
        if (x < 0 || (x != 0 && x % 10==0)) return false;

        int resVal = 0; //��¼������һ��
        while (x > resVal){
            resVal = resVal * 10 + x % 10;
            x /= 10;
        }
        return  x == resVal || x == resVal / 10;
    }

    // ��һ�ֽⷨ �ٶȸ���
    public boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        int h=1;
        // �������ȷ���������λ�ĳ߶�
        while(x/h>=10)
            h = h * 10;

        while(x>0)
        {
            //������Ƚ����λ�����λ
            if(x/h!=x%10){
                return false;
            }
            //����һ�������޳�
            x=x%h;
            //�����һ�������޳�
            x=x/10;
            //�����Ϊ�ĳ߶����Ųһλ
            h=h/100;
        }
        return true;
    }

    public static void main(String[] args){
        boolean flag = isPalindrome(121);
        System.out.println(flag);
    }
}
