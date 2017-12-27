/**
 * Created by WenXun on 2017/12/27.
 * leetcode problems Roman number converse to integer
 */
public class romanToInteger_13 {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        char max = 'I';
        int result = 0;
        for (int i = chars.length-1; i>=0; i--){
            if (getVal(chars[i]) >= getVal(max)){
                max = chars[i];
                result += getVal(chars[i]);
            }else{
                result -= getVal(chars[i]);
            }
        }
        return result;
    }

    public int getVal(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
