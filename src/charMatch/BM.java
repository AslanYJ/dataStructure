package charMatch;

public class BM {
    private static int SIZE = 256;//散列表的长度




    /**
     * 功能描述:
     * 散列表，用来匹配是否字符相等
     * @author: lanyangjia
     * @date: 2019/2/18
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 存储每个模式串中的字符出现的位置
     * @return:
     **/
    private void generateBC(char[] b, int m, int[] bc) {
        for(int i=0; i<SIZE; i++) {
            bc[i] = -1;
        }
        for(int i=0; i<m; i++) {
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }
}
