import java.lang.Character;
import java.lang.Integer;
import java.lang.Object;
import java.lang.System;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class longestSubString_3{

    public static int lengthOfLongestSubstring(String s){
        char[] chArray = s.toCharArray();
        if (chArray.length == 0) return 0;

        List<Character> charList = null;
        List<Integer> countList = new ArrayList<Integer>();

        for (int i = 0; i < chArray.length; i++) {
            charList = new ArrayList<Character>();
            charList.add(chArray[i]);
            for (int j = i+1; j < chArray.length; j++) {
                if (!charList.contains(chArray[j])){
                    charList.add(chArray[j]);
                }else break;
            }
            int retlen = charList.size();
            countList.add(retlen);
        }

        int max = Collections.max(countList);
        return max;
    }

    // 高效解法。
    public static int lengthOfLongestSubstring2(String s){
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int [] countTable = new int[256];
        Arrays.fill(countTable, -1);

        int max = 1;
        int start = 0;
        int end = 1;

        countTable[s.charAt(0)] = 0;
        while (end < length) {
            if (countTable[s.charAt(end)] >= start) {
                start = countTable[s.charAt(end)] + 1;
            }
            max = Math.max(max, end - start + 1);
            print(max);
            countTable[s.charAt(end)] = end;
            end++;
        }
        return max;
    }
    public static void printArr(int[] countTable){
        System.out.print("[");
        for (int i = 0; i < countTable.length-1 ; i++) {
            System.out.print(countTable[i]+",");
        }
        print(countTable[countTable.length-1]);
        System.out.println("]");
    }
    public static void print(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
        int value = lengthOfLongestSubstring2("abcabcbb");
        print(value);
    }
}
