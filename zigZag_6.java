/**
 * Created by WenXun on 2017/12/15.
 * leetcode problems 6 zigZag Conversion
 */
public class zigZag_6 {
    public static String convert(String s, int numRows) {

        if (s.length() == 0 || s.length() <= numRows -1) return s;
        StringBuffer buffer = new StringBuffer();
        int distance = 2 * numRows - 2;

        //外层循环行数，表示第i行
        for (int i = 0; i < numRows; i++) {
            //内层循环一个“之”字
            for (int j = i; j < s.length(); j += distance) {
                buffer.append(s.charAt(j));
                /**
                 *  zig中间行有如下性质：
                 *      1.每一行有两个元素
                 *      2.每行的两个元素之间的距离为 distance - 2 * i;
                 */
                if (i > 0 && i < numRows - 1){
                    int chIndex = j + distance - 2 * i;
                    if (chIndex < s.length())
                        buffer.append(s.charAt(chIndex));
                }
            }
        }
        return buffer.toString();
    }
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        String retVal = convert(s, 3);
        System.out.println(retVal);
    }
}
