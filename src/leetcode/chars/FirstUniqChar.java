package leetcode.chars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yjlan
 * @version V1.0
 * @Description 字符串中的第一个唯一字符
 * @date 2022.03.09 18:47
 */
public class FirstUniqChar {
    
    
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        // 首先肯定从0开始最小的，用一个map来记录
        // 否则设置为对应的下标
        char[] chars = s.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i],hashMap.getOrDefault(chars[i],0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
