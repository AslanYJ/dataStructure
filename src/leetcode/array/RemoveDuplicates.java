package leetcode.array;

/**
 * @author yjlan
 * @version V1.0
 * @Description 删除重复的元素
 * @date 2022.02.28 09:15
 */
public class RemoveDuplicates {
    
    
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int index = 1;
        int count = 1;
        // 其实就是比较交换，分为两个部分，一个是没有重复数据的，一个是有重复数据的。
        for (int i = 1; i < nums.length; i++) {
            // 首个数据是不用做保证的，但是不能保证第二个数据和第一个数据的是否相同。
            // 如果不同话，那么第二个数据
            if (nums[index - 1] == nums[i]) {
                continue;
            }
            nums[index] = nums[i];
            index++;
            count++;
        }
        return count;
    }
}
