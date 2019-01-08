package sort;

import java.util.Random;

/**
 * 功能描述: 
 * 冒泡排序
 * @Author: lanyangjia
 * @Date: 2019/1/8 11:14
 * 
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        long currentTime = System.currentTimeMillis();
        for(int i=0; i<1000;i++) {
            int[] a = new int[200];
            for(int j=0;j<a.length; j++) {
                int number = new Random().nextInt(100);
                a[j] = number;
            }
            new BubbleSort().bubbleSort(a);
        }
        System.out.println(System.currentTimeMillis() - currentTime);
        for(int a : array) {
            System.out.print(a + "");
        }
    }
    public void bubbleSort(int[] array) {
        if(array.length == 0) return;
        for(int i=0; i<array.length; i++) {
            boolean flag = false;//判断是否已经有序了。有序就不用排了
            for(int j=0; j<array.length - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    //这里会发生比较和交换。冒泡排序是基于比较的排序算法
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
           if(!flag)  {
                break;
           }
        }
    }
}
