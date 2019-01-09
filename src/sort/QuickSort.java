package sort;

/**
 * 快速排序
 */
public class QuickSort {
    //快速排序也是分而治之的思想，先选一个pivot.一个点。然后比这个数小的都放在数的左边，比这个数打的都放在数的右边

    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        new QuickSort().quickSort(array,0,array.length-1);
        for(int a : array) {
            System.out.print(a + "");
        }
    }
    /**
     *
     * @param array
     * @param p 数组下标的开始
     * @param r 数组下标的结束
     */
    public void quickSort(int[] array,int p,int r) {
        if(p >= r) return;
        int pivot = partition(array,p,r);//获取分区点
        quickSort(array,p,pivot-1);
        quickSort(array,pivot+1,r);

    }

    public int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        int j = p;
        for(;j<= r-1;j++) {
            //这个阶段就是将小的放在pivot的左边
            if(array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i = i + 1;
            }
        }
        int temp = array[r];
        array[r] = array[i];
        array[i] = temp;
        return i;
    }
}
