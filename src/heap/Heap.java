package heap;

public class Heap {
    private int count;//堆中已经存储的数据；
    private int n;//堆中可以存储的最大元素
    private int[] a;//存储堆的数组，下标从1开始

    public Heap(int capacity) {
        a = new int[capacity + 1];//因为下标是从0开始的，所以这里要再+1 不然容量不对
        n = capacity;
        count = 0;
    }

    
    
    /**
     * 功能描述: 
     * 堆，插入
     * @author: lanyangjia
     * @date: 2019/1/27 
     * @param value  要插入的值
     * @return:
     **/
    public void insert(int value) {
        if(count >= n) return;//堆满
        ++count;
        a[count] = value;
        int i = count;
        while (i / 2 != 0) {
            //从下往上开始比较
            if(a[i] > a[i/2]) {
                //交换
                swap(a,i,i/2);
            }
            i = i / 2;
        }
    }


    /**
     * 功能描述: 
     * 移除最大元素
     * @author: lanyangjia
     * @date: 2019/1/27
     * */
    public void removeMax() {
        if(count == 0) return;
        a[1] = a[count];//将堆顶的元素移除，将最后的元素放到堆顶
        --count;
        heapify(a,count,1);
    }


    /**
     * 功能描述: 
     * 自上而下堆化
     * @author: lanyangjia
     * @date: 2019/1/27 
     * @param   
     * @return: 
     **/
    private void heapify(int[] a, int n, int i) {

        while (true) {
            int maxPos = i;
            if(i * 2 <= n && a[i * 2] > a[i]) maxPos = i * 2;//比较左子树的大小
            if(i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) maxPos = i * 2 + 1;//比较右子树的大小
            if(maxPos == i) break;//如果发生交换的话，那么maxPos 和 i是肯定不等的，没发生交换的话 说明已经找到了最大值
            swap(a,i,maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int child, int parent) {
        int temp = a[parent];
        a[parent] = a[child];
        a[child] = temp;
    }


    public void buildHeap(int[] a , int n) {
        //n/2+1~n都是叶子结点
        for(int i = n / 2; i >= 1; i--) {
            heapify(a,n,i);
        }
    }


    //排序
    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public  void sort(int[] a, int n) {
        buildHeap(a, n);//堆化
        int k = n;//从最后一个开始和堆顶进行交换
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }




}
