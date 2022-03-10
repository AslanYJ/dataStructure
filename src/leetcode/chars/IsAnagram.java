package leetcode.chars;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yjlan
 * @version V1.0
 * @Description 字母异位词
 * @date 2022.03.10 09:43
 */
public class IsAnagram {
    
    
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean isAnagramResult = isAnagram.isAnagram("ab","bac");
        System.out.println(isAnagramResult);
    }
    
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letterCount = new int[26];
        //统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++)
            letterCount[s.charAt(i) - 'a']++;
        //减去字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++)
            letterCount[t.charAt(i) - 'a']--;
        //如果数组letterCount的每个值都是0，返回true，否则返回false
        for (int count : letterCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
  
}
