package sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        new InsertionSort().insertionSort(array);
        for(int a : array) {
            System.out.print(a + "");
        }
    }

    public void insertionSort(int[] array) {
        if(array.length == 0) return;
        //这里取第一个元素作为有序区间的第一个元素，因此从i开始遍历
        for(int i=1; i<array.length; i++) {
            int value = array[i];//从无序区间拿一个元素
            int j = i-1;
            //在在有序区间中找到位置，然后移动
            for(;j >=0 ;j--) {
                if(array[j] > value) {
                    array[j+1] = array[j];  //找到比value大的，将元素往后移动
                } else {
                    break;
                }
            }
            array[j+1] = value;//插入数据
        }
    }
}
