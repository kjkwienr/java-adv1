package thread.control.sync.test;

public class SyncTest2Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new RunTask(counter), "thread - 1");
        Thread thread2 = new Thread(new RunTask(counter), "thread - 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("결과 : " + counter.getCount());
    }

    static class RunTask implements Runnable {

        Counter counter = new Counter();

        public RunTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }

    static class Counter {
        private int count = 0;

        public synchronized void increment(){
            //count++;
            count = count + 1;
        }
        public int getCount(){
            return count;
        }
    }
}
