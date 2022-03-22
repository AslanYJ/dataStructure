package leetcode.chars;

/**
 * @author yjlan
 * @version V1.0
 * @Description 外观数据列
 * @date 2022.03.22 17:18
 */
public class CountAndSay {
    
    
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        //  假设拿到了这一层的数据
        String str = countAndSay(n - 1);
        // 这一层要做的事情
        StringBuilder stringBuilder = new StringBuilder();
        // 计算每一个字符出现的次数，如果遇到不符合的，直接拿到下一个
        char pre = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == pre) {
                count++;
            } else {
                // 不符合记录一下次数
                stringBuilder.append(count);
                stringBuilder.append(pre);
                count = 1;
                pre = str.charAt(i);
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(pre);
        return stringBuilder.toString();
    }
}
