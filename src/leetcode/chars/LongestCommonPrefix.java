package leetcode.chars;

/**
 * @author yjlan
 * @version V1.0
 * @Description 最长前缀
 * @date 2022.03.21 19:39
 */
public class LongestCommonPrefix {
    
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 ) {
            return "";
        }
        String pre = strs[0];
        int i =1;
        // 不断的截取
        while (i < strs.length) {
            // 这里其实就是不断做裁剪,不断的将之前的公共前缀不断进行比较
            // 最终获得一个最长的
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0,pre.length() - 1);
            }
            i++;
        }
        
        
        
        return pre;
    }
}
