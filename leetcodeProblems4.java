/**
 * Created by WenXun on 2017/12/14.
 * 4. Median of Two Sorted Arrays
 */
public class leetcodeProblems4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 && n == 0) return 0;

        if (m == 0) return retArrayMid(nums2);
        if (n == 0) return retArrayMid(nums1);

        int[] addArr = new int[m + n];
        int i = 0;
        while (i < addArr.length) {
            int len1 = 0, len2 = 0;
            while (len1 < m && len2 < n){
                if (nums1[len1] <= nums2[len2]){
                    addArr[i] = nums1[len1];
                    print("num1 <= num2 addArr["+i+"] = "+addArr[i]+" nums1["+len1+"] = "+nums1[len1]);
                    len1++; i++;
                }else{
                    addArr[i] = nums2[len2];
                    print("num1 > num2 addArr["+i+"] = "+addArr[i]+" nums2["+len2+"] = "+nums2[len2]);
                    len2++; i++;
                }
            }
            int p = m-len1;
            int q = n-len2;
            if (p > q){
                while (len1 < m) {
                    addArr[i] = nums1[len1];
                    len1++; i++;
                }
            }else{
                while (len2 < n){
                    addArr[i] = nums2[len2];
                    len2++; i++;
                }
            }
            /*if(m == n){
                addArr[i] = nums1[nums1.length - 1] > nums2[nums2.length - 1] ? nums1[nums1.length - 1] : nums2[nums2.length - 1];
                printArr(addArr);
                i++;
            }

            if (m > n){
                while (len1 < m) {
                    addArr[i] = nums1[len1];
                    len1++; i++;
                }
            }else{
                while (len2 < n){
                    addArr[i] = nums2[len2];
                    len2++; i++;
                }
            }*/
        }
        printArr(addArr);
        return retArrayMid(addArr);
    }

    public static double retArrayMid(int[] arr){
        int index;
        double mid;
        if (arr.length % 2 == 0){
            index = (arr.length - 1) / 2;
            mid = (arr[index]+arr[index+1]) / 2.0;
        } else {
            index = arr.length / 2;
            mid = arr[index];
        }
        return mid;
    }

    public static void print(Object obj){
        System.out.println(obj);
    }

    public static void printArr(int[] countTable){
        System.out.print("[");
        for (int i = 0; i < countTable.length-1 ; i++) {
            System.out.print(countTable[i]+",");
        }
        System.out.print(countTable[countTable.length - 1]);
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] testArr1 = {1,3,4,7,8,9};
        int[] testArr2 = {2,5,6,10};
        double mid = findMedianSortedArrays(testArr1,testArr2);
        print(mid);
    }
}
