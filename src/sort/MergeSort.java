package sort;

import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {
    //归并排序主要是分治思想。将一个数组拆分两半，然后再合并.
    //利用递归
    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        long currentTime = System.currentTimeMillis();
        for(int i=0; i<1000;i++) {
            int[] a = new int[200];
            for(int j=0;j<a.length; j++) {
                int number = new Random().nextInt(100);
                a[j] = number;
            }
            new MergeSort().mergeSort(a);
        }
        System.out.println(System.currentTimeMillis() - currentTime);
        for(int a : array) {
            System.out.print(a + "");
        }
    }
    public void mergeSort(int[] array) {
        if(array.length <= 1) return;
        mergeSortC(array,0,array.length - 1);
    }

    public void mergeSortC(int[] array,int p,int r) {
        if(p >= r) return;
        int q = (p + r) / 2;
        mergeSortC(array,p,q);
        mergeSortC(array,q+1,r);
        //将两个子数组合并
        merge(array,p,q,r);

    }

    public void merge(int[] array,int p,int q,int r) {
        int i = p,j = q + 1,k = 0;
        int[] temp = new int[r - p + 1];
        while(i <= q && j <= r) {
            if(array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        //将剩下的补上
        int start = i,end = q;
        if(j <= r) {
            //小于r证明还有剩余
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = array[start++];
        }
        //将temp拷贝到array
        for(int a=0; a<temp.length; a++) {
            array[p+a] = temp[a];
        }

    }


}
