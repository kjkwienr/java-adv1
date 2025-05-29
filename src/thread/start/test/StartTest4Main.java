package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        PrintWork a = new PrintWork("A", 1000);
        PrintWork b = new PrintWork("B", 500);
        Thread thread1 = new Thread(a, "Thread-A");
        Thread thread2 = new Thread(b, "Thread-B");
        thread1.start();
        thread2.start();

    }

    static class PrintWork implements Runnable {
        private String content;
        private int sleeps;

        public PrintWork(String content, int sleeps) {
            this.content = content;
            this.sleeps = sleeps;
        }

        @Override
        public void run(){
            while (true){
                log(content);
                try {
                    Thread.sleep(sleeps);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
