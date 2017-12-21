/**
 * Created by WenXun on 2017/12/14.
 * 5 Longest Palindromic Substring
 */
import Tools.*;

import java.util.*;


public class longestPalindromicSubstring_5 {
    /*public static String longestPalindrome(String s) {
        PrintTools p = new PrintTools();
        char[] charArray = s.toCharArray();

        if (charArray.length == 0) return "";
        if (charArray.length == 1) return s;

        //if (charArray.length == 2 && (charArray[0] == charArray[charArray.length - 1])) return s;
        List<Character> arrList = new ArrayList<Character>();
        for (char ch : charArray){
            arrList.add(ch);
        }


        int end = arrList.size()-1;
        Map<Integer, String> retMap = new HashMap<Integer,String>();
        for (int start = 0; start < arrList.size(); start++){
            int headFlag = start;

            while (end > 0 && (headFlag < arrList.size())){
                int index = headFlag;
                int tailIndex = end;
                if(arrList.get(headFlag) == arrList.get(tailIndex) ){

                    StringBuffer str = new StringBuffer();
                    while(arrList.get(headFlag) == arrList.get(tailIndex)){
                        str.append(arrList.get(headFlag));
                        if (tailIndex <= 0 || headFlag >= (arrList.size() - start)) {
                            break;
                        }
                        tailIndex--;
                        headFlag++;
                    }
                    String subStr = str.toString();
                    retMap.put(headFlag - index, subStr);
                    p.print("Exits same!");
                }else{
                    end--;
                }

                end = tailIndex;
            }

            end = arrList.size() - 1;
        }
        Set keySet = retMap.keySet();
        int key = (int)Collections.max(keySet);
        //p.print(retMap);
        return retMap.get(key);
    }*/

    public static String longestPalindrome(String s) {
        int end = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = judgeIfPali(s, i, i);
            int len2 = judgeIfPali(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i+ len / 2;
            }
        }
        return s.substring(start, end);
    }

    public static int judgeIfPali(String s, int left, int right){
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args){
        PrintTools p = new PrintTools();
        String retStr = longestPalindrome("ccc");
        p.print("main print = "+retStr);

    }
}
