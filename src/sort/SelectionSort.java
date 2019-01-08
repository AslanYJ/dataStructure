package sort;


import java.util.Random;


/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        long currentTime = System.currentTimeMillis();
        for(int i=0; i<1000;i++) {
            int[] a = new int[200];
            for(int j=0;j<a.length; j++) {
                int number = new Random().nextInt(100);
                a[j] = number;
            }
            new SelectionSort().selectionSort(a);
        }
        System.out.println(System.currentTimeMillis() - currentTime);
        for(int a : array) {
            System.out.print(a + "");
        }
    }

    public void selectionSort(int[] array) {
        if(array.length == 0) return;
        for(int i = 0; i<array.length; i++) {
            //先从无序序列中找到最小的值
            int min = i;
            for(int j=i+1; j<array.length;j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            if(i != min) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }

    }
}
