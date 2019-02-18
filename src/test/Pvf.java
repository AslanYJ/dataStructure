package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class Pvf {

    public static void main(String[] args)
    {
        Integer n1 = new Integer(47);
        Integer n2 = Integer.valueOf(47);
        Integer n3 = Integer.valueOf(47);
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
        System.out.println(n2 == n3);
        int x=20;int y=5;
        System.out.println(x+y +""+(x+y)+y);
    }
}
