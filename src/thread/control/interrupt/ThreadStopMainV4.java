package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "Thread-1");
        t1.start();

        sleep(100);
        log("작업중단 지시 thread.interrupt()");
        t1.interrupt();
        log("work 스레드 인터럽트 상태2 = " + t1.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            log("work 스레드 인터럽트 상태1 = "+Thread.currentThread().isInterrupted());
            while (!Thread.interrupted()){    //인터럽트 상태 변경 ㅇ
                log("Run..");
            }
            log("work 스레드 인터럽트 상태3 = "+Thread.currentThread().isInterrupted());

            try {
                log("자원정리");
                Thread.sleep(1000);
                log("자원종료");
            } catch (InterruptedException e){
                log("자원정리 실패");
                log("자원상태 : "+Thread.currentThread().isInterrupted());
            }


        }
    }
}
