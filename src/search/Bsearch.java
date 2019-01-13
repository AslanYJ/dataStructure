package search;

/**
 * 二分查找。二分查找使用策略。1、数据量合适。2.有序数组。3.适合在插入，删除操作不频繁的场景
 */
public class Bsearch {

    public static void main(String[] args) {
//        int[] a = new int[] {1,2,3,4,5};
//        int value = 5;
//        System.out.println(new Bsearch().bsearch(a,value,a.length));
        int[] a = new int[] {1,3,4,5,6,8,8,8,11,18};
        int value = 5;
        System.out.println(new Bsearch().bsearch4(a,value,a.length));
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

    /**
     * 查找第一个值等于给定的值
     * @param a 有序数组
     * @param value 要查找的值
     * @param n 数组的长度
     * @return 数组中第一个与给定的值相等的下标
     */
    public int beserch1(int[] a,int value,int n) {
        int low = 0;
        int high = n - 1;//数组最后的下标
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] < value) {
                low = mid + 1;
            } else if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] == value) {
                if(mid ==0 || a[mid - 1] != value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定的值
     * @param a 有序数组
     * @param value 要查找的值
     * @param n 数组的长度
     * @return 数组中第一个与给定的值相等的下标
     */
    public int bsearch2(int[] a, int value ,int n) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] < value) {
                low = mid + 1;
            } else if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] == value) {
                if(mid == n - 1 || a[mid+1] != value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于或者等于给定的值
     * @param a 有序数组
     * @param value 要查找的值
     * @param n 数组的长度
     * @return 数组中第一个大于或者等于给定的值的下标
     */
    public int bsearch3(int[] a,int value,int n) {
        //两种情况，小于，或者大于等于
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value) {
                if(mid ==0 || a[mid - 1] < value) return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于或者等于给定的值
     * @param a 有序数组
     * @param value 要查找的值
     * @param n 数组的长度
     * @return 数组中最后一个小于或者等于给定的值的下标
     */
    public int bsearch4(int[] a,int value,int n) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] <= value) {
                if(mid == n-1 || a[mid + 1] > value) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
