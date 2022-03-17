package leetcode.chars;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断一个字符串是否为回文串
 * @author lanyangjia
 * @date 2019/6/3
 */
public class IsPalindrome {

    public static void main(String[] args) {
    }
    
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 需要过滤掉非字母和数字，只获取数字和字母
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}
