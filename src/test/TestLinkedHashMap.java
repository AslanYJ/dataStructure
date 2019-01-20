package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }


    }
}
