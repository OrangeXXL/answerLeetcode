/**
 * Created by WenXun on 2017/12/27.
 * leetcode problems get the longest prefix common substring
 */
public class longestCommonPrefix_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int min = strs[0].length();
        int end = 1;
        for (int i = 1; i < strs.length; i++) {
            min = Math.min(min,strs[i].length());
        }
        System.out.println("min = " + min);
        if (min == 0) return "";

        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            System.out.println("temp = " + temp);
            for (int j = 1; j < strs.length; j++) {
                System.out.println("temp = " + temp + " and strs[" + j + "].charAt(i) = " + strs[j].charAt(i) + " i = " + i);
                if (temp != strs[j].charAt(i)) {
                    System.out.println("will return temp = " + temp + " and strs[" + j + "].charAt(" + i + ") = " + strs[j].charAt(i));
                    end--;
                    return strs[j].substring(0, end);
                }
            }
            end = i+1;
            System.out.println("end = "+end);
        }
        return strs[0].substring(0,end);
    }

    public static void main(String[] args){
        String[] s = {"aa","ab"};
        String result = longestCommonPrefix(s);
        System.out.println("return answer = "+result);
    }
}
