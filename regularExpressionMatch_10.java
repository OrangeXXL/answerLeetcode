/**
 * Created by WenXun on 2017/12/15.
 * leetcode problem 10 Regular Expression Match
 *
 */
public class regularExpressionMatch_10 {
    public static boolean isMatch(String s, String p){
        char [] strArr = s.toCharArray();
        char [] strPartArr = p.toCharArray();

        if (strArr.length < strPartArr.length) return false;

        for (int i = 0; i < strArr.length; i++) {
            System.out.println("1---------strPartArr[" + i + "] = " + strPartArr[i]);
            if (strPartArr.length == i) return false;
            if (strArr[i] != strPartArr[i]){
                if (".".equals(String.valueOf(strPartArr[i])))
                    continue;
                if("*".equals(String.valueOf(strPartArr[i]))) {

                } else {

                }
            }
        }
        return true;
    }

    public static  void main(String[] args){
        boolean flag = isMatch("aab","c*a*b");
        System.out.println(flag);
    }
}
