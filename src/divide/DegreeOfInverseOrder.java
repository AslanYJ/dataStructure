package divide;

/**
 * 利用分治思想求逆序度
 *
 * @author lanyangjia
 * @date 2019/6/20
 */
public class DegreeOfInverseOrder {
    private int num = 0;

    public static void main(String[] args) {
        int[] a = new int[]{2,4,3,1,5,6};
        int result = new DegreeOfInverseOrder().count(a,a.length);
        System.out.println(result);
    }

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a,0,n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                // 统计 p-q之间，比a[j]大的个数
                num += (q - i + 1);
                temp[k++] = a[j++];
            }
        }
        while (i <= q) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for(i=0; i <= r-p; i++) {
            a[p+i] = temp[i];
        }
        }
    }
