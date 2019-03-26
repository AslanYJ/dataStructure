package test.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 代理模式
 */
public class Proxy implements Move {

    List<String> array = new ArrayList<>();
    private Move move;
    public Proxy(Move move) {
        this.move = move;
    }
    @Override
    public void move() {
        System.out.println("行车记录仪~~~~");
        move.move();
        System.out.println("~~~~~~");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Move car = new Car();
        Move proxy = new Proxy(car);
        proxy.move();
    }
}
