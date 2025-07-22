package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "Thread-1");
        t1.start();

        sleep(4000);
        log("작업중단 지시 flase");
        task.runFlag = false;

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag){
                log("RUn");
                sleep(3000);
            }
            log("자원정리");
            log("자원종료");

        }
    }
}
