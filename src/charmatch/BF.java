package charMatch;

/**
 * 字符串,BF算法
 */
public class BF {
    public static void main(String[] args) {
        String str1 = "baddef";
        String str2 = "abc";
        System.out.println(new BF().bf(str1,str2));
        System.out.println(new BF().index("abdabc","abc",0));
    }

    /**
     * 功能描述:
     * BF算法
     * @author: lanyangjia
     * @date: 2019/2/2
     * @param str1 主串
	 * @param str2 模式串
     * @return:
     **/
    public boolean bf(String str1,String str2) {
        boolean isEqual = false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for(int i=0; i<chars1.length; i++) {
            if(chars1[i] == chars2[0] && chars1.length - i >= chars2.length) {
                int k = i;//当前的下标
                //如果第一个相等，开始匹配模式串，看看是不是相等
                int j = 0;
                for(;j<chars2.length; j++) {
                    if(chars1[k] != chars2[j]) {
                        isEqual = false;
                        break;
                    } else {
                        k++;
                        isEqual = true;
                    }
                }
                if(j == chars2.length) {
                    return isEqual;
                }
            }
        }
        return isEqual;
    }

    /**
     * 功能描述:
     * 返回字符串第一次出现的下标
     * @author: lanyangjia
     * @date: 2019/2/2
     * @param s
     * @param t
     * @param pos
     * @return:
     **/
    public int index(String s,String t,int pos) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int i = pos;//从哪里开始遍历
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if( s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j >= s2.length) {
            return i - s2.length;//返回第一次出现字符的下标
        }
        return -1;
    }

}
