package thread.control.join;


import util.ThreadUtils;

import static util.MyLogger.log;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("Start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");
        thread1.start();
        thread2.start();

        //ThreadUtils.sleep(2500);

        log("task1. result = "+ sumTask1.result);
        log("task2. result = "+ sumTask2.result);

        int sumAll = sumTask1.result + sumTask2.result;

        log("End sum = "+sumAll);


    }

    static class SumTask implements Runnable {
        int startVal;
        int endVal;
        int result = 0;

        public SumTask(int startVal, int endVal) {
            this.startVal = startVal;
            this.endVal = endVal;
        }

        @Override
        public void run() {
            log("작업시작");
            ThreadUtils.sleep(2000);
            int sum = 0;
            for(int i = startVal; i<= endVal ;i++){
                sum += i;
            }
            result = sum;

            log("작업완료 result = "+result);
        }
    }

}
