package leetcode.array;

import java.util.HashMap;

/**
 * @author yjlan
 * @version V1.0
 * @Description 两者之和
 * @date 2022.03.07 09:34
 */
public class TwoNum {
    
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>(2);
        // key：对应的数值，value：对应的下标
        for (int i = 0; i < nums.length; i++){
            if (hashMap.get(target - nums[i]) != null) {
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
