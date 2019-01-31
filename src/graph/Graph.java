package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int v;//顶点个数
    private LinkedList<Integer> adj[];//邻接表
    private boolean found;//深度优先搜索的标志位，判断是否已经到了终点
    public Graph(int v) {
        //初始化图
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    public void addEdge(int s, int t) {//无向图一条边存两次
        adj[s] .add(t);
        adj[t].add(s);
    }


    /**
     * 功能描述:
     * 广度优先搜索算法
     * @author: lanyangjia
     * @date: 2019/1/30
     * @param s 图的起点
	 * @param t  图的终点
     * @return: 计算得出的最后结果是图的最短路径
     **/
    public void bfs(int s, int t) {
        if(s == t) return;//如果已经到终点了，直接return
        boolean[] visisted = new boolean[v];//记录该顶点是否已经被访问
        Queue<Integer> queue = new LinkedList<>();//记录相邻未访问的顶点
        queue.add(s);//把顶点加入队列中
        int[] prev = new int[v];//记录顶点的前驱
        for(int i=0; i<v;i ++) {
            prev[i] = - 1;//初始化prev数组中的值
        }
        //开始访问队列中的顶点
        while (queue.size() != 0) {
            int w = queue.poll();//队头出列
            //这里的size是与w相连的其他顶点
            for(int i=0; i<adj[w].size(); i++) {
                int q = adj[w].get(i);//获得顶点的值
                //如果该顶点没有被访问过
                if(!visisted[q]) {
                    prev[q] = w;//记录该顶点的前驱顶点
                    if(q == t) {
                        //如果已经是顶点，递归输出路径
                        print(prev,s,t);
                        return;
                    }
                }
                visisted[q] = true;//将该顶点标记为已经访问
                queue.add(q);//将相邻的点入队，获得下一层的顶点
            }
        }
    }


    /**
     * 功能描述:
     * 深度优先搜索
     * @author: lanyangjia
     * @date: 2019/1/30
     * @param s 起点
	 * @param t 终点
     * @return:
     **/
    public void dfs(int s,int t) {
        found = false;
        boolean visisted[] = new boolean[v];//记录已经访问过的顶点
        int[] prev  = new int[v];//记录顶点的前驱
        for(int i=0; i<v; i++) {
            prev[i] = -1;
        }
        //下面开始深度优先搜索

        print(prev,s,t);
    }


    /**
     * 功能描述:
     * 递归深度优先搜索
     * @author: lanyangjia
     * @date: 2019/1/30
     * @param w 当前的顶点
     * @param t 终点
     * @param visited 顶点访问记录
     * @param prev  顶点的前驱
     * @return:
     **/
    private void recurDfs(int w,int t,boolean[] visited,int[] prev) {
        if(found) return;
        visited[w] = true;
        if(w == t) {
            found = true;
            return;
        }
        //递归访问每一个节点
        for(int i=0; i<adj[w].size(); i++) {
            int q = adj[w].get(i);
            if(!visited[q]) {
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }



    private void print(int[] prev,int s,int t) {
        //递归打印s->t的路径
        if(prev[t] != -1 && t != s) {
            print(prev,s,prev[t]);
        }
        System.out.println(t + "");
    }
}
