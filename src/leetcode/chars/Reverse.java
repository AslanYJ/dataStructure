package leetcode.chars;

/**
 * @author yjlan
 * @version V1.0
 * @Description 整数反转
 * @date 2022.03.09 17:40
 */
public class Reverse {
    
    
    public int reverse(int x) {
        if (x==0||x==Integer.MIN_VALUE){
            return 0;
        }
        // 判断是正数还是负数
        int flag = x > 0 ? 1: -1;
        // 去掉符号
        x = Math.abs(x);
        // 转成String反转
        try {
            x = Integer.parseInt(new StringBuffer(String.valueOf(x)).reverse().toString());
        }catch (NumberFormatException e) {
            return 0;
        }
        return x * flag;
    }
}
