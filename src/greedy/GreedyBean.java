package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 100kg背包，使物品价值最大，有五种豆子，豆子的价值都不相同
 * 分配豆子问题
 * @author lanyangjia
 * @date 2019年4月5日18:56:19
 *
 */
public class GreedyBean {

    public static class Bean {
        private String name;
        private int kg;
        private int price;
        /**单价**/
        private double perPrice;

        public Bean(String name,int kg, int price) {
            this.kg = kg;
            this.price = price;
            this.name = name;
            this.perPrice = price * 1.0 / kg;
        }

        public Bean(String name, int kg, double perPrice) {
            this.name = name;
            this.kg = kg;
            this.perPrice = perPrice;
        }

        public Bean(String name, int kg) {
            this.name = name;
            this.kg = kg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKg() {
            return kg;
        }

        public void setKg(int kg) {
            this.kg = kg;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }


        public double getPerPrice() {
            return perPrice;
        }

        public void setPerPrice(double perPrice) {
            this.perPrice = perPrice;
        }
    }

    public static void main(String[] args) {
        int maxKG = 100;
        //放结果
        List<Bean> result = new ArrayList<>();
        Bean[] beans = new Bean[]{
                new Bean("yellow",100,100),
                new Bean("green",30,90),
                new Bean("black",20,80),
                new Bean("red",60,120),
                new Bean("cyan",50,75)};
        sort(beans);
        for (int i = 0; i < beans.length; i++) {
            if(maxKG <= 0) {
                break;
            }
            Bean bean;
            if(beans[i].getKg() > maxKG) {
                bean = new Bean(beans[i].getName(),maxKG);
            } else {
                bean = new Bean(beans[i].getName(),beans[i].getKg());
            }
            result.add(bean);
            maxKG = maxKG - beans[i].getKg();
        }

        for (Bean bean : result) {
            System.out.println(bean.getName() + bean.getKg());
        }

    }

    /**
     * 根据单价排序
     * @param beans
     */
    public static void sort(Bean[] beans) {
        int length = beans.length;
        if(length == 0) {
            return;
        }
        for(int i=0; i<length; i++) {
            //判断是否发生了排序，如果没有发生，则已经是有序了s
            boolean flag = false;
            for(int j=0; j<length - i - 1; j++) {
                if(beans[j].getPerPrice() < beans[j+1].getPerPrice() ) {
                    Bean temp = beans[j+1];
                    beans[j+1] = beans[j];
                    beans[j] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }
}
