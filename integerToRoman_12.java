/**
 * Created by WenXun on 2017/12/21.
 * leetcode problems integer to roman numbers
 */
public class integerToRoman_12 {
    public String intToRoman(int num) {
        String[] thousandArr = {"", "M", "MM","MMM"};
        String[] hundredArr = {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tenArr = {"", "X", "XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] oneArr = {"", "I","II","III","IV","V","VI","VII","VIII","IX"};
        String[][] conver = {oneArr, tenArr, hundredArr, thousandArr};
        String ret = "";
        int index = 0;
        while(num > 0){
            ret = conver[index][num % 10] + ret;
            num /= 10;
            index++;
        }
        return ret;
    }
}
