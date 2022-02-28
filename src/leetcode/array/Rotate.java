package leetcode.array;

/**
 * @author yjlan
 * @version V1.0
 * @Description leetCode：旋转数组
 * @date 2022.02.28 09:09
 */
public class Rotate {
    
    /**
     * 可以使用一个临时数组，先把原数组的值存放到一个临时数组中，
     * 然后再把临时数组的值重新赋给原数组，重新赋值的时候要保证每个元素都要往后移k位，
     * 如果超过数组的长度就从头开始，所以这里可以使用(i + k) % length来计算重新赋值的元素下标
     *
     * @param nums 数组
     * @param k 旋转多少个位置
     */
    public void rotate2(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }
    
    /**
     * 简单的解法，直接截取K的位置
     * @param nums 数组
     * @param k 要旋转的数组。注意有可能k >= nums
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int[] temp = new int[nums.length];
        int index = nums.length - k;
        int preIndex = index;
        // 从源数组中截取对应的k长度数据，拼接到temps中
        int i = 0;
        for(;index < nums.length;index++) {
            temp[i++] = nums[index];
        }
        for(int j = 0; j < preIndex;j++) {
            temp[i++] = nums[j];
        }
        for(int f = 0; f < nums.length; f++) {
            nums[f] = temp[f];
        }
    }
}
