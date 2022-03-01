package leetcode.array;

/**
 * @author yjlan
 * @version V1.0
 * @Description +1
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * @date 2022.03.01 10:49
 */
public class AddOne {
    
    
    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,1};
        AddOne addOne = new AddOne();
        int[] newArray = addOne.plusOne(array);
        for (int i : newArray) {
            System.out.println(i);
        }
    }
    
    public int[] plusOne(int[] digits) {
        // 是否有进位
        int len = digits.length;
        for(int i = len - 1;i >= 0; i--) {
            // 最后一位不是9的话，那么直接返回
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // 如果数组中全部都是9的话，那么第一位肯定是1
        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }
    
}
