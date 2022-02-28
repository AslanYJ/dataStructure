package leetcode.array;

import java.util.HashMap;

/**
 * @author yjlan
 * @version V1.0
 * @Description 存在重复的元素
 * @date 2022.02.28 09:17
 */
public class ContainsDuplicate {
    
    
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            Integer value = hashMap.get(nums[i]);
            if(value == null) {
                hashMap.put(nums[i],1);
            } else {
                return true;
            }
        }
        return false;
    }
}
