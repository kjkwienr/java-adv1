package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyRunnable(), "MyThread");
        log("myThread.state1 = "+myThread.getState());
        log("myThread start");
        myThread.start();

        Thread.sleep(1000);
        log("myThread.state3 = "+myThread.getState());
        Thread.sleep(4000);
        log("myThread.state5 = "+myThread.getState());
        log("end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {

            try {
                log("MyRunnable start");
                log("myThread.state2 = "+Thread.currentThread().getState());
                log("start() start");
                Thread.sleep(3000);
                log("start() end");
                log("myThread.state4 = "+Thread.currentThread().getState());
                log("MyRunnable end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
