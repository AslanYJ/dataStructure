package leetcode.chars;

/**
 * @author yjlan
 * @version V1.0
 * @Description 反转字符串
 * @date 2022.03.09 16:17
 */
public class ReverseString {
    
    
    public static void main(String[] args) {
        char[] s = "test".toCharArray();
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
        System.out.println(new String(s));
        
    }
    
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        // 前指针
        int left = 0;
        // 后指针
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
