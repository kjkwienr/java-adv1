package thread.volatie1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatieCountMain {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread t = new Thread(myTask, "work");
        t.start();
        sleep(1000);

        myTask.flag = false;
        log("flag = "+myTask.flag +", count = "+myTask.count+ " Main 종료");

    }

    static class MyTask implements  Runnable {

        //boolean flag = true;
        //long count;
        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {

            while (flag){
                count++;
                if( count % 100_000_000 == 0 ){
                    log("flag = "+flag +", count = "+count+ "in while()");
                }
            }
            log("flag = "+flag +", count = "+count+ " 종료");
        }
    }
}
