package search;

/**
 * 二分查找。二分查找使用策略。1、数据量合适。2.有序数组。3.适合在插入，删除操作不频繁的场景
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        int value = 5;
        System.out.println(new Bsearch().bsearch(a,value,a.length));
    }

    /**
     * 二分查找
     * @param array 有序数组
     * @param num 要查找的数值
     * @param n 数组的长度
     * @return 数组中对应值的下标
     */
    public int bsearch(int[] array,int num,int n) {
        int low = 0;//数组初始下标
        int high = n - 1;//数组最后的下标
        while (low <= high) {//注意是<=
            int mid = low + ((high-low)>>1);
            if(array[mid] == num) {
                return mid;
            } else if(array[mid] < num) {
                low = mid + 1;//如果mid的值比value小，证明在右边
            } else if(array[mid] > num) {
                high = mid - 1;//如果mid的值比value小，证明在左边
            }
        }
        return -1;
    }
}
