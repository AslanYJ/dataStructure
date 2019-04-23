package practice;

import java.util.Arrays;

/**
 * 递归计算数组的结果
 */
public class Sum {


    public static void main(String[] args) {
        int[] a = new int[] {2,4,6,8};
        System.out.println(sum(a));
        System.out.println(count(a));
    }


    private static int sum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return arr[0];
        }
        return arr[0] + sum( Arrays.copyOfRange(arr,1,arr.length));
    }

    private static int count(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return 1;
        }
        return count(Arrays.copyOf(arr,1)) + count(Arrays.copyOfRange(arr,1,arr.length));
    }


}
