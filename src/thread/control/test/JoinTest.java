package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyTask(), "thread-1");
        Thread thread2 = new Thread(new MyTask(), "thread-2");
        Thread thread3 = new Thread(new MyTask(), "thread-3");
        log("start1");
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        log("end1");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i=1;i<=3;i++){
                log(i);
                sleep(1000);
            }
        }
    }
}
