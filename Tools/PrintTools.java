package Tools;

/**
 * Created by WenXun on 2017/12/14.
 * my print tools
 */
public class PrintTools {
    public void print(Object obj){
        System.out.println(obj);
    }

    public void printArr(int[] countTable){
        System.out.print("[");
        for (int i = 0; i < countTable.length-1 ; i++) {
            System.out.print(countTable[i]+",");
        }
        System.out.print(countTable[countTable.length - 1]);
        System.out.println("]");
    }
}
