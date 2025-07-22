package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "Thread-1");
        t1.start();

        sleep(4000);
        log("작업중단 지시 thread.interrupt()");
        t1.interrupt();
        log("work 스레드 인터럽트 상태1 = " + t1.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true){
                    log("Run");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = "+Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = "+Thread.currentThread().getState());
            }

            log("자원정리");
            log("자원종료");

        }
    }
}
