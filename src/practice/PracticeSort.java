package practice;

public class PracticeSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,4,1,2,6};
        //冒泡排序
//        new PracticeSort().bubbleSort(array);
        //插入排序
//        new PracticeSort().insertionSort(array);
        //选择排序
//        new PracticeSort().selectionSort(array);
        //归并排序
//        new PracticeSort().mergeSort(array,0,array.length-1);
        //快速排序
        new PracticeSort().quickSort(array,0,array.length - 1);
        for(int a : array) {
            System.out.print(a + "");
        }
    }


    //冒泡排序,基于比较的排序算法，是原地排序，稳定排序,(前后相同的元素顺序不会变)，最好情况是O(n),最坏是O(n2),相邻两个元素之间比较，
    public void bubbleSort(int[] array) {
        if(array.length <= 1) return;
        for(int i=0; i<array.length; i++) {
            boolean flag = false;
            for(int j=0; j<array.length - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    //插入排序，分为有序区间和无序区间，每次排序从无序区间取一个数，在遍历有序区间，在有序区间找到合适的位置插入。默认第一个元素是有序空间
    //插入排序是稳定排序，原地排序，最好最坏都和冒泡排序一样
    public void insertionSort(int[] array) {
        if(array.length <= 1) return;
        for(int i=1; i<array.length; i++) {
            int value = array[i];//从无序空间拿出一个数
            int j = i-1;
            for(;j >=0; j--) {
                if(array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }
    }


    //选择排序。选择排序也分为有序空间，无序空间。不过每次取的话是从无序空间取最小的，然后和有序空间的比较。选择一个最小的值和有序空间的元素比较
    public void selectionSort(int[] array) {
        if(array.length <= 1) return;
        for(int i=0; i<array.length; i++) {
            int min = i;
            for(int j = i+1; j<array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

        }
    }


    //归并排序Merge = merge(a.....p) + merge(p....r) O(nlogn)。不是原地排序，
    public void mergeSort(int[] array,int p,int r) {
        if(p >= r) return;
        int q = (p + r) / 2;
        mergeSort(array,p,q);
        mergeSort(array,q+1,r);
        //合并函数
        merge(array,p,r,q);
    }

    public void merge(int[] array,int p,int r,int q) {
        int k = 0;
        int[] temp = new int[r - p + 1];//temp的长度
        int i = p;
        int j = q+1;
        while (i <= q && j <= r) {
            //两个指针同时移动
            if(array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        int start = i;
        int end = q;
        if(j <= r) {
            start = j;
            end = r;
        }
        while(start <= end) {
            temp[k++] = array[start++];
        }
        //将temp拷贝到array
        for(int a=0; a<temp.length; a++) {
            array[p+a] = temp[a];
        }

    }




    //快排。快排的平均也是O(nlogn).但是快排的应用比归并好。因为快排可以设计成原地排序的。不用额外的空间。就算最坏的O(n2).
    //也有技巧去处理
    public void quickSort(int[] array,int p,int r) {
        if(p >= r) return;
        int pivot = partition(array,p,r);//分区点
        quickSort(array,p,pivot-1);
        quickSort(array,pivot+1,r);
    }

    public int partition(int[] arr,int p,int r) {
        int pivot = arr[r];
        int i = p;
        int j = p;
        for(;j<=r-1;j++) {
            if(arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i = i + 1;
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }
}
