package test;
class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
                System.out.println("测试");
            } catch (InterruptedException e) {
                System.out.println("222222222222" + Thread.currentThread().interrupted());//将当前线程重新置为false

            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(3000);
        myThread.interrupt();
    }
}
