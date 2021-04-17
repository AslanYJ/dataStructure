package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021年4月18日01:39:26
 * 狄克斯特拉算法简单版demo
 * @author lanyangjia
 */
public class Dijkstra {

    public static void main(String[] args) {
        Map<String,Map<String,Double>> graphMap = Dijkstra.hashMapNewInstance();
        Map<String,Double> pointMap = new HashMap<>(2);
        pointMap.put("a",6.0);
        pointMap.put("b",2.0);
        //起点到邻居点的所有初始权重
        graphMap.put("start",pointMap);
        pointMap.clear();
        //A点到终点的权重
        pointMap.put("fin",1.0);
        graphMap.put("a",pointMap);
        pointMap.clear();
        //B点到终点和A点的权重
        pointMap.put("a",3.0);
        pointMap.put("fin",5.0);
        graphMap.put("b",pointMap);
        //终点,赋值一个空的Map?
        pointMap.clear();
        graphMap.put("fin",pointMap);
        //无穷大
        double infinity = Double.POSITIVE_INFINITY;
        //创建一个负责记录开销的costMap(从起点到前往该节点所花费的时间)
        Map<String,Double> costMap = new HashMap<>(3);
        costMap.put("a",6.0);
        costMap.put("b",2.0);
        costMap.put("fin",infinity);
        //存储父节点的散列表
        Map<String,String> parentMap = new HashMap<>(3);
        parentMap.put("a","start");
        parentMap.put("b","start");
        parentMap.put("fin","None");
        //记录处理过的节点
        List<String> processed = new ArrayList<>(4);

    }

    public static Map<String,Map<String,Double>> hashMapNewInstance() {
        return new HashMap<>(4);
    }
}
