package thread.control.sync.test;

import static util.MyLogger.log;

public class SyncTest3Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                counter.count();
            }
        };

        Thread thread1 = new Thread(task, "thread - 1");
        Thread thread2 = new Thread(task, "thread - 2");
        thread1.start();
        thread2.start();
        //thread1.join();
        //thread2.join();
    }

    static class Counter {
        public void count(){
            int localVal = 0;
            for (int i = 0; i < 1000; i++) {
                localVal = localVal + 1;
            }
            log("결과 : "+localVal);
        }
    }
}
