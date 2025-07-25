package thread.volatie1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatieFlagMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread t = new Thread(myTask, "work");
        log("runFlag : "+ myTask.runFlag);
        t.start();
        sleep(1000);

        log("runFlag 변경");
        myTask.runFlag = false;

        log("runFlag : "+ myTask.runFlag);
        log("main종료");


    }

    static class MyTask implements Runnable {

        //boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag){

            }
            log("task 종료");

        }
    }
}
