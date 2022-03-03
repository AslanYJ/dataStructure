package leetcode.array;

/**
 * @author yjlan
 * @version V1.0
 * @Description 移动0
 * 连接地址
 *https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * @date 2022.03.03 15:18
 */
public class MoveZero {
    
    public static void main(String[] args) {
    
    }
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        // 分为已移动和为移动区域
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
